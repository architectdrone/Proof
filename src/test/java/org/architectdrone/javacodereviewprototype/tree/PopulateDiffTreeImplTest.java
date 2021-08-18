package org.architectdrone.javacodereviewprototype.tree;

import com.github.javaparser.utils.Pair;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
        enum TreeNames
        {
            A("A"),
            B("B"),
            C("C"),
            D("D"),
            E("E"),
            F("F"),
            G("G");

            String name;

            TreeNames(String name)
            {
                this.name = name;
            }
        }

        static DiffTree<String> createNode(String name, List<DiffTree<String>> children, boolean isOriginal)
        {
            return new DiffTree<>(name, name, children, isOriginal);
        }

        static DiffTree<String> createANode(boolean isOriginal, DiffTree<String>... children )
        {
            return createNode("A", Arrays.asList(children), isOriginal);
        }

        static DiffTree<String> createBNode(boolean isOriginal, DiffTree<String>... children )
        {
            return createNode("B", Arrays.asList(children), isOriginal);
        }

        static DiffTree<String> createCNode(boolean isOriginal, DiffTree<String>... children )
        {
            return createNode("C", Arrays.asList(children), isOriginal);
        }

        static DiffTree<String> createDNode(boolean isOriginal, DiffTree<String>... children )
        {
            return createNode("D", Arrays.asList(children), isOriginal);
        }

        static DiffTree<String> createENode(boolean isOriginal, DiffTree<String>... children )
        {
            return createNode("E", Arrays.asList(children), isOriginal);
        }

        static DiffTree<String> createFNode(boolean isOriginal, DiffTree<String>... children )
        {
            return createNode("F", Arrays.asList(children), isOriginal);
        }

        static DiffTree<String> createGNode(boolean isOriginal, DiffTree<String>... children )
        {
            return createNode("G", Arrays.asList(children), isOriginal);
        }

//        static DiffTree<String> createModifiedSingleLevelTree(DiffTree<String> originalSingleLevelTree, TreeNames... treeNames)
//        {
//            DiffTree<String> newTree = createSingleLevelTree(false, treeNames);
//            Pair<DiffTree<String>, DiffTree<String>>
//        }
//
//        static DiffTree<String> createOriginalSingleLevelTree(TreeNames... treeNames) {
//            return createSingleLevelTree(true, treeNames);
//        }
//
//        static DiffTree<String> createSingleLevelTree(boolean isOriginal, TreeNames... treeNames)
//        {
//            return createNode(
//                "A",
//                Arrays.stream(treeNames)
//                    .map(treeName -> treeName.name)
//                    .map(name -> createNode(name, Collections.emptyList(), isOriginal))
//                    .collect(Collectors.toList()),
//                isOriginal);
//        }

        static DiffTree<String> getSingleChild(DiffTree<String> parent, int childNumber)
        {
            List<DiffTree<String>> potentialChildren = parent.getChild(childNumber);
            assertEquals(1, potentialChildren.size());
            return potentialChildren.get(0);
        }

        static DiffTree<String> getNodeWithType(DiffTree<String> parent, ReferenceType referenceType)
        {
            List<DiffTree<String>> potentialChildren = parent.getChildren().stream().filter(a -> a.getReferenceType() == referenceType).collect(Collectors.toList());
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

        static void assertMovedTo(DiffTree<String> node)
        {
            assertEquals(ReferenceType.MOVE_TO, node.getReferenceType());
            assertTrue(node.isMatched());
        }

        static void assertMovedFrom(DiffTree<String> node)
        {
            assertEquals(ReferenceType.MOVE_FROM, node.getReferenceType());
            assertFalse(node.isMatched());
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

        static void assertParent(DiffTree<String> child, DiffTree<String> parent)
        {
            assertEquals(parent, child.getParent());
        }

        static void assertNumberOfChildren(DiffTree<String> node, int number)
        {
            assertEquals(number, node.getChildren().size());
        }

        static void assertChildNumber(DiffTree<String> node, int number)
        {
            assertEquals(number, node.getChildNumber());
        }

        static void assertPointsAt(DiffTree<String> moveTo, DiffTree<String> moveFrom)
        {
            assertEquals(moveFrom, moveTo.getReferenceLocation());
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
         * B1 should be 0
         * C1 should be 1
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

            assertChildNumber(b1, 0);
            assertChildNumber(c1, 1);
        }

        /**
         * In this test, the unmatched node has a matching sibling after it.
         * In the original tree, we have root (A1) and two children (B1 and C1).
         * In the modified tree, we have root (A2) and one child (C1).
         * B1 should be deleted.
         * B1 should be 0
         * C1 should be 1
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
            assertChildNumber(c1, 1);
        }

        /**
         * In this test, the unmatched node has a matching sibling after it.
         * In the original tree, we have root (A1) and three children (B1, C1, and D1).
         * In the modified tree, we have root (A2) and two children (B1, D1).
         * C1 should be deleted.
         * B1 should be 0
         * C1 should be 1
         * D1 should be 2
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

            assertChildNumber(b1, 0);
            assertChildNumber(c1, 1);
            assertChildNumber(d1, 2);
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

                assertChildNumber(d1, 0);
                assertChildNumber(b1, 1);
                assertChildNumber(c1, 2);

                assertNone(b1);
                assertDeleted(c1);
                assertCreated(d1);
                
                assertMatch(d1, d2);
            }
        }
    }

    /**
     * Tests where we expect a node to be moved.
     * Also considers CREATE and DELETE
     */
    @Nested
    class MovingTests
    {
        /**
         * Tests where the nodes share a parent.
         */
        @Nested
        class SameParents
        {
            /**
             * Tests where the order of two nodes is swapped, with no nodes between.
             */
            @Nested
            class PerfectSwap
            {

                /**
                 * In the original tree, we have B1 and C1.
                 * In the modified tree, we have C2 and B2.
                 * This is called a "perfect swap".
                 * Although two swaps could be registered, we just want one.
                 * (This is arbitrary, but we need to make a choice)
                 * Therefore, we default to only counting the first as a swap.
                 * That is, in the same parent, code moves downwards, not upwards.
                 * Following this logic, B1 should be moved, and C1 should be none.
                 * At 0, we want a MOVE_TO for B1, pointing at the MOVE_FROM.
                 * At 1, we want C1, with type NONE.
                 * At 2, we want a MOVE_FROM for B1.
                 */
                @Test
                void perfectSwap_causesMove()
                {
                    //Setup trees
                    DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                    DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                    DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, c1), true);

                    DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
                    DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                    DiffTree<String> a2 = createNode("A2", Arrays.asList(c2, b2), false);

                    //Match trees
                    a1.setMatch(a2);
                    b1.setMatch(b2);
                    c1.setMatch(c2);

                    populateDiffTree.populateDiffTree(a1, a2);
                    DiffTree<String> b1_mt = b1;
                    DiffTree<String> b1_mf = getSingleChild(a1, 2);

                    assertChildNumber(b1_mt, 0);
                    assertChildNumber(c1, 1);
                    assertChildNumber(b1_mf, 2);

                    assertMovedFrom(b1_mf);
                    assertNone(c1);
                    assertMovedTo(b1_mt);

                    assertPointsAt(b1_mt, b1_mf);
                }

                /**
                 * In the original tree, we have B1, C1, D1, E1.
                 * In the modified tree, we have C2, B2, E1, D1.
                 * 0 - B, MT
                 * 1 - C, N
                 * 2 - B, MF (These will both be two because the net change is 0)
                 * 2 - D, MT
                 * 3 - E, N
                 * 4 - D, MF
                 */
                @Test
                void twoPerfectSwaps_causesTwoMoves()
                {
                    //Setup trees
                    DiffTree<String> e1 = createNode("E1", Collections.emptyList(), true);
                    DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                    DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                    DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                    DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, c1, d1, e1), true);

                    DiffTree<String> e2 = createNode("E2", Collections.emptyList(), false);
                    DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                    DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
                    DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                    DiffTree<String> a2 = createNode("A2", Arrays.asList(c2, b2, e2, d2), false);

                    //Match trees
                    a1.setMatch(a2);
                    b1.setMatch(b2);
                    c1.setMatch(c2);
                    d1.setMatch(d2);
                    e1.setMatch(e2);

                    populateDiffTree.populateDiffTree(a1, a2);
                    DiffTree<String> b1_mt = b1;
                    DiffTree<String> b1_mf = a1.getChild(2).stream().filter(a -> a.getReferenceType() == ReferenceType.MOVE_FROM).findFirst().get();
                    DiffTree<String> d1_mt = d1;
                    DiffTree<String> d1_mf = getSingleChild(a1, 4);

                    assertChildNumber(b1_mt, 0);
                    assertChildNumber(c1, 1);
                    assertChildNumber(b1_mf, 2);
                    assertChildNumber(d1_mt, 2);
                    assertChildNumber(e1, 3);
                    assertChildNumber(d1_mf, 4);

                    assertMovedFrom(b1_mf);
                    assertNone(c1);
                    assertMovedTo(b1_mt);
                    assertMovedFrom(d1_mf);
                    assertNone(e1);
                    assertMovedTo(d1_mt);

                    assertPointsAt(b1_mt, b1_mf);
                    assertPointsAt(d1_mt, d1_mf);
                }

                /**
                 * In the original tree, we have D1, B1 and C1.
                 * In the modified tree, we have D2, C2 and B2.
                 * Outside the "critical region", we, of course, expect nodes to be untouched
                 * At 0, we want D1.
                 * At 1, we want a MOVE_TO for B1, pointing at the MOVE_TO.
                 * At 2, we want C1, with type NONE.
                 * At 3, we want a MOVE_FROM for B1.
                 */
                @Test
                void perfectSwap_withNodeBefore_causesMove()
                {
                    //Setup trees
                    DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                    DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                    DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                    DiffTree<String> a1 = createNode("A1", Arrays.asList(d1, b1, c1), true);

                    DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                    DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
                    DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                    DiffTree<String> a2 = createNode("A2", Arrays.asList(d2, c2, b2), false);

                    //Match trees
                    a1.setMatch(a2);
                    b1.setMatch(b2);
                    c1.setMatch(c2);
                    d1.setMatch(d2);

                    populateDiffTree.populateDiffTree(a1, a2);
                    DiffTree<String> b1_mt = b1;
                    DiffTree<String> b1_mf = getSingleChild(a1, 3);

                    assertChildNumber(d1, 0);
                    assertChildNumber(b1_mt, 1);
                    assertChildNumber(c1, 2);
                    assertChildNumber(b1_mf, 3);

                    assertNone(d1);
                    assertMovedFrom(b1_mf);
                    assertNone(c1);
                    assertMovedTo(b1_mt);

                    assertPointsAt(b1_mt, b1_mf);
                }

                /**
                 * In the original tree, we have B1, C1 and D1.
                 * In the modified tree, we have C2, B2 and D2.
                 * Outside the "critical region", we, of course, expect nodes to be untouched
                 * At 0, we want a MOVE_TO for B1, pointing at the MOVE_TO.
                 * At 1, we want C1, with type NONE.
                 * At 2, we want a MOVE_FROM for B1.
                 * At 3, we want D1.
                 */
                @Test
                void perfectSwap_sameParent_differentOrder_withNodeAfter_causesMove()
                {
                    //Setup trees
                    DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                    DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                    DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                    DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, c1, d1), true);

                    DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                    DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
                    DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                    DiffTree<String> a2 = createNode("A2", Arrays.asList(c2, b2, d2), false);

                    //Match trees
                    a1.setMatch(a2);
                    b1.setMatch(b2);
                    c1.setMatch(c2);
                    d1.setMatch(d2);

                    populateDiffTree.populateDiffTree(a1, a2);
                    DiffTree<String> b1_mt = b1;
                    DiffTree<String> b1_mf = getSingleChild(a1, 2);

                    assertChildNumber(b1_mt, 0);
                    assertChildNumber(c1, 1);
                    assertChildNumber(b1_mf, 2);
                    assertChildNumber(d1, 3);

                    assertNone(d1);
                    assertMovedFrom(b1_mf);
                    assertNone(c1);
                    assertMovedTo(b1_mt);

                    assertPointsAt(b1_mt, b1_mf);
                }

                /**
                 * In the original tree, we have D1, B1, C1 and E1.
                 * In the modified tree, we have D1, C2, B2 and E2.
                 *
                 * At 0, we want D1.
                 * At 1, we want a MOVE_TO for B1, pointing at the MOVE_TO.
                 * At 2, we want C1, with type NONE.
                 * At 3, we want a MOVE_FROM for B1.
                 * At 4, we want E1.
                 */
                @Test
                void perfectSwap_withNodeBeforeAndAfter_causesMove()
                {
                    //Setup trees
                    DiffTree<String> e1 = createNode("E1", Collections.emptyList(), true);
                    DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                    DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                    DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                    DiffTree<String> a1 = createNode("A1", Arrays.asList(d1, b1, c1, e1), true);

                    DiffTree<String> e2 = createNode("E2", Collections.emptyList(), false);
                    DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                    DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
                    DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                    DiffTree<String> a2 = createNode("A2", Arrays.asList(d2, c2, b2, e2), false);

                    //Match trees
                    a1.setMatch(a2);
                    b1.setMatch(b2);
                    c1.setMatch(c2);
                    d1.setMatch(d2);
                    e1.setMatch(e2);

                    populateDiffTree.populateDiffTree(a1, a2);
                    DiffTree<String> b1_mt = b1;
                    DiffTree<String> b1_mf = getSingleChild(a1, 3);

                    assertChildNumber(d1, 0);
                    assertChildNumber(b1_mt, 1);
                    assertChildNumber(c1, 2);
                    assertChildNumber(b1_mf, 3);
                    assertChildNumber(e1, 4);

                    assertNone(d1);
                    assertMovedFrom(b1_mf);
                    assertNone(c1);
                    assertMovedTo(b1_mt);
                    assertNone(e1);

                    assertPointsAt(b1_mt, b1_mf);
                }

                /**
                 * Tests examining the intersection between CREATE and MOVE.
                 */
                @Nested
                class AndCreation {
                    /**
                     * In the original tree, we have B1, D1.
                     * In the modified tree, we have C2, D2, B2.
                     *
                     * At 0, we want C1, CREATE.
                     * At 0, we want B1, MT.
                     * At 1, we want D1, NONE.
                     * At 2, we want B1, MF.
                     */
                    @Test
                    void perfectSwap_andNodeBefore_works()
                    {
                        //Setup trees
                        DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                        DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                        DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, d1), true);

                        DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                        DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
                        DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                        DiffTree<String> a2 = createNode("A2", Arrays.asList(c2, d2, b2), false);

                        //Match trees
                        a1.setMatch(a2);
                        b1.setMatch(b2);
                        d1.setMatch(d2);

                        populateDiffTree.populateDiffTree(a1, a2);
                        DiffTree<String> b1_mt = b1;
                        DiffTree<String> b1_mf = getSingleChild(a1, 2);
                        DiffTree<String> c1 = getNodeWithType(a1, ReferenceType.CREATE);

                        assertChildNumber(c1, 0);
                        assertChildNumber(b1_mt, 0);
                        assertChildNumber(d1, 1);
                        assertChildNumber(b1_mf, 2);

                        assertCreated(c1);
                        assertMovedFrom(b1_mf);
                        assertNone(d1);
                        assertMovedTo(b1_mt);

                        assertPointsAt(b1_mt, b1_mf);
                    }

                    /**
                     * In the original tree, we have B1, D1.
                     * In the modified tree, we have D2, B2, C2.
                     *
                     * At 0, we want B1, MF.
                     * At 1, we want D1, NONE.
                     * At 2, we want B1, MT.
                     * At 3, we want C1, CREATE.
                     */
                    @Test
                    void perfectSwap_andNodeAfter_works()
                    {
                        //Setup trees
                        DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                        DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                        DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, d1), true);

                        DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                        DiffTree<String> c2 = createNode("C2", Collections.emptyList(), false);
                        DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                        DiffTree<String> a2 = createNode("A2", Arrays.asList(d2, b2, c2), false);

                        //Match trees
                        a1.setMatch(a2);
                        b1.setMatch(b2);
                        d1.setMatch(d2);

                        populateDiffTree.populateDiffTree(a1, a2);
                        DiffTree<String> b1_mt = b1;
                        DiffTree<String> b1_mf = getSingleChild(a1, 2);
                        DiffTree<String> c1 = getSingleChild(a1, 3);

                        assertChildNumber(b1_mt, 0);
                        assertChildNumber(d1, 1);
                        assertChildNumber(b1_mf, 2);
                        assertChildNumber(c1, 3);

                        assertMovedFrom(b1_mf);
                        assertNone(d1);
                        assertMovedTo(b1_mt);
                        assertCreated(c1);

                        assertPointsAt(b1_mt, b1_mf);
                    }
                }

                /**
                 * Tests examining the intersection between DELETE and MOVE.
                 */
                @Nested
                class AndDeletion {
                    /**
                     * In the original tree, we have C1, B1, D1.
                     * In the modified tree, we have D2, B2.
                     *
                     * At 0, we want C1, DELETE.
                     * At 1, we want B1, MT.
                     * At 2, we want D1, NONE.
                     * At 3, we want B1, MF.
                     */
                    @Test
                    void perfectSwap_andNodeBefore_works()
                    {
                        //Setup trees
                        DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                        DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                        DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                        DiffTree<String> a1 = createNode("A1", Arrays.asList(c1, b1, d1), true);

                        DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                        DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                        DiffTree<String> a2 = createNode("A2", Arrays.asList(d2, b2), false);

                        //Match trees
                        a1.setMatch(a2);
                        b1.setMatch(b2);
                        d1.setMatch(d2);

                        populateDiffTree.populateDiffTree(a1, a2);
                        DiffTree<String> b1_mt = b1;
                        DiffTree<String> b1_mf = getSingleChild(a1, 3);

                        assertChildNumber(c1, 0);
                        assertChildNumber(b1_mt, 1);
                        assertChildNumber(d1, 2);
                        assertChildNumber(b1_mf, 3);

                        assertDeleted(c1);
                        assertMovedFrom(b1_mf);
                        assertNone(d1);
                        assertMovedTo(b1_mt);

                        assertPointsAt(b1_mt, b1_mf);
                    }

                    /**
                     * In the original tree, we have B1, D1, C1.
                     * In the modified tree, we have D2, B2.
                     *
                     * At 0, we want B1, MT.
                     * At 1, we want D1, NONE.
                     * At 2, we want B1, MF.
                     * At 3, we want C1, DELETE.
                     */
                    @Test
                    void perfectSwap_andNodeAfter_works()
                    {
                        //Setup trees
                        DiffTree<String> c1 = createNode("C1", Collections.emptyList(), true);
                        DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                        DiffTree<String> b1 = createNode("B1", Collections.emptyList(), true);
                        DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, d1, c1), true);

                        DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                        DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                        DiffTree<String> a2 = createNode("A2", Arrays.asList(d2, b2), false);

                        //Match trees
                        a1.setMatch(a2);
                        b1.setMatch(b2);
                        d1.setMatch(d2);

                        populateDiffTree.populateDiffTree(a1, a2);
                        DiffTree<String> b1_mt = b1;
                        DiffTree<String> b1_mf = getNodeWithType(a1, ReferenceType.MOVE_FROM);

                        assertChildNumber(b1_mt, 0);
                        assertChildNumber(d1, 1);
                        assertChildNumber(b1_mf, 2);
                        assertChildNumber(c1, 2);

                        assertDeleted(c1);
                        assertMovedFrom(b1_mf);
                        assertNone(d1);
                        assertMovedTo(b1_mt);

                        assertPointsAt(b1_mt, b1_mf);
                    }
                }
            }

            /**
             * All other cases of moving nodes.
             */
            @Nested
            class GeneralReordering
            {
                @Nested
                class SingleReorder
                {
                    @Nested
                    class Downward
                    {
                        /**
                         * In the original tree, we have B1, C1, and D1.
                         * In the modified tree, we have C2, D2, and B2.
                         * We could either have C and D both move upwards by one, or have B move downwards by two.
                         * We want B to move downwards by two.
                         * 0 - B, MT
                         * 1 - C, N
                         * 2 - D, N
                         * 3 - B, MF
                         */
                        @Test
                        void whenANodeIsMovedTwoNodesDownward_onlyThatNodeMoves()
                        {
                            //Setup trees
                            DiffTree<String> d1 = createDNode(true);
                            DiffTree<String> c1 = createCNode(true);
                            DiffTree<String> b1 = createBNode(true);
                            DiffTree<String> a1 = createANode(true, b1, c1, d1);

                            DiffTree<String> d2 = createDNode(false);
                            DiffTree<String> c2 = createCNode(false);
                            DiffTree<String> b2 = createBNode(false);
                            DiffTree<String> a2 = createANode(false, c2, d2, b2);

                            //Match trees
                            a1.setMatch(a2);
                            b1.setMatch(b2);
                            c1.setMatch(c2);
                            d1.setMatch(d2);

                            populateDiffTree.populateDiffTree(a1, a2);
                            DiffTree<String> b1_mt = b1;
                            DiffTree<String> b1_mf = getSingleChild(a1, 3);

                            assertChildNumber(b1_mt, 0);
                            assertChildNumber(c1, 1);
                            assertChildNumber(d1, 2);
                            assertChildNumber(b1_mf, 3);

                            assertMovedFrom(b1_mf);
                            assertNone(c1);
                            assertNone(d1);
                            assertMovedTo(b1_mt);

                            assertPointsAt(b1_mt, b1_mf);
                        }

                        /**
                         * In the original tree, we have E1, B1, C1, and D1.
                         * In the modified tree, we have E1, C2, D2, and B2.
                         * We could either have C and D both move upwards by one, or have B move downwards by two.
                         * We want B to move downwards by two.
                         * 0 - E
                         * 1 - B, MT
                         * 2 - C, N
                         * 3 - D, N
                         * 4 - B, MF
                         */
                        @Test
                        void whenANodeIsMovedTwoNodesDownward_withANodeBefore_onlyThatNodeMoves()
                        {
                            //Setup trees
                            DiffTree<String> e1 = createENode(true);
                            DiffTree<String> d1 = createDNode(true);
                            DiffTree<String> c1 = createCNode(true);
                            DiffTree<String> b1 = createBNode(true);
                            DiffTree<String> a1 = createANode(true, e1, b1, c1, d1);

                            DiffTree<String> e2 = createENode(false);
                            DiffTree<String> d2 = createDNode(false);
                            DiffTree<String> c2 = createCNode(false);
                            DiffTree<String> b2 = createBNode(false);
                            DiffTree<String> a2 = createANode(false, e2, c2, d2, b2);

                            //Match trees
                            a1.setMatch(a2);
                            b1.setMatch(b2);
                            c1.setMatch(c2);
                            d1.setMatch(d2);
                            e1.setMatch(e2);

                            populateDiffTree.populateDiffTree(a1, a2);
                            DiffTree<String> b1_mt = b1;
                            DiffTree<String> b1_mf = getSingleChild(a1, 4);

                            assertChildNumber(e1, 0);
                            assertChildNumber(b1_mt, 1);
                            assertChildNumber(c1, 2);
                            assertChildNumber(d1, 3);
                            assertChildNumber(b1_mf, 4);

                            assertNone(e1);
                            assertMovedFrom(b1_mf);
                            assertNone(c1);
                            assertNone(d1);
                            assertMovedTo(b1_mt);

                            assertPointsAt(b1_mt, b1_mf);
                        }

                        /**
                         * In the original tree, we have B1, C1, D1, E1.
                         * In the modified tree, we have C2, D2, B2, E2.
                         * We could either have C and D both move upwards by one, or have B move downwards by two.
                         * We want B to move downwards by two.
                         * 0 - B, MT
                         * 1 - C, N
                         * 2 - D, N
                         * 3 - B, MF
                         * 4 - E
                         */
                        @Test
                        void whenANodeIsMovedTwoNodesDownward_withANodeAfter_onlyThatNodeMoves()
                        {
                            //Setup trees
                            DiffTree<String> e1 = createENode(true);
                            DiffTree<String> d1 = createDNode(true);
                            DiffTree<String> c1 = createCNode(true);
                            DiffTree<String> b1 = createBNode(true);
                            DiffTree<String> a1 = createANode(true, b1, c1, d1, e1);

                            DiffTree<String> e2 = createENode(false);
                            DiffTree<String> d2 = createDNode(false);
                            DiffTree<String> c2 = createCNode(false);
                            DiffTree<String> b2 = createBNode(false);
                            DiffTree<String> a2 = createANode(false, c2, d2, b2, e2);

                            //Match trees
                            a1.setMatch(a2);
                            b1.setMatch(b2);
                            c1.setMatch(c2);
                            d1.setMatch(d2);
                            e1.setMatch(e2);

                            populateDiffTree.populateDiffTree(a1, a2);
                            DiffTree<String> b1_mt = b1;
                            DiffTree<String> b1_mf = getSingleChild(a1, 3);

                            assertChildNumber(b1_mt, 0);
                            assertChildNumber(c1, 1);
                            assertChildNumber(d1, 2);
                            assertChildNumber(b1_mf, 3);
                            assertChildNumber(e1, 4);

                            assertNone(e1);
                            assertMovedFrom(b1_mf);
                            assertNone(c1);
                            assertNone(d1);
                            assertMovedTo(b1_mt);

                            assertPointsAt(b1_mt, b1_mf);
                        }

                        @Nested
                        class Creating
                        {
                            /**
                             * 1: B, C, D, E
                             * 2: C, D, F, E, B
                             * O: Bt, Cn, Dn, Fc, En, Bf
                             */
                            @Test
                            void whenANodeIsCreatedInTheCriticalRegion()
                            {
                                //Setup trees
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> b1 = createBNode(true);
                                DiffTree<String> a1 = createANode(true, b1, c1, d1, e1);

                                DiffTree<String> f2 = createFNode(false);
                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> b2 = createBNode(false);
                                DiffTree<String> a2 = createANode(false, c2, d2, f2, e2, b2);

                                //Match trees
                                a1.setMatch(a2);
                                b1.setMatch(b2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> b1_mt = b1;
                                DiffTree<String> b1_mf = getSingleChild(a1, 5);
                                DiffTree<String> f1 = getSingleChild(a1, 3);

                                assertChildNumber(b1_mt, 0);
                                assertChildNumber(c1, 1);
                                assertChildNumber(d1, 2);
                                assertChildNumber(f1, 3);
                                assertChildNumber(e1, 4);
                                assertChildNumber(b1_mf, 5);

                                assertMovedFrom(b1_mf);
                                assertNone(c1);
                                assertNone(d1);
                                assertNone(e1);
                                assertCreated(f1);
                                assertMovedTo(b1_mt);

                                assertPointsAt(b1_mf, b1_mt);
                            }

                            /**
                             * 1: B, C, D, E
                             * 2: F, C, D, E, B
                             * O: Fc, Bt, Cn, Dn, En, Bf
                             */
                            @Test
                            void whenANodeIsCreatedBeforeTheCriticalRegion()
                            {
                                //Setup trees
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> b1 = createBNode(true);
                                DiffTree<String> a1 = createANode(true, b1, c1, d1, e1);

                                DiffTree<String> f2 = createFNode(false);
                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> b2 = createBNode(false);
                                DiffTree<String> a2 = createANode(false, f2, c2, d2, e2, b2);

                                //Match trees
                                a1.setMatch(a2);
                                b1.setMatch(b2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> b1_mt = b1;
                                DiffTree<String> b1_mf = getSingleChild(a1, 4);
                                DiffTree<String> f1 = getNodeWithType(a1, ReferenceType.CREATE);

                                assertChildNumber(f1, 0);
                                assertChildNumber(b1_mt, 0);
                                assertChildNumber(c1, 1);
                                assertChildNumber(d1, 2);
                                assertChildNumber(e1, 3);
                                assertChildNumber(b1_mf, 4);

                                assertMovedFrom(b1_mf);
                                assertNone(c1);
                                assertNone(d1);
                                assertNone(e1);
                                assertCreated(f1);
                                assertMovedTo(b1_mt);

                                assertPointsAt(b1_mt, b1_mf);
                            }

                            /**
                             * 1: B, C, D, E
                             * 2: C, D, E, B, F
                             * O: Bt, Cn, Dn, En, Bf, Fc
                             */
                            @Test
                            void whenANodeIsCreatedAfterTheCriticalRegion()
                            {
                                //Setup trees
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> b1 = createBNode(true);
                                DiffTree<String> a1 = createANode(true, b1, c1, d1, e1);

                                DiffTree<String> f2 = createFNode(false);
                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> b2 = createBNode(false);
                                DiffTree<String> a2 = createANode(false, c2, d2, e2, b2, f2);

                                //Match trees
                                a1.setMatch(a2);
                                b1.setMatch(b2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> b1_mt = b1;
                                DiffTree<String> b1_mf = getSingleChild(a1, 4);
                                DiffTree<String> f1 = getSingleChild(a1, 5);

                                assertChildNumber(b1_mt, 0);
                                assertChildNumber(c1, 1);
                                assertChildNumber(d1, 2);
                                assertChildNumber(e1, 3);
                                assertChildNumber(b1_mf, 4);
                                assertChildNumber(f1, 5);

                                assertMovedFrom(b1_mf);
                                assertNone(c1);
                                assertNone(d1);
                                assertNone(e1);
                                assertCreated(f1);
                                assertMovedTo(b1_mt);

                                assertPointsAt(b1_mt, b1_mf);
                            }
                        }

                        @Nested
                        class Deleting
                        {
                            /**
                             * 1: B, C, D, F, E
                             * 2: C, D, E, B
                             * O: Bt, Cn, Dn, Fd, En, Bf
                             */
                            @Test
                            void whenANodeIsDeletedInTheCriticalRegion()
                            {
                                //Setup trees
                                DiffTree<String> f1 = createFNode(true);
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> b1 = createBNode(true);
                                DiffTree<String> a1 = createANode(true, b1, c1, d1, f1, e1);

                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> b2 = createBNode(false);
                                DiffTree<String> a2 = createANode(false, c2, d2, e2, b2);

                                //Match trees
                                a1.setMatch(a2);
                                b1.setMatch(b2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> b1_mt = b1;
                                DiffTree<String> b1_mf = getSingleChild(a1, 5);

                                assertChildNumber(b1_mt, 0);
                                assertChildNumber(c1, 1);
                                assertChildNumber(d1, 2);
                                assertChildNumber(f1, 3);
                                assertChildNumber(e1, 4);
                                assertChildNumber(b1_mf, 5);

                                assertMovedFrom(b1_mf);
                                assertNone(c1);
                                assertNone(d1);
                                assertNone(e1);
                                assertDeleted(f1);
                                assertMovedTo(b1_mt);

                                assertPointsAt(b1_mt, b1_mf);
                            }

                            /**
                             * 1: F, B, C, D, E
                             * 2: C, D, E, B
                             * O: Fd, Bt, Cn, Dn, En, Bf
                             */
                            @Test
                            void whenANodeIsDeletedBeforeTheCriticalRegion()
                            {
                                //Setup trees
                                DiffTree<String> f1 = createFNode(true);
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> b1 = createBNode(true);
                                DiffTree<String> a1 = createANode(true, f1, b1, c1, d1, e1);

                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> b2 = createBNode(false);
                                DiffTree<String> a2 = createANode(false, c2, d2, e2, b2);

                                //Match trees
                                a1.setMatch(a2);
                                b1.setMatch(b2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> b1_mt = b1;
                                DiffTree<String> b1_mf = getSingleChild(a1, 5);

                                assertChildNumber(f1, 0);
                                assertChildNumber(b1_mt, 1);
                                assertChildNumber(c1, 2);
                                assertChildNumber(d1, 3);
                                assertChildNumber(e1, 4);
                                assertChildNumber(b1_mf, 5);

                                assertMovedFrom(b1_mf);
                                assertNone(c1);
                                assertNone(d1);
                                assertNone(e1);
                                assertDeleted(f1);
                                assertMovedTo(b1_mt);

                                assertPointsAt(b1_mt, b1_mf);
                            }

                            /**
                             * 1: B, C, D, E, F
                             * 2: C, D, E, B
                             * O: Bt, Cn, Dn, En, Bf, Fd
                             */
                            @Test
                            void whenANodeIsDeletedAfterTheCriticalRegion()
                            {
                                //Setup trees
                                DiffTree<String> f1 = createENode(true);
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> b1 = createBNode(true);
                                DiffTree<String> a1 = createANode(true, b1, c1, d1, e1, f1);

                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> b2 = createBNode(false);
                                DiffTree<String> a2 = createANode(false, c2, d2, e2, b2);

                                //Match trees
                                a1.setMatch(a2);
                                b1.setMatch(b2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> b1_mt = b1;
                                DiffTree<String> b1_mf = getNodeWithType(a1, ReferenceType.MOVE_FROM);

                                assertChildNumber(b1_mt, 0);
                                assertChildNumber(c1, 1);
                                assertChildNumber(d1, 2);
                                assertChildNumber(e1, 3);
                                assertChildNumber(b1_mf, 4);
                                assertChildNumber(f1, 4);

                                assertMovedFrom(b1_mf);
                                assertNone(c1);
                                assertNone(d1);
                                assertNone(e1);
                                assertDeleted(f1);
                                assertMovedTo(b1_mt);

                                assertPointsAt(b1_mt, b1_mf);
                            }
                        }
                    }

                    @Nested
                    class Upward
                    {
                        /**
                         * In the original tree, we have B1, C1, and D1.
                         * In the modified tree, we have D2, B2, and C2.
                         * 0 - D, MF
                         * 1 - B, N
                         * 2 - C, N
                         * 3 - D, MT
                         */
                        @Test
                        void whenANodeIsMovedTwoNodesUpward_onlyThatNodeMoves()
                        {
                            //Setup trees
                            DiffTree<String> d1 = createDNode(true);
                            DiffTree<String> c1 = createCNode(true);
                            DiffTree<String> b1 = createBNode(true);
                            DiffTree<String> a1 = createANode(true, b1, c1, d1);

                            DiffTree<String> d2 = createDNode(false);
                            DiffTree<String> c2 = createCNode(false);
                            DiffTree<String> b2 = createBNode(false);
                            DiffTree<String> a2 = createANode(false, d2, b2, c2);

                            //Match trees
                            a1.setMatch(a2);
                            b1.setMatch(b2);
                            c1.setMatch(c2);
                            d1.setMatch(d2);

                            populateDiffTree.populateDiffTree(a1, a2);
                            DiffTree<String> d1_mf = getSingleChild(a1, 0);
                            DiffTree<String> d1_mt = d1;

                            assertChildNumber(d1_mf, 0);
                            assertChildNumber(b1, 1);
                            assertChildNumber(c1, 2);
                            assertChildNumber(d1_mt, 3);

                            assertMovedFrom(d1_mf);
                            assertNone(b1);
                            assertNone(c1);
                            assertMovedTo(d1_mt);

                            assertPointsAt(d1_mt, d1_mf);
                        }

                        /**
                         * In the original tree, we have E1, B1, C1, and D1.
                         * In the modified tree, we have E2, D2, B2, and C2.
                         * 0 - E
                         * 1 - D, MF
                         * 2 - B, N
                         * 3 - C, N
                         * 4 - D, MT
                         */
                        @Test
                        void whenANodeIsMovedTwoNodesUpward_withAnotherBefore_onlyThatNodeMoves()
                        {
                            //Setup trees
                            DiffTree<String> e1 = createENode(true);
                            DiffTree<String> d1 = createDNode(true);
                            DiffTree<String> c1 = createCNode(true);
                            DiffTree<String> b1 = createBNode(true);
                            DiffTree<String> a1 = createANode(true, e1, b1, c1, d1);

                            DiffTree<String> e2 = createENode(false);
                            DiffTree<String> d2 = createDNode(false);
                            DiffTree<String> c2 = createCNode(false);
                            DiffTree<String> b2 = createBNode(false);
                            DiffTree<String> a2 = createANode(false, e2, d2, b2, c2);

                            //Match trees
                            a1.setMatch(a2);
                            b1.setMatch(b2);
                            c1.setMatch(c2);
                            d1.setMatch(d2);
                            e1.setMatch(e2);

                            populateDiffTree.populateDiffTree(a1, a2);
                            DiffTree<String> d1_mf = getSingleChild(a1, 1);
                            DiffTree<String> d1_mt = d1;

                            assertChildNumber(e1, 0);
                            assertChildNumber(d1_mf, 1);
                            assertChildNumber(b1, 2);
                            assertChildNumber(c1, 3);
                            assertChildNumber(d1_mt, 4);

                            assertNone(e1);
                            assertMovedFrom(d1_mf);
                            assertNone(b1);
                            assertNone(c1);
                            assertMovedTo(d1_mt);

                            assertPointsAt(d1_mt, d1_mf);
                        }

                        /**
                         * In the original tree, we have B1, C1, D1, and E1.
                         * In the modified tree, we have D2, B2, C2, and E2.
                         * 0 - D, MF
                         * 1 - B, N
                         * 2 - C, N
                         * 3 - D, MT
                         * 4 - E
                         */
                        @Test
                        void whenANodeIsMovedTwoNodesUpward_withAnotherAfter_onlyThatNodeMoves()
                        {
                            //Setup trees
                            DiffTree<String> e1 = createENode(true);
                            DiffTree<String> d1 = createDNode(true);
                            DiffTree<String> c1 = createCNode(true);
                            DiffTree<String> b1 = createBNode(true);
                            DiffTree<String> a1 = createANode(true, b1, c1, d1, e1);

                            DiffTree<String> e2 = createENode(false);
                            DiffTree<String> d2 = createDNode(false);
                            DiffTree<String> c2 = createCNode(false);
                            DiffTree<String> b2 = createBNode(false);
                            DiffTree<String> a2 = createANode(false, d2, b2, c2, e2);

                            //Match trees
                            a1.setMatch(a2);
                            b1.setMatch(b2);
                            c1.setMatch(c2);
                            d1.setMatch(d2);
                            e1.setMatch(e2);

                            populateDiffTree.populateDiffTree(a1, a2);
                            DiffTree<String> d1_mf = getSingleChild(a1, 0);
                            DiffTree<String> d1_mt = d1;

                            assertChildNumber(d1_mf, 0);
                            assertChildNumber(b1, 1);
                            assertChildNumber(c1, 2);
                            assertChildNumber(d1_mt, 3);
                            assertChildNumber(e1, 4);

                            assertNone(e1);
                            assertMovedFrom(d1_mf);
                            assertNone(b1);
                            assertNone(c1);
                            assertMovedTo(d1_mt);

                            assertPointsAt(d1_mt, d1_mf);
                        }

                        @Nested
                        class Creation
                        {
                            /**
                             * 1: C, D, E
                             * 2: B, E, C, D
                             * Bc, Ef, Cn, Dn, Et
                             */
                            @Test
                            void withOneCreatedBefore()
                            {
                                //Setup trees
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> a1 = createANode(true, c1, d1, e1);

                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> b2 = createBNode(false);
                                DiffTree<String> a2 = createANode(false, b2, e2, c2, d2);

                                //Match trees
                                a1.setMatch(a2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> e1_mt = e1;
                                DiffTree<String> e1_mf = getSingleChild(a1, 1);
                                DiffTree<String> b1 = getSingleChild(a1, 0);

                                assertChildNumber(b1, 0);
                                assertChildNumber(e1_mf, 1);
                                assertChildNumber(c1, 2);
                                assertChildNumber(d1, 3);
                                assertChildNumber(e1_mt, 4);

                                assertCreated(b1);
                                assertMovedFrom(e1_mf);
                                assertNone(c1);
                                assertNone(d1);
                                assertMovedTo(e1_mt);
                            }

                            /**
                             * 1: C, D, E
                             * 2: E, C, D, B
                             * Ef, Cn, Dn, Et, Bc
                             */
                            @Test
                            void withOneCreatedAfter()
                            {
                                //Setup trees
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> a1 = createANode(true, c1, d1, e1);

                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> b2 = createBNode(false);
                                DiffTree<String> a2 = createANode(false, e2, c2, d2, b2);

                                //Match trees
                                a1.setMatch(a2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> e1_mt = e1;
                                DiffTree<String> e1_mf = getSingleChild(a1, 0);
                                DiffTree<String> b1 = getNodeWithLabel(a1, "B");

                                assertChildNumber(e1_mf, 0);
                                assertChildNumber(c1, 1);
                                assertChildNumber(d1, 2);
                                assertChildNumber(e1_mt, 3);
                                assertChildNumber(b1, 3);

                                assertMovedFrom(e1_mf);
                                assertNone(c1);
                                assertNone(d1);
                                assertMovedTo(e1_mt);
                                assertCreated(b1);
                            }

                            /**
                             * 1: C, D, E
                             * 2: E, C, B, D
                             * Ef, Cn, Bc, Dn, Et,
                             */
                            @Test
                            void withOneCreatedInsideCriticalRegion()
                            {
                                //Setup trees
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> a1 = createANode(true, c1, d1, e1);

                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> b2 = createBNode(false);
                                DiffTree<String> a2 = createANode(false, e2, c2, b2, d2);

                                //Match trees
                                a1.setMatch(a2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> e1_mt = e1;
                                DiffTree<String> e1_mf = getSingleChild(a1, 0);
                                DiffTree<String> b1 = getSingleChild(a1, 2);

                                assertChildNumber(e1_mf, 0);
                                assertChildNumber(c1, 1);
                                assertChildNumber(b1, 2);
                                assertChildNumber(d1, 3);
                                assertChildNumber(e1_mt, 4);

                                assertMovedFrom(e1_mf);
                                assertNone(c1);
                                assertCreated(b1);
                                assertNone(d1);
                                assertMovedTo(e1_mt);
                            }
                        }

                        @Nested
                        class Deletion
                        {
                            /**
                             * 1: B, C, D, E
                             * 2: E, C, D
                             * Bd, Ef, Cn, Dn, Et
                             */
                            @Test
                            void withOneDeletedBefore()
                            {
                                //Setup trees
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> b1 = createCNode(true);
                                DiffTree<String> a1 = createANode(true, b1, c1, d1, e1);

                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> a2 = createANode(false, e2, c2, d2);

                                //Match trees
                                a1.setMatch(a2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> e1_mf = getNodeWithLabel(a1, "E");
                                DiffTree<String> e1_mt = e1;

                                assertChildNumber(b1, 0);
                                assertChildNumber(e1_mf, 0);
                                assertChildNumber(c1, 1);
                                assertChildNumber(d1, 2);
                                assertChildNumber(e1_mt, 3);

                                assertDeleted(b1);
                                assertMovedFrom(e1_mf);
                                assertNone(c1);
                                assertNone(d1);
                                assertMovedTo(e1_mt);
                            }

                            /**
                             * 1: C, D, E, B
                             * 2: E, C, D
                             * Ef, Cn, Dn, Et, Bd
                             */
                            @Test
                            void withOneDeletedAfter()
                            {
                                //Setup trees
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> b1 = createBNode(true);
                                DiffTree<String> a1 = createANode(true, c1, d1, e1, b1);

                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> b2 = createBNode(false);
                                DiffTree<String> a2 = createANode(false, e2, c2, d2);

                                //Match trees
                                a1.setMatch(a2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> e1_mt = e1;
                                DiffTree<String> e1_mf = getSingleChild(a1, 0);

                                assertChildNumber(e1_mf, 0);
                                assertChildNumber(c1, 1);
                                assertChildNumber(d1, 2);
                                assertChildNumber(e1_mt, 3);
                                assertChildNumber(b1, 4);

                                assertMovedFrom(e1_mf);
                                assertNone(c1);
                                assertNone(d1);
                                assertMovedTo(e1_mt);
                                assertDeleted(b1);
                            }

                            /**
                             * 1: C, B, D, E
                             * 2: E, C, D
                             * Ef, Cn, Bd, Dn, Et,
                             */
                            @Test
                            void withOneDeletedInsideCriticalRegion()
                            {
                                //Setup trees
                                DiffTree<String> e1 = createENode(true);
                                DiffTree<String> d1 = createDNode(true);
                                DiffTree<String> c1 = createCNode(true);
                                DiffTree<String> b1 = createBNode(true);
                                DiffTree<String> a1 = createANode(true, c1, b1, d1, e1);

                                DiffTree<String> e2 = createENode(false);
                                DiffTree<String> d2 = createDNode(false);
                                DiffTree<String> c2 = createCNode(false);
                                DiffTree<String> a2 = createANode(false, e2, c2, d2);

                                //Match trees
                                a1.setMatch(a2);
                                c1.setMatch(c2);
                                d1.setMatch(d2);
                                e1.setMatch(e2);

                                populateDiffTree.populateDiffTree(a1, a2);
                                DiffTree<String> e1_mt = e1;
                                DiffTree<String> e1_mf = getSingleChild(a1, 0);

                                assertChildNumber(e1_mf, 0);
                                assertChildNumber(c1, 1);
                                assertChildNumber(b1, 2);
                                assertChildNumber(d1, 3);
                                assertChildNumber(e1_mt, 4);

                                assertMovedFrom(e1_mf);
                                assertNone(c1);
                                assertDeleted(b1);
                                assertNone(d1);
                                assertMovedTo(e1_mt);
                            }
                        }
                    }
                }

                /**
                 * Where more than one node is reordered.
                 * We are just going to be covering three reorders
                 */
                @Nested
                class MultipleReorder {
                    /**
                     * A donut reordering is where there is a reordering with both the endpoint and startpoint in the critical region of another reordering
                     * 1: B, C, D, E, F, G
                     * 2: C, E, F, D, G, B
                     * Bt, Cn, Dt, En, Fn, Df, Gn, Bf
                     */
                    @Test
                    void donutReordering() {
                        //Setup trees
                        DiffTree<String> g1 = createGNode(true);
                        DiffTree<String> f1 = createFNode(true);
                        DiffTree<String> e1 = createENode(true);
                        DiffTree<String> d1 = createDNode(true);
                        DiffTree<String> c1 = createCNode(true);
                        DiffTree<String> b1 = createBNode(true);
                        DiffTree<String> a1 = createANode(true, b1, c1, d1, e1, f1, g1);

                        DiffTree<String> g2 = createGNode(false);
                        DiffTree<String> f2 = createFNode(false);
                        DiffTree<String> e2 = createENode(false);
                        DiffTree<String> d2 = createDNode(false);
                        DiffTree<String> c2 = createCNode(false);
                        DiffTree<String> b2 = createBNode(false);
                        DiffTree<String> a2 = createANode(false, c2, e2, f2, d2, g2, b2);

                        //Match trees
                        a1.setMatch(a2);
                        b1.setMatch(b2);
                        c1.setMatch(c2);
                        d1.setMatch(d2);
                        e1.setMatch(e2);
                        f1.setMatch(f2);
                        g1.setMatch(g2);

                        populateDiffTree.populateDiffTree(a1, a2);
                        DiffTree<String> b1_mt = b1;
                        DiffTree<String> b1_mf = getSingleChild(a1, 7);
                        DiffTree<String> d1_mt = d1;
                        DiffTree<String> d1_mf = getSingleChild(a1, 5);

                        assertChildNumber(b1_mt, 0);
                        assertChildNumber(c1, 1);
                        assertChildNumber(d1_mt, 2);
                        assertChildNumber(e1, 3);
                        assertChildNumber(f1, 4);
                        assertChildNumber(d1_mf, 5);
                        assertChildNumber(g1, 6);
                        assertChildNumber(b1_mf, 7);

                        assertMovedFrom(b1_mf);
                        assertMovedTo(b1_mt);
                        assertMovedFrom(d1_mf);
                        assertMovedTo(d1_mt);
                        assertNone(c1);
                        assertNone(e1);
                        assertNone(f1);
                        assertNone(g1);

                        assertPointsAt(b1_mt, b1_mf);
                        assertPointsAt(d1_mt, d1_mf);
                    }

                    /**
                     * A chainlink reordering is where either the start point or end point of some reordering is in the critical region of some other reordering
                     * 1: B, C, D, E, F, G
                     * 2: C, E, F, B, G, D
                     * Bt, Cn, Dt, En, Fn, Bf, Gn, Df
                     */
                    @Test
                    void chainlinkReordering() {
                        //Setup trees
                        DiffTree<String> g1 = createGNode(true);
                        DiffTree<String> f1 = createFNode(true);
                        DiffTree<String> e1 = createENode(true);
                        DiffTree<String> d1 = createDNode(true);
                        DiffTree<String> c1 = createCNode(true);
                        DiffTree<String> b1 = createBNode(true);
                        DiffTree<String> a1 = createANode(true, b1, c1, d1, e1, f1, g1);

                        DiffTree<String> g2 = createGNode(false);
                        DiffTree<String> f2 = createFNode(false);
                        DiffTree<String> e2 = createENode(false);
                        DiffTree<String> d2 = createDNode(false);
                        DiffTree<String> c2 = createCNode(false);
                        DiffTree<String> b2 = createBNode(false);
                        DiffTree<String> a2 = createANode(false, c2, e2, f2, b2, g2, d2);

                        //Match trees
                        a1.setMatch(a2);
                        b1.setMatch(b2);
                        c1.setMatch(c2);
                        d1.setMatch(d2);
                        e1.setMatch(e2);
                        f1.setMatch(f2);
                        g1.setMatch(g2);

                        populateDiffTree.populateDiffTree(a1, a2);
                        DiffTree<String> b1_mt = b1;
                        DiffTree<String> b1_mf = getSingleChild(a1, 5);
                        DiffTree<String> d1_mt = d1;
                        DiffTree<String> d1_mf = getSingleChild(a1, 7);

                        assertChildNumber(b1_mt, 0);
                        assertChildNumber(c1, 1);
                        assertChildNumber(d1_mt, 2);
                        assertChildNumber(e1, 3);
                        assertChildNumber(f1, 4);
                        assertChildNumber(b1_mf, 5);
                        assertChildNumber(g1, 6);
                        assertChildNumber(d1_mf, 7);

                        assertMovedFrom(b1_mf);
                        assertMovedTo(b1_mt);
                        assertMovedFrom(d1_mf);
                        assertMovedTo(d1_mt);
                        assertNone(c1);
                        assertNone(e1);
                        assertNone(f1);
                        assertNone(g1);

                        assertPointsAt(b1_mf, b1_mt);
                        assertPointsAt(d1_mf, d1_mt);
                    }

                    /**
                     * A twin reordering is where there are two reorderings with distinct critical regions
                     * 1: B, C, D, E, F, G
                     * 2: C, D, B, F, G, E
                     * Bt, Cn, Dn, Bf, Et, Fn, Gn, Ef
                     */
                    @Test
                    void twinReordering() {
                        //Setup trees
                        DiffTree<String> g1 = createGNode(true);
                        DiffTree<String> f1 = createFNode(true);
                        DiffTree<String> e1 = createENode(true);
                        DiffTree<String> d1 = createDNode(true);
                        DiffTree<String> c1 = createCNode(true);
                        DiffTree<String> b1 = createBNode(true);
                        DiffTree<String> a1 = createANode(true, b1, c1, d1, e1, f1, g1);

                        DiffTree<String> g2 = createGNode(false);
                        DiffTree<String> f2 = createFNode(false);
                        DiffTree<String> e2 = createENode(false);
                        DiffTree<String> d2 = createDNode(false);
                        DiffTree<String> c2 = createCNode(false);
                        DiffTree<String> b2 = createBNode(false);
                        DiffTree<String> a2 = createANode(false, c2, d2, b2, f2, g2, e2);

                        //Match trees
                        a1.setMatch(a2);
                        b1.setMatch(b2);
                        c1.setMatch(c2);
                        d1.setMatch(d2);
                        e1.setMatch(e2);
                        f1.setMatch(f2);
                        g1.setMatch(g2);

                        populateDiffTree.populateDiffTree(a1, a2);
                        DiffTree<String> b1_mt = b1;
                        DiffTree<String> b1_mf = a1
                                .getChildren()
                                .stream()
                                .filter(a -> a.getReferenceType() == ReferenceType.MOVE_FROM)
                                .filter(a -> a.getLabel() == "B")
                                .findFirst()
                                .get();

                        DiffTree<String> e1_mt = e1;
                        DiffTree<String> e1_mf = getSingleChild(a1, 6);

                        assertChildNumber(b1_mt, 0);
                        assertChildNumber(c1, 1);
                        assertChildNumber(d1, 2);
                        assertChildNumber(b1_mf, 3);
                        assertChildNumber(e1_mt, 3);
                        assertChildNumber(f1, 4);
                        assertChildNumber(g1, 5);
                        assertChildNumber(e1_mf, 6);

                        assertMovedFrom(b1_mf);
                        assertMovedTo(b1_mt);
                        assertMovedFrom(e1_mf);
                        assertMovedTo(e1_mt);
                        assertNone(c1);
                        assertNone(d1);
                        assertNone(f1);
                        assertNone(g1);

                        assertPointsAt(b1_mt, b1_mf);
                        assertPointsAt(e1_mt, e1_mf);
                    }
                }
            }
        }

        /**
         * Tests where the nodes have different parents.
         */
        @Nested
        class DifferentParents
        {
            /**
             * In A1, we have B1 and C1. In B1, we have D1. In C1, we have E1.
             * In A2, we have B2 and C2. C2 has E2 and D2.
             * We expect D1 to be moved from B1 to C1, to the correct location (after E1).
             * Everything else should be in the same location, with type NONE.
             */
            @Test
            void movingInSameLevel()
            {
                //Setup trees
                DiffTree<String> e1 = createNode("E1", Collections.emptyList(), true);
                DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                DiffTree<String> c1 = createNode("C1", Arrays.asList(e1), true);
                DiffTree<String> b1 = createNode("B1", Arrays.asList(d1), true);
                DiffTree<String> a1 = createNode("A1", Arrays.asList(b1, c1), true);

                DiffTree<String> e2 = createNode("E2", Collections.emptyList(), false);
                DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                DiffTree<String> c2 = createNode("C2", Arrays.asList(e2, d2), false);
                DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                DiffTree<String> a2 = createNode("A2", Arrays.asList(b2, c2), false);

                //Match trees
                a1.setMatch(a2);
                b1.setMatch(b2);
                c1.setMatch(c2);
                d1.setMatch(d2);
                e1.setMatch(e2);

                populateDiffTree.populateDiffTree(a1, a2);
                DiffTree<String> d1_mt = d1;
                DiffTree<String> d1_mf = getSingleChild(c1, 1);

                assertParent(b1, a1);
                assertParent(c1, a1);
                assertChildNumber(b1, 0);
                assertChildNumber(c1, 1);
                assertParent(d1_mt, b1);
                assertChildNumber(d1_mt, 0);
                assertParent(e1, c1);
                assertParent(d1_mf, c1);
                assertChildNumber(e1, 0);
                assertChildNumber(d1_mf, 1);

                assertNone(a1);
                assertNone(b1);
                assertNone(c1);
                assertNone(e1);
                assertMovedFrom(d1_mf);
                assertMovedTo(d1_mt);

                assertPointsAt(d1_mf, d1_mt);
            }

            /**
             * In A1, we have B1. In B1, we have D1.
             * In A2, we have B2 and D2.
             * We expect D1 to be moved from B1 to A1, to the correct location (after B1).
             * Everything else should be in the same location, with type NONE.
             */
            @Test
            void movingToUpperLevel()
            {
                //Setup trees
                DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                DiffTree<String> b1 = createNode("B1", Arrays.asList(d1), true);
                DiffTree<String> a1 = createNode("A1", Arrays.asList(b1), true);

                DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                DiffTree<String> b2 = createNode("B2", Collections.emptyList(), false);
                DiffTree<String> a2 = createNode("A2", Arrays.asList(b2, d2), false);

                //Match trees
                a1.setMatch(a2);
                b1.setMatch(b2);
                d1.setMatch(d2);

                populateDiffTree.populateDiffTree(a1, a2);
                DiffTree<String> d1_mt = d1;
                DiffTree<String> d1_mf = getSingleChild(a1, 1);

                assertParent(b1, a1);
                assertParent(d1_mf, a1);
                assertChildNumber(b1, 0);
                assertChildNumber(d1_mf, 1);
                assertParent(d1_mt, b1);
                assertChildNumber(d1_mt, 0);

                assertNone(a1);
                assertNone(b1);
                assertMovedFrom(d1_mf);
                assertMovedTo(d1_mt);

                assertPointsAt(d1_mf, d1_mt);
            }

            /**
             * In A1, we have D1 and C1. In C1, we have E1.
             * In A2, we have C2. C2 has E2 and D2.
             * We expect D1 to be moved from A1 to C1, to the correct location (after E1).
             * Everything else should be in the same location, with type NONE.
             */
            @Test
            void movingToLowerLevel()
            {
                //Setup trees
                DiffTree<String> e1 = createNode("E1", Collections.emptyList(), true);
                DiffTree<String> d1 = createNode("D1", Collections.emptyList(), true);
                DiffTree<String> c1 = createNode("C1", Arrays.asList(e1), true);
                DiffTree<String> a1 = createNode("A1", Arrays.asList(d1, c1), true);

                DiffTree<String> e2 = createNode("E2", Collections.emptyList(), false);
                DiffTree<String> d2 = createNode("D2", Collections.emptyList(), false);
                DiffTree<String> c2 = createNode("C2", Arrays.asList(e2, d2), false);
                DiffTree<String> a2 = createNode("A2", Arrays.asList(c2), false);

                //Match trees
                a1.setMatch(a2);
                c1.setMatch(c2);
                d1.setMatch(d2);
                e1.setMatch(e2);

                populateDiffTree.populateDiffTree(a1, a2);
                DiffTree<String> d1_mt = d1;
                DiffTree<String> d1_mf = getSingleChild(c1, 1);

                assertParent(d1_mt, a1);
                assertParent(c1, a1);
                assertChildNumber(d1_mt, 0);
                assertChildNumber(c1, 1);
                assertParent(e1, c1);
                assertParent(d1_mf, c1);
                assertChildNumber(e1, 0);
                assertChildNumber(d1_mf, 1);

                assertNone(a1);
                assertNone(c1);
                assertNone(e1);
                assertMovedFrom(d1_mf);
                assertMovedTo(d1_mt);

                assertPointsAt(d1_mf, d1_mt);
            }

            @Nested
            class Creation
            {
                /**
                 * In A1, we have B1.
                 * In A2, we have C2. C2 has B2.
                 * We expect B1 to move from A1 into C1.
                 */
                @Test
                void movingIntoCreatedNode()
                {
                    //Setup trees
                    DiffTree<String> b1 = createBNode(true);
                    DiffTree<String> a1 = createANode(true, b1);

                    DiffTree<String> b2 = createBNode(false);
                    DiffTree<String> c2 = createCNode(false, b2);
                    DiffTree<String> a2 = createCNode(false, c2);

                    //Match trees
                    a1.setMatch(a2);
                    b1.setMatch(b2);

                    populateDiffTree.populateDiffTree(a1, a2);
                    DiffTree<String> c1 = getSingleChild(a1, 1);
                    DiffTree<String> b1_mt = b1;
                    DiffTree<String> b1_mf = getSingleChild(c1, 0);

                    assertParent(b1_mt, a1);
                    assertParent(c1, a1);
                    assertChildNumber(b1_mt, 0);
                    assertChildNumber(c1, 1);
                    assertParent(b1_mf, c1);

                    assertMovedFrom(b1_mf);
                    assertMovedTo(b1_mt);
                    assertCreated(c1);
                }
            }

            @Nested
            class Deletion
            {
                /**
                 * In A1, we have C1. C1 has B1.
                 * In A2, we have B2.
                 * We expect B1 to move from C1 into A1.
                 */
                @Test
                void movingOutOfDeletedNode()
                {
                    //Setup trees
                    DiffTree<String> b1 = createBNode(true);
                    DiffTree<String> c1 = createCNode(true, b1);
                    DiffTree<String> a1 = createANode(true, c1);

                    DiffTree<String> b2 = createBNode(false);
                    DiffTree<String> a2 = createCNode(false, b2);

                    //Match trees
                    a1.setMatch(a2);
                    b1.setMatch(b2);

                    populateDiffTree.populateDiffTree(a1, a2);
                    DiffTree<String> b1_mt = b1;
                    DiffTree<String> b1_mf = getSingleChild(a1, 0);

                    assertParent(b1_mf, a1);
                    assertParent(c1, a1);
                    assertChildNumber(b1_mf, 0);
                    assertChildNumber(c1, 1);
                    assertParent(b1_mt, c1);

                    assertMovedFrom(b1_mf);
                    assertMovedTo(b1_mt);
                    assertDeleted(c1);
                }
            }
        }
    }
}