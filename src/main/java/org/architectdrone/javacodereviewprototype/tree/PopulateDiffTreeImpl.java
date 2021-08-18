package org.architectdrone.javacodereviewprototype.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        assert treeA.getMatch() == treeB;
        treeA.populateAdvancedData();
        treeB.populateAdvancedData();
        int level = 0;
        while (true)
        {
            level++;
            List<DiffTree<L>> originalNodes = treeA.getLevel(level);
            List<DiffTree<L>> modifiedNodes = treeB.getLevel(level);
            if (originalNodes.isEmpty() && modifiedNodes.isEmpty())
            {
                break;
            }
            List<DiffTree<L>> nodesToCreate = modifiedNodes
                    .stream()
                    .filter(a -> !a.isMatched())
                    .collect(Collectors.toList());
            List<DiffTree<L>> nodesToDelete = originalNodes
                    .stream()
                    .filter(a -> !a.isMatched())
                    .collect(Collectors.toList());

            for (DiffTree<L> nodeToDelete : nodesToDelete)
            {
                nodeToDelete.setReferenceType(ReferenceType.DELETE);
                DiffTree<L> deletedNodeParent = nodeToDelete.getParent();
                int childNumber = nodeToDelete.getChildNumber();
                nodeToDelete.getParent().shiftDownAfterChild(nodeToDelete.getChildNumber());
            }
            for (DiffTree<L> createdNodeMatch : nodesToCreate)
            {
                DiffTree<L> createdNode = new DiffTree<>(
                        createdNodeMatch.getLabel(),
                        createdNodeMatch.getValue(),
                        Collections.emptyList(),
                        true
                );

                DiffTree<L> createdNodeParent = createdNodeMatch.getParent().getMatch();

                createdNode.setChildNumber(createdNodeMatch.getChildNumber());
                createdNode.setParent(createdNodeParent);
                createdNode.setHasAdvancedDataBeenPopulated(true);

                createdNode.setMatch(createdNodeMatch);
                createdNode.setReferenceType(ReferenceType.CREATE);

                createdNodeParent.insertAndShiftUp(createdNode);
            }

            List<DiffTree<L>> allMisMatchedNodes = originalNodes
                    .stream()
                    .filter(DiffTree::isMatched)
                    .filter(a -> a.getParent() == a.getMatch().getParent().getMatch())
                    .filter(a -> a.getChildNumber() != a.getMatch().getChildNumber())
                    .collect(Collectors.toList());
            Map<DiffTree<L>, List<DiffTree<L>>> parentToMismatchedNodes = new HashMap<>();
            for (DiffTree<L> node : allMisMatchedNodes)
            {
                parentToMismatchedNodes.compute(node.getParent(), (k, v) -> {
                    if (v == null)
                    {
                        v = new ArrayList<>();
                    }
                    v.add(node);
                    return v;
                });
            }
            for (Map.Entry<DiffTree<L>, List<DiffTree<L>>> parentAndMisMatchedChildren : parentToMismatchedNodes.entrySet())
            {
                List<DiffTree<L>> sortedMismatchedNodes = parentAndMisMatchedChildren
                        .getValue()
                        .stream()
                        .sorted(Comparator.comparingInt(a -> -1*Math.abs(a.getChildNumber() - a.getMatch().getChildNumber())))
                        .collect(Collectors.toList());
                for (DiffTree<L> mismatchedNode : sortedMismatchedNodes)
                {
                    if (mismatchedNode.getChildNumber() != mismatchedNode.getMatch().getChildNumber())
                    {
                        mismatchedNode.setReferenceType(ReferenceType.MOVE_TO);
                        mismatchedNode.getParent().shiftDownAfterChild(mismatchedNode.getChildNumber());

                        DiffTree<L> moveFromNode = new DiffTree<L>(mismatchedNode.getLabel(), mismatchedNode.getValue(), Collections.emptyList(), true);
                        mismatchedNode.setReferenceLocation(moveFromNode);

                        moveFromNode.setChildNumber(mismatchedNode.getMatch().getChildNumber());
                        moveFromNode.setParent(mismatchedNode.getParent());
                        moveFromNode.setHasAdvancedDataBeenPopulated(true);
                        moveFromNode.setReferenceType(ReferenceType.MOVE_FROM);
                        mismatchedNode.getParent().insertAndShiftUp(moveFromNode);

                    }
                }
            }
        }
        treeA.rectifyNodes();
    }
}
