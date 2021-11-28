package org.architectdrone.javacodereviewprototype.java;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.type.PrimitiveType;
import lombok.Getter;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;
import com.github.javaparser.ast.Node;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaTree extends DiffTree<Class<Node>> {
    @Getter private final Node javaParserNode;
    public JavaTree(Node javaParserNode, boolean isOriginal) {
        super(
                (Class<Node>) javaParserNode.getClass(),
                javaParserNodeToString(javaParserNode),
                javaParserNode
                        .getChildNodes()
                        .stream()
                        .filter(c -> !(c instanceof LineComment))
                        .filter(c -> !(c instanceof SimpleName))
                        .map(c -> new JavaTree(c, isOriginal))
                        .collect(Collectors.toList()),
                isOriginal
        );
        this.javaParserNode = javaParserNode;
    }

    /**
     * If the given node has string data, this will extract it.
     * Or, it should. There's no real way to extract data that isn't in the AST from a node...
     * Also, if you are wondering why I don't just call toString, it's because that will return the toString of all children as well.
     * @param javaParserNode The node to convert into a string.
     * @return The string.
     */
    private static String javaParserNodeToString(Node javaParserNode)
    {
        List<String> nestedSimpleNames = javaParserNode
                .getChildNodes()
                .stream()
                .filter(a -> a instanceof SimpleName)
                .map(a -> ((SimpleName)a).getIdentifier())
                .collect(Collectors.toList());

        assert nestedSimpleNames.size() <= 1;
        Optional<String> nestedSimpleName = nestedSimpleNames.stream().findFirst();

        if (nestedSimpleName.isPresent())
        {
            return nestedSimpleName.get();
        }
        if (javaParserNode instanceof SimpleName)
        {
            return ((SimpleName) javaParserNode).getIdentifier();
        }
        else if (javaParserNode instanceof Name)
        {
            return ((Name) javaParserNode).getIdentifier();
        }
        else if (javaParserNode instanceof Modifier)
        {
            return ((Modifier) javaParserNode).getKeyword().asString();
        }
        else if (javaParserNode instanceof LiteralStringValueExpr)
        {
            return ((LiteralStringValueExpr) javaParserNode).getValue();
        }
        else if (javaParserNode instanceof Comment)
        {
            return ((Comment) javaParserNode).getContent();
        }
        else if (javaParserNode instanceof MethodReferenceExpr)
        {
            return ((MethodReferenceExpr) javaParserNode).getIdentifier();
        }
        else if (javaParserNode instanceof PrimitiveType)
        {
            return ((PrimitiveType) javaParserNode).asString();
        }
        else if (javaParserNode instanceof BinaryExpr)
        {
            return ((BinaryExpr) javaParserNode).getOperator().asString();
        }
        else if (javaParserNode instanceof UnaryExpr)
        {
            return ((UnaryExpr) javaParserNode).getOperator().asString();
        }
        else if (javaParserNode instanceof AssignExpr)
        {
            return ((AssignExpr) javaParserNode).getOperator().asString();
        }
        else
        {
            return "";
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
