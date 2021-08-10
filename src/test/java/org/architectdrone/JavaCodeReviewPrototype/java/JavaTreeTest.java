package org.architectdrone.JavaCodeReviewPrototype.java;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import org.architectdrone.javacodereviewprototype.java.JavaTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaTreeTest {
    @Test
    void works()
    {
        String fileA = ClassMockFactory
                .builder()
                .method(MethodMock
                        .builder()
                        .bodyA(true)
                        .build())
                .build()
                .getClassMock();
        CompilationUnit treeA = StaticJavaParser.parse(fileA);
        JavaTree javaTree = new JavaTree(treeA.findRootNode(), true);
        assertEquals(1, javaTree.getChildren().size());
        assertEquals("", javaTree.getValue());
        assertEquals(CompilationUnit.class, javaTree.getLabel());

        JavaTree classJavaTree = (JavaTree) javaTree.getChildren().get(0);
        assertEquals(3, classJavaTree.getChildren().size());
        assertEquals("", classJavaTree.getValue());
        assertEquals(ClassOrInterfaceDeclaration.class, classJavaTree.getLabel());

    }
}