package org.architectdrone.javacodereviewprototype.tree;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.architectdrone.javacodereviewprototype.tree.DiffTree.areNodesMisaligned;
import static org.architectdrone.javacodereviewprototype.tree.DiffTree.getMisalignedDual;
import static org.architectdrone.javacodereviewprototype.tree.DiffTree.getNodeGeneric;

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

            Set<DiffTree<L>> parents = new HashSet<>(treeA.getLevel(level - 1));

            for (DiffTree<L> parent : parents)
            {
                if (parent.getReferenceType() == ReferenceType.MOVE_FROM)
                {
                    parent = parent.getReferenceLocation();
                }

                //Identify and fix mismatched nodes
                while (true)
                {
                    DiffTree<L> maximumMisalignedNode = null;
                    int maximumMisalignment = 0;

                    //Populate misalignment map
                    DiffTree<L> current = getNodeGeneric(parent.getFirst(), 0, DiffTree::getNextMatched, a -> a.getReferenceType() == ReferenceType.NONE && a.isMatched());
                    while (true)
                    {
                        DiffTree<L> next = getNodeGeneric(current, 1, DiffTree::getNextMatched, a -> a.getReferenceType() == ReferenceType.NONE);
                        if (next == null)
                        {
                            break;
                        }
                        if (areNodesMisaligned(current, next))
                        {
                            DiffTree<L> currentMisalignedDual = getMisalignedDual(current);
                            DiffTree<L> nextMisalignedDual = getMisalignedDual(next);
                            assert !((currentMisalignedDual == null) && (nextMisalignedDual == null));
                            DiffTree<L> beforeNewNode = currentMisalignedDual != null ? currentMisalignedDual.getMatch() : nextMisalignedDual.getMatch().getPrevious();
                            maximumMisalignedNode = currentMisalignedDual != null ? current : next;

                            maximumMisalignedNode.setReferenceType(ReferenceType.MOVE_TO);

                            DiffTree<L> moveFromNode = new DiffTree<L>(maximumMisalignedNode.getLabel(), maximumMisalignedNode.getValue(), Collections.emptyList(), true);
                            maximumMisalignedNode.setReferenceLocation(moveFromNode);
                            moveFromNode.setReferenceLocation(maximumMisalignedNode);

                            moveFromNode.setChildNumber(maximumMisalignedNode.getMatch().getChildNumber());
                            moveFromNode.setParent(maximumMisalignedNode.getParent());
                            moveFromNode.setHasAdvancedDataBeenPopulated(true);
                            moveFromNode.setReferenceType(ReferenceType.MOVE_FROM);

                            parent.insertNodeAfter(beforeNewNode, moveFromNode);
                            maximumMisalignedNode.getMatch().unmatch();
                            moveFromNode.setMatch(maximumMisalignedNode.getMatch());
                            maximumMisalignedNode.unmatch();
                        }
                        current = getNodeGeneric(current, 1, DiffTree::getNextMatched, a -> a.getReferenceType() == ReferenceType.NONE);
                    }

                    if (maximumMisalignment == 0)
                    {
                        break;
                    }
                }

                //Theoretically, by this point, all nodes are in order
                //Now, we are left with some disconnected nodes
                //We handle these now

                DiffTree<L> current;

                //First, nodes that are created and nodes that are moved into this tree
                if (parent.isMatched())
                {
                    current = parent.getMatch().getFirst();
                    while (true)
                    {
                        if (current == null)
                        {
                            break;
                        }
                        else if (!current.isMatched())
                        {
                            //Create
                            DiffTree<L> createdNode = new DiffTree<>(current.getLabel(), current.getValue(), Collections.emptyList(), true);

                            DiffTree<L> createdNodeParent = current.getParent().getMatch();

                            createdNode.setChildNumber(current.getChildNumber());
                            createdNode.setParent(createdNodeParent);
                            createdNode.setHasAdvancedDataBeenPopulated(true);

                            createdNode.setMatch(current);
                            createdNode.setReferenceType(ReferenceType.CREATE);

                            /*
                             * We want to place the new node after the node before's match
                             * Unless the node before's match is a MOVE_FROM, in which case we want to move it to the node before
                             */
                            DiffTree<L> previous = getNodeGeneric(current, 1, DiffTree::getPreviousMatched, a -> true);
                            DiffTree<L> previousMatch = previous != null ? previous.getMatch() : null;
                            parent.insertNodeAfter(previousMatch, createdNode);
                        }
                        else if (current.getParent() != current.getMatch().getParent().getMatch())
                        {
                            //Move from
                            DiffTree<L> createdNode = new DiffTree<L>(
                                    current.getLabel(),
                                    current.getValue(),
                                    Collections.emptyList(),
                                    true
                            );

                            DiffTree<L> createdNodeParent = current.getParent().getMatch();

                            createdNode.setChildNumber(current.getChildNumber());
                            createdNode.setParent(createdNodeParent);
                            createdNode.setHasAdvancedDataBeenPopulated(true);

                            DiffTree<L> moveTo = current.getMatch();
                            moveTo.setReferenceType(ReferenceType.MOVE_TO);
                            moveTo.setReferenceLocation(createdNode);
                            moveTo.unmatch();

                            createdNode.setMatch(current);
                            createdNode.setReferenceType(ReferenceType.MOVE_FROM);
                            createdNode.setReferenceLocation(moveTo);

                            DiffTree<L> previous = getNodeGeneric(current, 1, DiffTree::getPreviousMatched, a -> true);
                            DiffTree<L> previousMatch = previous != null ? previous.getMatch() : null;
                            parent.insertNodeAfter(previousMatch, createdNode);
                        }
                        current = current.getNext();

                    }
                }

                //Then we take care of deleted and moved out nodes
                current = parent.getFirst();
                while (true)
                {
                    if (current == null)
                    {
                        break;
                    }
                    else if (!current.isMatched() && (current.getReferenceType() == ReferenceType.NONE))
                    {
                        //Delete
                        current.setReferenceType(ReferenceType.DELETE);
                    }
                    else if ((current.getReferenceType() == ReferenceType.NONE) && current.getParent() != current.getMatch().getParent().getMatch())
                    {
//                        current.setReferenceType(ReferenceType.MOVE_TO);
//                        current.setReferenceLocation(current.getMatch().getMatch());
                    }
                    current = current.getNext();
                }
            }
        }
        treeA.rectifyNodes();
    }
}