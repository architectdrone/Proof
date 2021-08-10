package org.architectdrone.javacodereviewprototype.java;

import com.github.javaparser.ast.AccessSpecifier;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.CallableDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.validator.ReservedKeywordValidator;
import lombok.Getter;
import org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTree;
import com.github.javaparser.ast.Node;

import java.util.stream.Collectors;

public class JavaTree extends ChangeDistillationTree<Class<Node>> {
    @Getter private final Node javaParserNode;
    public JavaTree(Node javaParserNode, boolean isOriginal) {
        super(
                (Class<Node>) javaParserNode.getClass(),
                javaParserNodeToString(javaParserNode),
                javaParserNode
                        .getChildNodes()
                        .stream()
                        .filter(c -> !(c instanceof LineComment))
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
        if (javaParserNode instanceof SimpleName)
        {
            return ((SimpleName) javaParserNode).getIdentifier();
        }
        if (javaParserNode instanceof Modifier)
        {
            return ((Modifier) javaParserNode).getKeyword().asString();
        }
        if (javaParserNode instanceof CallableDeclaration)
        {
            return ((CallableDeclaration) javaParserNode).getName().asString();
        }
        if (javaParserNode instanceof LiteralStringValueExpr)
        {
            return ((LiteralStringValueExpr) javaParserNode).getValue();
        }
//        if (javaParserNode instanceof AccessSpecifier) //TODO, research
//        {
//            return ((Modifier) javaParserNode).getKeyword().asString();
//        }
        else if (javaParserNode instanceof Name)
        {
            return ((Name) javaParserNode).getIdentifier();
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
