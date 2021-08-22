package org.architectdrone.javacodereviewprototype.tree;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.architectdrone.javacodereviewprototype.tree.DiffTree.areNodesMisaligned;
import static org.architectdrone.javacodereviewprototype.tree.DiffTree.getMisalignedDual;
import static org.architectdrone.javacodereviewprototype.tree.DiffTree.getNodeGeneric;

/**
 * Populates a diff tree. The results are:
 * 1. In some parent,
 *      a. If nodes match, order matches, and value matches, the node is assigned a reference type of NONE.
 *      b. If nodes match, order matches, but value does not match, the node is assigned a reference type of MODIFY, the value is changed to the value in the modified tree, and the original value is stored.
 *      c. If nodes match, but order does not match, set reference type of original node to MOVE_TO, and create a new node w/ reference type MOVE_FROM at correct location.
 *      d. If nodes match, but parents do not match, set reference type of original to MOVE_TO, and create a new node with correct position MOVE_FROM
 *          i. Any nodes existing beneath the original are considered children of both the move from and move to.
 *      d. If a node does not match, and exists in the original tree, set the type of the node to DELETE.
 *      e. If a node does not match, and exists in the modified tree, create a new node at the correct location in original tree with type CREATE.
 * Once populated, we have the following requirements:
 * 1. The value of all nodes, with lines created either 0 of -1 should have the same order as the original tree.
 * 2. The value of all nodes, with lines created either 0 of +1 should have the same order as the modified tree.
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
                //If the parent is a MOVE_FROM, we want to consider the corresponding MOVE_TO's children.
                if (parent.getReferenceType() == ReferenceType.MOVE_FROM)
                {
                    parent = parent.getReferenceLocation();
                }

                //Identify and fix mismatched nodes
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
                        DiffTree<L> maximumMisalignedNode = currentMisalignedDual != null ? current : next;

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

                //Theoretically, by this point, all nodes are in order
                //Now, we are left with some disconnected nodes
                //We handle these now

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
                            createNewNode(current, parent);
                        }
                        else if (current.getParent() != current.getMatch().getParent().getMatch())
                        {
                            DiffTree<L> createdNode = createNewNode(current, parent);

                            DiffTree<L> moveTo = current.getMatch();
                            moveTo.setReferenceType(ReferenceType.MOVE_TO);
                            moveTo.setReferenceLocation(createdNode);
                            moveTo.unmatch();

                            createdNode.setMatch(current);
                            createdNode.setReferenceType(ReferenceType.MOVE_FROM);
                            createdNode.setReferenceLocation(moveTo);
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
                    current = current.getNext();
                }
            }
        }
        treeA.rectifyNodes();
    }
    
    private static <L> DiffTree<L> createNewNode(DiffTree<L> original, DiffTree<L> parent)
    {
        //Create
        DiffTree<L> createdNode = new DiffTree<>(original.getLabel(), original.getValue(), Collections.emptyList(), true);

        DiffTree<L> createdNodeParent = original.getParent().getMatch();

        createdNode.setChildNumber(original.getChildNumber());
        createdNode.setParent(createdNodeParent);
        createdNode.setHasAdvancedDataBeenPopulated(true);

        createdNode.setMatch(original);
        createdNode.setReferenceType(ReferenceType.CREATE);

        /*
         * We want to place the new node after the node before's match
         */
        DiffTree<L> previous = getNodeGeneric(original, 1, DiffTree::getPreviousMatched, a -> true);
        DiffTree<L> previousMatch = previous != null ? previous.getMatch() : null;
        parent.insertNodeAfter(previousMatch, createdNode);

        return createdNode;
    }
}