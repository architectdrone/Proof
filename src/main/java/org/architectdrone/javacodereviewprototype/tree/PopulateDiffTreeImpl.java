package org.architectdrone.javacodereviewprototype.tree;

/**
 * The algorithm used here is of my own creation.
 *
 * We proceed in level order from the root nodes.
 * 1. Gather all nodes on level n of both trees.
 * 2. For each node, (exclude all nodes whose ancestor's reference type is in (MOVE_FROM, DELETE)
 *  a. If the node is matched,
 *      i. And the parent nodes are both matched,
 *          - And the parent nodes are matched to each other,
 *              1. And the child number for both is equal,
 *                  a. Then the nodes are considered good.
 *              2. And the child numbers are different,
 *                  a. Then a SWAP action is needed.
 *                  b. Set reference type of original to MOVE_TO.
 *                  c. Insert new reference node beneath original's parent w/ reference type of MOVE_FROM.
 *                  d. Set original's effective subtree to the new reference node.
 *                  e. Match new reference node with corresponding modified node.
 *          - And the parent nodes are not matched to each other,
 *              1. Then a MOVE action is needed.
 *              2. Set reference type of original to MOVE_TO.
 *              3. Define destination node = modified node's parent's match.
 *              4. Insert new reference node beneath destination w/ reference type of MOVE_FROM.
 *              5. Set original's effective subtree to the new reference node.
 *              6. Match new reference node with corresponding modified node.
 *      ii. And the parent nodes are not both matched,
 *          - I don't think this can happen, so throw an error.
 *      iii. If the value of the modified and original values differ,
 *          - If some other action has already been taken,
 *              - In the other reference node, silently change the value.
 *          - If no other action has been taken,
 *              - Set reference type of original to EDIT
 *              - Set new_value to the new value
 *              - Set old_value to the old value
 *              - Set effective subtree to own subtree.
 *  b. If the node is unmatched,
 *      1. If the node is original,
 *          - Then a DELETE action is needed.
 *          - Set reference type to DELETE.
 *          - Set effective subtree to itself.
 *      2. If the node is modified,
 *          - If parent is matched,
 *              a. Then a CREATE action is needed.
 *              b. Create new node beneath parent's match with appropriate child number
 *              c. Set reference type to CREATE.
 *              d. Match new node with modified node.
 *          - Otherwise, something has gone wrong, lol
 */
public class PopulateDiffTreeImpl implements PopulateDiffTree {
    @Override
    public <L> void populateDiffTree(final DiffTree<L> treeA, final DiffTree<L> treeB) {

    }
}
