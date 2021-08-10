package org.architectdrone.JavaCodeReviewPrototype.java;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.architectdrone.javacodereviewprototype.java.JavaTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JavaTreeTest {
    @Test
    void itAtLeastKindOfWorks()
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
        JavaTree myJavaTree = new JavaTree(treeA.findRootNode(), true);
        assertNotNull(myJavaTree);

    }
}