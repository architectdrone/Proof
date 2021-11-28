package org.architectdrone.javacodereviewprototype.context.language.unparser;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.StringDisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.action.*;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;
import org.architectdrone.javacodereviewprototype.tree.ReferenceType;

/*
 * Unparses a tree.
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */
public class Unparser {
    public static <L> List<DisplayElement> unparse(Function<L, Discriminator<L>> discriminatorRetriever, DiffTree<L> diffTree)
    {
        Discriminator<L> discriminator = discriminatorRetriever.apply(diffTree.getLabel());
        UnparserPattern<L> pattern = discriminator.getPattern(diffTree.getChildren());
        Set<DisplayElementAccessor<L>> displayElementAccessors = diffTree
                .getChildren()
                .stream()
                .map(a -> new DisplayElementAccessor<L>(a.getChildNumber(), a.getLabel(), unparse(discriminatorRetriever, diffTree)))
                .collect(Collectors.toSet());
        DisplayElementAccessor<L> displayElementAccessor = new DisplayElementAccessor<>(displayElementAccessors);
        DisplayElement label;
        if (!diffTree.getOldValue().equals(diffTree.getValue()))
        {
            label = new ModifyDisplayElement(diffTree.getOldValue(), diffTree.getValue());
        }
        else {
            label = new StringDisplayElement(diffTree.getValue());
        }
        List<DisplayElement> displayElements = pattern.unparse(label, displayElementAccessor);

        if (diffTree.getReferenceType() != ReferenceType.NONE)
        {
            ActionDisplayElement actionDisplayElement;
            switch (diffTree.getReferenceType())
            {
                case CREATE:
                    actionDisplayElement = new CreateDisplayElement(displayElements);
                    break;
                case DELETE:
                    actionDisplayElement = new DeleteDisplayElement(displayElements);
                    break;
                case MOVE_FROM:
                    actionDisplayElement = new MoveFromDisplayElement(displayElements);
                    break;
                case MOVE_TO:
                    actionDisplayElement = new MoveToDisplayElement(displayElements);
                    break;
                case MODIFY:
                    throw new RuntimeException("Huh. I can't handle MODIFY actions like this.");
                default:
                    throw new RuntimeException("Unrecognized reference type.");
            }
            return Collections.singletonList(actionDisplayElement);
        }
        else {
            return displayElements;
        }

    }
}
