package org.architectdrone.javacodereviewprototype.tree;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.architectdrone.javacodereviewprototype.tree.ReferenceType.*;

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
                doForEachPairOfMatchedNodes(parent, PopulateDiffTreeImpl::handleMisalignedNodes, PopulateDiffTreeImpl::areNodesMisaligned);

                //First, nodes that are created and nodes that are moved into this tree
                if (parent.isMatched())
                {
                    doForEachChild(parent.getMatch(), PopulateDiffTreeImpl::handleNodeInModified, a -> true);
                }

                //Then we take care of deleted nodes
                doForEachChild(parent, PopulateDiffTreeImpl::deleteNode, a -> (!a.isMatched() && (a.getReferenceType() == ReferenceType.NONE)));

                //Finally, we take care of renamed nodes.
                doForEachChild(parent, PopulateDiffTreeImpl::modifyNode, (a -> a.isMatched() && !a.getMatch().getValue().equals(a.getValue())));
            }
        }
        rectifyNodes(treeA);
    }

    /**
     * Renames a node.
     * Node renaming occurs when two matching nodes have different values.
     * The given node's old value is assigned to the given node's oldValue field.
     * The matched node's value is assigned to the given node's value field.
     * Finally, if the given node does not already have a reference type, it is assigned as MODIFY.
     * @param nodeToModify the node to modify
     * @param <L> The reference type.
     */
    private static <L> void modifyNode(DiffTree<L> nodeToModify)
    {
        DiffTree<L> matchedNode = nodeToModify.getMatch();
        nodeToModify.oldValue = nodeToModify.value;
        nodeToModify.value = matchedNode.value;
        if (nodeToModify.getReferenceType() == NONE)
        {
            nodeToModify.setReferenceType(MODIFY);
        }
    }

    private static <L> void deleteNode(DiffTree<L> unmatchedNode)
    {
        unmatchedNode.setReferenceType(ReferenceType.DELETE);
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

        DiffTree<L> previous = getNodeGeneric(original, 1, PopulateDiffTreeImpl::getPreviousMatched, a -> true);
        DiffTree<L> previousMatch = previous != null ? previous.getMatch() : null;
        insertNodeAfter(createdNode.getParent(), previousMatch, createdNode);

        return createdNode;
    }

    private static <L> void handleMisalignedNodes(DiffTree<L> current, DiffTree<L> next)
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

        insertNodeAfter(current.getParent(), beforeNewNode, moveFromNode);
        maximumMisalignedNode.getMatch().unmatch();
        moveFromNode.setMatch(maximumMisalignedNode.getMatch());
        maximumMisalignedNode.unmatch();
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

    private static <L> void doForEachPairOfMatchedNodes(DiffTree<L> parent, BiConsumer<DiffTree<L>, DiffTree<L>> handler, BiPredicate<DiffTree<L>, DiffTree<L>> discriminator)
    {
        DiffTree<L> current = getNodeGeneric(parent.getFirst(), 0, PopulateDiffTreeImpl::getNextMatched, a -> a.getReferenceType() == ReferenceType.NONE && a.isMatched());
        while (true) {
            DiffTree<L> next = getNodeGeneric(current, 1, PopulateDiffTreeImpl::getNextMatched, a -> a.getReferenceType() == ReferenceType.NONE);
            if (next == null) {
                break;
            }
            if (discriminator.test(current, next)) {
                handler.accept(current, next);
            }
            current = getNodeGeneric(current, 1, PopulateDiffTreeImpl::getNextMatched, a -> a.getReferenceType() == ReferenceType.NONE);
        }
    }

    /**
     * Ensures nodes are in correct form after running PopulateDiffTree.
     */
    private static <L> void rectifyNodes(DiffTree<L> toRectify)
    {
        DiffTree<L> current = toRectify.getFirst();
        int childNumber = -1;
        while (true)
        {
            if (current == null)
            {
                break;
            }
            if (current.getPrevious() == null || current.getPrevious() != null && current.getReferenceType().linesCreated + current.getPrevious()
                    .getReferenceType().linesCreated != 0 || current.getReferenceType() == NONE) {
                childNumber++;
            }
            if (current.getReferenceType() == MOVE_TO)
            {
                current.unmatch();
            }
            current.setChildNumber(childNumber);
            rectifyNodes(current);
            current = current.getNext();
        }
    }

    /**
     * Inserts a node after some other node.
     * Should be called on the parent of before
     * @param before The node before the new node
     * @param newNode The new node
     */
    private static <L> void insertNodeAfter(DiffTree<L> parent, DiffTree<L> before, DiffTree<L> newNode)
    {
        if (before == null)
        {
            newNode.setNext(parent.getFirst());
            if (parent.getFirst() != null)
            {
                parent.getFirst().setPrevious(newNode);
            }
            parent.setFirst(newNode);
        }
        else
        {
            DiffTree<L> oldAfter = before.getNext();
            before.setNext(newNode);
            newNode.setNext(oldAfter);
            newNode.setPrevious(before);
            if (oldAfter != null)
            {
                oldAfter.setPrevious(newNode);
            }
        }

        parent.getChildren().add(newNode);
    }

    /**
     * @return the next matched node after this ndoe, or null.
     */
    private static <L> DiffTree<L> getNextMatched(DiffTree<L> current)
    {
        return getNodeGeneric(current.getNext(), 0, DiffTree::getNext, a -> a.isMatched() && a.getParent() == current.getParent());
    }

    /**
     * @return the next matched NONE node after this ndoe, or null.
     */
    private static <L> DiffTree<L> getNextMatchedNone(DiffTree<L> current)
    {
        return getNodeGeneric(current.getNext(), 0, DiffTree::getNext, a -> a.isMatched() && a.getParent() == current.getParent() && a.getReferenceType() == NONE);
    }

    /**
     * @return the previous matched NONE after this node
     */
    private static <L> DiffTree<L> getPreviousMatchedNone(DiffTree<L> current)
    {
        return getNodeGeneric(current.getPrevious(), 0, DiffTree::getPrevious, a -> a.isMatched() && a.getParent() == current.getParent()&& a.getReferenceType() == NONE);
    }

    /**
     * @return the previous matched after this node
     */
    private static <L> DiffTree<L> getPreviousMatched(DiffTree<L> current)
    {
        return getNodeGeneric(current.getPrevious(), 0, DiffTree::getPrevious, a -> a.isMatched() && a.getParent() == current.getParent());
    }

    /**
     * Gets a node by some criteria
     * @param start The first node in the sequence
     * @param index Which node to get.
     * @param iterator The function to return the next node
     * @param discriminator The function to determine if it valid
     * @param <L> The label type
     * @return The node
     */
    private static <L> DiffTree<L> getNodeGeneric(DiffTree<L> start,  int index, UnaryOperator<DiffTree<L>> iterator, Predicate<DiffTree<L>> discriminator)
    {
        int currentIndex = 0;
        DiffTree<L> current = start;
        while (true)
        {
            if (current == null)
            {
                return null;
            }
            if (discriminator.test(current))
            {
                if (currentIndex == index)
                {
                    return current;
                }
                currentIndex++;
            }
            current = iterator.apply(current);
        }
    }

    /**
     * Determines whether two nodes are misaligned.
     * @param x The first node.
     * @param y The second node.
     * @param <L> The label type.
     * @return Whether they are misaligned.
     */
    static <L> boolean areNodesMisaligned(DiffTree<L> x, DiffTree<L> y)
    {
        if (x == null || y == null)
        {
            return false;
        }

        boolean xThenY = getNextMatchedNone(x) == y;
        DiffTree<L> xNextMatch = getNextMatchedNone(x.getMatch());
        DiffTree<L> xPrevMatch = getPreviousMatchedNone(x.getMatch());

        while (true)
        {
            if (xPrevMatch == y.getMatch())
            {
                return xThenY;
            }
            else if (xNextMatch == y.getMatch())
            {
                return !xThenY;
            }
            else if (xNextMatch == null && xPrevMatch == null)
            {
                return false;
            }
            else {
                xNextMatch = xNextMatch != null ? getNextMatchedNone(xNextMatch) : null;
                xPrevMatch = xPrevMatch != null ? getPreviousMatchedNone(xPrevMatch) : null;
            }
        }
    }

    /**
     * Gets the misaligned dual of x
     * @param x The node to get the dual of
     * @param <L> The label type
     * @return The misaligned dual, or null if x is not misaligned.
     */
    static <L> DiffTree<L> getMisalignedDual(DiffTree<L> x)
    {
        DiffTree<L> xMatch = x.getMatch();
        DiffTree<L> preX = getPreviousMatched(xMatch);
        DiffTree<L> postX = getNextMatched(xMatch);

        if (areNodesMisaligned(xMatch, preX))
        {
            return preX;
        } else if (areNodesMisaligned(xMatch, postX))
        {
            return postX;
        } else {
            return null;
        }
    }
}