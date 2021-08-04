package org.architectdrone.JavaCodeReviewPrototype;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.architectdrone.javacodereviewprototype.JavaCompare;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaCompareTest {
    File fileA;
    File fileA_withComments;
    File fileA_withExtraWhitespace;
    File fileB;

    @BeforeEach
    void init() throws URISyntaxException {
        fileA = Paths.get(this.getClass().getResource("/fileA.txt").toURI()).toFile();
        fileB = Paths.get(this.getClass().getResource("/fileB.txt").toURI()).toFile();
        fileA_withExtraWhitespace = Paths.get(this.getClass().getResource("/fileA_withExtraWhitespace.txt").toURI()).toFile();
        fileA_withComments = Paths.get(this.getClass().getResource("/fileA_withComments.txt").toURI()).toFile();
    }

    @Test
    void twoExactSameFiles() throws IOException {
        Assertions.assertTrue(new JavaCompare(fileA, fileA).pedanticComparison());
        Assertions.assertTrue(new JavaCompare(fileA, fileA).semanticComparison());
    }

    @Test
    void oneWithExtraWhitespace() throws IOException {
        Assertions.assertFalse(new JavaCompare(fileA, fileA_withExtraWhitespace).pedanticComparison());
        Assertions.assertTrue(new JavaCompare(fileA, fileA_withExtraWhitespace).semanticComparison());
    }

    @Test
    void oneWithComments() throws IOException {
        Assertions.assertFalse(new JavaCompare(fileA, fileA_withComments).pedanticComparison());
        Assertions.assertTrue(new JavaCompare(fileA, fileA_withComments).semanticComparison());
    }

    @Test
    void twoDifferentFiles() throws IOException {
        Assertions.assertFalse(new JavaCompare(fileA, fileB).pedanticComparison());
        Assertions.assertFalse(new JavaCompare(fileA, fileB).semanticComparison());
    }
}
