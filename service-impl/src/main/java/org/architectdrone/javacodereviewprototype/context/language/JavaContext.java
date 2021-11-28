package org.architectdrone.javacodereviewprototype.context.language;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.google.inject.Inject;
import java.text.MessageFormat;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.java.JavaTree;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;
import org.architectdrone.javacodereviewprototype.tree.PopulateDiffTree;
import org.architectdrone.javacodereviewprototype.tree.TreeMatch;

/**
 * Context for the Java language
 */
public class JavaContext implements LanguageContext {
    TreeMatch treeMatch;
    PopulateDiffTree populateDiffTree;

    @Inject
    public JavaContext(TreeMatch treeMatch, PopulateDiffTree populateDiffTree)
    {
        this.treeMatch = treeMatch;
        this.populateDiffTree = populateDiffTree;
    }

    @Override
    public String getFileExtension() {
        return ".java";
    }

    @Override
    public DisplayElement getDisplayElement(final String fileA, final String fileB) {
        DiffTree<Class<Node>> result = getPopulatedDiffTree(fileA, fileB);
        return getDisplayElement(result);
    }

    public DisplayElement getDisplayElement(DiffTree<Class<Node>> node)
    {
        if (node.getLabel().isInstance(ClassOrInterfaceDeclaration.class))
        {

        }
        return null;
    }

    @Override
    public DiffTree<Class<Node>> parse(final String file, final Boolean isOriginal) {
        return new JavaTree(StaticJavaParser.parse(file), isOriginal);
    }

    public DiffTree<Class<Node>> getPopulatedDiffTree(final String fileA, final String fileB)
    {
        DiffTree<Class<Node>> original = parse(fileA, true);
        DiffTree<Class<Node>> modified = parse(fileB, false);

        treeMatch.matchTrees(original, modified);
        populateDiffTree.populateDiffTree(original, modified);

        return original;
    }

    public void printDiffTree(final String fileA, final String fileB)
    {
        DiffTree<Class<Node>> result = getPopulatedDiffTree(fileA, fileB);
        printDiffTree(0, result);
    }

    public void printDiffTree(int tabLevel, final DiffTree<Class<Node>> toPrint)
    {
        StringBuilder builder = new StringBuilder();

        switch (toPrint.getReferenceType())
        {
            case CREATE:
                builder.append("[+]");
                break;
            case DELETE:
                builder.append("[-]");
                break;
            case MOVE_FROM:
                builder.append("[>]");
                break;
            case MOVE_TO:
                builder.append("[<]");
                break;
            case MODIFY:
                builder.append("[~]");
                break;
            case NONE:
                builder.append("[.]");
                break;
        }

        for (int i = 0; i < tabLevel; i++) {
            builder.append("\t");
        }

        builder.append(" ");
        if (!toPrint.getValue()
                .equals(""))
        {
            builder.append(MessageFormat.format("{0}:{1}", toPrint.getLabel().getSimpleName(), toPrint.getValue()));
        }
        else
        {
            builder.append(toPrint.getLabel().getSimpleName());
        }

        System.out.println(builder.toString());
        for (DiffTree<Class<Node>> child : toPrint.getChildren())
        {
            printDiffTree(tabLevel+1, child);
        }
    }
}
