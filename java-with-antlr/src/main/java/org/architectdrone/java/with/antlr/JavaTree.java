package org.architectdrone.java.with.antlr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.architectdrone.java.with.antlr.parser.implementation.Java8Parser.*;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;

import java.util.List;

import static org.architectdrone.java.with.antlr.JavaNode.QUALIFIER;
import static org.architectdrone.java.with.antlr.JavaNode.QUALIFIER_ELEMENT;

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
        PackageDeclarationContext packageDeclarations = compilationUnit.packageDeclaration();
        List<ImportDeclarationContext> importDeclarationContextss = compilationUnit.importDeclaration();
        List<TypeDeclarationContext> typeDeclarationContexts = compilationUnit.typeDeclaration();

        return null;
    }

    private static List<DiffTree<JavaNode>> parsePackageDeclaration(PackageDeclarationContext packageDeclarationContext)
    {
        List<AnnotationContext> annotations = packageDeclarationContext.packageModifier().stream().map(a -> a.annotation()).collect(Collectors.toList());
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

    static DiffTree<JavaNode> parseAnnotation(AnnotationContext annotationContext)
    {
        if (annotationContext.normalAnnotation() != null)
        {
            return parseNormalAnnotation(annotationContext.normalAnnotation())
        }
    }

    static DiffTree<JavaNode> parseNormalAnnotation(NormalAnnotationContext normalAnnotationContext, boolean isOriginal)
    {
        JavaTree typeName = parseTypeName(normalAnnotationContext.typeName(), isOriginal);

    }

    static JavaTree parseElementValuePair(ElementValuePairContext elementValuePair, boolean isOriginal)
    {
        String annotationName = elementValuePair.Identifier().toString();
        ElementValueContext elementValue = elementValuePair.elementValue();

    }

    static JavaTree parseConditionalExpression(Object someConditionalExpression)
    {
        Function<ConditionalExpressionContext, JavaTree> assumedTernaryToJT = t -> null; //TODO
        Function<ConditionalOrExpressionContext, JavaTree> assumedCOrToJT = t -> null; //TODO
        Function<ConditionalAndExpressionContext, JavaTree> assumedCAndToJT = t -> null; //TODO
        Function<InclusiveOrExpressionContext, JavaTree> assumedIOrToJT = t -> null; //TODO
        Function<ExclusiveOrExpressionContext, JavaTree> assumedEOrToJT = t -> null; //TODO
        Function<AndExpressionContext, JavaTree> assumedAndToJT = t -> null; //TODO
        Function<EqualityExpressionContext, JavaTree> assumedEqualityToJT = t -> null; //TODO
        Function<RelationalExpressionContext, JavaTree> assumedRelationalToJT = t -> null; //TODO
        Function<ShiftExpressionContext, JavaTree> assumedShiftToJT = t -> null; //TODO
        Function<AdditiveExpressionContext, JavaTree> assumedAddToJT = t -> null; //TODO

        Function<AdditiveExpressionContext, JavaTree> AddToJT = a -> drillParse(a, b -> b.additiveExpression(), b -> b.multiplicativeExpression(), assumedAddToJT, b -> null); //TODO
        Function<ShiftExpressionContext, JavaTree> ShiftToJT = a -> drillParse(a, b -> b.shiftExpression(), b -> b.additiveExpression(), assumedShiftToJT, AddToJT);
        Function<RelationalExpressionContext, JavaTree> RelationalToJT = a -> drillParse(a, b -> b.relationalExpression(), b -> b.shiftExpression(), assumedRelationalToJT, ShiftToJT);
        Function<EqualityExpressionContext, JavaTree> EqualityToJT = a -> drillParse(a, b -> b.equalityExpression(), b -> b.relationalExpression(), assumedEqualityToJT, RelationalToJT);
        Function<AndExpressionContext, JavaTree> AndToJT = a -> drillParse(a, b -> b.andExpression(), b -> b.equalityExpression(), assumedAndToJT, EqualityToJT);
        Function<ExclusiveOrExpressionContext, JavaTree> EOrToJT = a -> drillParse(a, b -> b.exclusiveOrExpression(), b -> b.andExpression(), assumedEOrToJT, AndToJT);
        Function<InclusiveOrExpressionContext, JavaTree> IOrToJT = a -> drillParse(a, b -> b.inclusiveOrExpression(), b -> b.exclusiveOrExpression(), assumedIOrToJT, EOrToJT);
        Function<ConditionalAndExpressionContext, JavaTree> CAndToJT = a -> drillParse(a, b -> b.conditionalAndExpression(), b -> b.inclusiveOrExpression(), assumedCAndToJT, IOrToJT);
        Function<ConditionalOrExpressionContext, JavaTree> COrToJT = a -> drillParse(a, b -> b.conditionalOrExpression(), b -> b.conditionalAndExpression(), assumedCOrToJT, CAndToJT);
        Function<ConditionalExpressionContext, JavaTree> TernarytoJT = a -> drillParse(a, b -> a.expression(), b -> a.conditionalOrExpression(), assumedTernaryToJT, COrToJT);

        if (someConditionalExpression instanceof ConditionalExpressionContext)
        {
            return TernarytoJT.apply((ConditionalExpressionContext)someConditionalExpression);
        }
        if (someConditionalExpression instanceof ConditionalOrExpressionContext)
        {
            return COrToJT.apply((ConditionalOrExpressionContext)someConditionalExpression);
        }
        if (someConditionalExpression instanceof AdditiveExpressionContext) {
            return AddToJT.apply((AdditiveExpressionContext) someConditionalExpression);
        }
        if (someConditionalExpression instanceof ShiftExpressionContext) {
            return ShiftToJT.apply((ShiftExpressionContext) someConditionalExpression);
        }
        if (someConditionalExpression instanceof RelationalExpressionContext) {
            return RelationalToJT.apply((RelationalExpressionContext) someConditionalExpression);
        }
        if (someConditionalExpression instanceof EqualityExpressionContext) {
            return EqualityToJT.apply((EqualityExpressionContext) someConditionalExpression);
        }
        if (someConditionalExpression instanceof AndExpressionContext) {
            return AndToJT.apply((AndExpressionContext) someConditionalExpression);
        }
        if (someConditionalExpression instanceof ExclusiveOrExpressionContext) {
            return EOrToJT.apply((ExclusiveOrExpressionContext) someConditionalExpression);
        }
        if (someConditionalExpression instanceof InclusiveOrExpressionContext) {
            return IOrToJT.apply((InclusiveOrExpressionContext) someConditionalExpression);
        }
        if (someConditionalExpression instanceof ConditionalAndExpressionContext) {
            return CAndToJT.apply((ConditionalAndExpressionContext) someConditionalExpression);
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

    static JavaTree parseExpression(ExpressionContext expressionContext)
    {

    }

    static JavaTree parseTypeName(TypeNameContext typeName, boolean isOriginal)
    {
        List<String> annotationTypeNameElements = getRecursive(typeName.packageOrTypeName(), a -> a.Identifier().toString(), PackageOrTypeNameContext::packageOrTypeName);
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
