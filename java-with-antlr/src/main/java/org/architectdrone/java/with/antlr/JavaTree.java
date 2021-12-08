package org.architectdrone.java.with.antlr;

import java.util.ArrayList;
import java.util.Arrays;
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

import static org.architectdrone.java.with.antlr.JavaNode.BINARY_EXPRESSION;
import static org.architectdrone.java.with.antlr.JavaNode.OR_SYMBOL;
import static org.architectdrone.java.with.antlr.JavaNode.QUALIFIER;
import static org.architectdrone.java.with.antlr.JavaNode.QUALIFIER_ELEMENT;

public class JavaTree extends DiffTree<JavaNode> {
    public JavaTree(JavaNode label, String value, List<DiffTree<JavaNode>> children, boolean isOriginal)
    {
        super(label, value, children, isOriginal);
    }


}
