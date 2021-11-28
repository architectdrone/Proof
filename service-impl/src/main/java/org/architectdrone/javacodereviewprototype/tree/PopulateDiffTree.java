package org.architectdrone.javacodereviewprototype.tree;

/**
 * Tools for populating a diff tree with reference data.
 */
public interface PopulateDiffTree {
    /**
     * Populates a diff tree with reference data.
     * The top two nodes are, at least, required to be matching.
     * If {@link TreeMatch#matchTrees(DiffTree, DiffTree)} has not been called for these trees, the results will not be very useful!
     * @param treeA The original tree.
     * @param treeB The modified tree.
     * @param <L> The label type.
     */
    <L> void populateDiffTree(DiffTree<L> treeA, DiffTree<L> treeB);
}
