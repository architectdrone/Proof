package org.architectdrone.javacodereviewprototype.java;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.LiteralStringValueExpr;
import com.github.javaparser.ast.expr.MethodReferenceExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.type.PrimitiveType;
import java.util.Collections;
import org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTreeMatchImpl;
import org.architectdrone.javacodereviewprototype.utils.common.CommonUtilsImpl;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarityImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for the Java Tree.
 * NOTE: There are a LOT of types of elements in the AST. The total number is likely over a hundred.
 * For that reason I am not going to waste time testing each of them here.
 * Rather, I will do full "integration" tests on snippets corresponding to each node type later.
 */
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
        assertEquals(2, classJavaTree.getChildren().size());
        assertEquals("MyClass", classJavaTree.getValue());
        assertEquals(ClassOrInterfaceDeclaration.class, classJavaTree.getLabel());
    }

    @Nested
    class ConstructorTests
    {
        @Nested
        class SpecialValue
        {
            @Test
            void whenRootNodeIsSimpleName_thenValueIsTheName()
            {
                SimpleName node = mock(SimpleName.class);
                when(node.getIdentifier()).thenReturn("foo");
                when(node.getChildNodes()).thenReturn(Collections.emptyList());

                JavaTree javaTree = new JavaTree(node, true);
                assertEquals("foo", javaTree.getValue());
            }

            @Test
            void whenRootNodeIsName_thenValueIsTheName()
            {
                Name node = mock(Name.class);
                when(node.getIdentifier()).thenReturn("foo");
                when(node.getChildNodes()).thenReturn(Collections.emptyList());

                JavaTree javaTree = new JavaTree(node, true);
                assertEquals("foo", javaTree.getValue());
            }

            @Test
            void whenRootNodeIsModifier_thenValueIsTheKeyword()
            {
                Modifier node = mock(Modifier.class);
                when(node.getKeyword()).thenReturn(Modifier.Keyword.ABSTRACT);
                when(node.getChildNodes()).thenReturn(Collections.emptyList());

                JavaTree javaTree = new JavaTree(node, true);
                assertEquals("abstract", javaTree.getValue());
            }

            @Test
            void whenRootNodeIsLiteralString_thenValueIsTheValue()
            {
                LiteralStringValueExpr node = mock(LiteralStringValueExpr.class);
                when(node.getValue()).thenReturn("foo");
                when(node.getChildNodes()).thenReturn(Collections.emptyList());

                JavaTree javaTree = new JavaTree(node, true);
                assertEquals("foo", javaTree.getValue());
            }

            @Test
            void whenRootNodeIsMethodReferenceExpr_thenValueIsTheIdentifier()
            {
                MethodReferenceExpr node = mock(MethodReferenceExpr.class);
                when(node.getIdentifier()).thenReturn("foo");
                when(node.getChildNodes()).thenReturn(Collections.emptyList());

                JavaTree javaTree = new JavaTree(node, true);
                assertEquals("foo", javaTree.getValue());
            }

            @Test
            void whenRootNodeIsPrimitiveType_thenValueIsTheType()
            {
                PrimitiveType node = mock(PrimitiveType.class);
                when(node.asString()).thenReturn("foo");
                when(node.getChildNodes()).thenReturn(Collections.emptyList());

                JavaTree javaTree = new JavaTree(node, true);
                assertEquals("foo", javaTree.getValue());
            }

            @Test
            void whenRootNodeIsBinaryExpr_thenValueIsTheOperator()
            {
                BinaryExpr node = mock(BinaryExpr.class);
                when(node.getOperator()).thenReturn(BinaryExpr.Operator.AND);
                when(node.getChildNodes()).thenReturn(Collections.emptyList());

                JavaTree javaTree = new JavaTree(node, true);
                assertEquals("&&", javaTree.getValue());
            }

            @Test
            void whenRootNodeIsUnaryExpr_thenValueIsTheOperator()
            {
                UnaryExpr node = mock(UnaryExpr.class);
                when(node.getOperator()).thenReturn(UnaryExpr.Operator.POSTFIX_INCREMENT);
                when(node.getChildNodes()).thenReturn(Collections.emptyList());

                JavaTree javaTree = new JavaTree(node, true);
                assertEquals("++", javaTree.getValue());
            }

            @Test
            void whenRootNodeIsAssignExpr_thenValueIsTheOperator()
            {
                AssignExpr node = mock(AssignExpr.class);
                when(node.getOperator()).thenReturn(AssignExpr.Operator.PLUS);
                when(node.getChildNodes()).thenReturn(Collections.emptyList());

                JavaTree javaTree = new JavaTree(node, true);
                assertEquals("+=", javaTree.getValue());
            }
        }
    }

    @Nested
    class GeneralJavaProcessingTests
    {
        @Test
        void smallChanges_produceSmallMismatches()
        {
            String fileA = ClassMockFactory
                    .builder()
                    .method(MethodMock
                            .builder()
                            .bodyA(true)
                            .build())
                    .build()
                    .getClassMock();
            String fileB = ClassMockFactory
                    .builder()
                    .method(MethodMock
                            .builder()
                            .bodyA(false)
                            .build())
                    .build()
                    .getClassMock();

            JavaTree treeA = new JavaTree(StaticJavaParser.parse(fileA), true);
            JavaTree treeB = new JavaTree(StaticJavaParser.parse(fileB), false);

            ChangeDistillationTreeMatchImpl changeDistillationTree = new ChangeDistillationTreeMatchImpl(new StringSimilarityImpl(new CommonUtilsImpl()), new CommonUtilsImpl());
            changeDistillationTree.matchTrees(treeA, treeB);

            long differingNodes = treeA
                    .getDescendants(true)
                    .stream()
                    .filter(c -> !c.isMatched())
                    .count();
            assertEquals(1, differingNodes);
        }
    }
}