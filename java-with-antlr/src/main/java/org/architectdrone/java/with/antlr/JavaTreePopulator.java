package org.architectdrone.java.with.antlr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import static org.architectdrone.java.with.antlr.JavaNode.ABSTRACT_MODIFIER_KEYWORD;
import static org.architectdrone.java.with.antlr.JavaNode.ADD_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.AND_ASSIGNMENT_EQUALS;
import static org.architectdrone.java.with.antlr.JavaNode.AND_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.ANNOTATION;
import static org.architectdrone.java.with.antlr.JavaNode.ANNOTATION_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.ANNOTATION_TYPE_ELEMENT_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.ARGUMENT_LIST;
import static org.architectdrone.java.with.antlr.JavaNode.ARRAY_ACCESS;
import static org.architectdrone.java.with.antlr.JavaNode.ARRAY_ACCESS_ELEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.ARRAY_CREATION_EXPRESSION;
import static org.architectdrone.java.with.antlr.JavaNode.ARRAY_INITIALIZER;
import static org.architectdrone.java.with.antlr.JavaNode.ASSERT_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.ASSIGNMENT;
import static org.architectdrone.java.with.antlr.JavaNode.BASIC_FOR_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.BINARY_AND_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.BINARY_EXPRESSION;
import static org.architectdrone.java.with.antlr.JavaNode.BINARY_NOT_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.BINARY_OR_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.BLOCK;
import static org.architectdrone.java.with.antlr.JavaNode.BREAK_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.CAST_EXPRESSION;
import static org.architectdrone.java.with.antlr.JavaNode.CLASS_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.CLASS_INSTANCE_CREATION_EXPRESSION;
import static org.architectdrone.java.with.antlr.JavaNode.COMPILATION_UNIT;
import static org.architectdrone.java.with.antlr.JavaNode.CONTINUE_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.DECREMENT_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.DEFAULT_KEYWORD;
import static org.architectdrone.java.with.antlr.JavaNode.DIM;
import static org.architectdrone.java.with.antlr.JavaNode.DIM_EXPRESSION;
import static org.architectdrone.java.with.antlr.JavaNode.DIVIDE_ASSIGNMENT_EQUALS;
import static org.architectdrone.java.with.antlr.JavaNode.DIVIDE_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.DO_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.ELEMENT_ARRAY;
import static org.architectdrone.java.with.antlr.JavaNode.ELEMENT_PAIR;
import static org.architectdrone.java.with.antlr.JavaNode.EMPTY_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.ENHANCED_FOR_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.ENUM_BODY;
import static org.architectdrone.java.with.antlr.JavaNode.ENUM_CONSTANT;
import static org.architectdrone.java.with.antlr.JavaNode.ENUM_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.EQUAL_TO_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.EXTENDS_CLASS;
import static org.architectdrone.java.with.antlr.JavaNode.EXTENDS_INTERFACE;
import static org.architectdrone.java.with.antlr.JavaNode.FIELD_ACCESS;
import static org.architectdrone.java.with.antlr.JavaNode.FINAL_MODIFIER_KEYWORD;
import static org.architectdrone.java.with.antlr.JavaNode.FOR_INIT;
import static org.architectdrone.java.with.antlr.JavaNode.FOR_UPDATE;
import static org.architectdrone.java.with.antlr.JavaNode.GREATER_THAN_OR_EQUAL_TO_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.GREATER_THAN_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.IF_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.IMPLEMENTS_INTERFACE;
import static org.architectdrone.java.with.antlr.JavaNode.INCREMENT_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.INITIALIZER;
import static org.architectdrone.java.with.antlr.JavaNode.INSTANCEOF_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.INTERFACE_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.LABELED_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.LAMBDA_EXPRESSION;
import static org.architectdrone.java.with.antlr.JavaNode.LAMBDA_EXPRESSION_FORMAL_PARAMETER_LIST;
import static org.architectdrone.java.with.antlr.JavaNode.LAMBDA_EXPRESSION_INFERRED_FORMAL_PARAMETER_LIST;
import static org.architectdrone.java.with.antlr.JavaNode.LESS_THAN_OR_EQUAL_TO_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.LESS_THAN_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.LITERAL;
import static org.architectdrone.java.with.antlr.JavaNode.METHOD_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.METHOD_ELLIPSIS_PARAMETER;
import static org.architectdrone.java.with.antlr.JavaNode.METHOD_INVOCATION;
import static org.architectdrone.java.with.antlr.JavaNode.METHOD_PARAMETER;
import static org.architectdrone.java.with.antlr.JavaNode.METHOD_RECEIVER_PARAMETER;
import static org.architectdrone.java.with.antlr.JavaNode.MINUS_ASSIGNMENT_EQUALS;
import static org.architectdrone.java.with.antlr.JavaNode.MOD_ASSIGNMENT_EQUALS;
import static org.architectdrone.java.with.antlr.JavaNode.MULTIPLY_ASSIGNMENT_EQUALS;
import static org.architectdrone.java.with.antlr.JavaNode.MULTIPLY_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.NEW_METHOD_REFERENCE;
import static org.architectdrone.java.with.antlr.JavaNode.NORMAL_IMPORT_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.NORMAL_METHOD_REFERENCE;
import static org.architectdrone.java.with.antlr.JavaNode.NOT_ASSIGNMENT_EQUALS;
import static org.architectdrone.java.with.antlr.JavaNode.NOT_EQUAL_TO_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.NOT_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.OR_ASSIGNMENT_EQUALS;
import static org.architectdrone.java.with.antlr.JavaNode.OR_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.PACKAGE_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.PLUS_ASSIGNMENT_EQUALS;
import static org.architectdrone.java.with.antlr.JavaNode.PRIMARY;
import static org.architectdrone.java.with.antlr.JavaNode.PRIMARY_TYPE_DOT_CLASS;
import static org.architectdrone.java.with.antlr.JavaNode.PRIMARY_TYPE_DOT_THIS;
import static org.architectdrone.java.with.antlr.JavaNode.PRIVATE_MODIFIER_KEYWORD;
import static org.architectdrone.java.with.antlr.JavaNode.PROTECTED_MODIFIER_KEYWORD;
import static org.architectdrone.java.with.antlr.JavaNode.PUBLIC_MODIFIER_KEYWORD;
import static org.architectdrone.java.with.antlr.JavaNode.QUALIFIER;
import static org.architectdrone.java.with.antlr.JavaNode.QUALIFIER_ELEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.RETURN_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.SHIFT_LEFT_LOGICAL_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.SHIFT_RIGHT_ARITMATIC_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.SHIFT_RIGHT_LOGICAL_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.STATIC_IMPORT_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.STATIC_MODIFIER_KEYWORD;
import static org.architectdrone.java.with.antlr.JavaNode.STRICTFP_MODIFIER_KEYWORD;
import static org.architectdrone.java.with.antlr.JavaNode.SUBTRACT_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.SUPER_EXPLICIT_CONSTRUCTOR_INVOCATION;
import static org.architectdrone.java.with.antlr.JavaNode.SUPER_FIELD_ACCESS;
import static org.architectdrone.java.with.antlr.JavaNode.SUPER_METHOD_INVOCATION;
import static org.architectdrone.java.with.antlr.JavaNode.SUPER_METHOD_REFERENCE;
import static org.architectdrone.java.with.antlr.JavaNode.SWITCH_GROUP;
import static org.architectdrone.java.with.antlr.JavaNode.SWITCH_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.SYNCHRONIZED_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.TERNARY_EXPRESSION;
import static org.architectdrone.java.with.antlr.JavaNode.THIS_EXPLICIT_CONSTRUCTOR_INVOCATION;
import static org.architectdrone.java.with.antlr.JavaNode.THROWS_EXCEPTION;
import static org.architectdrone.java.with.antlr.JavaNode.THROW_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.TRY_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.TRY_STATEMENT_CATCH;
import static org.architectdrone.java.with.antlr.JavaNode.TRY_STATEMENT_FINALLY;
import static org.architectdrone.java.with.antlr.JavaNode.TRY_STATEMENT_RESOURCE;
import static org.architectdrone.java.with.antlr.JavaNode.TYPE;
import static org.architectdrone.java.with.antlr.JavaNode.TYPE_ARGUMENT_LIST;
import static org.architectdrone.java.with.antlr.JavaNode.TYPE_BODY;
import static org.architectdrone.java.with.antlr.JavaNode.TYPE_PARAMETER;
import static org.architectdrone.java.with.antlr.JavaNode.TYPE_PARAMETER_LIST;
import static org.architectdrone.java.with.antlr.JavaNode.TYPE_QUALIFIER_ELEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.UNARY_EXPRESSION;
import static org.architectdrone.java.with.antlr.JavaNode.VARIABLE_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.VARIABLE_DECLARATOR;
import static org.architectdrone.java.with.antlr.JavaNode.VOID_MODIFIER_KEYWORD;
import static org.architectdrone.java.with.antlr.JavaNode.WHILE_STATEMENT;
import static org.architectdrone.java.with.antlr.JavaNode.WILDCARD;
import static org.architectdrone.java.with.antlr.JavaNode.WILDCARD_EXTENDS;
import static org.architectdrone.java.with.antlr.JavaNode.WILDCARD_SUPER;
import static org.architectdrone.java.with.antlr.JavaNode.XOR_SYMBOL;
import static org.architectdrone.java.with.antlr.parser.implementation.Java8Parser.*;

public class JavaTreePopulator {
    boolean isOriginal;

    public JavaTreePopulator(boolean isOriginal)
    {
        this.isOriginal = isOriginal;
    }

    JavaTree getChildren(ParseTree parseTree) {
        if (parseTree.getClass() == CompilationUnitContext.class)
        {
            return parseCompilationUnit((CompilationUnitContext) parseTree);
        } else {
            throw new RuntimeException("Cannot parse this.");
        }
    }

    private JavaTree parseCompilationUnit(CompilationUnitContext compilationUnit)
    {
        PackageDeclarationContext packageDeclarations = compilationUnit.packageDeclaration();
        List<ImportDeclarationContext> importDeclarationContexts = compilationUnit.importDeclaration();
        List<TypeDeclarationContext> typeDeclarationContexts = compilationUnit.typeDeclaration();

        List<JavaTree> children = new ArrayList<>();
        if (compilationUnit.packageDeclaration() != null)
        {
            children.add(parsePackageDeclaration(compilationUnit.packageDeclaration()));
        }

        for (ImportDeclarationContext importDeclaration : compilationUnit.importDeclaration())
        {
            JavaNode importJavaNodeType;
            List<String> qualifierElementStrings;
            if (importDeclaration.singleTypeImportDeclaration() != null) {
                importJavaNodeType = NORMAL_IMPORT_DECLARATION;
                qualifierElementStrings = typeNameToStrings(importDeclaration.singleTypeImportDeclaration().typeName());
            } else if (importDeclaration.typeImportOnDemandDeclaration() != null) {
                importJavaNodeType = NORMAL_IMPORT_DECLARATION;
                qualifierElementStrings = packageOrTypeNameToStrings(importDeclaration.typeImportOnDemandDeclaration().packageOrTypeName());
                qualifierElementStrings.add("*");
            } else if (importDeclaration.singleStaticImportDeclaration() != null) {
                importJavaNodeType = STATIC_IMPORT_DECLARATION;
                qualifierElementStrings = typeNameToStrings(importDeclaration.singleStaticImportDeclaration().typeName());
            } else {
                importJavaNodeType = STATIC_IMPORT_DECLARATION;
                qualifierElementStrings = typeNameToStrings(importDeclaration.staticImportOnDemandDeclaration().typeName());
                qualifierElementStrings.add("*");
            }
            children.add(getJavaTree(importJavaNodeType, Collections.singletonList(createQualifier(qualifierElementStrings))));
        }

        for (TypeDeclarationContext typeDeclaration : compilationUnit.typeDeclaration())
        {
            if (typeDeclaration.classDeclaration() != null)
            {
                children.add(parseClassDeclaration(typeDeclaration.classDeclaration()));
            } else
            {
                children.add(parseInterfaceDeclaration(typeDeclaration.interfaceDeclaration()));
            }
        }

        return getJavaTree(COMPILATION_UNIT, children);
    }

    private JavaTree parsePackageDeclaration(PackageDeclarationContext packageDeclarationContext)
    {
        List<AnnotationContext> annotations = packageDeclarationContext.packageModifier().stream().map(a -> a.annotation()).collect(Collectors.toList());
        List<String> packageNameElements = getRecursive(packageDeclarationContext.packageName(), a -> a.Identifier().toString(), a -> a.packageName());

        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseAnnotations(annotations));
        children.add(createQualifier(packageNameElements));

        return getJavaTree(PACKAGE_DECLARATION, children);
    }

    JavaTree createQualifier(List<String> strings)
    {
        List<JavaTree> qualifierElements = strings
                .stream()
                .map(a -> new JavaTree(QUALIFIER_ELEMENT, a, Collections.emptyList(), isOriginal))
                .collect(Collectors.toList());

        return new JavaTree(QUALIFIER, "", qualifierElements, isOriginal);
    }

    JavaTree parseAnnotation(AnnotationContext annotationContext)
    {
        if (annotationContext.normalAnnotation() != null)
        {
            return parseNormalAnnotation(annotationContext.normalAnnotation());
        } else if (annotationContext.singleElementAnnotation() != null)
        {
            return parseSingleElementAnnotation(annotationContext.singleElementAnnotation());
        } else
        {
            return parseMarkerAnnotation(annotationContext.markerAnnotation());
        }
    }

    private JavaTree parseMarkerAnnotation(final MarkerAnnotationContext markerAnnotation) {
        List<JavaTree> children = new ArrayList<>();
        children.add(parseTypeName(markerAnnotation.typeName()));
        return getJavaTree(ANNOTATION, children);
    }

    private JavaTree parseSingleElementAnnotation(final SingleElementAnnotationContext singleElementAnnotation) {
        List<JavaTree> children = new ArrayList<>();
        children.add(parseTypeName(singleElementAnnotation.typeName()));
        children.add(parseElementValue(singleElementAnnotation.elementValue()));
        return getJavaTree(ANNOTATION, children);
    }

    JavaTree parseNormalAnnotation(NormalAnnotationContext normalAnnotationContext)
    {
        List<JavaTree> children = new ArrayList<>();
        children.add(parseTypeName(normalAnnotationContext.typeName()));
        children.addAll(normalAnnotationContext
                .elementValuePairList()
                .elementValuePair()
                .stream()
                .map(this::parseElementValuePair)
                .collect(Collectors.toList()));

        return getJavaTree(ANNOTATION, children);
    }

    JavaTree parseElementValuePair(ElementValuePairContext elementValuePair)
    {
        String elementName = elementValuePair.Identifier().toString();
        ElementValueContext elementValue = elementValuePair.elementValue();

        List<JavaTree> children = new ArrayList<>();
        children.add(parseElementValue(elementValuePair.elementValue()));

        return new JavaTree(ELEMENT_PAIR, elementName, children, isOriginal);
    }

    JavaTree parseConditionalExpression(Object someConditionalExpression)
    {
        Function<ConditionalExpressionContext, JavaTree> assumedTernaryToJT = a -> new JavaTree(
                TERNARY_EXPRESSION,
                "",
                Arrays.asList(
                        parseConditionalExpression(a.conditionalOrExpression()),
                        parseExpression(a.expression()),
                        parseConditionalExpression(a.conditionalExpression())
                ),
                isOriginal
        );

        Map<JavaNode, Function<EqualityExpressionContext, ?>> equalityExpressionOperatorMap = new HashMap<>();
        equalityExpressionOperatorMap.put(EQUAL_TO_SYMBOL, EqualityExpressionContext::equalityExpressionEqualToSymbol);
        equalityExpressionOperatorMap.put(NOT_EQUAL_TO_SYMBOL, EqualityExpressionContext::equalityExpressionNotEqualToSymbol);

        Map<JavaNode, Function<RelationalExpressionContext, ?>> relationalExpressionOperatorMap = new HashMap<>();
        relationalExpressionOperatorMap.put(LESS_THAN_SYMBOL, RelationalExpressionContext::relationalExpressionLT);
        relationalExpressionOperatorMap.put(GREATER_THAN_SYMBOL, RelationalExpressionContext::relationalExpressionGT);
        relationalExpressionOperatorMap.put(LESS_THAN_OR_EQUAL_TO_SYMBOL, RelationalExpressionContext::relationalExpressionLTE);
        relationalExpressionOperatorMap.put(GREATER_THAN_OR_EQUAL_TO_SYMBOL, RelationalExpressionContext::relationalExpressionGTE);
        relationalExpressionOperatorMap.put(INSTANCEOF_SYMBOL, RelationalExpressionContext::relationalExpressionIO);

        Map<JavaNode, Function<ShiftExpressionContext, ?>> shiftExpressionOperatorMap = new HashMap<>();
        shiftExpressionOperatorMap.put(SHIFT_LEFT_LOGICAL_SYMBOL, ShiftExpressionContext::shiftExpressionSLL);
        shiftExpressionOperatorMap.put(SHIFT_RIGHT_LOGICAL_SYMBOL, ShiftExpressionContext::shiftExpressionSRL);
        shiftExpressionOperatorMap.put(SHIFT_RIGHT_ARITMATIC_SYMBOL, ShiftExpressionContext::shiftExpressionSRA);

        Map<JavaNode, Function<AdditiveExpressionContext, ?>> additiveExpressionOperatorMap = new HashMap();
        additiveExpressionOperatorMap.put(ADD_SYMBOL, AdditiveExpressionContext::additiveExpressionP);
        additiveExpressionOperatorMap.put(SUBTRACT_SYMBOL, AdditiveExpressionContext::additiveExpressionM);

        Map<JavaNode, Function<MultiplicativeExpressionContext, ?>> multiplyExpressionOperatorMap = new HashMap();
        multiplyExpressionOperatorMap.put(MULTIPLY_SYMBOL, MultiplicativeExpressionContext::multiplicativeExpressionM);
        multiplyExpressionOperatorMap.put(DIVIDE_SYMBOL, MultiplicativeExpressionContext::multiplicativeExpressionD);
        multiplyExpressionOperatorMap.put(MOD_ASSIGNMENT_EQUALS, MultiplicativeExpressionContext::multiplicativeExpressionMod);

        Function<MultiplicativeExpressionContext, JavaTree> MultiplyToJT = a -> drillParseBinaryExpressionMultiple(a, b -> b.multiplicativeExpression(), b -> b.unaryExpression(), multiplyExpressionOperatorMap, this::parseUnaryExpression);
        Function<AdditiveExpressionContext, JavaTree> AddToJT = a -> drillParseBinaryExpressionMultiple(a, b -> b.additiveExpression(), b -> b.multiplicativeExpression(), additiveExpressionOperatorMap, MultiplyToJT);
        Function<ShiftExpressionContext, JavaTree> ShiftToJT = a -> drillParseBinaryExpressionMultiple(a, b -> b.shiftExpression(), b -> b.additiveExpression(), shiftExpressionOperatorMap, AddToJT);
        Function<RelationalExpressionContext, JavaTree> RelationalToJT = a -> parseRelationalExpression(a, ShiftToJT);
        Function<EqualityExpressionContext, JavaTree> EqualityToJT = a -> drillParseBinaryExpressionMultiple(a, b -> b.equalityExpression(), b -> b.relationalExpression(), equalityExpressionOperatorMap,
                RelationalToJT);
        Function<AndExpressionContext, JavaTree> AndToJT = a -> drillParseBinaryExpressionSingle(a, b -> b.andExpression(), b -> b.equalityExpression(), BINARY_AND_SYMBOL, EqualityToJT);
        Function<ExclusiveOrExpressionContext, JavaTree> EOrToJT = a -> drillParseBinaryExpressionSingle(a, b -> b.exclusiveOrExpression(), b -> b.andExpression(), XOR_SYMBOL, AndToJT);
        Function<InclusiveOrExpressionContext, JavaTree> IOrToJT = a -> drillParseBinaryExpressionSingle(a, b -> b.inclusiveOrExpression(), b -> b.exclusiveOrExpression(), BINARY_OR_SYMBOL, EOrToJT);
        Function<ConditionalAndExpressionContext, JavaTree> CAndToJT = a -> drillParseBinaryExpressionSingle(a, b -> b.conditionalAndExpression(), b -> b.inclusiveOrExpression(), AND_SYMBOL, IOrToJT);
        Function<ConditionalOrExpressionContext, JavaTree> COrToJT = a -> drillParseBinaryExpressionSingle(a, b -> b.conditionalOrExpression(), b -> b.conditionalAndExpression(), OR_SYMBOL, CAndToJT);
        Function<ConditionalExpressionContext, JavaTree> TernarytoJT = a -> drillParse(a, b -> b.expression(), b -> b.conditionalOrExpression(), assumedTernaryToJT, COrToJT);

        if (someConditionalExpression instanceof MultiplicativeExpressionContext) {
            return MultiplyToJT.apply((MultiplicativeExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof AdditiveExpressionContext) {
            return AddToJT.apply((AdditiveExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof ShiftExpressionContext) {
            return ShiftToJT.apply((ShiftExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof RelationalExpressionContext) {
            return RelationalToJT.apply((RelationalExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof EqualityExpressionContext) {
            return EqualityToJT.apply((EqualityExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof AndExpressionContext) {
            return AndToJT.apply((AndExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof ExclusiveOrExpressionContext) {
            return EOrToJT.apply((ExclusiveOrExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof InclusiveOrExpressionContext) {
            return IOrToJT.apply((InclusiveOrExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof ConditionalAndExpressionContext) {
            return CAndToJT.apply((ConditionalAndExpressionContext) someConditionalExpression);
        }
        else if (someConditionalExpression instanceof ConditionalExpressionContext) {
            return TernarytoJT.apply((ConditionalExpressionContext)someConditionalExpression);
        }
        else if (someConditionalExpression instanceof ConditionalOrExpressionContext) {
            return COrToJT.apply((ConditionalOrExpressionContext)someConditionalExpression);
        }
        else {
            throw new RuntimeException("Given unknown expression type");
        }
    }

    JavaTree parseRelationalExpression(RelationalExpressionContext relationalExpression, Function<ShiftExpressionContext, JavaTree> drillDeeper)
    {
        JavaNode operator;
        JavaTree right;
        if (relationalExpression.relationalExpression() == null)
            return drillDeeper.apply(relationalExpression.shiftExpression());
        if (relationalExpression.relationalExpressionLTE() != null)
        {
            operator = LESS_THAN_OR_EQUAL_TO_SYMBOL;
            right = drillDeeper.apply(relationalExpression.shiftExpression());
        } else if (relationalExpression.relationalExpressionLT() != null)
        {
            operator = LESS_THAN_SYMBOL;
            right = drillDeeper.apply(relationalExpression.shiftExpression());
        } else if (relationalExpression.relationalExpressionGTE() != null)
        {
            operator = GREATER_THAN_OR_EQUAL_TO_SYMBOL;
            right = drillDeeper.apply(relationalExpression.shiftExpression());
        } else if (relationalExpression.relationalExpressionGT() != null)
        {
            operator = GREATER_THAN_SYMBOL;
            right = drillDeeper.apply(relationalExpression.shiftExpression());
        } else
        {
            operator = INSTANCEOF_SYMBOL;
            right = parseReferenceType(relationalExpression.referenceType());
        }

        return getJavaTree(BINARY_EXPRESSION, Arrays.asList(parseRelationalExpression(relationalExpression.relationalExpression(), drillDeeper),
                getSymbol(operator),
                right));
    }

    private JavaTree parseUnaryExpression(final UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus) {
        JavaNode symbol;
        UnaryExpressionContext nextUnaryExpression;
        if (unaryExpressionNotPlusMinus.unaryExpressionNotPlusMinusBN() != null) {
            symbol = BINARY_NOT_SYMBOL;
            nextUnaryExpression = unaryExpressionNotPlusMinus.unaryExpression();
        } else if (unaryExpressionNotPlusMinus.unaryExpressionNotPlusMinusCN() != null) {
            symbol = NOT_SYMBOL;
            nextUnaryExpression = unaryExpressionNotPlusMinus.unaryExpression();
        } else if (unaryExpressionNotPlusMinus.castExpression() != null)
        {
            return parseCastExpression(unaryExpressionNotPlusMinus.castExpression());
        } else
        {
            return parsePostfixExpression(unaryExpressionNotPlusMinus.postfixExpression());
        }
        return new JavaTree(UNARY_EXPRESSION, "", Arrays.asList(getSymbol(symbol), parseUnaryExpression(nextUnaryExpression)), isOriginal);
    }

    JavaTree parseUnaryExpression(UnaryExpressionContext unaryExpression) {
        JavaNode symbol;
        UnaryExpressionContext nextUnaryExpression;
        if (unaryExpression.preIncrementExpression() != null)
        {
            symbol = INCREMENT_SYMBOL;
            nextUnaryExpression = unaryExpression.preIncrementExpression().unaryExpression();
        } else if (unaryExpression.preDecrementExpression() != null)
        {
            symbol = DECREMENT_SYMBOL;
            nextUnaryExpression = unaryExpression.preDecrementExpression().unaryExpression();
        } else if (unaryExpression.unaryExpressionP() != null)
        {
            symbol = ADD_SYMBOL;
            nextUnaryExpression = unaryExpression.unaryExpression();
        } else if (unaryExpression.unaryExpressionM() != null)
        {
            symbol = SUBTRACT_SYMBOL;
            nextUnaryExpression = unaryExpression.unaryExpression();
        } else {
            return parseUnaryExpression(unaryExpression.unaryExpressionNotPlusMinus());
        }

        return new JavaTree(UNARY_EXPRESSION, "", Arrays.asList(getSymbol(symbol), parseUnaryExpression(nextUnaryExpression)), isOriginal);
    }

    JavaTree parsePostfixExpression(PostfixExpressionContext postfixExpressionContext) {
        JavaTree next;
        List<JavaTree> symbols = new ArrayList<>();
        if (postfixExpressionContext.primary() != null)
        {
            next = parsePrimary(postfixExpressionContext.primary());
        }
        else {
            next = parseExpressionName(postfixExpressionContext.expressionName());
        }
        if (postfixExpressionContext.postfixExpressionSymbol().isEmpty())
        {
            return next;
        }

        for (PostfixExpressionSymbolContext symbol : postfixExpressionContext.postfixExpressionSymbol())
        {
            if (symbol.postDecrementExpression_lf_postfixExpression() != null)
            {
                symbols.add(getSymbol(DECREMENT_SYMBOL));
            }
            else
            {
                symbols.add(getSymbol(INCREMENT_SYMBOL));
            }
        }
        List<JavaTree> children = new ArrayList<>();
        children.add(next);
        children.addAll(symbols);
        return new JavaTree(UNARY_EXPRESSION, "", children, isOriginal);
    }

    JavaTree parsePrimary(PrimaryContext primary)
    {
        List<JavaTree> children = new ArrayList<>();
        if (primary.primaryNoNewArray_lfno_primary() != null)
        {
            children.add(parsePrimary(primary.primaryNoNewArray_lfno_primary()));
        }
        else
        {
            children.add(parseArrayCreationExpression(primary.arrayCreationExpression()));
        }

        for (PrimaryNoNewArray_lf_primaryContext i : primary.primaryNoNewArray_lf_primary())
        {
            children.add(parsePrimary(i));
        }
        return new JavaTree(PRIMARY, "", children, isOriginal);
    }

    JavaTree parseArrayCreationExpression(ArrayCreationExpressionContext arrayCreationExpression)
    {
        List<JavaTree> children = new ArrayList<>();
        if (arrayCreationExpression.primitiveType() != null)
        {
            children.add(parsePrimitiveType(arrayCreationExpression.primitiveType()));
        } else
        {
            children.add(parseClassOrInterfaceType(arrayCreationExpression.classOrInterfaceType()));
        }
        if (arrayCreationExpression.dimExprs() != null)
        {
            for (DimExprContext dimExpr : arrayCreationExpression.dimExprs().dimExpr())
            {
                List<JavaTree> annotations = dimExpr
                        .annotation()
                        .stream()
                        .map(a -> parseAnnotation(a))
                        .collect(Collectors.toList());
                JavaTree expression = parseExpression(dimExpr.expression());
                List<JavaTree> dimExprChildren = new ArrayList<>();
                dimExprChildren.addAll(annotations);
                dimExprChildren.add(expression);
                children.add(new JavaTree(DIM_EXPRESSION, "", dimExprChildren, isOriginal));
            }
        }
        if (arrayCreationExpression.dims() != null)
        {
            children.addAll(getDims(arrayCreationExpression.dims()));
        }
        if (arrayCreationExpression.arrayInitializer() != null)
        {
            children.add(parseArrayInitializer(arrayCreationExpression.arrayInitializer()));
        }
        return new JavaTree(ARRAY_CREATION_EXPRESSION, "", children, isOriginal);
    }

    private JavaTree parseArrayInitializer(final ArrayInitializerContext arrayInitializer) {
        List<JavaTree> children = new ArrayList<>();
        for (VariableInitializerContext variableInitializerContext : arrayInitializer.variableInitializerList().variableInitializer())
        {
            if (variableInitializerContext.arrayInitializer() != null)
            {
                children.add(parseArrayInitializer(variableInitializerContext.arrayInitializer()));
            }
            else
            {
                children.add(parseExpression(variableInitializerContext.expression()));
            }
        }
        return getJavaTree(ARRAY_INITIALIZER, children);
    }

    private JavaTree getJavaTree(JavaNode node, List<JavaTree> children)
    {
        return new JavaTree(node, "", children , isOriginal);
    }

    private <I, CT, IT, CCT, CCCT, ICCT> List<JavaTree> getClassOrInterfaceTypeChildren(I input,
            Function<I, CT> extractClassType,
            Function<I, IT> extractInterfaceType,
            Function<IT, CT> extractClassTypeFromInterface,
            Function<CT, List<AnnotationContext>> extractAnnotationsFromFirstClass,
            Function<CT, TypeArgumentsContext> extractTypeArgumentsFromFirstClass,
            Function<CT, TerminalNode> extractIdentifier,
            Function<I, List<CCT>> extractContinuedClasses,
            Function<CCT, CCCT> extractClassFromContinuedClassType,
            Function<CCT, ICCT> extractInterfaceFromContinuedInterfaceType,
            Function<ICCT, CCCT> extractContinuedClassFromContinuedInterface,
            Function<CCCT, List<AnnotationContext>> extractAnnotationsFromContinuedClass,
            Function<CCCT, TypeArgumentsContext> extractTypeArgumentsFromContinuedClass,
            Function<CCCT, TerminalNode> extractIdentifierFormContinuedClass
            )
    {
        CT first;
        List<JavaTree> firstElementChildren = new ArrayList<>();
        if (extractClassType.apply(input) != null)
        {
            first = extractClassType.apply(input);
        } else
        {
            first = extractClassTypeFromInterface.apply(extractInterfaceType.apply(input));
        }

        if (extractAnnotationsFromFirstClass.apply(first) != null)
        {
            firstElementChildren.addAll(parseAnnotations(extractAnnotationsFromFirstClass.apply(first)));
        }

        if (extractTypeArgumentsFromFirstClass.apply(first) != null)
        {
            firstElementChildren.add(parseTypeArguments(extractTypeArgumentsFromFirstClass.apply(first)));
        }
        JavaTree firstElement = new JavaTree(TYPE_QUALIFIER_ELEMENT, extractIdentifier.apply(first).toString(), firstElementChildren, isOriginal);

        List<JavaTree> nextElements = new ArrayList<>();

        for (CCT continuedClassOrInterfaceType : extractContinuedClasses.apply(input))
        {
            CCCT next;
            if (extractClassFromContinuedClassType.apply(continuedClassOrInterfaceType) != null)
            {
                next = extractClassFromContinuedClassType.apply(continuedClassOrInterfaceType);
            }
            else {
                next = extractContinuedClassFromContinuedInterface.apply(extractInterfaceFromContinuedInterfaceType.apply(continuedClassOrInterfaceType));
            }

            List<JavaTree> nextElementChildren = new ArrayList<>();
            nextElementChildren.addAll(parseAnnotations(extractAnnotationsFromContinuedClass.apply(next)));
            if (extractTypeArgumentsFromContinuedClass.apply(next) != null)
            {
                nextElementChildren.add(parseTypeArguments(extractTypeArgumentsFromContinuedClass.apply(next)));
            }
            nextElements.add(new JavaTree(TYPE_QUALIFIER_ELEMENT, extractIdentifierFormContinuedClass.apply(next).toString(), nextElementChildren, isOriginal));
        }

        List<JavaTree> children = new ArrayList<>();
        children.add(firstElement);
        children.addAll(nextElements);
        return children;
    }

    private List<JavaTree> getClassOrInterfaceTypeChildren(final ClassOrInterfaceTypeContext classOrInterfaceType) {
       return getClassOrInterfaceTypeChildren(
               classOrInterfaceType,
               i -> i.classType_lfno_classOrInterfaceType(),
               i -> i.interfaceType_lfno_classOrInterfaceType(),
               it -> it.classType_lfno_classOrInterfaceType(),
               ct -> ct.annotation(),
               ct -> ct.typeArguments(),
               ct -> ct.Identifier(),
               i -> i.continuedClassOrInterfaceType(),
               cct -> cct.classType_lf_classOrInterfaceType(),
               cct -> cct.interfaceType_lf_classOrInterfaceType(),
               icct -> icct.classType_lf_classOrInterfaceType(),
               ccct -> ccct.annotation(),
               ccct -> ccct.typeArguments(),
               ccct -> ccct.Identifier());
    }

    private List<JavaTree> getClassOrInterfaceTypeChildren(final UnannClassOrInterfaceTypeContext classOrInterfaceType) {
       return getClassOrInterfaceTypeChildren(
               classOrInterfaceType,
               i -> i.unannClassType_lfno_unannClassOrInterfaceType(),
               i -> i.unannInterfaceType_lfno_unannClassOrInterfaceType(),
               it -> it.unannClassType_lfno_unannClassOrInterfaceType(),
               ct -> null,
               ct -> ct.typeArguments(),
               ct -> ct.Identifier(),
               i -> i.unannContinuedClassOrInterfaceType(),
               cct -> cct.unannClassType_lf_unannClassOrInterfaceType(),
               cct -> cct.unannInterfaceType_lf_unannClassOrInterfaceType(),
               icct -> icct.unannClassType_lf_unannClassOrInterfaceType(),
               ccct -> ccct.annotation(),
               ccct -> ccct.typeArguments(),
               ccct -> ccct.Identifier());
    }

    private JavaTree parseTypeArguments(final TypeArgumentsContext typeArguments) {
        List<JavaTree> children = new ArrayList<>();
        for (TypeArgumentContext typeArgument : typeArguments.typeArgumentList().typeArgument())
        {
            if (typeArgument.wildcard() != null)
            {
                WildcardContext wildcard = typeArgument.wildcard();
                List<JavaTree> wildcardChildren = new ArrayList<>();
                wildcardChildren.addAll(parseAnnotations(typeArgument.wildcard().annotation()));
                if (wildcard.wildcardBounds() != null)
                {
                    if (wildcard.wildcardBounds().wildcardExtends() != null)
                    {
                        ReferenceTypeContext referenceType = wildcard
                                .wildcardBounds()
                                .wildcardExtends()
                                .referenceType();
                        wildcardChildren.add(
                                getJavaTree(
                                        WILDCARD_EXTENDS,
                                        Arrays.asList(parseReferenceType(referenceType))));
                    }
                    else
                    {
                        ReferenceTypeContext referenceType = wildcard
                                .wildcardBounds()
                                .referenceType();
                        wildcardChildren.add(
                                getJavaTree(
                                        WILDCARD_SUPER,
                                        Arrays.asList(parseReferenceType(referenceType))));
                    }
                }
                children.add(getJavaTree(WILDCARD, wildcardChildren));
            }
            else
            {
                children.add(parseReferenceType(typeArgument.referenceType()));
            }
        }
        return getJavaTree(TYPE_ARGUMENT_LIST, children);
    }

    private <I, C, T, A> JavaTree parseReferenceType(I referenceType,
            Function<I, C> extractClassType,
            Function<C, JavaTree> parseClass,
            Function<I, T> extractTypeVariable,
            Function<T, JavaTree> parseType,
            Function<I, A> extractArray,
            Function<A, JavaTree> parseArray) {
        if (extractClassType.apply(referenceType) != null)
        {
            return parseClass.apply(extractClassType.apply(referenceType));
        } else if (extractTypeVariable.apply(referenceType) != null)
        {
            return parseType.apply(extractTypeVariable.apply(referenceType));
        } else
        {
            return parseArray.apply(extractArray.apply(referenceType));
        }
    }

    private JavaTree parseReferenceType(final ReferenceTypeContext referenceType) {
        return parseReferenceType(referenceType,
                a -> a.classOrInterfaceType(),
                c -> parseClassOrInterfaceType(c),
                a -> a.typeVariable(),
                t -> parseTypeVariable(t),
                a -> a.arrayType(),
                a -> parseArrayType(a));
    }

    private JavaTree parseReferenceType(final UnannReferenceTypeContext referenceType) {
        return parseReferenceType(referenceType,
                a -> a.unannClassOrInterfaceType(),
                c -> parseClassOrInterfaceType(c),
                a -> a.unannTypeVariable(),
                t -> parseTypeVariable(t),
                a -> a.unannArrayType(),
                a -> parseArrayType(a));
    }

        private <I, C, T, P> JavaTree parseArrayType(I arrayType,
            Function<I, C> extractClassType,
            Function<C, List<JavaTree>> getClassChildren,
            Function<I, T> extractTypeVariable,
            Function<T, List<JavaTree>> getTypeChildren,
            Function<I, P> extractPrimitive,
            Function<P, List<JavaTree>> getPrimitiveChildren,
            Function<I, DimsContext> extractDims
            ) {
        List<JavaTree> children = new ArrayList<>();
        if (extractClassType.apply(arrayType) != null)
        {
            children.addAll(getClassChildren.apply(extractClassType.apply(arrayType)));
        } else if (extractTypeVariable.apply(arrayType) != null)
        {
            children.addAll(getTypeChildren.apply(extractTypeVariable.apply(arrayType)));
        } else
        {
            children.addAll(getPrimitiveChildren.apply(extractPrimitive.apply(arrayType)));
        }
        children.addAll(getDims(extractDims.apply(arrayType)));
        return getJavaTree(TYPE, children);
    }

    private JavaTree parseArrayType(final ArrayTypeContext arrayType) {
        return parseArrayType(arrayType,
                a -> a.classOrInterfaceType(),
                c -> getClassOrInterfaceTypeChildren(c),
                a -> a.typeVariable(),
                t -> getTypeVariableChildren(t),
                a -> a.primitiveType(),
                p -> getPrimitiveTypeElements(p),
                a -> a.dims());
    }

    private JavaTree parseArrayType(final UnannArrayTypeContext arrayType) {
        return parseArrayType(arrayType,
                a -> a.unannClassOrInterfaceType(),
                c -> getClassOrInterfaceTypeChildren(c),
                a -> a.unannTypeVariable(),
                t -> getTypeVariableChildren(t),
                a -> a.unannPrimitiveType(),
                p -> getPrimitiveTypeElements(p),
                a -> a.dims());
    }

    private JavaTree parseUnannType(final UnannTypeContext unannType) {
        if (unannType.unannPrimitiveType() != null)
        {
            return parsePrimitiveType(unannType.unannPrimitiveType());
        }
        return parseReferenceType(unannType.unannReferenceType());
    }

    private JavaTree parsePrimitiveType(PrimitiveTypeContext primitiveType)
    {
        return getJavaTree(TYPE, getPrimitiveTypeElements(primitiveType));
    }

    private JavaTree parsePrimitiveType(UnannPrimitiveTypeContext primitiveType)
    {
        return getJavaTree(TYPE, getPrimitiveTypeElements(primitiveType));
    }

    private <I> List<JavaTree> getPrimitiveTypeElements(I input,
            Function<I, List<AnnotationContext>> extractAnnotation,
            Function<I, NumericTypeContext> extractNumericType)
    {
        List<JavaTree> children = new ArrayList<>();
        if (extractAnnotation.apply(input) != null)
        {
            children.addAll(parseAnnotations(extractAnnotation.apply(input)));
        }
        String label;
        if (extractNumericType.apply(input) != null)
        {
            label = extractNumericType.apply(input).getText();
        }
        else
        {
            label = "boolean";
        }
        return Collections.singletonList(new JavaTree(TYPE_QUALIFIER_ELEMENT, label, children, isOriginal));
    }

    private List<JavaTree> getPrimitiveTypeElements(PrimitiveTypeContext primitiveType)
    {
        return getPrimitiveTypeElements(primitiveType,
                a -> a.annotation(),
                a -> a.numericType());
    }

    private List<JavaTree> getPrimitiveTypeElements(UnannPrimitiveTypeContext primitiveType)
    {
        return getPrimitiveTypeElements(primitiveType,
                a -> null,
                a -> a.numericType());
    }

    private JavaTree parseTypeVariable(final TypeVariableContext typeVariable) {
        return getJavaTree(TYPE, getTypeVariableChildren(typeVariable));
    }

    private JavaTree parseTypeVariable(final UnannTypeVariableContext typeVariable) {
        return getJavaTree(TYPE, getTypeVariableChildren(typeVariable));
    }

    private List<JavaTree> getTypeVariableChildren(final TypeVariableContext typeVariable) {
        return Collections.singletonList(new JavaTree(TYPE_QUALIFIER_ELEMENT, typeVariable.Identifier().toString(), parseAnnotations(typeVariable.annotation()), isOriginal));
    }

    private JavaTree parseClassOrInterfaceType(final UnannClassOrInterfaceTypeContext classOrInterfaceType) {
        return new JavaTree(TYPE, "", getClassOrInterfaceTypeChildren(classOrInterfaceType), isOriginal);
    }

    private JavaTree parseClassOrInterfaceType(final ClassOrInterfaceTypeContext classOrInterfaceType) {
        return new JavaTree(TYPE, "", getClassOrInterfaceTypeChildren(classOrInterfaceType), isOriginal);
    }

    private List<JavaTree> getTypeVariableChildren(final UnannTypeVariableContext typeVariable) {
        return Collections.singletonList(new JavaTree(TYPE_QUALIFIER_ELEMENT, typeVariable.Identifier().toString(), Collections.emptyList(), isOriginal));
    }

    private List<JavaTree> parseAnnotations(List<AnnotationContext> annotations)
    {
        return annotations
                .stream()
                .map(this::parseAnnotation)
                .collect(Collectors.toList());
    }

    JavaTree parsePrimary(PrimaryNoNewArrayContext primaryElement)
    {
        return parsePrimary(primaryElement,
                a -> a.literal(),
                a -> a.typeName(),
                a -> a.classKeyword(),
                a -> a.dim(),
                a -> a.expression(),
                a -> a.classInstanceCreationExpression(),
                this::parseClassInstanceCreationExpression,
                a -> a.fieldAccess(),
                this::parseFieldAccess,
                a -> a.arrayAccess(),
                this::parseArrayAccess,
                a -> a.methodInvocation(),
                this::parseMethodInvocation,
                a -> a.methodReference(),
                this::parseMethodReference);
    }

    JavaTree parsePrimary(PrimaryNoNewArray_lf_primaryContext primaryElement)
    {
        return parsePrimary(primaryElement,
                null,
                null,
                null,
                null,
                null,
                a -> a.classInstanceCreationExpression_lf_primary(),
                this::parseClassInstanceCreationExpression,
                a -> a.fieldAccess_lf_primary(),
                this::parseFieldAccess,
                a -> a.arrayAccess_lf_primary(),
                this::parseArrayAccess,
                a -> a.methodInvocation_lf_primary(),
                this::parseMethodInvocation,
                a -> a.methodReference_lf_primary(),
                this::parseMethodReference);
    }

    private <I> JavaTree parseMethodReference(
            I methodReference,
            Function<I, ExpressionNameContext> extractExpressionName,
            Function<I, ReferenceTypeContext> extractReferenceType,
            Function<I, PrimaryContext> extractPrimary,
            Function<I, TypeNameContext> extractTypeName,
            Function<I, ClassTypeContext> extractClassType,
            Function<I, ArrayTypeContext> extractArrayType,
            Function<I, TypeArgumentsContext> extractTypeArguments,
            Function<I, TerminalNode> extractIdentifier)
    {
        if (extractIdentifier.apply(methodReference) == null)
        {
            //NEW
            List<JavaTree> children = new ArrayList<>();
            if (extractClassType.apply(methodReference) != null)
            {
                children.add(parseClassType(extractClassType.apply(methodReference)));
            } else {
                children.add(parseArrayType(extractArrayType.apply(methodReference)));
            }
            if (extractTypeArguments.apply(methodReference) != null)
            {
                children.add(parseTypeArguments(extractTypeArguments.apply(methodReference)));
            }
            return getJavaTree(NEW_METHOD_REFERENCE, children);
        } else if (extractExpressionName.apply(methodReference) == null && extractReferenceType.apply(methodReference) == null && extractPrimary.apply(methodReference) == null)
        {
            //SUPER
            List<JavaTree> children = new ArrayList<>();
            if (extractTypeName.apply(methodReference) != null)
            {
                children.add(parseTypeName(extractTypeName.apply(methodReference)));
            }

            if (extractTypeArguments.apply(methodReference) != null)
            {
                children.add(parseTypeArguments(extractTypeArguments.apply(methodReference)));
            }
            return new JavaTree(SUPER_METHOD_REFERENCE, extractIdentifier.apply(methodReference).toString(), children, isOriginal);
        } else {
            //NORMAL
            List<JavaTree> children = new ArrayList<>();
            if (extractPrimary.apply(methodReference) != null)
            {
                children.add(parsePrimary(extractPrimary.apply(methodReference)));
            } else if (extractReferenceType.apply(methodReference) != null)
            {
                children.add(parseReferenceType(extractReferenceType.apply(methodReference)));
            } else if (extractExpressionName.apply(methodReference) != null)
            {
                children.add(parseExpressionName(extractExpressionName.apply(methodReference)));
            }

            if (extractTypeArguments.apply(methodReference) != null)
            {
                children.add(parseTypeArguments(extractTypeArguments.apply(methodReference)));
            }

            return new JavaTree(NORMAL_METHOD_REFERENCE, extractIdentifier.apply(methodReference).toString(), children, isOriginal);
        }
    }

    private JavaTree parseMethodReference(final MethodReferenceContext methodReference) {
        return parseMethodReference(methodReference,
                a -> a.expressionName(),
                a -> a.referenceType(),
                a -> a.primary(),
                a -> a.typeName(),
                a -> a.classType(),
                a -> a.arrayType(),
                a -> a.typeArguments(),
                a -> a.Identifier());
    }

    private JavaTree parseMethodReference(final MethodReference_lfno_primaryContext methodReference) {
        return parseMethodReference(methodReference,
                a -> a.expressionName(),
                a -> a.referenceType(),
                a -> null,
                a -> a.typeName(),
                a -> a.classType(),
                a -> a.arrayType(),
                a -> a.typeArguments(),
                a -> a.Identifier());
    }

    private JavaTree parseMethodReference(final MethodReference_lf_primaryContext methodReference) {
        return parseMethodReference(methodReference,
                a -> null,
                a -> null,
                a -> null,
                a -> null,
                a -> null,
                a -> null,
                a -> a.typeArguments(),
                a -> a.Identifier());
    }

    private <I, C> JavaTree  parseClassType(I classType,
            Function<I, TerminalNode> extractIdentifier,
            Function<I, TypeArgumentsContext> extractTypeArguments,
            Function<I, List<AnnotationContext>> extractAnnotations,
            Function<I, C> extractClassOrInterfaceType,
            Function<C, List<JavaTree>> parseClassOrInterfaceType)
    {
        List<JavaTree> children = new ArrayList<>();
        if (extractClassOrInterfaceType.apply(classType) != null)
        {
            children.addAll(parseClassOrInterfaceType.apply(extractClassOrInterfaceType.apply(classType)));
        }

        List<JavaTree> lastElementChildren = new ArrayList<>();
        lastElementChildren.addAll(parseAnnotations(extractAnnotations.apply(classType)));
        if (extractTypeArguments.apply(classType) != null)
        {
            lastElementChildren.add(parseTypeArguments(extractTypeArguments.apply(classType)));
        }
        JavaTree lastElement = new JavaTree(TYPE_QUALIFIER_ELEMENT, extractIdentifier.apply(classType).toString(), lastElementChildren, isOriginal);

        children.add(lastElement);

        return getJavaTree(TYPE, children);
    }

    private JavaTree parseClassType(final ClassTypeContext classType) {
        return parseClassType(classType,
                a -> a.Identifier(),
                a -> a.typeArguments(),
                a -> a.annotation(),
                a -> a.classOrInterfaceType(),
                c -> getClassOrInterfaceTypeChildren(c));
    }

    private JavaTree parseUnannClassType(final UnannClassTypeContext unannClassType) {
        return parseClassType(unannClassType,
                a -> a.Identifier(),
                a -> a.typeArguments(),
                a -> a.annotation(),
                a -> a.unannClassOrInterfaceType(),
                c -> getClassOrInterfaceTypeChildren(c));
    }

    private <I> JavaTree parseMethodInvocation(
            I methodInvocation,
            Function<I, MethodNameContext> extractMethodName,
            Function<I, TypeNameContext> extractTypeName,
            Function<I, ExpressionNameContext> extractExpressionName,
            Function<I, PrimaryContext> extractPrimary,
            Function<I, SuperKeywordContext> extractSuperKeyword,
            Function<I, TypeArgumentsContext> extractTypeArguments,
            Function<I, ArgumentListContext> extractArgumentList,
            Function<I, TerminalNode> extractIdentifier) {
        List<JavaTree> children = new ArrayList<>();
        if (extractMethodName.apply(methodInvocation) != null)
        {
            children.add(parseMethodNameAsQualifier(extractMethodName.apply(methodInvocation)));
        } else if (extractTypeName.apply(methodInvocation) != null)
        {
            children.add(parseTypeName(extractTypeName.apply(methodInvocation)));
        } else if (extractExpressionName.apply(methodInvocation) != null)
        {
            children.add(parseExpressionName(extractExpressionName.apply(methodInvocation)));
        } else if (extractPrimary.apply(methodInvocation) != null)
        {
            children.add(parsePrimary(extractPrimary.apply(methodInvocation)));
        }

        if (extractTypeArguments.apply(methodInvocation) != null)
        {
            children.add(parseTypeArguments(extractTypeArguments.apply(methodInvocation)));
        }

        if (extractArgumentList.apply(methodInvocation) != null)
        {
            children.add(parseArgumentList(extractArgumentList.apply(methodInvocation)));
        }

        JavaNode label;
        if (extractSuperKeyword.apply(methodInvocation) != null)
        {
            label = SUPER_METHOD_INVOCATION;
        } else {
            label = METHOD_INVOCATION;
        }

        String name;
        if (extractIdentifier.apply(methodInvocation) != null)
        {
            name = extractIdentifier.apply(methodInvocation).toString();
        }
        else {
            name = "";
        }

        return new JavaTree(label, name, children, isOriginal);
    }

    private JavaTree parseMethodInvocation(final MethodInvocationContext methodInvocation) {
        return parseMethodInvocation(methodInvocation,
                a -> a.methodName(),
                a -> a.typeName(),
                a -> a.expressionName(),
                a -> a.primary(),
                a -> a.superKeyword(),
                a -> a.typeArguments(),
                a -> a.argumentList(),
                a -> a.Identifier());
    }

    private JavaTree parseMethodInvocation(final MethodInvocation_lfno_primaryContext methodInvocation) {
        return parseMethodInvocation(methodInvocation,
                a -> a.methodName(),
                a -> a.typeName(),
                a -> a.expressionName(),
                a -> null,
                a -> null,
                a -> a.typeArguments(),
                a -> a.argumentList(),
                a -> a.Identifier());
    }

    private JavaTree parseMethodInvocation(final MethodInvocation_lf_primaryContext methodInvocation) {
        return parseMethodInvocation(methodInvocation,
                a -> null,
                a -> null,
                a -> null,
                a -> null,
                a -> null,
                a -> a.typeArguments(),
                a -> a.argumentList(),
                a -> a.Identifier());
    }

    private JavaTree parseArgumentList(final ArgumentListContext argumentList) {
        return new JavaTree(ARGUMENT_LIST, "", argumentList.expression().stream().map(a -> parseExpression(a)).collect(Collectors.toList()), isOriginal);
    }

    private JavaTree parseMethodNameAsQualifier(final MethodNameContext methodName) {
        JavaTree element = new JavaTree(QUALIFIER_ELEMENT, methodName.Identifier().toString(), Collections.emptyList(), isOriginal);
        return getJavaTree(QUALIFIER, Collections.singletonList(element));
    }

    private <I, PA, PB> JavaTree parseArrayAccess(I arrayAccess,
            Function<I, ExpressionNameContext> extractExpressionName,
            Function<I, List<ExpressionContext>> extractExpression,
            Function<I, PA> extractPrimaryA,
            Function<PA, JavaTree> primaryAToJavaTree,
            Function<I, List<PB>> extractPrimaryB,
            Function<PB, JavaTree> primaryBToJavaTree)
    {
        List<JavaTree> children = new ArrayList<>();
        if (extractExpressionName.apply(arrayAccess) != null)
        {
            children.add(parseExpressionName(extractExpressionName.apply(arrayAccess)));
        } else
        {
            children.add(primaryAToJavaTree.apply(extractPrimaryA.apply(arrayAccess)));
        }

        if (extractExpression.apply(arrayAccess).get(0) != null)
        {
            children.add(parseExpression(extractExpression.apply(arrayAccess).get(0)));
        }

        for (int i = 0; i < extractPrimaryB.apply(arrayAccess)
                .size(); i++) {
            ExpressionContext expression = extractExpression.apply(arrayAccess).get(i+1);
            PB primaryB = extractPrimaryB.apply(arrayAccess).get(i);
            List<JavaTree> arrayAccessChildren = new ArrayList<>();
            JavaTree primaryBJavaTree = primaryBToJavaTree.apply(primaryB);
            if (primaryBJavaTree != null)
            {
                arrayAccessChildren.add(primaryBJavaTree);
            }
            arrayAccessChildren.add(parseExpression(expression));
            children.add(new JavaTree(ARRAY_ACCESS_ELEMENT, "", arrayAccessChildren, isOriginal));
        }

        return new JavaTree(ARRAY_ACCESS, "", children, isOriginal);
    }

    private JavaTree parseArrayAccess(final ArrayAccess_lf_primaryContext arrayAccess) {
        return parseArrayAccess(
                arrayAccess,
                a -> null,
                a -> a.expression(),
                a -> a.primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(),
                b -> parsePrimary(b),
                a -> a.primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(),
                b -> parsePrimary(b));
    }

    private JavaTree parseArrayAccess(final ArrayAccess_lfno_primaryContext arrayAccess) {
        return parseArrayAccess(
                arrayAccess,
                a -> a.expressionName(),
                a -> a.expression(),
                a -> a.primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(),
                b -> parsePrimary(b),
                a -> a.primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(),
                b -> parsePrimary(b));
    }

    private JavaTree parseArrayAccess(final ArrayAccessContext arrayAccess) {
        return parseArrayAccess(
                arrayAccess,
                a -> a.expressionName(),
                a -> a.expression(),
                a -> a.primaryNoNewArray_lfno_arrayAccess(),
                b -> parsePrimary(b),
                a -> a.primaryNoNewArray_lf_arrayAccess(),
                b -> parsePrimary(b));
    }

    <I, CI, FA, AA, MI, MR> JavaTree parsePrimary(
            I primaryElement,
            Function<I, LiteralContext> extractLiteral,
            Function<I, TypeNameContext> extractTypeName,
            Function<I, ClassKeywordContext> extractClassKeyword,
            Function<I, List<DimContext>> extractDim,
            Function<I, ExpressionContext> extractExpression,
            Function<I, CI> extractClassInstanceCreationExpression,
            Function<CI, JavaTree> classInstanceCreationToJavaTree,
            Function<I, FA> extractFieldAccess,
            Function<FA, JavaTree> fieldAccessToJavaTree,
            Function<I, AA> extractArrayAccess,
            Function<AA, JavaTree> arrayAccessToJavaTree,
            Function<I, MI> extractMethodInvocation,
            Function<MI, JavaTree> methodInvocationToJavaTree,
            Function<I, MR> extractMethodReference,
            Function<MR, JavaTree> methodReferenceToJavaTree)
    {
        if (extractLiteral != null && extractLiteral.apply(primaryElement) != null)
        {
            return parseLiteral(extractLiteral.apply(primaryElement));
        } else if (extractTypeName != null && extractTypeName.apply(primaryElement) != null)
        {
            if (extractClassKeyword != null && extractClassKeyword.apply(primaryElement) != null)
            {
                List<JavaTree> children = new ArrayList<>();
                children.add(parseTypeName(extractTypeName.apply(primaryElement)));
                children.addAll(getDims(extractDim.apply(primaryElement)));
                return new JavaTree(PRIMARY_TYPE_DOT_CLASS,
                        "",
                        children,
                        isOriginal);
            }
            else
            {
                return new JavaTree(PRIMARY_TYPE_DOT_THIS,
                        "",
                        Collections.singletonList(
                                parseTypeName(
                                        extractTypeName.apply(primaryElement)))
                        , isOriginal);
            }
        } else if (extractClassKeyword != null && extractClassKeyword.apply(primaryElement) != null)
        {
            return getSymbol(PRIMARY_TYPE_DOT_CLASS);
        } else if (extractExpression != null && extractExpression.apply(primaryElement) != null)
        {
            return parseExpression(extractExpression.apply(primaryElement));
        } else if (extractClassInstanceCreationExpression != null && extractClassInstanceCreationExpression.apply(primaryElement) != null)
        {
            return classInstanceCreationToJavaTree.apply(extractClassInstanceCreationExpression.apply(primaryElement));
        } else if (extractFieldAccess != null && extractFieldAccess.apply(primaryElement) != null)
        {
            return fieldAccessToJavaTree.apply(extractFieldAccess.apply(primaryElement));
        } else if (extractArrayAccess != null && extractArrayAccess.apply(primaryElement) != null)
        {
            return arrayAccessToJavaTree.apply(extractArrayAccess.apply(primaryElement));
        } else if (extractMethodInvocation != null && extractMethodInvocation.apply(primaryElement) != null)
        {
            return methodInvocationToJavaTree.apply(extractMethodInvocation.apply(primaryElement));
        } else if (extractMethodReference != null && extractMethodReference.apply(primaryElement) != null)
        {
            return methodReferenceToJavaTree.apply(extractMethodReference.apply(primaryElement));
        } else {
            return new JavaTree(PRIMARY_TYPE_DOT_THIS,
                    "",
                    Collections.emptyList()
                    , isOriginal);
        }
    }

    private JavaTree parsePrimary(final PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext primary) {
        return null; //this one is nothing
    }

    private JavaTree parsePrimary(final PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext primary) {
        return parsePrimary(primary,
                a -> null,
                a -> null,
                a -> null,
                a -> null,
                a -> null,
                a -> a.classInstanceCreationExpression_lf_primary(),
                this::parseClassInstanceCreationExpression,
                a -> a.fieldAccess_lf_primary(),
                this::parseFieldAccess,
                a -> null,
                b -> null,
                a -> a.methodInvocation_lf_primary(),
                this::parseMethodInvocation,
                a -> a.methodReference_lf_primary(),
                this::parseMethodReference);
    }

    private JavaTree parsePrimary(final PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext b) {
        return null; //lol this one is literally nothing.
    }

    private JavaTree parsePrimary(final PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext primary) {
        return parsePrimary(primary,
                a -> a.literal(),
                a -> a.typeName(),
                a -> a.classKeyword(),
                a -> a.dim(),
                a -> a.expression(),
                a -> a.classInstanceCreationExpression_lfno_primary(),
                this::parseClassInstanceCreationExpression,
                a -> a.fieldAccess_lfno_primary(),
                this::parseFieldAccess,
                a -> null,
                b -> null,
                a -> a.methodInvocation_lfno_primary(),
                this::parseMethodInvocation,
                a -> a.methodReference_lfno_primary(),
                this::parseMethodReference);
    }

    private JavaTree parsePrimary(final PrimaryNoNewArray_lf_arrayAccessContext primary) {
        return null; //lol this one is literally nothing.
    }

    private JavaTree parsePrimary(final PrimaryNoNewArray_lfno_arrayAccessContext primaryElement) {
        return parsePrimary(primaryElement,
                a -> a.literal(),
                a -> a.typeName(),
                a -> a.classKeyword(),
                a -> a.dim(),
                a -> a.expression(),
                a -> a.classInstanceCreationExpression(),
                this::parseClassInstanceCreationExpression,
                a -> a.fieldAccess(),
                this::parseFieldAccess,
                a -> null,
                b -> null,
                a -> a.methodInvocation(),
                this::parseMethodInvocation,
                a -> a.methodReference(),
                this::parseMethodReference);
    }

    JavaTree parsePrimary(PrimaryNoNewArray_lfno_primaryContext primaryElement)
    {
        return parsePrimary(primaryElement,
                PrimaryNoNewArray_lfno_primaryContext::literal,
                a -> a.typeName(),
                a -> a.classKeyword(),
                a -> a.dim(),
                a -> a.expression(),
                a -> a.classInstanceCreationExpression_lfno_primary(),
                this::parseClassInstanceCreationExpression,
                a -> a.fieldAccess_lfno_primary(),
                this::parseFieldAccess,
                a -> a.arrayAccess_lfno_primary(),
                this::parseArrayAccess,
                a -> a.methodInvocation_lfno_primary(),
                this::parseMethodInvocation,
                a -> a.methodReference_lfno_primary(),
                this::parseMethodReference);
    }

    <I> JavaTree parseFieldAccess(I fieldAccess,
            Function<I, PrimaryContext> extractPrimary,
            Function<I, SuperKeywordContext> extractSuperKeyword,
            Function<I, TypeNameContext> extractTypeName,
            Function<I, TerminalNode> extractIdentifier)
    {
        List<JavaTree> children = new ArrayList<>();

        if (extractPrimary.apply(fieldAccess) != null)
        {
            children.add(parsePrimary(extractPrimary.apply(fieldAccess)));
        } else if (extractTypeName.apply(fieldAccess) != null)
        {
            children.add(parseTypeName(extractTypeName.apply(fieldAccess)));
        }

        return new JavaTree(extractSuperKeyword.apply(fieldAccess) == null ? FIELD_ACCESS : SUPER_FIELD_ACCESS,
                extractIdentifier.apply(fieldAccess).toString(),
                children,
                isOriginal);
    }

    JavaTree parseFieldAccess(FieldAccessContext fieldAccess) {
        return parseFieldAccess(fieldAccess,
                a -> a.primary(),
                a -> a.superKeyword(),
                a -> a.typeName(),
                a -> a.Identifier());
    }

    private JavaTree parseFieldAccess(final FieldAccess_lf_primaryContext fieldAccess) {
        return parseFieldAccess(fieldAccess,
                a -> null,
                a -> null,
                a -> null,
                a -> a.Identifier());
    }

    private JavaTree parseFieldAccess(final FieldAccess_lfno_primaryContext fieldAccess) {
        return parseFieldAccess(fieldAccess,
                a -> null,
                a -> a.superKeyword(),
                a -> a.typeName(),
                a -> a.Identifier());
    }

    <I> JavaTree parseClassInstanceCreationExpression(
            I classInstanceCreationExpression,
            Function<I, ExpressionNameContext> extractExpressionName,
            Function<I, PrimaryContext> extractPrimary,
            Function<I, TypeArgumentsContext> extractTypeArguments,
            Function<I, List<AnnotatedQualifierElementContext>> extractAnnotatedQualifierElements,
            Function<I, TypeArgumentsOrDiamondContext> extractTypeArgumentsOrDiamond,
            Function<I, ArgumentListContext> extractArgumentList,
            Function<I, ClassBodyContext> extractClassBody
            ) {
        List<JavaTree> children = new ArrayList<>();
        if (extractExpressionName.apply(classInstanceCreationExpression) != null)
        {
            children.add(parseExpressionName(extractExpressionName.apply(classInstanceCreationExpression)));
        } else if (extractPrimary.apply(classInstanceCreationExpression) != null)
        {
            children.add(parsePrimary(extractPrimary.apply(classInstanceCreationExpression)));
        }

        if (extractTypeArguments.apply(classInstanceCreationExpression) != null)
        {
            children.add(parseTypeArguments(extractTypeArguments.apply(classInstanceCreationExpression)));
        }

        List<JavaTree> qualifierElements = new ArrayList<>();
        for (AnnotatedQualifierElementContext annotatedQualifierElement : extractAnnotatedQualifierElements.apply(classInstanceCreationExpression))
        {
            List<JavaTree> qualifierElementChildren = new ArrayList<>();
            qualifierElementChildren.addAll(parseAnnotations(annotatedQualifierElement.annotation()));
            qualifierElements.add(new JavaTree(QUALIFIER_ELEMENT, annotatedQualifierElement.Identifier().toString(), qualifierElementChildren, isOriginal));
        }
        children.add(getJavaTree(QUALIFIER, qualifierElements));

        if (extractTypeArgumentsOrDiamond.apply(classInstanceCreationExpression) != null)
        {
            children.add(parseTypeArgumentsOrDiamond(extractTypeArgumentsOrDiamond.apply(classInstanceCreationExpression)));
        }
        if (extractArgumentList.apply(classInstanceCreationExpression) != null)
        {
            children.add(parseArgumentList(extractArgumentList.apply(classInstanceCreationExpression)));
        }
        if (extractClassBody.apply(classInstanceCreationExpression) != null)
        {
            children.add(parseClassBody(extractClassBody.apply(classInstanceCreationExpression)));
        }
        return getJavaTree(CLASS_INSTANCE_CREATION_EXPRESSION, children);
    }

    JavaTree parseClassInstanceCreationExpression(ClassInstanceCreationExpressionContext classInstanceCreationExpression) {
        return parseClassInstanceCreationExpression(
                classInstanceCreationExpression,
                a -> a.expressionName(),
                a -> a.primary(),
                a -> a.typeArguments(),
                a -> a.annotatedQualifierElement(),
                a -> a.typeArgumentsOrDiamond(),
                a -> a.argumentList(),
                a -> a.classBody()
        );
    }

    private JavaTree parseTypeArgumentsOrDiamond(final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond) {
        if (typeArgumentsOrDiamond.typeArguments() != null)
        {
            return parseTypeArguments(typeArgumentsOrDiamond.typeArguments());
        } else
        {
            return getSymbol(TYPE_ARGUMENT_LIST);
        }
    }

    JavaTree parseClassInstanceCreationExpression(final ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression) {
        return parseClassInstanceCreationExpression(
                classInstanceCreationExpression,
                a -> null,
                a -> null,
                a -> a.typeArguments(),
                a -> Collections.singletonList(a.annotatedQualifierElement()),
                a -> a.typeArgumentsOrDiamond(),
                a -> a.argumentList(),
                a -> a.classBody()
        );
    }

    JavaTree parseClassInstanceCreationExpression(ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression) {
        return parseClassInstanceCreationExpression(
                classInstanceCreationExpression,
                a -> a.expressionName(),
                a -> null,
                a -> a.typeArguments(),
                a -> a.annotatedQualifierElement(),
                a -> a.typeArgumentsOrDiamond(),
                a -> a.argumentList(),
                a -> a.classBody()
        );
    }

    JavaTree parseLiteral(LiteralContext literal)
    {
        return new JavaTree(LITERAL, literal.getText(), Collections.emptyList(), isOriginal);
    }

    JavaTree parseCastExpression(CastExpressionContext castExpression){
        List<JavaTree> children = new ArrayList<>();
        if (castExpression.primitiveType() != null)
        {
            children.add(parsePrimitiveType(castExpression.primitiveType()));
            children.add(parseUnaryExpression(castExpression.unaryExpression()));
        }
        else
        {
            children.add(parseReferenceType(castExpression.referenceType()));
            for (AdditionalBoundContext additionalBound : castExpression.additionalBound())
            {
                children.add(parseClassType(additionalBound.interfaceType().classType()));
            }

            if (castExpression.unaryExpressionNotPlusMinus() != null)
            {
                children.add(parseUnaryExpression(castExpression.unaryExpressionNotPlusMinus()));
            } else
            {
                children.add(parseLambdaExpression(castExpression.lambdaExpression()));
            }
        }
        return new JavaTree(CAST_EXPRESSION, "", children, isOriginal);
    }

    private JavaTree parseLambdaExpression(final LambdaExpressionContext lambdaExpression) {
        LambdaParametersContext lambdaParameters = lambdaExpression.lambdaParameters();
        LambdaBodyContext lambdaBody = lambdaExpression.lambdaBody();
        List<JavaTree> children = new ArrayList<>();

        if (lambdaParameters.Identifier() != null)
        {

            children.add(getQualifier(lambdaParameters.Identifier()));
        } else if (lambdaParameters.formalParameterList() != null)
        {
            List<JavaTree> formalParametersChildren = new ArrayList<>();
            formalParametersChildren.addAll(parseFormalParameterList(lambdaParameters.formalParameterList()));
            children.add(getJavaTree(LAMBDA_EXPRESSION_FORMAL_PARAMETER_LIST, formalParametersChildren));
        } else if (lambdaParameters.inferredFormalParameterList() != null)
        {
            List<JavaTree> inferredChildren = lambdaParameters.inferredFormalParameterList().Identifier().stream().map(a -> getQualifier(a)).collect(Collectors.toList());
            children.add(getJavaTree(LAMBDA_EXPRESSION_INFERRED_FORMAL_PARAMETER_LIST, inferredChildren));
        }

        if (lambdaBody.expression() != null)
        {
            children.add(parseExpression(lambdaBody.expression()));
        } else
        {
            children.add(parseBlock(lambdaBody.block()));
        }

        return getJavaTree(LAMBDA_EXPRESSION, children);
    }

    private JavaTree parseBlock(final BlockContext block) {
        List<JavaTree> children = block
                .blockStatements()
                .blockStatement()
                .stream()
                .map(this::parseBlockStatement)
                .collect(Collectors.toList());
        return getJavaTree(BLOCK, children);
    }

    private JavaTree parseBlockStatement(final BlockStatementContext blockStatement) {
        if (blockStatement.localVariableDeclarationStatement() != null)
        {
            return parseLocalVariableStatement(blockStatement.localVariableDeclarationStatement().localVariableDeclaration());
        } else if (blockStatement.classDeclaration() != null)
        {
            return parseClassDeclaration(blockStatement.classDeclaration());
        } else {
            return parseStatement(blockStatement.statement());
        }
    }

    private <I, L, IT, ITE, W, F> JavaTree parseStatement(
            I statement,
            Function<I, StatementWithoutTrailingSubstatementContext> extractStatementWithout,
            Function<I, L> extractLabeled,
            Function<L, JavaTree> parseLabel,
            Function<I, IT> extractIfThen,
            Function<IT, JavaTree> parseIfThen,
            Function<I, ITE> extractIfThenElse,
            Function<ITE, JavaTree> parseIfThenElse,
            Function<I, W> extractWhile,
            Function<W, JavaTree> parseWhile,
            Function<I, F> extractFor,
            Function<F, JavaTree> parseFor)
    {
        if (extractStatementWithout.apply(statement) != null)
        {
            StatementWithoutTrailingSubstatementContext statementWithout = extractStatementWithout.apply(statement);
            if (statementWithout.block() != null)
            {
                return parseBlock(statementWithout.block());
            } else if (statementWithout.emptyStatement() != null)
            {
                return parseEmptyStatement(statementWithout.emptyStatement());
            } else if (statementWithout.expressionStatement() != null)
            {
                return parseExpressionStatement(statementWithout.expressionStatement());
            } else if (statementWithout.assertStatement() != null)
            {
                return parseAssertStatement(statementWithout.assertStatement());
            } else if (statementWithout.switchStatement() != null)
            {
                return parseSwitchStatement(statementWithout.switchStatement());
            } else if (statementWithout.doStatement() != null)
            {
                return parseDoStatement(statementWithout.doStatement());
            } else if (statementWithout.breakStatement() != null)
            {
                return parseBreakStatement(statementWithout.breakStatement());
            } else if (statementWithout.continueStatement() != null)
            {
                return parseContinueStatement(statementWithout.continueStatement());
            } else if (statementWithout.returnStatement() != null)
            {
                return parseReturnStatement(statementWithout.returnStatement());
            } else if (statementWithout.synchronizedStatement() != null)
            {
                return parseSynchronizedStatement(statementWithout.synchronizedStatement());
            } else if (statementWithout.throwStatement() != null)
            {
                return parseThrowStatement(statementWithout.throwStatement());
            } else
            {
                return parseTryStatement(statementWithout.tryStatement());
            }
        } else if (extractLabeled.apply(statement) != null)
        {
            return parseLabel.apply(extractLabeled.apply(statement));
        } else if (extractIfThen.apply(statement) != null)
        {
            return parseIfThen.apply(extractIfThen.apply(statement));
        } else if (extractIfThenElse.apply(statement) != null)
        {
            return parseIfThenElse.apply(extractIfThenElse.apply(statement));
        } else if (extractWhile.apply(statement) != null)
        {
            return parseWhile.apply(extractWhile.apply(statement));
        } else
        {
            return parseFor.apply(extractFor.apply(statement));
        }
    }

    private JavaTree parseStatement(StatementContext statement)
    {
        return parseStatement(
                statement,
                a -> a.statementWithoutTrailingSubstatement(),
                a -> a.labeledStatement(),
                l -> parseLabeledStatement(l),
                a -> a.ifThenStatement(),
                it -> parseIfThenStatement(it),
                a -> a.ifThenElseStatement(),
                ite -> parseIfThenElseStatement(ite),
                a -> a.whileStatement(),
                w -> parseWhileStatement(w),
                a -> a.forStatement(),
                f -> parseForStatement(f));
    }

    private JavaTree parseStatement(StatementNoShortIfContext statement)
    {
        return parseStatement(
                statement,
                a -> a.statementWithoutTrailingSubstatement(),
                a -> a.labeledStatementNoShortIf(),
                l -> parseLabeledStatement(l),
                a -> null,
                it -> null,
                a -> a.ifThenElseStatementNoShortIf(),
                ite -> parseIfThenElseStatement(ite),
                a -> a.whileStatementNoShortIf(),
                w -> parseWhileStatement(w),
                a -> a.forStatementNoShortIf(),
                f -> parseForStatement(f));
    }

    private <I, B, E, S> JavaTree parseForStatement(I forStatement,
            Function<I, B> extractBasicForStatement,
            Function<B, ForInitContext> extractForInit,
            Function<B, ExpressionContext> extractExpressionFromBasic,
            Function<B, ForUpdateContext> extractForUpdate,
            Function<B, S> extractStatement,
            Function<I, E> extractEnhancedForStatement,
            Function<E, List<VariableModifierContext>> extractVariableModifier,
            Function<E, UnannTypeContext> extractUnannType,
            Function<E, VariableDeclaratorIdContext> extractVariableDeclaratorId,
            Function<E, ExpressionContext> extractExpression,
            Function<E, S> extractStatementFromEnhanced,
            Function<S, JavaTree> parseStatement)
    {
        if (extractBasicForStatement.apply(forStatement) != null)
        {
            List<JavaTree> children = new ArrayList<>();
            B basicFor = extractBasicForStatement.apply(forStatement);
            if (extractForInit.apply(basicFor) != null)
            {
                List<JavaTree> forInitChildren = new ArrayList<>();
                ForInitContext forInit = extractForInit.apply(basicFor);
                if (forInit.statementExpressionList() != null)
                {
                    forInitChildren.addAll(parseStatementExpressionList(forInit.statementExpressionList()));
                } else {
                    forInitChildren.add(parseLocalVariableStatement(forInit.localVariableDeclaration()));
                }
                children.add(getJavaTree(FOR_INIT, forInitChildren));
            }
            if (extractExpressionFromBasic.apply(basicFor) != null)
            {
                children.add(parseExpression(extractExpressionFromBasic.apply(basicFor)));
            }
            if (extractForUpdate.apply(basicFor) != null)
            {
                ForUpdateContext forUpdate = extractForUpdate.apply(basicFor);
                children.add(getJavaTree(FOR_UPDATE, parseStatementExpressionList(forUpdate.statementExpressionList())));
            }
            children.add(parseStatement.apply(extractStatement.apply(basicFor)));
            return getJavaTree(BASIC_FOR_STATEMENT, children);
        } else {
            E enhancedFor = extractEnhancedForStatement.apply(forStatement);
            List<JavaTree> children = new ArrayList<>();
            children.add(parseVariableDeclarator(enhancedFor,
                    extractVariableModifier,
                    extractUnannType,
                    extractVariableDeclaratorId));
            children.add(parseExpression(extractExpression.apply(enhancedFor)));
            children.add(parseStatement.apply(extractStatementFromEnhanced.apply(enhancedFor)));
            return getJavaTree(ENHANCED_FOR_STATEMENT, children);
        }
    }

    private JavaTree parseForStatement(final ForStatementNoShortIfContext forStatement) {
        return parseForStatement(forStatement,
                a -> a.basicForStatementNoShortIf(),
                b -> b.forInit(),
                b -> b.expression(),
                b -> b.forUpdate(),
                b -> b.statementNoShortIf(),
                a -> a.enhancedForStatementNoShortIf(),
                e -> e.variableModifier(),
                e -> e.unannType(),
                e -> e.variableDeclaratorId(),
                e -> e.expression(),
                e -> e.statementNoShortIf(),
                this::parseStatement);
    }

    private JavaTree parseForStatement(final ForStatementContext forStatement) {
        return parseForStatement(forStatement,
                a -> a.basicForStatement(),
                b -> b.forInit(),
                b -> b.expression(),
                b -> b.forUpdate(),
                b -> b.statement(),
                a -> a.enhancedForStatement(),
                e -> e.variableModifier(),
                e -> e.unannType(),
                e -> e.variableDeclaratorId(),
                e -> e.expression(),
                e -> e.statement(),
                this::parseStatement);
    }

    <I> JavaTree parseVariableDeclarator(I variableDeclarator,
            Function<I, List<VariableModifierContext>> extractVariableModifier,
            Function<I, UnannTypeContext> extractUnannType,
            Function<I, VariableDeclaratorIdContext> extractVariableDeclaratorId)
    {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseVariableModifier(extractVariableModifier.apply(variableDeclarator)));
        children.add(parseUnannType(extractUnannType.apply(variableDeclarator)));
        children.addAll(getDims(extractVariableDeclaratorId.apply(variableDeclarator).dims()));
        return new JavaTree(VARIABLE_DECLARATION, extractVariableDeclaratorId.apply(variableDeclarator).Identifier().toString(), children, isOriginal);
    }

    private List<JavaTree> parseVariableModifier(List<VariableModifierContext> variableModifiers) {
        List<JavaTree> toReturn = new ArrayList<>();
        for (VariableModifierContext variableModifier : variableModifiers)
        {
            if (variableModifier.annotation() != null)
            {
                toReturn.add(parseAnnotation(variableModifier.annotation()));
            } else
            {
                toReturn.add(getSymbol(FINAL_MODIFIER_KEYWORD));
            }
        }
        return toReturn;
    }

    private List<JavaTree> parseStatementExpressionList(final StatementExpressionListContext statementExpressionList) {
        return statementExpressionList.statementExpression().stream().map(this::parseStatementExpression).collect(Collectors.toList());
    }

    private JavaTree parseStatementExpression(final StatementExpressionContext statementExpressionContext) {
        if (statementExpressionContext.assignment() != null)
        {
            return parseAssignment(statementExpressionContext.assignment());
        } else if (statementExpressionContext.preIncrementExpression() != null)
        {
            return parsePreIncrementExpression(statementExpressionContext.preIncrementExpression());
        } else if (statementExpressionContext.preDecrementExpression() != null)
        {
            return parsePreDecrementExpression(statementExpressionContext.preDecrementExpression());
        } else if (statementExpressionContext.postIncrementExpression() != null)
        {
            return parsePostIncrementExpression(statementExpressionContext.postIncrementExpression());
        } else if (statementExpressionContext.postDecrementExpression() != null)
        {
            return parsePostDecrementExpression(statementExpressionContext.postDecrementExpression());
        } else if (statementExpressionContext.methodInvocation() != null)
        {
            return parseMethodInvocation(statementExpressionContext.methodInvocation());
        } else
        {
            return parseClassInstanceCreationExpression(statementExpressionContext.classInstanceCreationExpression());
        }
    }

    private JavaTree parsePostDecrementExpression(final PostDecrementExpressionContext postDecrementExpression) {
        return getJavaTree(UNARY_EXPRESSION, Arrays.asList(
                parsePostfixExpression(postDecrementExpression.postfixExpression()),
                getSymbol(DECREMENT_SYMBOL)
        ));
    }

    private JavaTree parsePostIncrementExpression(final PostIncrementExpressionContext postIncrementExpression) {
        return getJavaTree(UNARY_EXPRESSION, Arrays.asList(
                parsePostfixExpression(postIncrementExpression.postfixExpression()),
                getSymbol(INCREMENT_SYMBOL)
        ));
    }

    private JavaTree parsePreDecrementExpression(final PreDecrementExpressionContext preDecrementExpression) {
        return getJavaTree(UNARY_EXPRESSION, Arrays.asList(
                getSymbol(DECREMENT_SYMBOL),
                parseUnaryExpression(preDecrementExpression.unaryExpression())
        ));
    }

    private JavaTree parsePreIncrementExpression(final PreIncrementExpressionContext preIncrementExpression) {
        return getJavaTree(UNARY_EXPRESSION, Arrays.asList(
                getSymbol(INCREMENT_SYMBOL),
                parseUnaryExpression(preIncrementExpression.unaryExpression())
        ));
    }

    private JavaTree parseAssignment(final AssignmentContext assignment) {
        List<JavaTree> children = new ArrayList<>();
        LeftHandSideContext leftHandSide = assignment.leftHandSide();
        if (leftHandSide.expressionName() != null)
        {
            children.add(parseExpressionName(leftHandSide.expressionName()));
        } else if (leftHandSide.fieldAccess() != null)
        {
            children.add(parseFieldAccess(leftHandSide.fieldAccess()));
        } else
        {
            children.add(parseArrayAccess(leftHandSide.arrayAccess()));
        }

        JavaNode assignmentNode;
        switch (assignment.assignmentOperator().toString())
        {
            	case "=":
            	    assignmentNode = ASSIGNMENT;
                case "*=":
                    assignmentNode = MULTIPLY_ASSIGNMENT_EQUALS;
                case "/=":
                    assignmentNode = DIVIDE_ASSIGNMENT_EQUALS;
                case "%=":
                    assignmentNode = MOD_ASSIGNMENT_EQUALS;
                case "+=":
                    assignmentNode = PLUS_ASSIGNMENT_EQUALS;
                case "-=":
                    assignmentNode = MINUS_ASSIGNMENT_EQUALS;
                case "<<=":
                    assignmentNode = SHIFT_LEFT_LOGICAL_SYMBOL;
                case ">>=":
                    assignmentNode = SHIFT_RIGHT_LOGICAL_SYMBOL;
                case ">>>=":
                    assignmentNode = SHIFT_RIGHT_ARITMATIC_SYMBOL;
                case "&=":
                    assignmentNode = AND_ASSIGNMENT_EQUALS;
                case "^=":
                    assignmentNode = NOT_ASSIGNMENT_EQUALS;
                default:
                case "|=":
                    assignmentNode = OR_ASSIGNMENT_EQUALS;
        }
        children.add(getSymbol(assignmentNode));

        children.add(parseExpression(assignment.expression()));
        
        return getJavaTree(ASSIGNMENT, children);
    }

    private <I, S> JavaTree parseWhileStatement(I whileStatement,
            Function<I, ExpressionContext> extractExpression,
            Function<I, S> extractStatement,
            Function<S, JavaTree> parseStatement)
    {
        return getJavaTree(WHILE_STATEMENT, Arrays.asList(parseExpression(extractExpression.apply(whileStatement)), parseStatement.apply(extractStatement.apply(whileStatement))));
    }

    private JavaTree parseWhileStatement(final WhileStatementNoShortIfContext w) {
        return parseWhileStatement(w,
                a -> a.expression(),
                a -> a.statementNoShortIf(),
                s -> parseStatement(s));
    }

    private JavaTree parseWhileStatement(final WhileStatementContext w) {
        return parseWhileStatement(w,
                a -> a.expression(),
                a -> a.statement(),
                s -> parseStatement(s));
    }

    private <I, SA, SB> JavaTree parseIfThenElseStatement(
            I ifThenElseStatement,
            Function<I, ExpressionContext> extractExpression,
            Function<I, SA> extractStatementA,
            Function<SA, JavaTree> parseStatementA,
            Function<I, SB> extractStatementB,
            Function<SB, JavaTree> parseStatementB)
    {
        List<JavaTree> children = new ArrayList<>();
        children.add(parseExpression(extractExpression.apply(ifThenElseStatement)));
        children.add(parseStatementA.apply(extractStatementA.apply(ifThenElseStatement)));
        children.add(parseStatementB.apply(extractStatementB.apply(ifThenElseStatement)));
        return getJavaTree(IF_STATEMENT, children);
    }

    private JavaTree parseIfThenElseStatement(final IfThenElseStatementNoShortIfContext ite) {
        return parseIfThenElseStatement(ite,
                a -> a.expression(),
                a -> a.statementNoShortIf().get(0),
                sa -> parseStatement(sa),
                a -> a.statementNoShortIf().get(1),
                sb -> parseStatement(sb));
    }

    private JavaTree parseIfThenElseStatement(final IfThenElseStatementContext ite) {
        return parseIfThenElseStatement(ite,
                a -> a.expression(),
                a -> a.statementNoShortIf(),
                sa -> parseStatement(sa),
                a -> a.statement(),
                sb -> parseStatement(sb));
    }

    <I, S> JavaTree parseLabeledStatement(
            I labeledStatement,
            Function<I, TerminalNode> extractIdentifer,
            Function<I, S> extractStatement,
            Function<S, JavaTree> parseStatement) {
        return new JavaTree(LABELED_STATEMENT, extractIdentifer.apply(labeledStatement).toString(), Collections.singletonList(parseStatement.apply(extractStatement.apply(labeledStatement))), isOriginal);
    }

    private JavaTree parseLabeledStatement(final LabeledStatementNoShortIfContext l) {
        return parseLabeledStatement(
                l,
                a -> a.Identifier(),
                a -> a.statementNoShortIf(),
                s -> parseStatement(s));
    }

    private JavaTree parseLabeledStatement(final LabeledStatementContext l) {
        return parseLabeledStatement(
                l,
                a -> a.Identifier(),
                a -> a.statement(),
                s -> parseStatement(s));
    }

    private JavaTree parseIfThenStatement(final IfThenStatementContext it) {
        List<JavaTree> children = new ArrayList<>();
        children.add(parseExpression(it.expression()));
        children.add(parseStatement(it.statement()));
        return getJavaTree(IF_STATEMENT, children);
    }

    private JavaTree parseTryStatement(final TryStatementContext tryStatement) {
        BlockContext block;
        CatchesContext catches;
        Finally_Context finally_;
        List<JavaTree> children = new ArrayList<>();
        if (tryStatement.tryWithResourcesStatement() != null)
        {
            block = tryStatement.tryWithResourcesStatement().block();
            catches = tryStatement.tryWithResourcesStatement().catches();
            finally_ = tryStatement.tryWithResourcesStatement().finally_();

            for (ResourceContext resource : tryStatement.tryWithResourcesStatement().resourceSpecification().resourceList().resource())
            {
                List<JavaTree> resourceChildren = new ArrayList<>();
                resourceChildren.addAll(parseVariableModifier(resource.variableModifier()));
                resourceChildren.add(parseUnannType(resource.unannType()));
                resourceChildren.addAll(getDims(resource.variableDeclaratorId().dims()));
                resourceChildren.add(parseExpression(resource.expression()));
                children.add(new JavaTree(TRY_STATEMENT_RESOURCE, resource.variableDeclaratorId().Identifier().toString(), resourceChildren, isOriginal));
            }
        } else {
            block = tryStatement.block();
            catches = tryStatement.catches();
            finally_ = tryStatement.finally_();
        }

        children.add(parseBlock(block));
        if (catches != null)
        {
            for (CatchClauseContext catchClause : catches.catchClause())
            {
                List<JavaTree> catchChildren = new ArrayList<>();
                catchChildren.addAll(parseVariableModifier(catchClause.catchFormalParameter().variableModifier()));
                catchChildren.add(parseUnannClassType(catchClause.catchFormalParameter().catchType().unannClassType()));
                catchChildren.addAll(catchClause.catchFormalParameter().catchType().classType().stream().map(a -> parseClassType(a)).collect(Collectors.toList()));
                catchChildren.addAll(getDims(catchClause.catchFormalParameter().variableDeclaratorId().dims()));
                catchChildren.add(parseBlock(catchClause.block()));
                children.add(new JavaTree(TRY_STATEMENT_CATCH, catchClause.catchFormalParameter().variableDeclaratorId().Identifier().toString(), catchChildren, isOriginal));
            }
        }

        if (finally_ != null)
        {
            return getJavaTree(TRY_STATEMENT_FINALLY, Collections.singletonList(parseBlock(finally_.block())));
        }

        return getJavaTree(TRY_STATEMENT, children);
    }



    private JavaTree parseThrowStatement(final ThrowStatementContext throwStatement) {
        return getJavaTree(THROW_STATEMENT, Collections.singletonList(parseExpression(throwStatement.expression())));
    }

    private JavaTree parseSynchronizedStatement(final SynchronizedStatementContext synchronizedStatement) {
        return getJavaTree(SYNCHRONIZED_STATEMENT, Arrays.asList(
                parseExpression(synchronizedStatement.expression()),
                parseBlock(synchronizedStatement.block())));

    }

    private JavaTree parseReturnStatement(final ReturnStatementContext returnStatement) {
        if (returnStatement.expression() != null)
        {
            return getJavaTree(RETURN_STATEMENT, Arrays.asList(
                    parseExpression(returnStatement.expression())));
        } else {
            return getJavaTree(RETURN_STATEMENT, Collections.emptyList());
        }
    }

    private JavaTree parseContinueStatement(final ContinueStatementContext continueStatement) {
        List<JavaTree> children = new ArrayList<>();
        if (continueStatement.Identifier() != null)
        {
            children.add(getQualifier(continueStatement.Identifier()));
        }
        return getJavaTree(CONTINUE_STATEMENT, children);
    }

    private JavaTree parseBreakStatement(final BreakStatementContext breakStatement) {
        List<JavaTree> children = new ArrayList<>();
        if (breakStatement.Identifier() != null)
        {
            children.add(getQualifier(breakStatement.Identifier()));
        }
        return getJavaTree(BREAK_STATEMENT, children);
    }

    private JavaTree parseDoStatement(final DoStatementContext doStatement) {
        List<JavaTree> children = new ArrayList<>();
        if (doStatement.statement() != null)
        {
            children.add(parseStatement(doStatement.statement()));
        }
        if (doStatement.expression() != null)
        {
            children.add(parseExpression(doStatement.expression()));
        }
        return getJavaTree(DO_STATEMENT, children);
    }

    private JavaTree parseSwitchStatement(final SwitchStatementContext switchStatement) {
        List<JavaTree> children = new ArrayList<>();
        if (switchStatement.expression() != null)
        {
            children.add(parseExpression(switchStatement.expression()));
        }

        for (SwitchBlockStatementGroupContext blockGroup : switchStatement.switchBlock().switchBlockStatementGroup())
        {
            List<JavaTree> groupChildren = new ArrayList<>();
            for (SwitchLabelContext switchLabel : blockGroup.switchLabels().switchLabel())
            {
                groupChildren.add(parseSwitchLabel(switchLabel));
            }
            if (blockGroup.blockStatements() != null)
            {
                groupChildren.add(parseBlockStatements(blockGroup.blockStatements()));
            }
            children.add(getJavaTree(SWITCH_GROUP, groupChildren));
        }

        if (switchStatement.switchBlock().switchLabel() != null)
        {
            List<JavaTree> groupChildren = new ArrayList<>();
            groupChildren.addAll(switchStatement.switchBlock().switchLabel().stream().map(a -> parseSwitchLabel(a)).collect(Collectors.toList()));
            children.add(getJavaTree(SWITCH_GROUP, groupChildren));
        }

        return getJavaTree(SWITCH_STATEMENT, children);
    }

    JavaTree parseBlockStatements(BlockStatementsContext blockStatements) {
        return getJavaTree(BLOCK, blockStatements.blockStatement().stream().map(a -> parseBlockStatement(a)).collect(Collectors.toList()));
    }

    List<JavaTree> parseBlockStatements(List<BlockStatementContext> blockStatements)
    {
        return blockStatements.stream().map(a -> parseBlockStatement(a)).collect(Collectors.toList());
    }

    JavaTree parseSwitchLabel(SwitchLabelContext switchLabel)
    {
        if (switchLabel.constantExpression() != null)
        {
             return parseExpression(switchLabel.constantExpression().expression());
        } else if (switchLabel.enumConstantName() != null)
        {
            return getQualifier(switchLabel.enumConstantName().Identifier());
        } else {
            return getSymbol(DEFAULT_KEYWORD);
        }
    }

    private JavaTree parseAssertStatement(final AssertStatementContext assertStatement) {
        return getJavaTree(ASSERT_STATEMENT, assertStatement.expression().stream().map(a -> parseExpression(a)).collect(Collectors.toList()));
    }

    private JavaTree parseExpressionStatement(final ExpressionStatementContext expressionStatement) {
        return parseStatementExpression(expressionStatement.statementExpression());
    }

    private JavaTree parseEmptyStatement(final EmptyStatementContext emptyStatement) {
        return getSymbol(EMPTY_STATEMENT);
    }

    private JavaTree parseClassDeclaration(final ClassDeclarationContext classDeclaration) {
        if (classDeclaration.normalClassDeclaration() != null)
        {
            return parseNormalClassDeclaration(classDeclaration.normalClassDeclaration());
        }
        else {
            return parseEnumDeclaration(classDeclaration.enumDeclaration());
        }
    }

    private JavaTree parseEnumDeclaration(final EnumDeclarationContext enumDeclaration) {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseClassModifier(enumDeclaration.classModifier()));
        children.addAll(parseSuperinterfaces(enumDeclaration.superinterfaces()));
        List<JavaTree> enumBodyChildren = new ArrayList<>();
        for (EnumConstantContext enumConstant : enumDeclaration.enumBody().enumConstantList().enumConstant())
        {
            List<JavaTree> enumConstantChildren = new ArrayList<>();
            enumConstantChildren.addAll(parseAnnotations(enumConstant.enumConstantModifier().stream().map(a -> a.annotation()).collect(Collectors.toList())));
            if (enumConstant.argumentList() != null)
            {
                enumConstantChildren.add(parseArgumentList(enumConstant.argumentList()));
            }
            if (enumConstant.classBody() != null)
            {
                enumConstantChildren.add(parseClassBody(enumConstant.classBody()));
            }
            enumBodyChildren.add(new JavaTree(ENUM_CONSTANT, enumConstant.Identifier().toString(), enumConstantChildren, isOriginal));
        }
        enumBodyChildren.add(parseClassBodyDeclaration(enumDeclaration.enumBody().enumBodyDeclarations().classBodyDeclaration()));
        children.add(getJavaTree(ENUM_BODY, enumBodyChildren));
        return getJavaTree(ENUM_DECLARATION, children);
    }

    private JavaTree parseNormalClassDeclaration(final NormalClassDeclarationContext normalClassDeclaration) {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseClassModifier(normalClassDeclaration.classModifier()));
        if (normalClassDeclaration.typeParameters() != null)
        {
            children.add(parseTypeParameters(normalClassDeclaration.typeParameters()));
        }
        if (normalClassDeclaration.superclass() != null)
        {
            children.add(parseSuperclass(normalClassDeclaration.superclass()));
        }
        if (normalClassDeclaration.superinterfaces() != null)
        {
            children.addAll(parseSuperinterfaces(normalClassDeclaration.superinterfaces()));
        }
        if (normalClassDeclaration.classBody() != null)
        {
            children.add(parseClassBody(normalClassDeclaration.classBody()));
        }
        return new JavaTree(CLASS_DECLARATION, normalClassDeclaration.Identifier().toString(), children, isOriginal);
    }

    private JavaTree parseInterfaceDeclaration(final InterfaceDeclarationContext interfaceDeclaration) {
        if (interfaceDeclaration.annotationTypeDeclaration() != null)
        {
            return parseAnnotationTypeDeclaration(interfaceDeclaration.annotationTypeDeclaration());
        } else {
            NormalInterfaceDeclarationContext normal = interfaceDeclaration.normalInterfaceDeclaration();
            List<JavaTree> children = new ArrayList<>();
            children.addAll(parseInterfaceModifier(normal.interfaceModifier()));
            if (normal.typeParameters() != null)
            {
                children.add(parseTypeParameters(normal.typeParameters()));
            }
            if (normal.extendsInterfaces() != null)
            {
                children.addAll(parseExtendsInterfaces(normal.extendsInterfaces()));
            }
            if (normal.interfaceBody() != null)
            {
                children.add(parseInterfaceBody(normal.interfaceBody()));
            }
            return new JavaTree(INTERFACE_DECLARATION, normal.Identifier().toString(), children, isOriginal);
        }
    }

    private JavaTree parseInterfaceBody(final InterfaceBodyContext interfaceBody) {
        List<JavaTree> children = new ArrayList<>();
        for (InterfaceMemberDeclarationContext interfaceMemberDeclaration : interfaceBody.interfaceMemberDeclaration())
        {
            if (interfaceMemberDeclaration.constantDeclaration() != null)
            {
                children.add(parseConstantDeclaration(interfaceMemberDeclaration.constantDeclaration()));
            } else if (interfaceMemberDeclaration.interfaceMethodDeclaration() != null)
            {
                children.add(parseInterfaceMethodDeclaration(interfaceMemberDeclaration.interfaceMethodDeclaration()));
            } else if (interfaceMemberDeclaration.classDeclaration() != null)
            {
                children.add(parseClassDeclaration(interfaceMemberDeclaration.classDeclaration()));
            } else if (interfaceMemberDeclaration.interfaceDeclaration() != null)
            {
                children.add(parseInterfaceDeclaration(interfaceMemberDeclaration.interfaceDeclaration()));
            } else {
                children.add(getSymbol(EMPTY_STATEMENT));
            }
        }
        return getJavaTree(TYPE_BODY, children);
    }

    private JavaTree parseConstantDeclaration(final ConstantDeclarationContext constantDeclaration) {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseConstantModifier(constantDeclaration.constantModifier()));
        children.add(parseUnannType(constantDeclaration.unannType()));
        children.addAll(parseVariableDeclaratorList(constantDeclaration.variableDeclaratorList()));
        return getJavaTree(VARIABLE_DECLARATION, children);
    }

    private List<JavaTree> parseVariableDeclaratorList(final VariableDeclaratorListContext variableDeclaratorList) {
        List<JavaTree> children = new ArrayList<>();
        for (VariableDeclaratorContext variableDeclarator : variableDeclaratorList.variableDeclarator())
        {
            List<JavaTree> variableDeclaratorChildren = new ArrayList<>();
            variableDeclaratorChildren.addAll(getDims(variableDeclarator.variableDeclaratorId().dims()));
            if (variableDeclarator.variableInitializer() != null)
            {
                VariableInitializerContext variableInitializer = variableDeclarator.variableInitializer();
                if (variableInitializer.expression() != null)
                {
                    variableDeclaratorChildren.add(parseExpression(variableInitializer.expression()));
                } else {
                    variableDeclaratorChildren.add(parseArrayInitializer(variableInitializer.arrayInitializer()));
                }
            }
            children.add(new JavaTree(VARIABLE_DECLARATOR, variableDeclarator.variableDeclaratorId().Identifier().toString(), variableDeclaratorChildren, isOriginal));
        }
        return children;
    }

    private Collection<? extends JavaTree> parseConstantModifier(final List<ConstantModifierContext> constantModifier) {
        return constantModifier
                .stream().map(a -> parseModifier(a, ConstantModifierContext::annotation, ConstantModifierContext::getText)).collect(Collectors.toList());
    }

    private <I, M> JavaTree parseMethodDeclaration(I input,
            Function<I, List<M>> extractModifiers,
            Function<List<M>, List<JavaTree>> parseModifier,
            Function<I, MethodHeaderContext> extractMethodHeader,
            Function<I, MethodBodyContext> extractMethodBody)
    {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseModifier.apply(extractModifiers.apply(input)));
        MethodHeaderContext methodHeader = extractMethodHeader.apply(input);
        if (methodHeader.typeParameters() != null)
        {
            children.add(parseTypeParameters(methodHeader.typeParameters()));
        }
        if (methodHeader.annotation() != null)
        {
            children.addAll(parseAnnotations(methodHeader.annotation()));
        }
        if (methodHeader.result() != null)
        {
            ResultContext result = methodHeader.result();
            if (result.unannType() != null)
            {
                children.add(parseUnannType(result.unannType()));
            } else
            {
                children.add(getSymbol(VOID_MODIFIER_KEYWORD));
            }
        }
        MethodDeclaratorContext methodDeclarator = methodHeader.methodDeclarator();
        if (methodDeclarator.formalParameterList() != null)
        {
            children.addAll(parseFormalParameterList(methodDeclarator.formalParameterList()));
        }
        if (methodDeclarator.dims() != null)
        {
            children.addAll(getDims(methodDeclarator.dims()));
        }
        if (methodHeader.throws_() != null)
        {
            children.addAll(parseThrows_(methodHeader.throws_()));
        }

        if (extractMethodBody.apply(input) != null)
        {
            children.add(parseBlock(extractMethodBody.apply(input).block()));
        }
        return new JavaTree(METHOD_DECLARATION, extractMethodHeader.apply(input).methodDeclarator().Identifier().toString(), children, isOriginal);
    }

    private JavaTree parseMethodDeclaration(final MethodDeclarationContext methodDeclaration) {
        return parseMethodDeclaration(
                methodDeclaration,
                a -> a.methodModifier(),
                m -> parseMethodModifier(m),
                a -> a.methodHeader(),
                a -> a.methodBody());
    }

    private List<JavaTree> parseMethodModifier(final List<MethodModifierContext> m) {
        return m.stream().map(a -> parseModifier(a, MethodModifierContext::annotation, MethodModifierContext::getText)).collect(Collectors.toList());
    }

    private JavaTree parseInterfaceMethodDeclaration(final InterfaceMethodDeclarationContext interfaceMethodDeclaration) {
        return parseMethodDeclaration(interfaceMethodDeclaration,
                a -> a.interfaceMethodModifier(),
                m -> parseInterfaceMethodModifier(m),
                a -> a.methodHeader(),
                a -> a.methodBody());
    }

    private List<JavaTree> parseInterfaceMethodModifier(final List<InterfaceMethodModifierContext> interfaceMethodModifier) {
        return interfaceMethodModifier.stream().map(a -> parseModifier(a, InterfaceMethodModifierContext::annotation, InterfaceMethodModifierContext::getText)).collect(Collectors.toList());
    }

    private List<JavaTree> parseExtendsInterfaces(final ExtendsInterfacesContext extendsInterfaces) {
        List<JavaTree> toReturn = new ArrayList<>();
        for (InterfaceTypeContext interfaceTypeContext : extendsInterfaces.interfaceTypeList().interfaceType())
        {
            toReturn.add(getJavaTree(EXTENDS_INTERFACE, Collections.singletonList(parseClassType(interfaceTypeContext.classType()))));
        }
        return toReturn;
    }

    private Collection<? extends JavaTree> parseInterfaceModifier(final List<InterfaceModifierContext> interfaceModifier) {
        return interfaceModifier.stream().map(a -> parseModifier(a, InterfaceModifierContext::annotation, InterfaceModifierContext::getText)).collect(Collectors.toList());
    }

    private JavaTree parseAnnotationTypeDeclaration(final AnnotationTypeDeclarationContext annotationTypeDeclaration) {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseInterfaceModifier(annotationTypeDeclaration.interfaceModifier()));
        children.add(parseAnnotationTypeBody(annotationTypeDeclaration.annotationTypeBody()));
        return new JavaTree(ANNOTATION_DECLARATION, annotationTypeDeclaration.Identifier().toString(), children, isOriginal);
    }

    private JavaTree parseAnnotationTypeBody(final AnnotationTypeBodyContext annotationTypeBody) {
        List<JavaTree> children = new ArrayList<>();
        for (AnnotationTypeMemberDeclarationContext annotationType : annotationTypeBody.annotationTypeMemberDeclaration())
        {
            if (annotationType.annotationTypeElementDeclaration() != null)
            {
                children.add(parseAnnotationTypeElementDeclaration(annotationType.annotationTypeElementDeclaration()));
            } else if (annotationType.constantDeclaration() != null)
            {
                children.add(parseConstantDeclaration(annotationType.constantDeclaration()));
            } else if (annotationType.classDeclaration() != null)
            {
                children.add(parseClassDeclaration(annotationType.classDeclaration()));
            } else if (annotationType.interfaceDeclaration() != null)
            {
                children.add(parseInterfaceDeclaration(annotationType.interfaceDeclaration()));
            } else {
                children.add(getSymbol(EMPTY_STATEMENT));
            }
        }
        return getJavaTree(BLOCK, children);
    }

    private JavaTree parseAnnotationTypeElementDeclaration(final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration) {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseAnnotationTypeElementModifier(annotationTypeElementDeclaration.annotationTypeElementModifier()));
        children.add(parseUnannType(annotationTypeElementDeclaration.unannType()));
        if (annotationTypeElementDeclaration.dims() != null)
        {
            children.addAll(getDims(annotationTypeElementDeclaration.dims()));
        }
        children.add(parseElementValue(annotationTypeElementDeclaration.defaultValue().elementValue()));
        return new JavaTree(ANNOTATION_TYPE_ELEMENT_DECLARATION, annotationTypeElementDeclaration.Identifier().toString(), children, isOriginal);
    }

    private Collection<? extends JavaTree> parseAnnotationTypeElementModifier(final List<AnnotationTypeElementModifierContext> annotationTypeElementModifier) {
        return annotationTypeElementModifier.stream().map(a -> parseModifier(a, AnnotationTypeElementModifierContext::annotation, AnnotationTypeElementModifierContext::getText)).collect(Collectors.toList());
    }

    private JavaTree parseElementValue(final ElementValueContext elementValue) {
        if (elementValue.conditionalExpression() != null)
        {
            return parseConditionalExpression(elementValue.conditionalExpression());
        } else if (elementValue.elementValueArrayInitializer() != null)
        {
            return parseElementValueArrayInitializer(elementValue.elementValueArrayInitializer());
        } else {
            return parseAnnotation(elementValue.annotation());
        }
    }

    private JavaTree parseElementValueArrayInitializer(final ElementValueArrayInitializerContext elementValueArrayInitializer) {
        List<JavaTree> children = new ArrayList<>();
        for (ElementValueContext elementValue : elementValueArrayInitializer.elementValueList().elementValue())
        {
            children.add(parseElementValue(elementValue));
        }
        return getJavaTree(ELEMENT_ARRAY, children);
    }

    JavaTree parseClassBodyDeclaration(List<ClassBodyDeclarationContext> contexts)
    {
        List<JavaTree> children = new ArrayList<>();
        for (ClassBodyDeclarationContext classBodyDeclaration : contexts)
        {
            if (classBodyDeclaration.classMemberDeclaration() != null)
            {
                ClassMemberDeclarationContext classMemberDeclaration = classBodyDeclaration.classMemberDeclaration();
                if (classMemberDeclaration.fieldDeclaration() != null)
                {
                    children.add(parseFieldDeclaration(classMemberDeclaration.fieldDeclaration()));
                } else if (classMemberDeclaration.methodDeclaration() != null)
                {
                    children.add(parseMethodDeclaration(classMemberDeclaration.methodDeclaration()));
                } else if (classMemberDeclaration.classDeclaration() != null)
                {
                    children.add(parseClassDeclaration(classMemberDeclaration.classDeclaration()));
                } else if (classMemberDeclaration.interfaceDeclaration() != null)
                {
                    children.add(parseInterfaceDeclaration(classMemberDeclaration.interfaceDeclaration()));
                } else {
                    children.add(getSymbol(EMPTY_STATEMENT));
                }
            } else if (classBodyDeclaration.instanceInitializer() != null)
            {
                children.add(parseInstanceInitializer(classBodyDeclaration.instanceInitializer()));
            } else if (classBodyDeclaration.staticInitializer() != null)
            {
                children.add(parseStaticInitializer(classBodyDeclaration.staticInitializer()));
            } else
            {
                children.add(parseConstructorDeclaration(classBodyDeclaration.constructorDeclaration()));
            }
        }
        return getJavaTree(TYPE_BODY, children);
    }

    private JavaTree parseClassBody(final ClassBodyContext classBody) {
        return parseClassBodyDeclaration(classBody.classBodyDeclaration());
    }

    private JavaTree parseConstructorDeclaration(final ConstructorDeclarationContext constructorDeclaration) {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseConstructorModifier(constructorDeclaration.constructorModifier()));
        ConstructorDeclaratorContext constructorDeclarator = constructorDeclaration.constructorDeclarator();
        if (constructorDeclarator.typeParameters() != null)
        {
            children.add(parseTypeParameters(constructorDeclarator.typeParameters()));
        }
        if (constructorDeclarator.formalParameterList() != null)
        {
            children.addAll(parseFormalParameterList(constructorDeclarator.formalParameterList()));
        }
        if (constructorDeclaration.throws_() != null)
        {
            children.addAll(parseThrows_(constructorDeclaration.throws_()));
        }
        if (constructorDeclaration.constructorBody() != null)
        {
            children.add(parseConstructorBody(constructorDeclaration.constructorBody()));
        }
        return new JavaTree(METHOD_DECLARATION, constructorDeclarator.simpleTypeName().Identifier().toString(), children, isOriginal);
    }

    private JavaTree parseConstructorBody(final ConstructorBodyContext constructorBody) {
        List<JavaTree> children = new ArrayList<>();
        if (constructorBody.explicitConstructorInvocation() != null)
        {
            ExplicitConstructorInvocationContext explicitConstructorInvocation = constructorBody.explicitConstructorInvocation();
            List<JavaTree> explicitChildren = new ArrayList<>();
            if (explicitConstructorInvocation.expressionName() != null)
            {
                children.add(parseExpressionName(explicitConstructorInvocation.expressionName()));
            } else if (explicitConstructorInvocation.primary() != null)
            {
                children.add(parsePrimary(explicitConstructorInvocation.primary()));
            }

            children.add(parseTypeArguments(explicitConstructorInvocation.typeArguments()));
            children.add(parseArgumentList(explicitConstructorInvocation.argumentList()));
            children.add(getJavaTree(explicitConstructorInvocation.superKeyword() == null ? THIS_EXPLICIT_CONSTRUCTOR_INVOCATION : SUPER_EXPLICIT_CONSTRUCTOR_INVOCATION, explicitChildren));
        }
        children.addAll(parseBlockStatements(constructorBody.blockStatements().blockStatement()));
        return getJavaTree(BLOCK, children);
    }

    private List<JavaTree> parseConstructorModifier(final List<ConstructorModifierContext> constructorModifier) {
        return constructorModifier.stream().map(a -> parseModifier(a, b -> a.annotation(), b -> a.getText())).collect(Collectors.toList());
    }

    private List<JavaTree> parseThrows_(final Throws_Context throws_) {
        List<JavaTree> toReturn = new ArrayList<>();
        for (ExceptionTypeContext exceptionType : throws_.exceptionTypeList().exceptionType())
        {
            JavaTree type;
            if (exceptionType.classType() != null)
            {
                type = parseClassType(exceptionType.classType());
            } else {
                type = parseTypeVariable(exceptionType.typeVariable());
            }
            toReturn.add(getJavaTree(THROWS_EXCEPTION, Collections.singletonList(type)));
        }
        return toReturn;
    }

    private JavaTree parseStaticInitializer(final StaticInitializerContext staticInitializer) {
        List<JavaTree> children = new ArrayList<>();
        children.add(getSymbol(STATIC_MODIFIER_KEYWORD));
        children.add(parseBlock(staticInitializer.block()));
        return getJavaTree(INITIALIZER, children);
    }

    private JavaTree parseInstanceInitializer(final InstanceInitializerContext instanceInitializer) {
        List<JavaTree> children = new ArrayList<>();
        children.add(parseBlock(instanceInitializer.block()));
        return getJavaTree(INITIALIZER, children);
    }



    private JavaTree parseFieldDeclaration(final FieldDeclarationContext fieldDeclaration) {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseFieldModifier(fieldDeclaration.fieldModifier()));
        children.add(parseUnannType(fieldDeclaration.unannType()));
        children.addAll(parseVariableDeclaratorList(fieldDeclaration.variableDeclaratorList()));
        return getJavaTree(VARIABLE_DECLARATION, children);
    }

    private List<JavaTree> parseFieldModifier(final List<FieldModifierContext> fieldModifier) {
        return fieldModifier
                .stream().map(a -> parseModifier(a, FieldModifierContext::annotation, FieldModifierContext::getText)).collect(Collectors.toList());
    }

    private List<JavaTree> parseSuperinterfaces(final SuperinterfacesContext superinterfaces) {
        List<JavaTree> toReturn = new ArrayList<>();
        for (InterfaceTypeContext interfaceTypeContext : superinterfaces.interfaceTypeList().interfaceType())
        {
            toReturn.add(getJavaTree(IMPLEMENTS_INTERFACE, Collections.singletonList(parseClassType(interfaceTypeContext.classType()))));
        }
        return toReturn;
    }

    private JavaTree parseSuperclass(final SuperclassContext superclass) {
        return getJavaTree(EXTENDS_CLASS, Collections.singletonList(parseClassType(superclass.classType())));
    }

    private JavaTree parseTypeParameters(final TypeParametersContext typeParameters) {
        List<JavaTree> children = new ArrayList<>();
        for (TypeParameterContext typeParameterContext : typeParameters.typeParameterList().typeParameter())
        {
            children.add(parseTypeParameter(typeParameterContext));
        }
        return getJavaTree(TYPE_PARAMETER_LIST, children);
    }

    private JavaTree parseTypeParameter(final TypeParameterContext typeParameterContext) {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(typeParameterContext.typeParameterModifier().stream().map(a -> parseModifier(a, TypeParameterModifierContext::annotation, TypeParameterModifierContext::getText)).collect(
                Collectors.toList()));
        if (typeParameterContext.typeBound() != null)
        {
            TypeBoundContext typeBound = typeParameterContext.typeBound();
            if (typeBound.typeVariable() != null)
            {
                children.add(parseTypeVariable(typeBound.typeVariable()));
            } else {
                children.add(parseClassOrInterfaceType(typeBound.classOrInterfaceType()));
                children.addAll(typeBound.additionalBound().stream().map(AdditionalBoundContext::interfaceType).map(InterfaceTypeContext::classType).map(this::parseClassType).collect(Collectors.toList()));
            }
        }
        return new JavaTree(TYPE_PARAMETER, typeParameterContext.getText(), children, isOriginal);
    }

    List<JavaTree> parseClassModifier(List<ClassModifierContext> classModifiers)
    {
        return classModifiers.stream().map(a -> parseClassModifier(a)).collect(Collectors.toList());
    }

    <I> JavaTree parseModifier(I modifier, Function<I, AnnotationContext> extractAnnotation, Function<I, String> extractString)
    {
        if (extractAnnotation.apply(modifier) != null)
        {
            return parseAnnotation(extractAnnotation.apply(modifier));
        } else {
            JavaNode keyword;
            switch (extractString.apply(modifier))
            {
                case "public":
                    keyword = PUBLIC_MODIFIER_KEYWORD;
                case "protected":
                    keyword = PROTECTED_MODIFIER_KEYWORD;
                case "private":
                    keyword = PRIVATE_MODIFIER_KEYWORD;
                case "default":
                    keyword = DEFAULT_KEYWORD;
                case "abstract":
                    keyword = ABSTRACT_MODIFIER_KEYWORD;
                case "static":
                    keyword = STATIC_MODIFIER_KEYWORD;
                case "final":
                    keyword = FINAL_MODIFIER_KEYWORD;
                case "strictfp":
                default:
                    keyword = STRICTFP_MODIFIER_KEYWORD;
            }
            return getSymbol(keyword);
        }
    }

    JavaTree parseClassModifier(ClassModifierContext classModifier)
    {
        return parseModifier(classModifier, a -> a.annotation(), a -> a.getText());
    }

    private JavaTree parseLocalVariableStatement(final LocalVariableDeclarationContext localVariableDeclaration) {
        List<JavaTree> children = new ArrayList<>();
        children.addAll(parseVariableModifier(localVariableDeclaration.variableModifier()));
        children.add(parseUnannType(localVariableDeclaration.unannType()));
        children.addAll(parseVariableDeclaratorList(localVariableDeclaration.variableDeclaratorList()));
        return getJavaTree(VARIABLE_DECLARATION, children);
    }

    JavaTree getQualifier(TerminalNode identifier)
    {
        JavaTree qualifierElement = new JavaTree(QUALIFIER_ELEMENT, identifier.toString(), Collections.emptyList(), isOriginal);
        JavaTree qualifier = getJavaTree(QUALIFIER, Collections.singletonList(qualifierElement));
        return qualifier;
    }

    JavaTree getQualifier(List<TerminalNode> identifiers)
    {
        List<JavaTree> qualifierElements = new ArrayList<>();
        for (TerminalNode identifier : identifiers)
        {
            qualifierElements.add(new JavaTree(QUALIFIER_ELEMENT, identifier.toString(), Collections.emptyList(), isOriginal));
        }
        return getJavaTree(QUALIFIER, qualifierElements);
    }

    private List<JavaTree> parseFormalParameterList(final FormalParameterListContext formalParameterList) {
        List<JavaTree> children = new ArrayList<>();
        if (formalParameterList.receiverParameter() != null)
        {
            children.add(parseReceiverParameter(formalParameterList.receiverParameter()));
        } else if (formalParameterList.formalParameters() != null)
        {
            FormalParametersContext formalParameters = formalParameterList.formalParameters();
            if (formalParameters.receiverParameter() != null)
            {
                children.add(parseReceiverParameter(formalParameters.receiverParameter()));
            }
            children.addAll(formalParameters.formalParameter().stream().map(this::parseFormalParameter).collect(Collectors.toList()));
        }

        if (formalParameterList.lastFormalParameter() != null)
        {
            LastFormalParameterContext lastFormalParameter = formalParameterList.lastFormalParameter();
            if (lastFormalParameter.formalParameter() != null)
            {
                children.add(parseFormalParameter(lastFormalParameter.formalParameter()));
            } else
            {
                children.add(parseEllipsisParameter(lastFormalParameter));
            }
        }

        return children;
    }

    <I> JavaTree parseParameter(I input,
            JavaNode node,
            Function<I, List<VariableModifierContext>> extractVariableModifier,
            Function<I, UnannTypeContext> extractUnannType,
            Function<I, VariableDeclaratorIdContext> extractVariableDeclaratorId)
    {
        List<JavaTree> children = new ArrayList<>();
        for (VariableModifierContext variableModifier : extractVariableModifier.apply(input))
        {
            if (variableModifier.annotation() != null)
            {
                children.add(parseAnnotation(variableModifier.annotation()));
            } else
            {
                children.add(getSymbol(FINAL_MODIFIER_KEYWORD));
            }
        }
        children.add(parseUnannType(extractUnannType.apply(input)));
        if (extractVariableDeclaratorId.apply(input).dims() != null)
        {
            children.addAll(getDims(extractVariableDeclaratorId.apply(input).dims()));
        }
        return new JavaTree(node, extractVariableDeclaratorId.apply(input).Identifier().toString(), children, isOriginal);
    }

    JavaTree parseFormalParameter(FormalParameterContext formalParameter) {
        return parseParameter(formalParameter,
                METHOD_PARAMETER,
                a -> a.variableModifier(),
                a -> a.unannType(),
                a -> a.variableDeclaratorId());
    }

    JavaTree parseEllipsisParameter(LastFormalParameterContext formalParameter) {
        return parseParameter(formalParameter,
                METHOD_ELLIPSIS_PARAMETER,
                a -> a.variableModifier(),
                a -> a.unannType(),
                a -> a.variableDeclaratorId());
    }

    JavaTree parseReceiverParameter(ReceiverParameterContext receiverParameterContext)
    {
        List<JavaTree> receiverParameterChildren = new ArrayList<>();
        receiverParameterChildren.addAll(parseAnnotations(receiverParameterContext.annotation()));
        receiverParameterChildren.add(parseUnannType(receiverParameterContext.unannType()));
        if (receiverParameterContext.Identifier() != null)
        {
            receiverParameterChildren.add(getQualifier(receiverParameterContext.Identifier()));
        }
        return getJavaTree(METHOD_RECEIVER_PARAMETER, receiverParameterChildren);
    }

    JavaTree parseExpression(ExpressionContext expressionContext)
    {
        if (expressionContext.lambdaExpression() != null)
        {
            return parseLambdaExpression(expressionContext.lambdaExpression());
        } else
        {
            AssignmentExpressionContext assignmentExpressionContext = expressionContext.assignmentExpression();
            if (assignmentExpressionContext.conditionalExpression() != null)
            {
                return parseConditionalExpression(assignmentExpressionContext.conditionalExpression());
            } else
            {
                return parseAssignment(assignmentExpressionContext.assignment());
            }
        }
    }

    List<String> packageOrTypeNameToStrings(PackageOrTypeNameContext packageOrTypeName)
    {
        return getRecursive(packageOrTypeName, a -> a.Identifier().toString(), PackageOrTypeNameContext::packageOrTypeName);
    }

    List<String> typeNameToStrings(TypeNameContext typeName)
    {
        List<String> nameElements = getRecursive(typeName.packageOrTypeName(), a -> a.Identifier().toString(), PackageOrTypeNameContext::packageOrTypeName);
        nameElements.add(typeName.Identifier().toString());
        return nameElements;
    }

    JavaTree parseTypeName(TypeNameContext typeName)
    {
        return createQualifier(typeNameToStrings(typeName));
    }

    JavaTree parseExpressionName(ExpressionNameContext typeName)
    {
        List<String> annotationTypeNameElements = getRecursive(typeName.ambiguousName(), a -> a.Identifier().toString(), AmbiguousNameContext::ambiguousName);
        annotationTypeNameElements.add(typeName.Identifier().toString());
        return createQualifier(annotationTypeNameElements);
    }

    <I, O> List<O> getRecursive(I input, Function<I, O> extractor, UnaryOperator<I> iterator, Predicate<I> checker)
    {
        List<O> toReturn = new ArrayList<>();
        I current = input;
        while (checker.test(current)) {
            toReturn.add(extractor.apply(current));
            current = iterator.apply(current);
        }

        return toReturn;
    }

    JavaTree getSymbol(JavaNode symbolToGet)
    {
        return new JavaTree(symbolToGet, "", Collections.emptyList(), isOriginal);
    }

    List<JavaTree> getDims(List<DimContext> dimContexts) {
        List<JavaTree> children = new ArrayList<>();
        for (int i = 0; i < dimContexts.size(); i++) {
            children.add(getSymbol(DIM));
        }
        return children;
    }

    List<JavaTree> getDims(DimsContext dims)
    {
        if (dims == null)
        {
            return Collections.emptyList();
        }
        List<JavaTree> children = new ArrayList<>();
        for (AnnotatedDimContext annotatedDim : dims.annotatedDim())
        {
            List<JavaTree> annotations = new ArrayList<>();
            for (AnnotationContext annotation: annotatedDim.annotation())
            {
                annotations.add(parseAnnotation(annotation));
            }
            children.add(new JavaTree(DIM, "", annotations, isOriginal));
        }
        return children;
    }

    <I, O> List<O> getRecursive(I input, Function<I, O> extractor, UnaryOperator<I> iterator)
    {
        return getRecursive(input, extractor, iterator, Objects::nonNull);
    }

    /**
     * "Drills" into an object. This works by assuming that we have two elements in the input, a "plateau" and a "cliff".
     * We are done if the "plateau" object is not null. We run getJavaTree in this case.
     * If "plateau" is null, we drill deeper. The next element to drill into is called the "cliff".
     * We call some other function with the cliff as an input.
     * @param input The input to the function
     * @param getPlateau Gets the plateau
     * @param getCliff Gets the cliff
     * @param getJavaTree Gets a javatree
     * @param drillDeeper drills down to the next level.
     * @param <I> Input type
     * @param <P> Plateau type
     * @param <C> Cliff type
     * @return The resolved javatree
     */
    <I, P, C> JavaTree drillParse(I input, Function<I, P> getPlateau, Function<I, C> getCliff, Function<I, JavaTree> getJavaTree, Function<C, JavaTree> drillDeeper)
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

    /**
     * Runs {@link JavaTreePopulator#drillParse(Object, Function, Function, Function, Function)}.
     * If the input has a plateau, we return a JavaTree with \{plateau, symbol, cliff\}
     * @param input The input
     * @param getPlateau Gets the plateau
     * @param getCliff Gets the cliff
     * @param operator The operator
     * @param drillDeeper Function to drill deeper
     * @param <I> Input type
     * @param <P> Plateau type
     * @param <C> Cliff type
     * @return A javatree
     */
    <I, P, C> JavaTree drillParseBinaryExpressionSingle(I input,
            Function<I, P> getPlateau,
            Function<I, C> getCliff,
            JavaNode operator,
            Function<C, JavaTree> drillDeeper)
    {
        Function<I, JavaTree> getJavaTree = (a) -> {
            JavaTree left = parseConditionalExpression(getPlateau.apply(a));
            JavaTree right = parseConditionalExpression(getCliff.apply(a));
            List<JavaTree> children = Arrays.asList(left, getSymbol(operator), right);
            return new JavaTree(BINARY_EXPRESSION, "", children, isOriginal);
        };
        return drillParse(input, getPlateau, getCliff, getJavaTree, drillDeeper);
    }

    /**
     * Runs {@link JavaTreePopulator#drillParse(Object, Function, Function, Function, Function)}.
     * If the input has a plateau, we check each of the elements in operatorToExtract. The one that is non-null will be used.
     * @param input The input
     * @param getPlateau Gets the plateau
     * @param getCliff Gets the cliff
     * @param operatorToExtractor The operator
     * @param drillDeeper Function to drill deeper
     * @param <I> Input type
     * @param <P> Plateau type
     * @param <C> Cliff type
     * @return A javatree
     */
    <I, P, C> JavaTree drillParseBinaryExpressionMultiple(I input, Function<I, P> getPlateau, Function<I, C> getCliff, Map<JavaNode, Function<I, ?>> operatorToExtractor, Function<C, JavaTree> drillDeeper)
    {

        Optional<JavaTree> symbolTree = operatorToExtractor
                .entrySet()
                .stream()
                .filter(b -> b.getValue().apply(input) != null)
                .map(Map.Entry::getKey)
                .map(this::getSymbol)
                .findFirst();
        if (!symbolTree.isPresent())
        {
            return drillDeeper.apply(getCliff.apply(input));
        }
        else
        {
            JavaTree left = parseConditionalExpression(getPlateau.apply(input));
            JavaTree right = parseConditionalExpression(getCliff.apply(input));
            List<JavaTree> children = Arrays.asList(left, symbolTree.get(), right);
            return new JavaTree(BINARY_EXPRESSION, "", children, isOriginal);
        }
    }
}
