package org.architectdrone.java.with.antlr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.architectdrone.java.with.antlr.parser.implementation.Java8Lexer;
import org.architectdrone.java.with.antlr.parser.implementation.Java8Parser;
import org.architectdrone.javacodereviewprototype.context.language.LanguageContext;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JavaContext implements LanguageContext {
    public String getFileExtension() {
        return "java";
    }

    public static void main(String[] args) throws IOException {
        JavaContext javaContext = new JavaContext();
        String filename = "C:\\dev\\personal\\JavaCodeReviewPrototype\\java-with-antlr\\src\\main\\java\\org\\architectdrone\\java\\with\\antlr\\JavaContext.java";
        String contents = new String(Files.readAllBytes(Paths.get(filename)));
        System.out.println(javaContext.parse(contents, true));
    }

    public <L> DiffTree<L> parse(String file, Boolean isOriginal) {
        Java8Lexer java8Lexer = new Java8Lexer(CharStreams.fromString(file));
        CommonTokenStream commonTokenStream = new CommonTokenStream(java8Lexer);
        Java8Parser java8Parser = new Java8Parser(commonTokenStream);
        ParseTree parseTree = java8Parser.compilationUnit();

        return (DiffTree<L>) new JavaTreePopulator(isOriginal).getChildren(parseTree);
    }

    public DisplayElement getDisplayElement(String fileA, String fileB) {
        return null;
    }
}
