package org.architectdrone.javacodereviewprototype;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.SimpleName;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;

@AllArgsConstructor
public class JavaCompare {
    String fileA;
    String fileB;

    public boolean semanticComparison() {
        CompilationUnit treeA = StaticJavaParser.parse(fileA);
        CompilationUnit treeB = StaticJavaParser.parse(fileB);
        return treeCompare(treeA, treeB);
    }

    public boolean treeCompare(Node nodeA, Node nodeB) {
        if (nodeA.getAllContainedComments().size() == 0 && nodeB.getAllContainedComments().size() == 0) {
            return nodeA.toString().equals(nodeB.toString());
        }

        if (nodeA.getClass() != nodeB.getClass())
        {
            return false;
        }
        List<Node> nodeAChildren = nodeA.getChildNodes().stream().filter(c -> !(c instanceof LineComment)).collect(Collectors.toList());
        List<Node> nodeBChildren = nodeB.getChildNodes().stream().filter(c -> !(c instanceof LineComment)).collect(Collectors.toList());

        if (nodeAChildren.size() != nodeBChildren.size())
        {
            return false;
        }
        if (nodeAChildren.size() == 0 && (nodeBChildren.size() == 0) && !getText(nodeA).equals(getText(nodeB)))
        {
            return false;
        }

        for (int i = 0; i < nodeA.getChildNodes().size(); i++) {
            Node nodeAChild = nodeA.getChildNodes().get(i);
            Node nodeBChild = nodeB.getChildNodes().get(i);
            if (!treeCompare(nodeAChild, nodeBChild))
            {
                return false;
            }
        }

        return true;
    }

    public String getText(Node node) {
        return node.getTokenRange().get().toString();
    }

    public boolean pedanticComparison() {
        return fileA.equals(fileB);
    }
}
