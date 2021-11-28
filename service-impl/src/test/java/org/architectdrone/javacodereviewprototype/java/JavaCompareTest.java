package org.architectdrone.javacodereviewprototype.java;

import java.io.IOException;

import org.architectdrone.javacodereviewprototype.JavaCompare;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaCompareTest {
    @Test
    void twoExactSameFiles() throws IOException {
        String fileA = ClassMockFactory
                .builder()
                .method(MethodMock.builder().build())
                .build()
                .getClassMock();
        Assertions.assertTrue(new JavaCompare(fileA, fileA).pedanticComparison());
        Assertions.assertTrue(new JavaCompare(fileA, fileA).semanticComparison());
    }

    @Test
    void oneWithExtraWhitespace() throws IOException {
        String fileA = ClassMockFactory
                .builder()
                .method(MethodMock
                        .builder()
                        .build())
                .build()
                .getClassMock();
        String fileB = ClassMockFactory
                .builder()
                .method(MethodMock
                        .builder()
                        .extraWhitespace(true)
                        .build())
                .build()
                .getClassMock();
        Assertions.assertFalse(new JavaCompare(fileA, fileB).pedanticComparison());
        Assertions.assertTrue(new JavaCompare(fileA, fileB).semanticComparison());
    }

    @Test
    void oneWithInlineComments() throws IOException {
        String fileA = ClassMockFactory
                .builder()
                .method(MethodMock
                        .builder()
                        .build())
                .build()
                .getClassMock();
        String fileB = ClassMockFactory
                .builder()
                .method(MethodMock
                        .builder()
                        .inlineComments(true)
                        .build())
                .build()
                .getClassMock();
        Assertions.assertFalse(new JavaCompare(fileA, fileB).pedanticComparison());
        Assertions.assertTrue(new JavaCompare(fileA, fileB).semanticComparison());
    }

    @Test
    void twoDifferentFiles() throws IOException {
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
        Assertions.assertFalse(new JavaCompare(fileA, fileB).pedanticComparison());
        Assertions.assertFalse(new JavaCompare(fileA, fileB).semanticComparison());
    }
}
