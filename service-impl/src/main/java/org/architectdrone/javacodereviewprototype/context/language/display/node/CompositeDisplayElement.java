package org.architectdrone.javacodereviewprototype.context.language.display.node;

import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.base.StringDisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.meta.*;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;
import org.architectdrone.javacodereviewprototype.tree.container.DiffTreeAccessor;

import java.util.Collections;
import java.util.List;

public abstract class CompositeDisplayElement <L> implements DisplayElement {
    DiffTreeAccessor<L> diffTreeAccessor;
    public CompositeDisplayElement(DiffTreeAccessor<L> accessor)
    {
        this.diffTreeAccessor = accessor;
    }

    public CompositeDisplayElement(DiffTree<L> diffTree) {
        this(new DiffTreeAccessor<L>(Collections.singletonList(diffTree)));
    }

    private List<DisplayElement> getChildren(DiffTree<L> diffTree) {
        DisplayElement parentValueDisplayElement = createStringDisplayElement(diffTree);
        DiffTreeAccessor<L> diffTreeAccessor = new DiffTreeAccessor<L>(diffTree);
        List<DisplayElement> contextFreeChildren = getContextFreeChildren(diffTree.getLabel(), parentValueDisplayElement, diffTreeAccessor);
        switch (diffTree.getReferenceType())
        {
            case CREATE:
            case DELETE:
            case MOVE_TO:
            case MOVE_FROM:
                return Collections.singletonList(
                        ActionDisplayElement
                                .builder()
                                .referenceType(diffTree.getReferenceType())
                                .children(contextFreeChildren)
                                .build());
            case NONE:
            default:
                return contextFreeChildren;
        }
    }

    List<DisplayElement> getChildren() {
        if (diffTreeAccessor.isSingleton())
        {
            DiffTree<L> diffTree = diffTreeAccessor.getOnly();
            return getChildren(diffTree);
        }
        else if (diffTreeAccessor.isDual() && isAllowedLabel(diffTreeAccessor.getNegativeOfDual().getLabel()) && isAllowedLabel(diffTreeAccessor.getPositiveOfDual().getLabel())) {
            List<DisplayElement> toReturn = getChildren(diffTreeAccessor.getNegativeOfDual());
            toReturn.addAll(getChildren(diffTreeAccessor.getPositiveOfDual()));
            return toReturn;
        }
        else {
            throw new RuntimeException();
        }
    }

    private DisplayElement createStringDisplayElement(DiffTree<L> tree) {
        DisplayElement stringDisplayElement;
        if (!tree.getOldValue().equals(""))
        {
            stringDisplayElement = ModifyDisplayElement
                    .builder()
                    .to(new StringDisplayElement(tree.getValue()))
                    .from(new StringDisplayElement(tree.getOldValue()))
                    .build();
        } else {
            stringDisplayElement = new StringDisplayElement(tree.getValue());
        }

        switch (tree.getReferenceType()) {
            case MOVE_FROM:
            case MOVE_TO:
            case DELETE:
            case CREATE:
                return ActionDisplayElement
                        .builder()
                        .referenceType(tree.getReferenceType())
                        .child(stringDisplayElement)
                        .build();
            default:
                return stringDisplayElement;
        }
    }

    abstract List<DisplayElement> getContextFreeChildren(L label, DisplayElement value, DiffTreeAccessor<L> children);

    abstract boolean isAllowedLabel(L label);
}
