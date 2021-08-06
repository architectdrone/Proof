package org.architectdrone.javacodereviewprototype.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Simple tree data structure with data for the change distillation process.
 * @param <L>
 */
@RequiredArgsConstructor
public class ChangeDistillationTree<L> {
    //Tree data
    @Getter
    final L label;
    @Getter final String value;
    @Getter final List<ChangeDistillationTree<L>> children;

    /**
     * Constructs a {@link ChangeDistillationTree} from some other tree type.
     * @param otherTree Root of other tree.
     * @param getChildrenOfTree Function that gets the children of the given tree type.
     * @param getValue Function that gets the value of the tree type
     * @param getLabel Function that gets the label of the tree type
     * @param <N> Other tree type.
     */
    public <N> ChangeDistillationTree(N otherTree, Function<N, List<N>> getChildrenOfTree, Function<N, String> getValue, Function<N, L> getLabel)
    {
        this.label = getLabel.apply(otherTree);
        this.value = getValue.apply(otherTree);
        this.children = new ArrayList<>();
        for (N child : getChildrenOfTree.apply(otherTree))
        {
            children.add(new ChangeDistillationTree<L>(child, getChildrenOfTree, getValue, getLabel));
        }
    }
}
