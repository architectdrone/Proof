package org.architectdrone.java.with.antlr.unparser;/*
 * Description
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.architectdrone.java.with.antlr.JavaNode;

import static org.architectdrone.java.with.antlr.JavaNode.*;

public class Constants {
    public static JavaNode[] EXPRESSIONS = {
            CLASS_INSTANCE_CREATION_EXPRESSION,
            ARRAY_CREATION_EXPRESSION,
            LAMBDA_EXPRESSION,
            TERNARY_EXPRESSION,
            BINARY_EXPRESSION,
            CAST_EXPRESSION,
            QUALIFIER,
            UNARY_EXPRESSION,
            PRIMARY
    };

    public static JavaNode[] MODIFIERS = {
            ANNOTATION,
            PUBLIC_MODIFIER_KEYWORD,
            PRIVATE_MODIFIER_KEYWORD,
            PROTECTED_MODIFIER_KEYWORD,
            ABSTRACT_MODIFIER_KEYWORD,
            STATIC_MODIFIER_KEYWORD,
            FINAL_MODIFIER_KEYWORD,
            TRANSIENT_MODIFIER_KEYWORD,
            VOLATILE_MODIFIER_KEYWORD,
            SYNCHRONIZED_MODIFIER_KEYWORD,
            NATIVE_MODIFIER_KEYWORD,
            STRICTFP_MODIFIER_KEYWORD
    };
    
    public static JavaNode[] BLOCK_STATEMENT = {
            VARIABLE_DECLARATION,
            CLASS_DECLARATION,
            ENUM_DECLARATION,
            LABELED_STATEMENT,
            IF_STATEMENT,
            WHILE_STATEMENT,
            BASIC_FOR_STATEMENT,
            ENHANCED_FOR_STATEMENT,
            BLOCK,
            EMPTY_STATEMENT,
            ASSIGNMENT,
            UNARY_EXPRESSION,
            METHOD_INVOCATION,
            SUPER_METHOD_INVOCATION,
            CLASS_INSTANCE_CREATION_EXPRESSION,
            ASSERT_STATEMENT,
            SWITCH_STATEMENT,
            DO_STATEMENT,
            BREAK_STATEMENT,
            CONTINUE_STATEMENT,
            RETURN_STATEMENT,
            SYNCHRONIZED_STATEMENT,
            THROW_STATEMENT,
            TRY_STATEMENT
    };

    public static JavaNode[] STATEMENT_EXPRESSION = {
            ASSIGNMENT,
            UNARY_EXPRESSION,
            METHOD_INVOCATION,
            CLASS_INSTANCE_CREATION_EXPRESSION
    };

    public static JavaNode[] TYPE_BODY_MEMBERS = {
            VARIABLE_DECLARATION,
            METHOD_DECLARATION,
            CLASS_DECLARATION,
            INITIALIZER,
            INTERFACE_DECLARATION,
            ANNOTATION_TYPE_ELEMENT_DECLARATION
    };
    
    public static JavaNode[] ASSIGNMENT_OPERATOR = {
            ASSIGNMENT_EQUALS,
            MULTIPLY_ASSIGNMENT_EQUALS,
            DIVIDE_ASSIGNMENT_EQUALS,
            MOD_ASSIGNMENT_EQUALS,
            PLUS_ASSIGNMENT_EQUALS,
            MINUS_ASSIGNMENT_EQUALS,
            SLL_ASSIGNMENT_EQUALS,
            SRL_ASSIGNMENT_EQUALS,
            SRA_ASSIGNMENT_EQUALS,
            AND_ASSIGNMENT_EQUALS,
            OR_ASSIGNMENT_EQUALS,
            NOT_ASSIGNMENT_EQUALS
    };
    
    public static JavaNode[] elementGroup() {
        List<JavaNode> toReturn = new ArrayList<>();
        toReturn.addAll(Arrays.asList(EXPRESSIONS));
        toReturn.add(ELEMENT_ARRAY);
        toReturn.add(ANNOTATION);
        return (JavaNode[]) toReturn.toArray();
    }

    public static JavaNode[] arrayInitializerVariable() {
        List<JavaNode> toReturn = new ArrayList<>();
        toReturn.addAll(Arrays.asList(EXPRESSIONS));
        toReturn.add(ARRAY_INITIALIZER);
        return (JavaNode[]) toReturn.toArray();
    }

    public static JavaNode[] forInitMembers() {
        List<JavaNode> toReturn = new ArrayList<>();
        toReturn.addAll(Arrays.asList(STATEMENT_EXPRESSION));
        toReturn.add(VARIABLE_DECLARATION);
        return (JavaNode[]) toReturn.toArray();
    }
}
