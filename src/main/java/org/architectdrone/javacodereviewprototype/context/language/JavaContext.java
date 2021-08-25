package org.architectdrone.javacodereviewprototype.context.language;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.Node;
import org.architectdrone.javacodereviewprototype.java.JavaTree;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;

/**
 * Context for the Java language
 */
public class JavaContext implements LanguageContext {
    @Override
    public String getFileExtension() {
        return ".java";
    }

    @Override
    public DiffTree<Class<Node>> parse(final String file, final Boolean isOriginal) {
        return new JavaTree(StaticJavaParser.parse(file), isOriginal);
    }
}
