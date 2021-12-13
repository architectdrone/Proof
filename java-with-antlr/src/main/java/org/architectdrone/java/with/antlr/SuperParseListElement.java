package org.architectdrone.java.with.antlr;

import java.util.List;

public abstract class SuperParseListElement<I, E> extends SuperParseElement<I, E, List<JavaTree>>{
    @Override
    void addToChildren(final List<JavaTree> children, final List<JavaTree> output) {
        children.addAll(output);
    }
}
