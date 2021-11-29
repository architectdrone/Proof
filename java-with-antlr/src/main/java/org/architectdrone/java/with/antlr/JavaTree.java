package org.architectdrone.java.with.antlr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.architectdrone.java.with.antlr.parser.implementation.Java8Parser.*;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;

import java.util.List;

public class JavaTree extends DiffTree<JavaNode> {
    private JavaTree(JavaNode label, String value, List<DiffTree<JavaNode>> children, boolean isOriginal)
    {
        super(label, value, children, isOriginal);
    }

    private static List<DiffTree<JavaNode>> getChildren(ParseTree parseTree) {
        if (parseTree.getClass() == CompilationUnitContext.class)
        {

        }
        return null;
    }

    private static List<DiffTree<JavaNode>> parseCompilationUnit(CompilationUnitContext compilationUnit)
    {
        PackageDeclarationContext packageDeclaration = compilationUnit.packageDeclaration();
        List<ImportDeclarationContext> importDeclarationContexts = compilationUnit.importDeclaration();
        List<TypeDeclarationContext> typeDeclarationContext = compilationUnit.typeDeclaration();
    }

    private static List<DiffTree<JavaNode>> parsePackageDeclaration(PackageDeclarationContext packageDeclarationContext)
    {
        packageDeclarationContext.
    }

}
