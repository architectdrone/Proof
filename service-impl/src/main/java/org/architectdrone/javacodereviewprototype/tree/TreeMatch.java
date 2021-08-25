package org.architectdrone.javacodereviewprototype.tree;

/**
 * Tools for matching trees.
 * That is, for setting the "match" field on {@link DiffTree}s
 */
interface TreeMatch {
    /**
     * Matches nodes in one tree to nodes in another tree.
     * @param treeA The original tree
     * @param treeB The modified tree
     * @param <L> Label type
     */
    <L> void matchTrees(DiffTree<L> treeA, DiffTree<L> treeB);
}
