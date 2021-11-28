package org.architectdrone.java.with.antlr;

import org.architectdrone.javacodereviewprototype.context.language.LanguageContext;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;

public class JavaContext implements LanguageContext {
    public String getFileExtension() {
        return "java";
    }

    public <L> DiffTree<L> parse(String file, Boolean isOriginal) {
        Java8Parser
        return null;
    }

    public DisplayElement getDisplayElement(String fileA, String fileB) {
        return null;
    }
}
