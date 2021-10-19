package org.architectdrone.javacodereviewprototype.java;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.BodyDeclaration;

public enum JavaLabel {
    BODY;

    JavaLabel fromNode(Node node) {
        if (node.getClass().isInstance(BodyDeclaration.class)) return BODY;
    }
}
