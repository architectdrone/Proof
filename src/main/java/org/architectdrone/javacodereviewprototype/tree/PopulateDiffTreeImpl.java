package org.architectdrone.javacodereviewprototype.tree;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
                    doForEachChild(parent.getMatch(), PopulateDiffTreeImpl::handleNodeInModified, a -> true);
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

    private static <L> void handleNodeInModified(DiffTree<L> unmatchedNode)
    {
        if (!unmatchedNode.isMatched())
        {
            createNewNode(unmatchedNode);
        }
        else if (unmatchedNode.getParent() != unmatchedNode.getMatch().getParent().getMatch())
        {
            handleInterTreeMove(unmatchedNode);
        }
    }

    /**
     * Handles inter-tree moves.
     * @param original Node in modified tree with a different parent from it's match.
     * @param <L> Label type.
     */
    private static <L> void handleInterTreeMove(DiffTree<L> original)
    {
        DiffTree<L> createdNode = copyNode(original, ReferenceType.MOVE_FROM);

        DiffTree<L> moveTo = original.getMatch();
        moveTo.setReferenceType(ReferenceType.MOVE_TO);
        moveTo.setReferenceLocation(createdNode);
        moveTo.unmatch();

        createdNode.setMatch(original);
        createdNode.setReferenceLocation(moveTo);
    }

    /**
     * Creates a copy of original under parent at the correct location.
     * @param original The original to copy.
     * @param <L> The Label Type.
     */
    private static <L> void createNewNode(DiffTree<L> original)
    {
        copyNode(original, ReferenceType.CREATE);
    }

    /**
     * Creates a copy of the given node.
     * @param <L> Label type
     * @param original The original node. (Should be in opposite of parent)
     * @param referenceType The new reference type of the node.
     * @return New node.
     */
    private static <L> DiffTree<L> copyNode(DiffTree<L> original, ReferenceType referenceType)
    {
        //Create
        DiffTree<L> createdNode = new DiffTree<>(original.getLabel(), original.getValue(), Collections.emptyList(), true);

        DiffTree<L> createdNodeParent = original.getParent().getMatch();

        createdNode.setChildNumber(original.getChildNumber());
        createdNode.setParent(createdNodeParent);
        createdNode.setHasAdvancedDataBeenPopulated(true);

        createdNode.setMatch(original);
        createdNode.setReferenceType(referenceType);

        DiffTree<L> previous = getNodeGeneric(original, 1, DiffTree::getPreviousMatched, a -> true);
        DiffTree<L> previousMatch = previous != null ? previous.getMatch() : null;
        createdNode.getParent().insertNodeAfter(previousMatch, createdNode);

        return createdNode;
    }

    private static <L> void doForEachChild(DiffTree<L> parent, Consumer<DiffTree<L>> handler, Predicate<DiffTree<L>> discriminator)
    {
        DiffTree<L> current = parent.getFirst();
        while (true) {
            if (current == null)
            {
                break;
            }
            else if (discriminator.test(current))
            {
                handler.accept(current);
            }
            current = current.getNext();
        }
    }
}