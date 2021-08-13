package org.architectdrone.javacodereviewprototype.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.architectdrone.javacodereviewprototype.tree.PopulateDiffTreeImplTest.Utils.*;
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

        static void assertDeleted(DiffTree<String> node)
        {
            assertEquals(ReferenceType.DELETE, node.getReferenceType());
            assertFalse(node.isMatched());
        }

        static void assertCreated(DiffTree<String> node)
        {
            assertEquals(ReferenceType.CREATE, node.getReferenceType());
            assertTrue(node.isMatched());
        }

        static void assertNone(DiffTree<String> node)
        {
            assertEquals(ReferenceType.NONE, node.getReferenceType());
            assertTrue(node.isMatched());
        }

        static void assertMatch(DiffTree<String> a, DiffTree<String> b)
        {
            assertEquals(a, b.getMatch());
        }

        static void assertName(DiffTree<String> node, String name)
        {
            assertEquals(name, node.getLabel());
            assertEquals(name, node.getValue());
        }

        static void assertNumberOfChildren(DiffTree<String> node, int number)
        {
            assertEquals(number, node.getChildren().size());
        }

        static void assertChildNumber(DiffTree<String> node, int number)
        {
            assertEquals(number, node.getChildNumber());
        }

        static DiffTree<String> getNodeWithLabel(DiffTree<String> tree, String label)
        {
            return tree
                    .getChildren()
                    .stream()
                    .filter(a -> a.getLabel()
                            .equals(label))
                    .findFirst()
                    .get();
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
            DiffTree<String> a1 = createNode("a1", Collections.emptyList(), true);

            DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = createNode("A2", Collections.singletonList(b2), false);

            //Match trees
            a1.setMatch(a2);

            populateDiffTree.populateDiffTree(a1, a2);
            assertNumberOfChildren(a1, 1);
            DiffTree<String> b1 = getSingleChild(a1, 0);

            assertCreated(b1);
            assertName(b1, "B2");
            assertMatch(b1, b2);
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
            DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
            DiffTree<String> a1 = createNode("A1", Collections.singletonList(b1), true);

            DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
            DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = createNode("A2", Arrays.asList(b2, c2), false);

            //Match trees
            a1.setMatch(a2);
            b1.setMatch(b2);

            populateDiffTree.populateDiffTree(a1, a2);
            DiffTree<String> c1 = getNodeWithLabel(a1, "C2");

            assertNumberOfChildren(a1, 2);
            assertMatch(c1, c2);

            assertCreated(c1);
            assertNone(b1);
        }

        /**
         * Same test as before, except the sibling is now *after* the new node.
         */
        @Test
        void unmatchedNodeWithNoChildren_andSiblingAfter_resultsInCreationInOriginal_atCorrectPosition()
        {
            //Setup trees
            DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
            DiffTree<String> a1 = createNode("A1", Collections.singletonList(c1), true);

            DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
            DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = createNode("A2", Arrays.asList(b2, c2), false);

            //Match trees
            a1.setMatch(a2);
            c1.setMatch(c2);

            populateDiffTree.populateDiffTree(a1, a2);
            DiffTree<String> b1 = getSingleChild(a1, 0);

            assertNumberOfChildren(a1, 2);
            assertMatch(b1, b2);

            assertCreated(b1);
            assertNone(c1);
        }

        /**
         * In this test, we have a new node between two children.
         * The tricky part here is that numbering must be preserved correctly.
         */
        @Test
        void unmatchedNodeWithNoChildren_andSiblingBeforeAndAfter_resultsInCreationInOriginal_atCorrectPosition()
        {
            //Setup trees
            DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
            DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
            DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, d1), true);

            DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
            DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
            DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = createNode("A2", Arrays.asList(b2, c2, d2), false);

            //Match trees
            a1.setMatch(a2);
            d1.setMatch(d2);
            b1.setMatch(b2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertNumberOfChildren(a1, 3);

            DiffTree<String> c1 = getSingleChild(a1, 1);
            assertCreated(c1);
            assertName(c1, "C2");
            
            assertMatch(c1, c2);

            assertChildNumber(b1, 0);
            assertChildNumber(c1, 1);
            assertChildNumber(d1, 2);

            assertNone(d1);
            assertNone(b1);
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
            DiffTree<String> a1 = createNode("a1", Collections.emptyList(), true);

            DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
            DiffTree<String> b2 = createNode("B2", Collections.singletonList(c2), false);
            DiffTree<String> a2 = createNode("A2", Collections.singletonList(b2), false);

            //Match trees
            a1.setMatch(a2);

            populateDiffTree.populateDiffTree(a1, a2);
            DiffTree<String> b1 = getSingleChild(a1, 0);
            DiffTree<String> c1 = getSingleChild(b1, 0);

            assertNumberOfChildren(a1, 1);
            assertNumberOfChildren(b1, 1);

            assertMatch(b1, b2);
            assertMatch(c1, c2);

            assertCreated(b1);
            assertCreated(c1);
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
            DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
            DiffTree<String> a1 = createNode("A1", Collections.singletonList(b1), true);

            DiffTree<String> a2 = createNode("A2", Collections.emptyList(), false);

            //Match trees
            a1.setMatch(a2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertNumberOfChildren(a1, 1);

            assertDeleted(b1);
            assertName(b1, "B1");
            assertChildNumber(b1, 0);
        }

        /**
         * In this test, the unmatched node has a matching sibling before it.
         * In the original tree, we have root (A1) and two children (B1 and C1).
         * In the modified tree, we have root (A2) and one child (B1).
         * C1 should be deleted.
         * C1 and B1 should both have CN of 0.
         */
        @Test
        void unmatchedNodeInOriginal_andSiblingBefore_resultsInNodeDeleted()
        {
            //Setup trees
            DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
            DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
            DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, c1), true);

            DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = createNode("A2", Collections.singletonList(b2), false);

            //Match trees
            a1.setMatch(a2);
            b1.setMatch(b2);

            populateDiffTree.populateDiffTree(a1, a2);
            assertChildNumber(b1, 0);

            assertNumberOfChildren(a1, 2);

            assertDeleted(c1);
            assertNone(b1);

            assertChildNumber(c1, 0);
            assertChildNumber(b1, 0);
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
            DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
            DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
            DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, c1), true);

            DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
            DiffTree<String> a2 = createNode("A2", Collections.singletonList(c2), false);

            //Match trees
            a1.setMatch(a2);
            c1.setMatch(c2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertNumberOfChildren(a1, 2);

            assertDeleted(b1);
            assertNone(c1);

            assertChildNumber(b1, 0);
            assertChildNumber(c1, 0);
        }

        /**
         * In this test, the unmatched node has a matching sibling after it.
         * In the original tree, we have root (A1) and three children (B1, C1, and D1).
         * In the modified tree, we have root (A2) and two children (B1, D1).
         * C1 should be deleted.
         * B1 and C1 should have a child number of 0
         * D1 should have child number of 1.
         */
        @Test
        void unmatchedNodeInOriginal_andSiblingBeforeAndAfter_resultsInNodeDeleted()
        {
            //Setup trees
            DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
            DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
            DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
            DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, c1, d1), true);

            DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
            DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
            DiffTree<String> a2 = createNode("A2", Arrays.asList(b2, d2), false);

            //Match trees
            a1.setMatch(a2);
            b1.setMatch(b2);
            d1.setMatch(d2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertNumberOfChildren(a1, 3);

            assertNone(b1);
            assertDeleted(c1);
            assertNone(d1);

            assertChildNumber(c1, 0);
            assertChildNumber(b1, 0);
            assertChildNumber(d1, 1);
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
            DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
            DiffTree<String> b1 = createNode("B1", Collections.singletonList(c1), true);
            DiffTree<String> a1 = createNode("A1", Collections.singletonList(b1), true);
            
            DiffTree<String> a2 = createNode("A2", Collections.emptyList(), false);

            //Match trees
            a1.setMatch(a2);

            populateDiffTree.populateDiffTree(a1, a2);

            assertNumberOfChildren(a1, 1);
            assertNumberOfChildren(b1, 1);

            assertChildNumber(b1, 0);
            assertChildNumber(c1, 0);

            assertDeleted(c1);
            assertDeleted(b1);
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
                DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                DiffTree<String> a1 = createNode("A1", Collections.singletonList(b1), true);

                DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
                DiffTree<String> a2 = createNode("A2", Collections.singletonList(c2), false);

                //Match trees
                a1.setMatch(a2);

                populateDiffTree.populateDiffTree(a1, a2);
                DiffTree<String> c1 = getNodeWithLabel(a1, "C2");

                assertNumberOfChildren(a1, 2);

                assertDeleted(b1);
                assertCreated(c1);

                assertMatch(c1, c2);

                assertChildNumber(c1, 0);
                assertChildNumber(b1, 0);
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
                DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, c1), true);

                DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                DiffTree<String> a2 = createNode("A2", Arrays.asList(b2, d2), false);

                //Match trees
                a1.setMatch(a2);
                b1.setMatch(b2);

                populateDiffTree.populateDiffTree(a1, a2);
                DiffTree<String> d1 = getNodeWithLabel(a1, "D2");

                assertNumberOfChildren(a1, 3);

                assertNone(b1);
                assertDeleted(c1);
                assertCreated(d1);

                assertMatch(d1, d2);

                assertChildNumber(b1, 0);
                assertChildNumber(c1, 1);
                assertChildNumber(d1, 1);
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
                DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                DiffTree<String> a1 = createNode("A1", Arrays.asList(c1, b1), true);

                DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                DiffTree<String> a2 = createNode("A2", Arrays.asList(d2, b2), false);

                //Match trees
                a1.setMatch(a2);
                b1.setMatch(b2);

                populateDiffTree.populateDiffTree(a1, a2);
                DiffTree<String> d1 = getNodeWithLabel(a1, "D2");

                assertNumberOfChildren(a1, 3);

                assertMatch(d1, d2);

                assertChildNumber(b1, 1);
                assertChildNumber(c1, 0);
                assertChildNumber(d1, 0);

                assertNone(b1);
                assertDeleted(c1);
                assertCreated(d1);
            }

            /**
             * In this test, we have a matched node that comes between the others, with the deleted node coming first.
             * In the original tree, we have a root (A1) with two children (C1, B1).
             * In the modified tree, we have a root (A2) with two children (B2, D2).
             * We expect C1 to be DELETE, and a new node, D1, to be CREATE.
             * We expect C1 to be 0.
             * We expect B1 to be 1.
             * We expect D1 to be 2.
             */
            @Test
            void unmatchedNodeInOriginal_andUnmatchedNodeInModified_andMatchedNodeBetween_originalFirst_resultsInCreationAndDeletion()
            {
                //Setup trees
                DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                DiffTree<String> a1 = createNode("A1", Arrays.asList(c1, b1), true);

                DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                DiffTree<String> a2 = createNode("A2", Arrays.asList(b2, d2), false);

                //Match trees
                a1.setMatch(a2);
                b1.setMatch(b2);

                populateDiffTree.populateDiffTree(a1, a2);

                assertNumberOfChildren(a1, 3);

                assertChildNumber(c1, 0);
                assertChildNumber(b1, 1);
                DiffTree<String> d1 = getSingleChild(a1, 2);

                assertNone(b1);
                assertDeleted(c1);
                assertCreated(d1);

                assertMatch(d1, d2);

                assertChildNumber(b1, 1);
                assertChildNumber(c1, 0);
                assertChildNumber(d1, 2);
            }

            /**
             * In this test, it's the same as before just reversed.
             * In the original tree, we have a root (A1) with two children (B1, C1).
             * In the modified tree, we have a root (A2) with two children (D2, B2).
             * We expect C1 to be DELETE, and a new node, D1, to be CREATE.
             * We expect D1 to be 0.
             * We expect B1 to be 1.
             * We expect C1 to be 2.
             */
            @Test
            void unmatchedNodeInOriginal_andUnmatchedNodeInModified_andMatchedNodeBetween_originalLast_resultsInCreationAndDeletion()
            {
                //Setup trees
                DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, c1), true);

                DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                DiffTree<String> a2 = createNode("A2", Arrays.asList(d2, b2), false);

                //Match trees
                a1.setMatch(a2);
                b1.setMatch(b2);

                populateDiffTree.populateDiffTree(a1, a2);
                DiffTree<String> d1 = getSingleChild(a1, 0);

                assertNumberOfChildren(a1, 3);

                assertChildNumber(b1, 1);
                assertChildNumber(c1, 2);

                assertNone(b1);
                assertDeleted(c1);
                assertCreated(d1);
                
                assertMatch(d1, d2);
            }
        }
    }
}