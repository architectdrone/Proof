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
import org.architectdrone.javacodereviewprototype.java.JavaTree;
import org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTreeMatchImpl;

@AllArgsConstructor
public class JavaCompare {
    String fileA;
    String fileB;

    public boolean semanticComparison() {
        JavaTree treeA = new JavaTree(StaticJavaParser.parse(fileA), true);
        JavaTree treeB = new JavaTree(StaticJavaParser.parse(fileB), false);
        return treeA.treeEquals(treeB);
    }

    public boolean pedanticComparison() {
        return fileA.equals(fileB);
    }
}
