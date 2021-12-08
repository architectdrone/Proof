package org.architectdrone.java.with.antlr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.tree.ParseTree;
import org.architectdrone.java.with.antlr.parser.implementation.Java8Parser;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;

import static org.architectdrone.java.with.antlr.JavaNode.BINARY_EXPRESSION;
import static org.architectdrone.java.with.antlr.JavaNode.OR_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.QUALIFIER;
import static org.architectdrone.java.with.antlr.JavaNode.QUALIFIER_ELEMENT;

public class JavaTreePopulator {
    boolean isOriginal;

    public JavaTreePopulator(boolean isOriginal)
    {
        this.isOriginal = isOriginal;
    }

    private static List<DiffTree<JavaNode>> getChildren(ParseTree parseTree) {
        if (parseTree.getClass() == Java8Parser.CompilationUnitContext.class)
        {

        }
        return null;
    }

    private static List<DiffTree<JavaNode>> parseCompilationUnit(Java8Parser.CompilationUnitContext compilationUnit)
    {
        Java8Parser.PackageDeclarationContext packageDeclarations = compilationUnit.packageDeclaration();
        List<Java8Parser.ImportDeclarationContext> importDeclarationContextss = compilationUnit.importDeclaration();
        List<Java8Parser.TypeDeclarationContext> typeDeclarationContexts = compilationUnit.typeDeclaration();

        return null;
    }

    private static List<DiffTree<JavaNode>> parsePackageDeclaration(Java8Parser.PackageDeclarationContext packageDeclarationContext)
    {
        List<Java8Parser.AnnotationContext> annotations = packageDeclarationContext.packageModifier().stream().map(a -> a.annotation()).collect(Collectors.toList());
        List<String> packageNameElements = getRecursive(packageDeclarationContext.packageName(), a -> a.Identifier().toString(), a -> a.packageName());

        return null;
    }

    static JavaTree createQualifier(List<String> strings, boolean isOriginal)
    {
        List<DiffTree<JavaNode>> qualifierElements = strings
                .stream()
                .map(a -> new JavaTree(QUALIFIER_ELEMENT, a, Collections.emptyList(), isOriginal))
                .collect(Collectors.toList());

        return new JavaTree(QUALIFIER, "", qualifierElements, isOriginal);
    }

    static DiffTree<JavaNode> parseAnnotation(Java8Parser.AnnotationContext annotationContext)
    {
        if (annotationContext.normalAnnotation() != null)
        {
            return parseNormalAnnotation(annotationContext.normalAnnotation())
        }
    }

    static DiffTree<JavaNode> parseNormalAnnotation(Java8Parser.NormalAnnotationContext normalAnnotationContext, boolean isOriginal)
    {
        JavaTree typeName = parseTypeName(normalAnnotationContext.typeName(), isOriginal);

    }

    static JavaTree parseElementValuePair(Java8Parser.ElementValuePairContext elementValuePair, boolean isOriginal)
    {
        String annotationName = elementValuePair.Identifier().toString();
        Java8Parser.ElementValueContext elementValue = elementValuePair.elementValue();

    }

    static JavaTree parseConditionalExpression(Object someConditionalExpression, boolean isOriginal)
    {
        Function<Java8Parser.ConditionalExpressionContext, JavaTree> assumedTernaryToJT = t -> null; //TODO
        Function<Java8Parser.ConditionalOrExpressionContext, JavaTree> assumedCOrToJT = t -> null; //TODO
        Function<Java8Parser.ConditionalAndExpressionContext, JavaTree> assumedCAndToJT = t -> null; //TODO
        Function<Java8Parser.InclusiveOrExpressionContext, JavaTree> assumedIOrToJT = t -> null; //TODO
        Function<Java8Parser.ExclusiveOrExpressionContext, JavaTree> assumedEOrToJT = t -> null; //TODO
        Function<Java8Parser.AndExpressionContext, JavaTree> assumedAndToJT = t -> null; //TODO
        Function<Java8Parser.EqualityExpressionContext, JavaTree> assumedEqualityToJT = t -> null; //TODO
        Function<Java8Parser.RelationalExpressionContext, JavaTree> assumedRelationalToJT = t -> null; //TODO
        Function<Java8Parser.ShiftExpressionContext, JavaTree> assumedShiftToJT = t -> null; //TODO
        Function<Java8Parser.AdditiveExpressionContext, JavaTree> assumedAddToJT = t -> null; //TODO

        Function<Java8Parser.AdditiveExpressionContext, JavaTree> AddToJT = a -> drillParse(a, b -> b.additiveExpression(), b -> b.multiplicativeExpression(), assumedAddToJT, b -> null); //TODO
        Function<Java8Parser.ShiftExpressionContext, JavaTree> ShiftToJT = a -> drillParse(a, b -> b.shiftExpression(), b -> b.additiveExpression(), assumedShiftToJT, AddToJT);
        Function<Java8Parser.RelationalExpressionContext, JavaTree> RelationalToJT = a -> drillParse(a, b -> b.relationalExpression(), b -> b.shiftExpression(), assumedRelationalToJT, ShiftToJT);
        Function<Java8Parser.EqualityExpressionContext, JavaTree> EqualityToJT = a -> drillParse(a, b -> b.equalityExpression(), b -> b.relationalExpression(), assumedEqualityToJT, RelationalToJT);
        Function<Java8Parser.AndExpressionContext, JavaTree> AndToJT = a -> drillParse(a, b -> b.andExpression(), b -> b.equalityExpression(), assumedAndToJT, EqualityToJT);
        Function<Java8Parser.ExclusiveOrExpressionContext, JavaTree> EOrToJT = a -> drillParse(a, b -> b.exclusiveOrExpression(), b -> b.andExpression(), assumedEOrToJT, AndToJT);
        Function<Java8Parser.InclusiveOrExpressionContext, JavaTree> IOrToJT = a -> drillParse(a, b -> b.inclusiveOrExpression(), b -> b.exclusiveOrExpression(), assumedIOrToJT, EOrToJT);
        Function<Java8Parser.ConditionalAndExpressionContext, JavaTree> CAndToJT = a -> drillParse(a, b -> b.conditionalAndExpression(), b -> b.inclusiveOrExpression(), assumedCAndToJT, IOrToJT);
        Function<Java8Parser.ConditionalOrExpressionContext, JavaTree> COrToJT = a -> drillParseBinaryExpressionSingle(a, b -> b.conditionalOrExpression(), b -> b.conditionalAndExpression(), getSymbol(OR_SYMBOL, isOriginal), CAndToJT);
        Function<Java8Parser.ConditionalExpressionContext, JavaTree> TernarytoJT = a -> drillParse(a, b -> a.expression(), b -> a.conditionalOrExpression(), assumedTernaryToJT, COrToJT);

        if (someConditionalExpression instanceof Java8Parser.ConditionalExpressionContext)
        {
            return TernarytoJT.apply((Java8Parser.ConditionalExpressionContext)someConditionalExpression);
        }
        else if (someConditionalExpression instanceof Java8Parser.ConditionalOrExpressionContext)
        {
            return COrToJT.apply((Java8Parser.ConditionalOrExpressionContext)someConditionalExpression);
        }
        else if (someConditionalExpression instanceof Java8Parser.AdditiveExpressionContext) {
            return AddToJT.apply((Java8Parser.AdditiveExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof Java8Parser.ShiftExpressionContext) {
            return ShiftToJT.apply((Java8Parser.ShiftExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof Java8Parser.RelationalExpressionContext) {
            return RelationalToJT.apply((Java8Parser.RelationalExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof Java8Parser.EqualityExpressionContext) {
            return EqualityToJT.apply((Java8Parser.EqualityExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof Java8Parser.AndExpressionContext) {
            return AndToJT.apply((Java8Parser.AndExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof Java8Parser.ExclusiveOrExpressionContext) {
            return EOrToJT.apply((Java8Parser.ExclusiveOrExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof Java8Parser.InclusiveOrExpressionContext) {
            return IOrToJT.apply((Java8Parser.InclusiveOrExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof Java8Parser.ConditionalAndExpressionContext) {
            return CAndToJT.apply((Java8Parser.ConditionalAndExpressionContext) someConditionalExpression);
        }

    }


    static <I, P, C> JavaTree drillParse(I input, Function<I, P> getPlateau, Function<I, C> getCliff, Function<I, JavaTree> getJavaTree, Function<C, JavaTree> drillDeeper)
    {
        if (getPlateau.apply(input) != null)
        {
            return getJavaTree.apply(input);
        }
        else
        {
            return drillDeeper.apply(getCliff.apply(input));
        }
    }

    static <I, P, C> JavaTree drillParseBinaryExpressionSingle(I input, Function<I, P> getPlateau, Function<I, C> getCliff, JavaNode operator, Function<C, JavaTree> drillDeeper, boolean isOriginal)
    {
        JavaTree left = parseConditionalExpression(getPlateau.apply(input), isOriginal);
        JavaTree right = parseConditionalExpression(getCliff.apply(input), isOriginal);
        List<DiffTree<JavaNode>> children = Arrays.asList(left, getSymbol(operator, isOriginal), right);
        JavaTree theJavaTree = new JavaTree(BINARY_EXPRESSION, "", children, isOriginal);
        return drillParse(input, getPlateau, getCliff, (a) -> theJavaTree, drillDeeper);
    }

    static JavaTree getSymbol(JavaNode symbolToGet, Boolean isOriginal)
    {
        return new JavaTree(symbolToGet, "", Collections.emptyList(), isOriginal);
    }

    static JavaTree parseExpression(Java8Parser.ExpressionContext expressionContext)
    {

    }

    static JavaTree parseTypeName(Java8Parser.TypeNameContext typeName, boolean isOriginal)
    {
        List<String> annotationTypeNameElements = getRecursive(typeName.packageOrTypeName(), a -> a.Identifier().toString(), Java8Parser.PackageOrTypeNameContext::packageOrTypeName);
        annotationTypeNameElements.add(typeName.Identifier().toString());
        return new JavaTree(QUALIFIER, "", Collections.singletonList(createQualifier(annotationTypeNameElements, isOriginal)), isOriginal);
    }

    static <I, O> List<O> getRecursive(I input, Function<I, O> extractor, UnaryOperator<I> iterator, Predicate<I> checker)
    {
        List<O> toReturn = new ArrayList<>();
        I current = input;
        while (checker.test(current)) {
            toReturn.add(extractor.apply(current));
            current = iterator.apply(current);
        }

        return toReturn;
    }

    static <I, O> List<O> getRecursive(I input, Function<I, O> extractor, UnaryOperator<I> iterator)
    {
        return getRecursive(input, extractor, iterator, a -> a != null);
    }
}
