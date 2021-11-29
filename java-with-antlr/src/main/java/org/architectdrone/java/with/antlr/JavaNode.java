package org.architectdrone.java.with.antlr;

/**
 * All nodes recognized by the system.
 * Key:
 *  - ALL_CAPS: A Node
 *  - \{lower_in_braces\}: Group of potential nodes
 */
public enum JavaNode {
    /**
     * Represents an annotation. There are three types of annotations:
     * - Normal: Annotation with a set of elements, like "@Foo(bar=baz)"
     * - Marker: Annotation with no elements, like "@Foo"
     * - Single Element: Annotation with a single value, like "@Foo(bar)"
     *
     * Part of {element_group}
     *
     * Value: The text of the annotation (If "@Foo", then "Foo")
     * Children: Depends on the annotation type.
     *  - Normal:
     *      - ELEMENT_PAIR*
     *  - Marker: None
     *  - Single Element:
     *      - {element_group}
     * Covers:
     *  - annotation
     *  - normalAnnotation
     *  - markerAnnotation
     *  - singleElementAnnotation
     *  - elementValuePairList
     */
    ANNOTATION,

    /**
     * A name and value for an element, in an annotation. In "@Foo(bar=baz)", "bar=baz" is the element pair.
     *
     * Value: The element pair's name (In "bar=baz", it is "bar")
     * Children:
     *  - {element_group}
     * Covers:
     *  - elementValuePair
     */
    ELEMENT_PAIR,

    /**
     * Array of elements in an annotation. For example, in "@Foo({bar, baz})", "{bar, baz}" is the ELEMENT_ARRAY.
     *
     * Part of {element_group}
     *
     * Value: Empty string.
     * Children:
     *  - {element_group}*
     * Covers:
     *  - elementValuePairList
     *  - elementValueArrayInitializer
     */
    ELEMENT_ARRAY,

    /**
     * Statement that chooses between two alternatives. For example, "Foo == Bar ? Baz : Qux"
     *
     * Value: Empty string.
     * Children:
     *  - CONDITIONAL_EXPRESSION
     *  -
     */
    TERNARY,

    /**
     * The package declaration. In code it looks like this:
     * "package foo.bar.baz"
     * It can also look like this:
     * "\@PackageAnnotation package foo.bar.baz"
     *
     * Value: The package name.
     * Children:
     *  - ANNOTATION?
     * Covers:
     *  - packageDeclaration
     *  - packageModifier
     */
    PACKAGE_DECLARATION,
}
