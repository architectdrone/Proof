package org.architectdrone.JavaCodeReviewPrototype.tree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeDistillationTreeTest {
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

    @Test
    void preExistingTreeIsSerializedCorrectly() {
        //Setup test tree
        TestPreExistingNode tree = getPreExistingTree();

        ChangeDistillationTree<String> expectedD = new ChangeDistillationTree<String>(tree, TestPreExistingNode::getChildren, TestPreExistingNode::getValue, TestPreExistingNode::getLabel);
        assertEquals("d_label", expectedD.getLabel());
        assertEquals("d_value", expectedD.getValue());
        assertEquals(1, expectedD.getChildren().size());

        ChangeDistillationTree<String> expectedC = expectedD.getChildren().get(0);
        assertEquals("c_label", expectedC.getLabel());
        assertEquals("c_value", expectedC.getValue());
        assertEquals(2, expectedC.getChildren().size());
        
        ChangeDistillationTree<String> expectedB = expectedC.getChildren().get(1);
        assertEquals("b_label", expectedB.getLabel());
        assertEquals("b_value", expectedB.getValue());
        assertEquals(0, expectedB.getChildren().size());

        ChangeDistillationTree<String> expectedA = expectedC.getChildren().get(0);
        assertEquals("a_label", expectedA.getLabel());
        assertEquals("a_value", expectedA.getValue());
        assertEquals(0, expectedA.getChildren().size());
    }
}

@AllArgsConstructor
@Getter
class TestPreExistingNode {
    String value;
    String label;
    List<TestPreExistingNode> children;
}