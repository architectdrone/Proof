package org.architectdrone.javacodereviewprototype.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test suite hits a variety of different scenarios in the populate phase.
 * Due to the inherent complexity of trees, the tests are rather lengthy.
 */
class PopulateDiffTreeImplTest {
    PopulateDiffTree populateDiffTree = new PopulateDiffTreeImpl();

    static class Utils
    {
        static DiffTree<String> createNode(String name, List<DiffTree<String>> children, boolean isOriginal)
        {
            return new DiffTree<>(name, name, children, isOriginal);
        }

        static DiffTree<String> getSingleChild(DiffTree<String> parent, int childNumber)
        {
            List<DiffTree<String>> potentialChildren = parent.getChild(childNumber);
            assertEquals(1, potentialChildren.size());
            return potentialChildren.get(0);
        }
    }

    /**
     * Tests where we expect a node to be created.
     */
    @Nested
    class CreatingTests
    {
        /**
         * Unmatched node from the modified subtree means that a new node needs to be created.
         * This new node will be under the correct parent, and have a reference type of CREATE.
         * This first example uses a very simple structure.
         * The original tree consists of a single node (a1).
         * The modified tree consists of a node (a2) with one child (b2).
         */
        @Test
        void unmatchedNodeWithNoChildren_resultsInCreationInOriginal()
        {
            //Setup trees
            DiffTree<String> a1 = Utils.createNode("a1", Collections.emptyList(), true);

            DiffTree<String> b2 = Utils.createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = Utils.createNode("A2", Collections.singletonList(b2), false);

            //Match trees
            a1.setMatch(a2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertEquals(1, a1.getChildren().size());

            DiffTree<String> createdNode = Utils.getSingleChild(a1, 0);
            assertEquals(ReferenceType.CREATE, createdNode.getReferenceType());
            assertEquals("B2", createdNode.getLabel());
            assertEquals("B2", createdNode.getValue());
            assertEquals(b2, createdNode.getMatch());
        }

        /**
         * Creating a new node should work even when other nodes are present.
         * Both trees have a node "B" which are matched.
         * The modified tree has a node "C" after "B" which is unmatched.
         * We expect a node to be created with child number 1 in the original tree.
         */
        @Test
        void unmatchedNodeWithNoChildren_andSiblingBefore_resultsInCreationInOriginal_atCorrectPosition()
        {
            //Setup trees
            DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
            DiffTree<String> a1 = Utils.createNode("A1", Collections.singletonList(b1), true);

            DiffTree<String> c2 = Utils.createNode("C2", Collections.emptyList(), false);
            DiffTree<String> b2 = Utils.createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = Utils.createNode("A2", Arrays.asList(b2, c2), false);

            //Match trees
            a1.setMatch(a2);
            b1.setMatch(b2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertEquals(2, a1.getChildren().size());

            DiffTree<String> createdNode = Utils.getSingleChild(a1, 1);
            assertEquals(ReferenceType.CREATE, createdNode.getReferenceType());
            assertEquals("C2", createdNode.getLabel());
            assertEquals("C2", createdNode.getValue());
            assertEquals(c2, createdNode.getMatch());
        }

        /**
         * Same test as before, except the sibling is now *after* the new node.
         */
        @Test
        void unmatchedNodeWithNoChildren_andSiblingAfter_resultsInCreationInOriginal_atCorrectPosition()
        {
            //Setup trees
            DiffTree<String> c1 = Utils.createNode("c1", Collections.emptyList(), true);
            DiffTree<String> a1 = Utils.createNode("A1", Collections.singletonList(c1), true);

            DiffTree<String> c2 = Utils.createNode("C2", Collections.emptyList(), false);
            DiffTree<String> b2 = Utils.createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = Utils.createNode("A2", Arrays.asList(b2, c2), false);

            //Match trees
            a1.setMatch(a2);
            c1.setMatch(c2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertEquals(2, a1.getChildren().size());

            DiffTree<String> createdNode = Utils.getSingleChild(a1, 0);
            assertEquals(ReferenceType.CREATE, createdNode.getReferenceType());
            assertEquals("C2", createdNode.getLabel());
            assertEquals("C2", createdNode.getValue());
            assertEquals(b2, createdNode.getMatch());
        }

        /**
         * In this test, we have a new node between two children.
         * The tricky part here is that numbering must be preserved correctly.
         */
        @Test
        void unmatchedNodeWithNoChildren_andSiblingBeforeAndAfter_resultsInCreationInOriginal_atCorrectPosition()
        {
            //Setup trees
            DiffTree<String> d1 = Utils.createNode("d1", Collections.emptyList(), true);
            DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
            DiffTree<String> a1 = Utils.createNode("A1", Arrays.asList(b1, d1), true);

            DiffTree<String> d2 = Utils.createNode("D2", Collections.emptyList(), false);
            DiffTree<String> c2 = Utils.createNode("C2", Collections.emptyList(), false);
            DiffTree<String> b2 = Utils.createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = Utils.createNode("A2", Arrays.asList(b2, c2, d2), false);

            //Match trees
            a1.setMatch(a2);
            d1.setMatch(d2);
            b1.setMatch(b2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertEquals(3, a1.getChildren().size());

            DiffTree<String> c1 = Utils.getSingleChild(a1, 1);
            assertEquals(ReferenceType.CREATE, c1.getReferenceType());
            assertEquals("C2", c1.getLabel());
            assertEquals("C2", c1.getValue());
            assertEquals(c2, c1.getMatch());

            assertEquals(0, b1.getChildNumber());
            assertEquals(1, c1.getChildNumber());
            assertEquals(2, c2.getChildNumber());
        }

        /**
         * In this test, the new node has some children.
         * The original tree (A1) has no children.
         * The modified tree (A2) has one child (B2) which has it's own child (C2)
         * We expect a new node "B1" to be added as a child of A2, and a new node "C1" to be added as a child of "B1".
         * (Note that B1 and C1 are just aliases I am using. The names of the nodes will be "B2" and "C2" respectively)
         */
        @Test
        void unmatchedNodeWithSomeChildren_resultsInAllChildrenBeingAdded()
        {
            //Setup trees
            DiffTree<String> a1 = Utils.createNode("a1", Collections.emptyList(), true);

            DiffTree<String> c2 = Utils.createNode("C2", Collections.emptyList(), false);
            DiffTree<String> b2 = Utils.createNode("B2", Collections.singletonList(c2), false);
            DiffTree<String> a2 = Utils.createNode("A2", Collections.singletonList(b2), false);

            //Match trees
            a1.setMatch(a2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertEquals(1, a1.getChildren().size());

            DiffTree<String> b1 = Utils.getSingleChild(a1, 0);
            assertEquals(ReferenceType.CREATE, b1.getReferenceType());
            assertEquals("B2", b1.getLabel());
            assertEquals("B2", b1.getValue());
            assertEquals(b2, b1.getMatch());

            assertEquals(1, b1.getChildren().size());

            DiffTree<String> c1 = Utils.getSingleChild(b1, 0);
            assertEquals(ReferenceType.CREATE, c1.getReferenceType());
            assertEquals("C2", c1.getLabel());
            assertEquals("C2", c1.getValue());
            assertEquals(c2, c1.getMatch());
        }
    }

    /**
     * Tests where we expect a node to be deleted.
     * Also considers CREATE.
     */
    @Nested
    class DeletingTests
    {
        /**
         * If an unmatched node exists in original, it should be assigned the DELETE reference type.
         * In the original tree, we have root (A1) and one child (B1).
         * In the modified tree, we only have root (A2).
         * B1 should be deleted.
         */
        @Test
        void unmatchedNodeInOriginal_resultsInNodeDeleted()
        {
            //Setup trees
            DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
            DiffTree<String> a1 = Utils.createNode("A1", Collections.singletonList(b1), true);

            DiffTree<String> a2 = Utils.createNode("A2", Collections.emptyList(), false);

            //Match trees
            a1.setMatch(a2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertEquals(1, a1.getChildren().size());

            assertEquals(ReferenceType.DELETE, b1.getReferenceType());
            assertEquals("B1", b1.getLabel());
            assertEquals("B1", b1.getValue());
            assertFalse(b1.isMatched());
            assertEquals(0, b1.getChildNumber());
        }

        /**
         * In this test, the unmatched node has a matching sibling before it.
         * In the original tree, we have root (A1) and two children (B1 and C1).
         * In the modified tree, we have root (A2) and one child (B1).
         * C1 should be deleted.
         */
        @Test
        void unmatchedNodeInOriginal_andSiblingBefore_resultsInNodeDeleted()
        {
            //Setup trees
            DiffTree<String> c1 = Utils.createNode("c1", Collections.emptyList(), true);
            DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
            DiffTree<String> a1 = Utils.createNode("A1", Arrays.asList(b1, c1), true);

            DiffTree<String> b2 = Utils.createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = Utils.createNode("A2", Collections.singletonList(b2), false);

            //Match trees
            a1.setMatch(a2);
            b1.setMatch(b2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertEquals(2, a1.getChildren().size());

            assertEquals(ReferenceType.DELETE, c1.getReferenceType());
            assertEquals("C1", c1.getLabel());
            assertEquals("C1", c1.getValue());
            assertFalse(c1.isMatched());
            assertEquals(1, c1.getChildNumber());
        }

        /**
         * In this test, the unmatched node has a matching sibling after it.
         * In the original tree, we have root (A1) and two children (B1 and C1).
         * In the modified tree, we have root (A2) and one child (C1).
         * B1 should be deleted. C1 should have a child number of 0.
         */
        @Test
        void unmatchedNodeInOriginal_andSiblingAfter_resultsInNodeDeleted()
        {
            //Setup trees
            DiffTree<String> c1 = Utils.createNode("c1", Collections.emptyList(), true);
            DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
            DiffTree<String> a1 = Utils.createNode("A1", Arrays.asList(b1, c1), true);

            DiffTree<String> c2 = Utils.createNode("C2", Collections.emptyList(), false);
            DiffTree<String> a2 = Utils.createNode("A2", Collections.singletonList(c2), false);

            //Match trees
            a1.setMatch(a2);
            c1.setMatch(c2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertEquals(2, a1.getChildren().size());

            assertEquals(ReferenceType.DELETE, b1.getReferenceType());
            assertEquals("B1", b1.getLabel());
            assertEquals("B1", b1.getValue());
            assertFalse(b1.isMatched());
            assertEquals(0, b1.getChildNumber());

            assertEquals(0, c1.getChildNumber());
        }

        /**
         * In this test, the unmatched node has a matching sibling after it.
         * In the original tree, we have root (A1) and two children (B1, C1, and D1).
         * In the modified tree, we have root (A2) and one child (C1).
         * C1 should be deleted. A1 should have a child number of 0, and B1 should have child number of 1.
         */
        @Test
        void unmatchedNodeInOriginal_andSiblingBeforeAndAfter_resultsInNodeDeleted()
        {
            //Setup trees
            DiffTree<String> d1 = Utils.createNode("d1", Collections.emptyList(), true);
            DiffTree<String> c1 = Utils.createNode("c1", Collections.emptyList(), true);
            DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
            DiffTree<String> a1 = Utils.createNode("A1", Arrays.asList(b1, c1, d1), true);

            DiffTree<String> d2 = Utils.createNode("D2", Collections.emptyList(), false);
            DiffTree<String> b2 = Utils.createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = Utils.createNode("A2", Arrays.asList(b2, d2), false);

            //Match trees
            a1.setMatch(a2);
            b1.setMatch(b2);
            d1.setMatch(d2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertEquals(3, a1.getChildren().size());

            assertEquals(ReferenceType.DELETE, c1.getReferenceType());
            assertEquals("C1", c1.getLabel());
            assertEquals("C1", c1.getValue());
            assertFalse(c1.isMatched());
            assertEquals(1, c1.getChildNumber());

            assertEquals(0, a1.getChildNumber());
            assertEquals(1, b1.getChildNumber());
        }

        /**
         * In this test, the unmatched node has a child.
         * In the original tree, we have root (A1) and it's child (B1), who has it's own child, (C1).
         * In the modified tree, we have root (A2).
         * B1 and C1 should both be deleted.
         */
        @Test
        void unmatchedNodeInOriginal_withChildren_resultsInAllNodesDeleted()
        {
            //Setup trees
            DiffTree<String> c1 = Utils.createNode("c1", Collections.emptyList(), true);
            DiffTree<String> b1 = Utils.createNode("B1", Collections.singletonList(c1), true);
            DiffTree<String> a1 = Utils.createNode("A1", Collections.singletonList(b1), true);
            
            DiffTree<String> a2 = Utils.createNode("A2", Collections.emptyList(), false);

            //Match trees
            a1.setMatch(a2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertEquals(1, a1.getChildren().size());

            assertEquals(ReferenceType.DELETE, b1.getReferenceType());
            assertEquals("B1", b1.getLabel());
            assertEquals("B1", b1.getValue());
            assertFalse(b1.isMatched());
            assertEquals(0, b1.getChildNumber());

            assertEquals(1, b1.getChildren().size());

            assertEquals(ReferenceType.DELETE, c1.getReferenceType());
            assertEquals("C1", c1.getLabel());
            assertEquals("C1", c1.getValue());
            assertFalse(c1.isMatched());
            assertEquals(0, c1.getChildNumber());
        }

        /**
         * Considers the intersection of creating and deleting.
         */
        @Nested
        class AndCreating
        {
            /**
             * In this test, we have an unmatched node in the original and modified tree.
             * In the original tree, we have a root (A1) with one child (B1).
             * In the modified tree, we have a root (A2) with one child (C1).
             * We expect B1 to be DELETE, and a new node, C1, to be CREATE.
             * We also expect both nodes to have a childNumber of 0.
             */
            @Test
            void unmatchedNodeInOriginal_andUnmatchedNodeInModified_resultsInCreationAndDeletion()
            {
                //Setup trees
                DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
                DiffTree<String> a1 = Utils.createNode("A1", Collections.singletonList(b1), true);

                DiffTree<String> c2 = Utils.createNode("C2", Collections.emptyList(), false);
                DiffTree<String> a2 = Utils.createNode("A2", Collections.singletonList(c2), false);

                //Match trees
                a1.setMatch(a2);

                populateDiffTree.populateDiffTree(a1, a2);

                assertEquals(2, a1.getChildren().size());

                List<DiffTree<String>> allNodesAt0 = a1.getChild(0);
                assertTrue(allNodesAt0.contains(b1));

                assertEquals(ReferenceType.DELETE, b1.getReferenceType());
                assertEquals("B1", b1.getLabel());
                assertEquals("B1", b1.getValue());
                assertFalse(b1.isMatched());
                assertEquals(0, b1.getChildNumber());

                DiffTree<String> c1 = allNodesAt0
                        .stream()
                        .filter(a -> a.getLabel()
                                .equals("C2"))
                        .findFirst()
                        .get();
                assertEquals(ReferenceType.CREATE, c1.getReferenceType());
                assertEquals("C2", c1.getLabel());
                assertEquals("C2", c1.getValue());
                assertTrue(c1.isMatched());
                assertEquals(c2, c1.getMatch());
                assertEquals(0, c1.getChildNumber());
            }

            /**
             * In this test, we have a matched node that comes before the others.
             * In the original tree, we have a root (A1) with two children (B1, C1).
             * In the modified tree, we have a root (A2) with two children (B2, D2).
             * We expect C1 to be DELETE, and a new node, D1, to be CREATE.
             * We also expect B1 to be 0.
             * We also expect both reference nodes to have a childNumber of 1.
             */
            @Test
            void unmatchedNodeInOriginal_andUnmatchedNodeInModified_andMatchedNodeBefore_resultsInCreationAndDeletion()
            {
                //Setup trees
                DiffTree<String> c1 = Utils.createNode("c1", Collections.emptyList(), true);
                DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
                DiffTree<String> a1 = Utils.createNode("A1", Arrays.asList(b1, c1), true);

                DiffTree<String> d2 = Utils.createNode("D2", Collections.emptyList(), false);
                DiffTree<String> b2 = Utils.createNode("B2", Collections.emptyList(), false);
                DiffTree<String> a2 = Utils.createNode("A2", Arrays.asList(b2, d2), false);

                //Match trees
                a1.setMatch(a2);
                b1.setMatch(b2);

                populateDiffTree.populateDiffTree(a1, a2);

                assertEquals(3, a1.getChildren().size());

                assertEquals(0, b1.getChildNumber());

                List<DiffTree<String>> allNodesAt1 = a1.getChild(1);
                assertTrue(allNodesAt1.contains(c1));

                assertEquals(ReferenceType.DELETE, c1.getReferenceType());
                assertEquals("C1", c1.getLabel());
                assertEquals("C1", c1.getValue());
                assertFalse(c1.isMatched());
                assertEquals(0, c1.getChildNumber());

                DiffTree<String> d1 = allNodesAt1
                        .stream()
                        .filter(a -> a.getLabel()
                                .equals("D2"))
                        .findFirst()
                        .get();

                assertEquals(ReferenceType.CREATE, d1.getReferenceType());
                assertEquals("D2", d1.getLabel());
                assertEquals("D2", d1.getValue());
                assertTrue(d1.isMatched());
                assertEquals(d2, d1.getMatch());
                assertEquals(0, d1.getChildNumber());
            }

            /**
             * In this test, we have a matched node that comes before the others.
             * In the original tree, we have a root (A1) with two children (C1, B1).
             * In the modified tree, we have a root (A2) with two children (D2, B2).
             * We expect C1 to be DELETE, and a new node, D1, to be CREATE.
             * We also expect B1 to be 1.
             * We also expect both reference nodes to have a childNumber of 0.
             */
            @Test
            void unmatchedNodeInOriginal_andUnmatchedNodeInModified_andMatchedNodeAfter_resultsInCreationAndDeletion()
            {
                //Setup trees
                DiffTree<String> c1 = Utils.createNode("c1", Collections.emptyList(), true);
                DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
                DiffTree<String> a1 = Utils.createNode("A1", Arrays.asList(c1, b1), true);

                DiffTree<String> d2 = Utils.createNode("D2", Collections.emptyList(), false);
                DiffTree<String> b2 = Utils.createNode("B2", Collections.emptyList(), false);
                DiffTree<String> a2 = Utils.createNode("A2", Arrays.asList(d2, b2), false);

                //Match trees
                a1.setMatch(a2);
                b1.setMatch(b2);

                populateDiffTree.populateDiffTree(a1, a2);

                assertEquals(3, a1.getChildren().size());

                assertEquals(1, b1.getChildNumber());

                List<DiffTree<String>> allNodesAt1 = a1.getChild(1);
                assertTrue(allNodesAt1.contains(c1));

                assertEquals(ReferenceType.DELETE, c1.getReferenceType());
                assertEquals("C1", c1.getLabel());
                assertEquals("C1", c1.getValue());
                assertFalse(c1.isMatched());

                DiffTree<String> d1 = allNodesAt1
                        .stream()
                        .filter(a -> a.getLabel()
                                .equals("D2"))
                        .findFirst()
                        .get();

                assertEquals(ReferenceType.CREATE, d1.getReferenceType());
                assertEquals("D2", d1.getLabel());
                assertEquals("D2", d1.getValue());
                assertTrue(d1.isMatched());
                assertEquals(d2, d1.getMatch());
            }

            /**
             * In this test, we have a matched node that comes between the others, with the deleted node coming first.
             * In the original tree, we have a root (A1) with two children (C1, B1).
             * In the modified tree, we have a root (A2) with two children (B2, D2).
             * We expect C1 to be DELETE, and a new node, D1, to be CREATE.
             * We also expect both B1 and C1 to be 0.
             * We also expect D1 to be 1.
             */
            @Test
            void unmatchedNodeInOriginal_andUnmatchedNodeInModified_andMatchedNodeBetween_originalFirst_resultsInCreationAndDeletion()
            {
                //Setup trees
                DiffTree<String> c1 = Utils.createNode("c1", Collections.emptyList(), true);
                DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
                DiffTree<String> a1 = Utils.createNode("A1", Arrays.asList(c1, b1), true);

                DiffTree<String> d2 = Utils.createNode("D2", Collections.emptyList(), false);
                DiffTree<String> b2 = Utils.createNode("B2", Collections.emptyList(), false);
                DiffTree<String> a2 = Utils.createNode("A2", Arrays.asList(b2, d2), false);

                //Match trees
                a1.setMatch(a2);
                b1.setMatch(b2);

                populateDiffTree.populateDiffTree(a1, a2);

                assertEquals(3, a1.getChildren().size());

                assertEquals(0, b1.getChildNumber());

                List<DiffTree<String>> allNodesAt0 = a1.getChild(0);
                assertTrue(allNodesAt0.contains(c1));
                assertTrue(allNodesAt0.contains(b1));

                assertEquals(ReferenceType.DELETE, c1.getReferenceType());
                assertEquals("C1", c1.getLabel());
                assertEquals("C1", c1.getValue());
                assertFalse(c1.isMatched());

                DiffTree<String> d1 = Utils.getSingleChild(a1, 1);

                assertEquals(ReferenceType.CREATE, d1.getReferenceType());
                assertEquals("D2", d1.getLabel());
                assertEquals("D2", d1.getValue());
                assertTrue(d1.isMatched());
                assertEquals(d2, d1.getMatch());
            }

            /**
             * In this test, it's the same as before just reversed.
             * In the original tree, we have a root (A1) with two children (B1, C1).
             * In the modified tree, we have a root (A2) with two children (D2, B2).
             * We expect C1 to be DELETE, and a new node, D1, to be CREATE.
             * We expect D1 to be 0.
             * We expect B1 to be 1.
             * We expect C1 to also be 1.
             */
            @Test
            void unmatchedNodeInOriginal_andUnmatchedNodeInModified_andMatchedNodeBetween_originalLast_resultsInCreationAndDeletion()
            {
                //Setup trees
                DiffTree<String> c1 = Utils.createNode("c1", Collections.emptyList(), true);
                DiffTree<String> b1 = Utils.createNode("b1", Collections.emptyList(), true);
                DiffTree<String> a1 = Utils.createNode("A1", Arrays.asList(b1, c1), true);

                DiffTree<String> d2 = Utils.createNode("D2", Collections.emptyList(), false);
                DiffTree<String> b2 = Utils.createNode("B2", Collections.emptyList(), false);
                DiffTree<String> a2 = Utils.createNode("A2", Arrays.asList(d2, b2), false);

                //Match trees
                a1.setMatch(a2);
                b1.setMatch(b2);

                populateDiffTree.populateDiffTree(a1, a2);

                assertEquals(3, a1.getChildren().size());

                assertEquals(1, b1.getChildNumber());

                List<DiffTree<String>> allNodesAt1 = a1.getChild(1);
                assertTrue(allNodesAt1.contains(c1));
                assertTrue(allNodesAt1.contains(b1));

                assertEquals(ReferenceType.DELETE, c1.getReferenceType());
                assertEquals("C1", c1.getLabel());
                assertEquals("C1", c1.getValue());
                assertFalse(c1.isMatched());

                DiffTree<String> d1 = Utils.getSingleChild(a1, 0);

                assertEquals(ReferenceType.CREATE, d1.getReferenceType());
                assertEquals("D2", d1.getLabel());
                assertEquals("D2", d1.getValue());
                assertTrue(d1.isMatched());
                assertEquals(d2, d1.getMatch());
            }
        }
    }
}