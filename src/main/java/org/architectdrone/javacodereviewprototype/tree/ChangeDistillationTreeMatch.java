package org.architectdrone.javacodereviewprototype.tree;

interface ChangeDistillationTreeMatch {
    /**
     * Matches nodes in one tree to nodes in another tree.
     * @param treeA The original tree
     * @param treeB The modified tree
     * @param <L> Label type
     */
    public <L> void matchTrees(ChangeDistillationTree<L> treeA, ChangeDistillationTree<L> treeB);
}
