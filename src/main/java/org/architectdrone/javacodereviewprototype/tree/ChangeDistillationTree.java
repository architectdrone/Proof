package org.architectdrone.javacodereviewprototype.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 * Simple tree data structure with data for the change distillation process.
 * @param <L> The label type
 */
public class ChangeDistillationTree<L> {
    //Tree data
    @Getter final List<ChangeDistillationTree<L>> children; //Children of the root node

    //Container data
    @Getter
    final L label; //The label of the root node
    @Getter
    final String value; //The value of the root node
    
    //Matching data
    @Getter
    private boolean isMatched = false; //Whether or not the root node is matched with a node from the other tree.
    @Getter
    private ChangeDistillationTree<L> match; //The matching node from the other tree, if it exists.

    //Diff data
    @Getter
    final boolean isOriginal;

    /**
     * Constructs a {@link ChangeDistillationTree} from some other tree type.
     * @param otherTree Root of other tree.
     * @param getChildrenOfTree Function that gets the children of the given tree type.
     * @param getValue Function that gets the value of the tree type
     * @param getLabel Function that gets the label of the tree type
     * @param <N> Other tree type.
     */
    public <N> ChangeDistillationTree(N otherTree, boolean isOriginal, Function<N, List<N>> getChildrenOfTree, Function<N, String> getValue, Function<N, L> getLabel)
    {
        this.isOriginal = isOriginal;
        this.label = getLabel.apply(otherTree);
        this.value = getValue.apply(otherTree);
        this.children = new ArrayList<>();
        for (N child : getChildrenOfTree.apply(otherTree))
        {
            children.add(new ChangeDistillationTree<L>(child, isOriginal, getChildrenOfTree, getValue, getLabel));
        }
    }

    public ChangeDistillationTree(final L label, final String value, final List<ChangeDistillationTree<L>> children, boolean isOriginal) {
        this.label = label;
        this.value = value;
        this.children = children;
        this.isOriginal = isOriginal;
    }

    /**
     * @param includeLeaves Include leaves?
     * @return descendants
     */
    public List<ChangeDistillationTree<L>> getDescendants(boolean includeLeaves)
    {
        List<ChangeDistillationTree<L>> toReturn = new ArrayList<>();

        toReturn.addAll(children.stream().flatMap(c -> c.getDescendants(includeLeaves).stream()).collect(Collectors.toList()));
        toReturn.addAll(children.stream().filter(c -> !c.getChildren().isEmpty() || includeLeaves).collect(Collectors.toList()));
        return toReturn;
    }

    public void setMatch(ChangeDistillationTree<L> match)
    {
        assert match.isOriginal() != this.isOriginal(); //We do not allow originals to match with other originals, or vice versa
        this.match = match;
        this.isMatched = true;
        if (!match.isMatched)
        {
            match.setMatch(this);
        }
    }

    public List<ChangeDistillationTree<L>> getLeaves() {
        if (children.isEmpty())
        {
            return Collections.singletonList(this);
        }
        else
        {
            List<ChangeDistillationTree<L>> toReturn = new ArrayList<>();
            for (ChangeDistillationTree<L> child : children)
            {
                toReturn.addAll(child.getLeaves());
            }
            return toReturn;
        }
    }
}
