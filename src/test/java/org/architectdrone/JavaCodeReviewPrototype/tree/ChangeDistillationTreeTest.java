package org.architectdrone.JavaCodeReviewPrototype.tree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTree;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeDistillationTreeTest {
    ChangeDistillationTree<String> a = new ChangeDistillationTree<String>("a_value", "a_label", Collections.emptyList(), true);
    ChangeDistillationTree<String> b = new ChangeDistillationTree<String>("b_value", "b_label", Collections.emptyList(), true);
    ChangeDistillationTree<String> c = new ChangeDistillationTree<String>("c_value", "c_label", Stream.of(a, b).collect(Collectors.toList()), true);
    ChangeDistillationTree<String> d = new ChangeDistillationTree<String>("d_value", "d_label", Collections.singletonList(c), true);

    /**
     * Gets a pre-existing tree
     * @return A tree that looks like:
     *     D
     *    /
     *   C
     *  / \
     * A   B
     */
    private TestPreExistingNode getPreExistingTree() {
        TestPreExistingNode a = new TestPreExistingNode("a_value", "a_label", Collections.emptyList());
        TestPreExistingNode b = new TestPreExistingNode("b_value", "b_label", Collections.emptyList());
        TestPreExistingNode c = new TestPreExistingNode("c_value", "c_label", Stream.of(a, b).collect(Collectors.toList()));
        TestPreExistingNode d = new TestPreExistingNode("d_value", "d_label", Collections.singletonList(c));
        return d;
    }

    @Nested
    class preExistingTests
    {
        @Test
        void preExistingTreeIsSerializedCorrectly() {
            //Setup test tree
            TestPreExistingNode tree = getPreExistingTree();

            ChangeDistillationTree<String> expectedD = new ChangeDistillationTree<String>(tree, true, TestPreExistingNode::getChildren, TestPreExistingNode::getValue, TestPreExistingNode::getLabel);
            assertEquals("d_label", expectedD.getLabel());
            assertEquals("d_value", expectedD.getValue());
            assertTrue(expectedD.isOriginal());
            assertEquals(1, expectedD.getChildren().size());

            ChangeDistillationTree<String> expectedC = expectedD.getChildren().get(0);
            assertEquals("c_label", expectedC.getLabel());
            assertEquals("c_value", expectedC.getValue());
            assertTrue(expectedC.isOriginal());
            assertEquals(2, expectedC.getChildren().size());

            ChangeDistillationTree<String> expectedB = expectedC.getChildren().get(1);
            assertEquals("b_label", expectedB.getLabel());
            assertEquals("b_value", expectedB.getValue());
            assertTrue(expectedB.isOriginal());
            assertEquals(0, expectedB.getChildren().size());

            ChangeDistillationTree<String> expectedA = expectedC.getChildren().get(0);
            assertEquals("a_label", expectedA.getLabel());
            assertEquals("a_value", expectedA.getValue());
            assertTrue(expectedA.isOriginal());
            assertEquals(0, expectedA.getChildren().size());
        }
    }

    @Nested
    class setMatchTests
    {
        @Test
        void worksCorrectly() {
            ChangeDistillationTree<String> a = new ChangeDistillationTree<String>("foo", "bar", Collections.emptyList(), true);
            ChangeDistillationTree<String> b = new ChangeDistillationTree<String>("foo", "bar", Collections.emptyList(), false);
            a.setMatch(b);
            assertEquals(a.getMatch(), b);
            assertEquals(b.getMatch(), a);
            assertTrue(a.isMatched());
            assertTrue(b.isMatched());
        }

        @Test
        void whenBothAreOriginal_fails() {
            ChangeDistillationTree<String> a = new ChangeDistillationTree<String>("foo", "bar", Collections.emptyList(), true);
            ChangeDistillationTree<String> b = new ChangeDistillationTree<String>("foo", "bar", Collections.emptyList(), true);
            assertThrows(AssertionError.class, () -> a.setMatch(b));
        }
    }

    @Nested
    class getLeavesTests
    {
        @Test
        void works()
        {
            assertTrue(d.getLeaves().contains(a));
            assertTrue(d.getLeaves().contains(b));
            assertFalse(d.getLeaves().contains(c));
            assertFalse(d.getLeaves().contains(d));
        }
    }

    @Nested
    class getDescendantsTests
    {
        @Test
        void whenGettingLeaves_works()
        {
            List<ChangeDistillationTree<String>> descendants = d.getDescendants(true);
            assertEquals(3, descendants.size());
            assertTrue(descendants.contains(a));
            assertTrue(descendants.contains(b));
            assertTrue(descendants.contains(c));
            assertTrue(descendants.indexOf(a) < descendants.indexOf(c));
            assertTrue(descendants.indexOf(b) < descendants.indexOf(c));
        }

        @Test
        void whenNotGettingLeaves_works()
        {
            List<ChangeDistillationTree<String>> descendants = d.getDescendants(false);
            assertEquals(1, descendants.size());
            assertTrue(descendants.contains(c));
        }
    }
}

@AllArgsConstructor
@Getter
class TestPreExistingNode {
    String value;
    String label;
    List<TestPreExistingNode> children;
}