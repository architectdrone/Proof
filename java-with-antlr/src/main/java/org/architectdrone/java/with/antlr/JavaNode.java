package org.architectdrone.java.with.antlr;

/**
 * All nodes recognized by the system.
 * Key:
 *  - ALL_CAPS: A Node
 *  - \{lower_in_braces\}: Group of potential nodes
 */
public enum JavaNode {
    /**
     * A literal. Can be an integer, floating point, boolean, character, string, or null.
     *
     * Value: The value of the literal (formatted as a String)
     * Children: None
     */
    LITERAL,

    /**
     * A type. There are two "types" of "types":
     * - Primitive: The ones that are standard to java, including:
     *  - boolean
     *  - byte
     *  - short
     *  - int
     *  - long
     *  - char
     *  - float
     *  - double
     * - ClassOrInterface (Or Type)
     * - Array
     *  - Looks like "A[]"
     *
     * Value: The non-qualified name of the type
     * Children:
     *  - TYPE_QUALIFIER_ELEMENT
     *  - DIM* (If an array type)
     */
    TYPE,

    /**
     * A qualifier element for type.
     *
     * Value: The value of the qualifier
     * Children:
     *  - ANNOTATION*
     *  - TYPE_ARGUMENT_LIST?
     */
    TYPE_QUALIFIER_ELEMENT,

    /**
     * Just the characters '[]'. Can be annotated
     *
     * Value: None
     * Children:
     *  - ANNOTATION*
     */
    DIM,

    /**
     * Dimension expression.
     *
     * {expression} is:
     *  - CLASS_INSTANCE_CREATION_expression
     *  - ARRAY_CREATION_expression
     *  - LAMBDA_expression
     *  - TERNARY_expression
     *  - BINARY_expression
     *  - CAST_expression
     *  - QUALIFIER
     *  - UNARY_EXPRESSION
     *  - PRIMARY
     *
     * Value: Empty String
     * Children:
     *  - ANNOTATION*
     *  - expression
    */
    DIM_EXPRESSION,

    /**
     * A type parameter, or template. In "List<A>", "A" is the type parameter.
     * Type paramters can be declared as extending classes. For example, "A extends B"
     * They can also extend multiple classes. For example, "A extends B & C"
     *
     * Value: The type parameter's name
     * Children:
     *  - ANNOTATION*
     *  - TYPE? (The first extends)
     *  - TYPE?* (The other extends)
     */
    TYPE_PARAMETER,

    /**
     * The actual values of a type parameter list. For example, in "Foo<Bar, Baz, ? extends Qux>", "<Bar, Baz, ? extends Qux>" is the type argument list
     *
     * Value: Empty String
     * Children:
     * - (TYPE | WILDCARD)*
     */
    TYPE_ARGUMENT_LIST,

    /**
     * A list of type parameters. If empty, looks like <>.
     *
     * Value: Empty String
     * Children:
     *  - TYPE_PARAMETER*
    */
    TYPE_PARAMETER_LIST,

    /**
     * A wildcard. For example, "? extends A" or "? super B"
     *
     * Value: Empty String
     * Children:
     *  - ANNOTATION*
     *  - (WILDCARD_SUPER | WILDCARD_EXTENDS)?
     */
    WILDCARD,

    /**
     * Super bound for a wildcard. In "? super B", "super B" is the WILDCARD_SUPER.
     *
     * Value: Empty String
     * Children:
     *  - TYPE
     */
    WILDCARD_SUPER,

    /**
     * Extends bound for a wildcard. In "? extends B", "extends B" is the WILDCARD_EXTENDS.
     *
     * Value: Empty String
     * Children:
     *  - TYPE
     */
    WILDCARD_EXTENDS,

    /**
     * Dot separated traversal of a hierarchy. Used in several different contexts. For example "foo.bar.baz"
     *
     * Value: Empty String
     * Children:
     *  - QUALIFIER_ELEMENT*
     */
    QUALIFIER,
    
    /**
     * A qualifier element. For example, in "foo.bar.baz", foo, bar, and baz are QUALIFIER_ELEMENTs.
     * 
     * Value: The value of the qualifier element
     * Children:
     *  - ANNOTATION*
    */
    QUALIFIER_ELEMENT,

    /**
     * A single java file.
     *
     * Value: Empty String
     * Children:
     *  - PACKAGE_DECLARATION?
     *  - (STATIC_IMPORT_DECLARATION | NORMAL_IMPORT_DECLARATION)*
     *  - (CLASS_DECLARATION | INTERFACE_DECLARATION | ENUM_DECLARATION)*
    */
    COMPILATION_UNIT,

    /**
     * The package declaration. In code it looks like this:
     * "package foo.bar.baz;"
     * It can also look like this:
     * "\@PackageAnnotation package foo.bar.baz;"
     *
     * Value: Empty string
     * Children:
     *  - ANNOTATION*
     *  - QUALIFIER
     */
    PACKAGE_DECLARATION,

    /**
     * Declares a normal import. Looks like:
     * "import a.b.c;" or
     * "import a.b.*;"
     *
     * Value: Empty String
     * Children:
     *  - QUALIFIER
    */
    NORMAL_IMPORT_DECLARATION,

    /**
     * Declares a static import. Looks like:
     * "import static a.b.c;" or
     * "import static a.b.*;"
     *
     * Value: Empty String
     * Children:
     *  - QUALIFIER
     */
    STATIC_IMPORT_DECLARATION,

    /**
     * Declares an enum.
     *
     * Value: The name of the enum.
     * Children:
     *  - (ANNOTATION | PUBLIC_MODIFIER_KEYWORD | PROTECTED_MODIFIER_KEYWORD | PRIVATE_MODIFIER_KEYWORD | ABSTRACT_MODIFIER_KEYWORD | STATIC_MODIFIER_KEYWORD | FINAL_MODIFIER_KEYWORD | STRICTFP_MODIFIER_KEYWORD)*
     *  - IMPLEMENTS_INTERFACE*
     *  - ENUM_BODY
    */
    ENUM_DECLARATION,

    /**
     * The body of an enum. It is composed of a list of enum values, and then a normal class body.
     *
     * Value: Empty String
     * Children:
     *  - ENUM_CONSTANT*
     *  - TYPE_BODY
    */
    ENUM_BODY,

    /**
     * A constant in an enum.
     *
     * Value: The name of the constant
     * Children:
     *  - ANNOTATION*
     *  - expression*
     *  - TYPE_BODY?
    */
    ENUM_CONSTANT,

    /**
     * Declares a class
     *
     * Value: The name of the class
     * Children:
     *  - (ANNOTATION | PUBLIC_MODIFIER_KEYWORD | PROTECTED_MODIFIER_KEYWORD | PRIVATE_MODIFIER_KEYWORD | ABSTRACT_MODIFIER_KEYWORD | STATIC_MODIFIER_KEYWORD | FINAL_MODIFIER_KEYWORD | STRICTFP_MODIFIER_KEYWORD)*
     *  - TYPE_PARAMETER_LIST?
     *  - EXTENDS_CLASS?
     *  - IMPLEMENTS_INTERFACE*
     *  - TYPE_BODY
    */
    CLASS_DECLARATION,

    /**
     * Declares an interface.
     *
     * Value: The name of the interface
     * Children:
     *  - (ANNOTATION | PUBLIC_MODIFIER_KEYWORD | PROTECTED_MODIFIER_KEYWORD | PRIVATE_MODIFIER_KEYWORD | ABSTRACT_MODIFIER_KEYWORD | STATIC_MODIFIER_KEYWORD | STRICTFP_MODIFIER_KEYWORD)*
     *  - TYPE_PARAMETER_LIST?
     *  - EXTENDS_INTERFACE*
     *  - TYPE_BODY
    */
    INTERFACE_DECLARATION,

    /**
     * Declares an annotation
     *
     * Value: The name of the annotation
     * Children:
     *  - (ANNOTATION | PUBLIC_MODIFIER_KEYWORD | PROTECTED_MODIFIER_KEYWORD | PRIVATE_MODIFIER_KEYWORD | ABSTRACT_MODIFIER_KEYWORD | STATIC_MODIFIER_KEYWORD | STRICTFP_MODIFIER_KEYWORD)*
     *  - TYPE_BODY
    */
    ANNOTATION_DECLARATION,

    /**
     * The body of a type declaration (class, enum, interface, annotation).
     * Not all possible children will be available in all circumstances, of course.
     * However, all type bodies have the same basic structure, except for enum, which has a unique constant header
     *
     *  //todo: some of these can be reduced :)
     * {type_body} contains:
     *  - VARIABLE_DECLARATION
     *  - METHOD_DECLARATION
     *  - CLASS_DECLARATION
     *  - INITIALIZER
     *  - INTERFACE_DECLARATION
     *  - ANNOTATION_TYPE_ELEMENT_DECLARATION
     *
     * Value: Empty String
     * Children:
     *  - {type_body}*
     */
    TYPE_BODY,

    /**
     * In a class/interface/method, this declares a variable.
     *
     * "field declaration" is a looser term than in the grammar. Here, it refers to any time a variable is declared inside of a class body, but outside of a method. This includes constants
     *
     * {modifier} contains:
     *  - PUBLIC_KEYWORD
     *  - PROTECTED_KEYWORD
     *  - PRIVATE_KEYWORD
     *  - STATIC_KEYWORD
     *  - FINAL_KEYWORD
     *  - TRANSIENT_KEYWORD
     *  - VOLATILE_KEYWORD
     *
     * Value: Empty String
     * Children:
     *  - ({modifier} | ANNOTATION)*
     *  - TYPE
     *  - VARIABLE_DECLARATOR+
    */
    VARIABLE_DECLARATION,

    /**
     * Declares a method. We abuse the notion of "method" to also allow constructors. Also, we allow interface methods
     *
     * {modifier} contains:
     *  - PUBLIC_MODIFIER_KEYWORD
     *  - PROTECTED_MODIFIER_KEYWORD
     *  - PRIVATE_MODIFIER_KEYWORD
     *  - ABSTRACT_MODIFIER_KEYWORD
     *  - STATIC_MODIFIER_KEYWORD
     *  - FINAL_MODIFIER_KEYWORD
     *  - SYNCHRONIZED_MODIFIER_KEYWORD
     *  - NATIVE_MODIFIER_KEYWORD
     *  - STRICTFP_MODIFIER_KEYWORD
     *
     * Value: The name of the method
     * Children:
     *  - ({modifier} | ANNOTATION)*
     *  - TYPE_PARAMETER_LIST? (If this is typed)
     *  - ANNOTATION*
     *  - (TYPE | VOID_MODIFIER_KEYWORD) (return type)
     *  - (METHOD_RECEIVER_PARAMETER, METHOD_PARAMETER, METHOD_ELLIPSIS_PARAMETER) (The parameters)
     *  - DIM* (Not sure why)
     *  - THROWS_EXCEPTION*
     *  - BLOCK? (the code block)
    */
    METHOD_DECLARATION,

    /**
     * A special directive given at the beginning of the constructor. There are three patterns:
     *  - "<Foo, Bar>super(a, b, c)"
     *  - "(primary)<Foo, Bar>super(a, b, c)
     *  - "Foo.Bar.super(a,b,c)
     *
     *  Value: Empty String
     *  Children:
     *   - PRIMARY?
     *   - QUALIFIER?
     *   - TYPE_ARGUMENT_LIST?
     *   - ARGUMENT_LIST?
     */
    SUPER_EXPLICIT_CONSTRUCTOR_INVOCATION,

    /**
     * A list of arguments to be passed to a method.
     *
     * Value: Empty String
     * Children:
     *  - expression*
     */
    ARGUMENT_LIST,

    /**
     * A special directive, but "this"
     *
     * Value: Empty String
     * Children:
     *  - TYPE_ARGUMENTS?
     *  - ARGUMENT_LIST?
     */
    THIS_EXPLICIT_CONSTRUCTOR_INVOCATION,

    /**
     * A language edge case allowing for "this" to be annotated. For example:
     * "@Foo MyClass this"
     *
     * Value: Empty String
     * Children:
     *  - ANNOTATION*
     *  - TYPE
     *  - QUALIFIER?
    */
    METHOD_RECEIVER_PARAMETER,

    /**
     * Basically a block of code, surrounded by braces, that can be annotated with the static keyword.
     *
     * Value: Empty String
     * Children:
     *  - STATIC_MODIFIER_KEYWORD?
     *  - BLOCK
    */
    INITIALIZER,

    /**
     * Defines an element for an annotation.
     *
     * {modifier} contains:
     *  - PUBLIC
     *  - ABSTRACT
     *
     * {value} is:
     *  - CONDITIONAL_expression
     *  - ELEMENT_ARRAY
     *  - ANNOTATION
     *
     * Value: Name of the element
     * Children:
     *  - ({modifier} | ANNOTATION)*
     *  - TYPE
     *  - DIMS*
     *  - {value}?
     *
    */
    ANNOTATION_TYPE_ELEMENT_DECLARATION,

    /**
     * A normal, ordinary method parameter.
     *
     * Value: Name of the parameter
     * Children:
     *  - (FINAL_KEYWORD | ANNOTATION)*
     *  - TYPE
     *  - DIM* (Not sure why)
    */
    METHOD_PARAMETER,

    /**
     * A parameter allowing an arbitrary number of parameters to be specified.
     *
     * Value: Name of the parameter
     * Children:
     *  - (FINAL_KEYWORD | ANNOTATION)*
     *  - TYPE
     *  - ANNOTATION*
    */
    METHOD_ELLIPSIS_PARAMETER,

    /**
     * Indicates that a method can throw an exception
     *
     * Value: Empty String
     * Children:
     *  - TYPE
    */
    THROWS_EXCEPTION,

    /**
     * Part of a variable declaration.
     *
     * Value: The name of the variable
     * Children:
     *  - DIM*
     *  - (expression | ARRAY_INITIALIZER)? (If initialized)
    */
    VARIABLE_DECLARATOR,

    /**
     * The keyword "public".
     *
     * Value: Empty String
     * Children: None
    */
    PUBLIC_MODIFIER_KEYWORD,
    
    /**
     * The keyword "protected".
     *
     * Value: Empty String
     * Children: None
    */
    PROTECTED_MODIFIER_KEYWORD,

    /**
     * The keyword "private".
     *
     * Value: Empty String
     * Children: None
     */
    PRIVATE_MODIFIER_KEYWORD,

    /**
     * The keyword "abstract".
     *
     * Value: Empty String
     * Children: None
     */
    ABSTRACT_MODIFIER_KEYWORD,

    /**
     * The keyword "static".
     *
     * Value: Empty String
     * Children: None
     */
    STATIC_MODIFIER_KEYWORD,

    /**
     * The keyword "final".
     *
     * Value: Empty String
     * Children: None
     */
    FINAL_MODIFIER_KEYWORD,

    /**
     * The keyword "strictfp".
     *
     * Value: Empty String
     * Children: None
     */
    STRICTFP_MODIFIER_KEYWORD,

    /**
     * The keyword "transient".
     *
     * Value: Empty String
     * Children: None
     */
    TRANSIENT_MODIFIER_KEYWORD,

    /**
     * The keyword "volatile".
     *
     * Value: Empty String
     * Children: None
     */
    VOLATILE_MODIFIER_KEYWORD,

    /**
     * The keyword "void".
     *
     * Value: Empty String
     * Children: None
     */
    VOID_MODIFIER_KEYWORD,

    /**
     * Signifies that some class implements an interface.
     *
     * Value: Empty String
     * Children:
     *  - TYPE
     */
    IMPLEMENTS_INTERFACE,

    /**
     * Signifies that some class extends an interface.
     *
     * Value: Empty String
     * Children:
     *  - TYPE
     */
    EXTENDS_INTERFACE,

    /**
     * Signifies that some class extends a class.
     *
     * Value: Empty String
     * Children:
     *  - TYPE
     */
    EXTENDS_CLASS,

    /**
     * Represents an annotation. There are three types of annotations:
     * - Normal: Annotation with a set of elements, like "@Foo(bar=baz)"
     * - Marker: Annotation with no elements, like "@Foo"
     * - Single Element: Annotation with a single value, like "@Foo(bar)"
     *
     * {value} is:
     *  - CONDITIONAL_expression
     *  - ELEMENT_ARRAY
     *  - ANNOTATION (Yes, it is recursive)
     *
     * Value: The text of the annotation (If "@Foo", then "Foo")
     * Children: Depends on the annotation type.
     *  - QUALIFIER
     *  - Normal:
     *      - ELEMENT_PAIR*
     *  - Marker: None
     *  - Single Element:
     *      - {element_group}
     */
    ANNOTATION,

    /**
     * A name and value for an element, in an annotation. In "@Foo(bar=baz)", "bar=baz" is the element pair.
     *
     * {value} is:
     *  - EXPRESSION
     *  - ELEMENT_ARRAY
     *  - ANNOTATION
     *
     * Value: The element pair's name (In "bar=baz", it is "bar")
     * Children:
     *  - {value}
     */
    ELEMENT_PAIR,

    /**
     * Array of elements in an annotation. For example, in "@Foo({bar, baz})", "{bar, baz}" is the ELEMENT_ARRAY.
     *
     * {value} is:
     *  - CONDITIONAL_expression
     *  - ELEMENT_ARRAY
     *  - ANNOTATION (Yes, it is recursive)
     *
     * Value: Empty string.
     * Children:
     *  - {value}*
     */
    ELEMENT_ARRAY,

    /**
     * Array of elements.
     *
     * {variable} is:
     *  - expression
     *  - ARRAY_INITIALIZER
     *
     * Value: Empty String.
     * Children:
     *  - {variable}*
     */
    ARRAY_INITIALIZER,

    /**
     * A block of statements.
     *
     * {block_statement} is:
     *  - VARIABLE_DECLARATION
     *  - CLASS_DECLARATION
     *  - ENUM_DECLARATION
     *  - LABELED_STATEMENT
     *  - IF_STATEMENT
     *  - WHILE_STATEMENT
     *  - BASIC_FOR_STATEMENT
     *  - ENHANCED_FOR_STATEMENT
     *  - BLOCK
     *  - EMPTY_STATEMENT
     *  - ASSIGNMENT
     *  - UNARY_expression
     *  - METHOD_INVOCATION
     *  - SUPER_METHOD_INVOCATION
     *  - CLASS_INSTANCE_CREATION_expression
     *  - ASSERT_STATEMENT
     *  - SWITCH_STATEMENT
     *  - DO_STATEMENT
     *  - BREAK_STATEMENT
     *  - CONTINUE_STATEMENT
     *  - RETURN_STATEMENT
     *  - SYNCHRONIZED_STATEMENT
     *  - THROW_STATEMENT
     *  - TRY_STATEMENT
     *
     * Value: Empty String
     * Children:
     *  - {block_statement}*
     */
    BLOCK,

    /**
     * A statement that is labeled. Looks like this:
     * "Hello: <statement>"
     *
     * Value: the label
     * Children:
     *  - {block_statement}
     */
    LABELED_STATEMENT,

    /**
     * An if statement.
     *
     * Value: Empty string
     * Children:
     *  - expression
     *  - {block_statement}
     *  - {block_statement}? (if there is an else)
     */
    IF_STATEMENT,

    /**
     * A while statement
     *
     * Value: Empty String
     * Children:
     *  - expression
     *  - {block_statement}
    */
    WHILE_STATEMENT,

    /**
     * A normal for statement. That is, initialize, check, update
     *
     * Value: Empty String
     * Children:
     *  - FOR_INIT
     *  - expression
     *  - FOR_UPDATE
     *  - STATEMENT
    */
    BASIC_FOR_STATEMENT,

    /**
     * Initializer for BASIC_FOR_STATEMENT
     *
     * Value: Empty String
     * Children:
     *  - (STATEMENT_expression* | VARAIBLE_DECLARATION)
    */
    FOR_INIT,

    /**
     * Updater for BASIC_FOR_STATEMENT
     *
     * Value: Empty String
     * Children:
     *  - STATEMENT_expression*
    */
    FOR_UPDATE,

    /**
     * Enhanced for statement.
     *
     * Value: Empty String
     * Children:
     *  - VARIABLE_DECLARATION (mustn't be initialized)
     *  - expression
     *  - STATEMENT
    */
    ENHANCED_FOR_STATEMENT,

    /**
     * An empty statement. Literally, just ";"
     *
     * Value: Empty String
     * Children: None
    */
    EMPTY_STATEMENT,

    /**
     * An assignment. Looks like "a = b".
     *
     * {assignment_operator} is:
     *  -ASSIGNMENT_EQUALS
     *  -MULTIPLY_ASSIGNMENT_EQUALS
     *  -DIVIDE_ASSIGNMENT_EQUALS
     *  -MOD_ASSIGNMENT_EQUALS
     *  -PLUS_ASSIGNMENT_EQUALS
     *  -MINUS_ASSIGNMENT_EQUALS
     *  -SLL_ASSIGNMENT_EQUALS
     *  -SRL_ASSIGNMENT_EQUALS
     *  -SRA_ASSIGNMENT_EQUALS
     *  -AND_ASSIGNMENT_EQUALS
     *  -OR_ASSIGNMENT_EQUALS
     *  -NOT_ASSIGNMENT_EQUALS
     *
     * Value: Empty String
     * Children:
     *  - (QUALIFIER | FIELD_ACCESS | ARRAY_ACCESS)
     *  - assignment_operator
     *  - expression
    */
    ASSIGNMENT,

    /**
     * A primary. //todo: research what a primary is
     *
     * {method_reference_element} is:
     *  - NORMAL_METHOD_REFERENCE
     *  - SUPER_METHOD_REFERENCE
     *  - NEW_METHOD_REFERENCE
     *
     * {primary_element} is:
     *  - PRIMARY_TYPE_DOT_CLASS
     *  - PRIMARY_TYPE_DOT_THIS
     *  - CLASS_INSTANCE_CREATION_expression
     *  - FIELD_ACCESS
     *  - ARRAY_ACCESS
     *  - expression
     *  - METHOD_INVOCATION
     *  - SUPER_METHOD_INVOCATION
     *  - {method_reference_element}
     *
     * Value: Empty String
     * Children:
     *  - (primary_element | ARRAY_CREATION_expression)
     *  - primary_element*
    */
    PRIMARY,

    /**
     * A primary. Looks like this:
     * "Foo.Bar[][].class"
     *
     * Value: Empty String
     * Children:
     *  - QUALIFIER
     *  - DIM*
    */
    PRIMARY_TYPE_DOT_CLASS,

    /**
     * A primary. Looks like this:
     * "Foo.Bar.this"
     * or just
     * "this"
     *
     *
     * Value: Empty String
     * Children:
     *  - QUALIFIER?
    */
    PRIMARY_TYPE_DOT_THIS,

    /**
     * Creates an instance of a class.
     *
     * Value: Empty String
     * Children:
     *  - (QUALIFIER | PRIMARY)?
     *  - TYPE_ARGUMENT_LIST?
     *  - QUALIFIER
     *  - TYPE_ARGUMENT_LIST?
     *  - ARGUMENT_LIST?
     *  - TYPE_BODY?
    */
    CLASS_INSTANCE_CREATION_EXPRESSION,

    /**
     * Accesses a field.
     *
     * Value: Name of the field
     * Children:
     *  - (QUALIFIER | PRIMARY)?
    */
    FIELD_ACCESS,

    /**
     * Accesses a field.
     *
     * Value: Name of the field
     * Children:
     *  - (QUALIFIER | PRIMARY)?
    */
    SUPER_FIELD_ACCESS,

    /**
     * Accesses elements from an array.
     *
     * Value: Empty String
     * Children:
     *  - (QUALIFIER | PRIMARY)?
     *  - expression
     *  - ARRAY_ACCESS_ELEMENT*
    */
    ARRAY_ACCESS,

    /**
     * An element in an array access.
     *
     * Value: Empty String
     * Children:
     *  - PRIMARY
     *  - expression
    */
    ARRAY_ACCESS_ELEMENT,

    /**
     * Invokes a method
     *
     * Value: The name of the method to invoke
     * Children:
     *  - (QUALIFIER | PRIMARY)?
     *  - TYPE_ARGUMENT_LIST?
     *  - ARGUMENT_LIST?
    */
    METHOD_INVOCATION,

    /**
     * Invokes a method, super
     *
     * Value: The name of the method to invoke
     * Children:
     *  - (QUALIFIER)?
     *  - TYPE_ARGUMENT_LIST?
     *  - ARGUMENT_LIST?
    */
    SUPER_METHOD_INVOCATION,

    /**
     * References a method
     *
     * Value: The referenced method
     * Children:
     *  - (TYPE | QUALIFIER | PRIMARY)
     *  - TYPE_ARGUMENT_LIST
    */
    NORMAL_METHOD_REFERENCE,

    /**
     * References a method, super
     *
     * Value: The referenced method
     * Children:
     *  - QUALIFIER?
     *  - TYPE_ARGUMENT_LIST
    */
    SUPER_METHOD_REFERENCE,

    /**
     * Reference method, new
     *
     * Value: Empty String
     * Children:
     *  - TYPE
     *  - TYPE_ARGUMENT_LIST?
    */
    NEW_METHOD_REFERENCE,

    /**
     * An expression to create an array.
     *
     * Value: Empty String
     * Children:
     *  - TYPE
     *  - DIM_expression*
     *  - DIM*
     *  - ARRAY_INITIALIZER
    */
    ARRAY_CREATION_EXPRESSION,
    
    /**
     * Just '='
     * 
     * Value: Empty String
     * Children: None
    */
    ASSIGNMENT_EQUALS,

    /**
     * Just '*='
     *
     * Value: Empty String
     * Children: None
     */
    MULTIPLY_ASSIGNMENT_EQUALS,

    /**
     * Just '/='
     *
     * Value: Empty String
     * Children: None
     */
    DIVIDE_ASSIGNMENT_EQUALS,

    /**
     * Just '%='
     *
     * Value: Empty String
     * Children: None
     */
    MOD_ASSIGNMENT_EQUALS,

    /**
     * Just '+='
     *
     * Value: Empty String
     * Children: None
     */
    PLUS_ASSIGNMENT_EQUALS,

    /**
     * Just '-='
     *
     * Value: Empty String
     * Children: None
     */
    MINUS_ASSIGNMENT_EQUALS,

    /**
     * Just '<<='
     *
     * Value: Empty String
     * Children: None
     */
    SLL_ASSIGNMENT_EQUALS,

    /**
     * Just '>>='
     *
     * Value: Empty String
     * Children: None
     */
    SRL_ASSIGNMENT_EQUALS,

    /**
     * Just '>>>='
     *
     * Value: Empty String
     * Children: None
     */
    SRA_ASSIGNMENT_EQUALS,

    /**
     * Just '&='
     *
     * Value: Empty String
     * Children: None
     */
    AND_ASSIGNMENT_EQUALS,

    /**
     * Just '|='
     *
     * Value: Empty String
     * Children: None
     */
    OR_ASSIGNMENT_EQUALS,

    /**
     * Just '^='
     *
     * Value: Empty String
     * Children: None
     */
    NOT_ASSIGNMENT_EQUALS,

    /**
     * Asserts that a statement is true.
     *
     * Value: Empty String
     * Children:
     *  - expression
     *  - expression?
    */
    ASSERT_STATEMENT,


    /**
     * A switch statement
     *
     * Value: Empty String
     * Children:
     *  - expression
     *  - SWITCH_GROUP*
    */
    SWITCH_STATEMENT,

    /**
     * A group of labels and an optional block statement
     *
     * {switch_label} is:
     *  - expression
     *  - QUALIFIER
     *  - DEFAULT_KEYWORD
     *
     * Value: Empty String
     * Children:
     *  - {switch_label}*
     *  - BLOCK?
    */
    SWITCH_GROUP,
    
    /**
     * The keyword "default"
     * 
     * Value: Empty String
     * Children: None
    */
    DEFAULT_KEYWORD,


    /**
     * A Do-While loop
     *
     * Value: Empty String
     * Children:
     *  - statement
     *  - expression
    */
    DO_STATEMENT,

    /**
     * Breaks. Can optionally have a reference to a label.
     *
     * Value: Empty String
     * Children:
     *  - QUALIFIER?
    */
    BREAK_STATEMENT,

    /**
     * Continues. Can optionally have a reference to a label.
     *
     * Value: Empty String
     * Children:
     *  - QUALIFIER?
     */
    CONTINUE_STATEMENT,

    /**
     * Returns.
     *
     * Value: Empty String
     * Children:
     *  - expression?
    */
    RETURN_STATEMENT,

    /**
     * Throws something.
     *
     * Value: Empty String
     * Children:
     *  - expression
     */
    THROW_STATEMENT,

    /**
     * This is a block of code that is synchronized.
     *
     * Value: Empty String
     * Children:
     *  - expression
     *  - BLOCK
    */
    SYNCHRONIZED_STATEMENT,

    /**
     * A try block.
     *
     * Value: Empty String
     * Children:
     *  - TRY_STATEMENT_RESOURCE*
     *  - BLOCK
     *  - TRY_STATEMENT_CATCH*
     *  - TRY_STATEMENT_FINALLY?
    */
    TRY_STATEMENT,

    /**
     * A resource in a try statement
     *
     * Value: The name of the resource
     * Children:
     *  - (modifier | ANNOTATION)
     *  - TYPE
     *  - DIM*
     *  - expression
    */
    TRY_STATEMENT_RESOURCE,

    /**
     * A catch for a try.
     *
     * Value: Name of the catch parameter
     * Children:
     *  - (modifier | ANNOTATION)
     *  - TYPE+
     *  - BLOCK
    */
    TRY_STATEMENT_CATCH,

    /**
     * A finally statement
     *
     * Value: Empty String
     * Children:
     *  - BLOCK
    */
    TRY_STATEMENT_FINALLY,

    /**
     * A lambda expression.
     *
     * Value: Empty String
     * Children:
     *  - (LAMBDA_EXPRESSION_FORMAL_PARAMETER_LIST | LAMBDA_expression_INFERRED_FORMAL_PARAMETER_LIST | QUALIFIER)
     *  - (expression | BLOCK)
    */
    LAMBDA_EXPRESSION,

    /**
     * List of formal parameters in a lambda expression
     *
     * Value: Empty String
     * Children:
     *  - (METHOD_RECEIVER_PARAMETER | METHOD_PARAMETER | METHOD_ELLIPSIS_PARAMETER)*
    */
    LAMBDA_EXPRESSION_FORMAL_PARAMETER_LIST,

    /**
     * List of inferred parameters in a lambda expression
     *
     * Value: Empty String
     * Children:
     *  - QUALIFIER*
     */
    LAMBDA_EXPRESSION_INFERRED_FORMAL_PARAMETER_LIST,

    /**
     * A ternary expression, like "A == B ? A : B"
     *
     * Value: Empty String
     * Children:
     *  - EXPRESSION (The expression to evaluate)
     *  - EXPRESSION (The true expression)
     *  - EXPRESSION (The false expression)
     */
    TERNARY_EXPRESSION,

    /**
     * An expression with two arguments and an operator
     *
     * {binary_operator} is:
     *  - OR_SYMBOL
     *  - AND_SYMBOL
     *  - BINARY_OR_SYMBOL
     *  - XOR_SYMBOL
     *  - BINARY_AND_SYMBOL
     *  - EQUAL_TO_SYMBOL
     *  - NOT_EQUAL_TO_SYMBOL
     *  - LESS_THAN_SYMBOL
     *  - GREATER_THAN_SYMBOL
     *  - LESS_THAN_OR_EQUAL_TO_SYMBOL
     *  - GREATER_THAN_OR_EQUAL_TO_SYMBOL
     *  - INSTANCEOF_SYMBOL
     *  - SHIFT_LEFT_LOGICAL_SYMBOL
     *  - SHIFT_RIGHT_LOGICAL_SYMBOL
     *  - SHIFT_RIGHT_ARITMATIC_SYMBOL
     *  - ADD_SYMBOL
     *  - SUBTRACT_SYMBOL
     *  - MULTIPLY_SYMBOL
     *  - DIVIDE_SYMBOL
     *  - MODULUS_SYMBOL
     *
     * Value: Empty String
     * Children:
     *  - expression
     *  - binary_operator
     *  - expression
    */
    BINARY_EXPRESSION,

    /**
     * An expression with one argument and an operator
     *
     * {unary_operator} is:
     *  - ADD_SYMBOL
     *  - SUBTRACT_SYMBOL
     *  - INCREMENT_SYMBOL
     *  - DECREMENT_SYMBOL
     *  - BINARY_NOT_SYMBOL
     *  - NOT_SYMBOL
     *
     * Value: Empty String
     * Children:
     *  - if prefix
     *      - unary_operator
     *      - expression
     *  - if postfix
     *      - expression
     *      - unary_operator
     */
    UNARY_EXPRESSION,

    /**
     * The symbol "||"
     *
     * Value: Empty String
     * Children: None
    */
    OR_SYMBOL,

    /**
     * The symbol "&&"
     *
     * Value: Empty String
     * Children: None
     */
    AND_SYMBOL,

    /**
     * The symbol "|"
     *
     * Value: Empty String
     * Children: None
     */
    BINARY_OR_SYMBOL,

    /**
     * The symbol "^"
     *
     * Value: Empty String
     * Children: None
     */
    XOR_SYMBOL,

    /**
     * The symbol "&"
     *
     * Value: Empty String
     * Children: None
     */
    BINARY_AND_SYMBOL,

    /**
     * The symbol "=="
     *
     * Value: Empty String
     * Children: None
     */
    EQUAL_TO_SYMBOL,

    /**
     * The symbol "!="
     *
     * Value: Empty String
     * Children: None
     */
    NOT_EQUAL_TO_SYMBOL,

    /**
     * The symbol "<"
     *
     * Value: Empty String
     * Children: None
     */
    LESS_THAN_SYMBOL,

    /**
     * The symbol ">"
     *
     * Value: Empty String
     * Children: None
     */
    GREATER_THAN_SYMBOL,

    /**
     * The symbol "<="
     *
     * Value: Empty String
     * Children: None
     */
    LESS_THAN_OR_EQUAL_TO_SYMBOL,

    /**
     * The symbol ">="
     *
     * Value: Empty String
     * Children: None
     */
    GREATER_THAN_OR_EQUAL_TO_SYMBOL,

    /**
     * The symbol "instanceof"
     *
     * Value: Empty String
     * Children: None
     */
    INSTANCEOF_SYMBOL,

    /**
     * The symbol "<<"
     *
     * Value: Empty String
     * Children: None
     */
    SHIFT_LEFT_LOGICAL_SYMBOL,

    /**
     * The symbol ">>"
     *
     * Value: Empty String
     * Children: None
     */
    SHIFT_RIGHT_LOGICAL_SYMBOL,

    /**
     * The symbol ">>>"
     *
     * Value: Empty String
     * Children: None
     */
    SHIFT_RIGHT_ARITMATIC_SYMBOL,

    /**
     * The symbol "+"
     *
     * Value: Empty String
     * Children: None
     */
    ADD_SYMBOL,

    /**
     * The symbol "-"
     *
     * Value: Empty String
     * Children: None
     */
    SUBTRACT_SYMBOL,

    /**
     * The symbol "*"
     *
     * Value: Empty String
     * Children: None
     */
    MULTIPLY_SYMBOL,

    /**
     * The symbol "/"
     *
     * Value: Empty String
     * Children: None
     */
    DIVIDE_SYMBOL,

    /**
     * The symbol "%"
     *
     * Value: Empty String
     * Children: None
     */
    MODULUS_SYMBOL,

    /**
     * Just '++'
     *
     * Value: Empty String
     * Children: None
     */
    INCREMENT_SYMBOL,

    /**
     * Just '--'
     *
     * Value: Empty String
     * Children: None
     */
    DECREMENT_SYMBOL,

    /**
     * The symbol "~"
     *
     * Value: Empty String
     * Children: None
     */
    BINARY_NOT_SYMBOL,

    /**
     * The symbol "!"
     *
     * Value: Empty String
     * Children: None
     */
    NOT_SYMBOL,

    /**
     * Casts something to something else.
     *
     * Value: Empty String
     * Children:
     *  - TYPE+
     *  - expression
    */
    CAST_EXPRESSION,
}
