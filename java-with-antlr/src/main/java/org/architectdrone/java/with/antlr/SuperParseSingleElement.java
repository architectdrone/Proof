package org.architectdrone.java.with.antlr;/*
 * Description
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */

import java.util.List;

public abstract class SuperParseSingleElement<I, E> extends SuperParseElement<I, E, JavaTree> {
    @Override
    void addToChildren(final List<JavaTree> children, final JavaTree output) {
        children.add(output);
    }
}
