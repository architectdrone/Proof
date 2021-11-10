package org.architectdrone.javacodereviewprototype.context.language.unparser;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;
import org.architectdrone.javacodereviewprototype.tree.ReferenceType;

/*
 * Description
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
        List<DisplayElement> displayElements = pattern.unparse(diffTree.getValue(), displayElementAccessor);

        if (diffTree.getReferenceType() == ReferenceType.DELETE)
        {
            //Add
        }

        return displayElements;
    }
}
