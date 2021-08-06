package org.architectdrone.javacodereviewprototype.tree;

interface ChangeDistillationTreeMatch {
    int N = 3; //"n" in "n-grams"
    float STRING_SIMILARITY_THRESHOLD = 1; //Strings with a similarity lower than this number will be considered not matching.

    /**
     * Matches nodes in one tree to nodes in another tree.
     * @param treeA The original tree
     * @param treeB The modified tree
     * @param <L> Label type
     */
    public <L> void matchTrees(ChangeDistillationTree<L> treeA, ChangeDistillationTree<L> treeB);
}
