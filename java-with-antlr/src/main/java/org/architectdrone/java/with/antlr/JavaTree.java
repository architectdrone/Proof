package org.architectdrone.java.with.antlr;

import org.architectdrone.javacodereviewprototype.tree.DiffTree;

import java.util.List;
import java.util.function.Function;

public class JavaTree extends DiffTree<String> {

    public <N> JavaTree(N otherTree, boolean isOriginal, Function<N, List<N>> getChildrenOfTree, Function<N, String> getValue, Function<N, String> getLabel) {
        super(otherTree, isOriginal, getChildrenOfTree, getValue, getLabel);
    }
}
