package org.architectdrone.java.with.antlr;/*
 * Description
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */

import java.util.List;

public abstract class SuperParseElement<I, E, O> {
    abstract E extract(I input);
    abstract O parse(E element);
    boolean canParse(I input) {
        return true;
    }
    abstract void addToChildren(List<JavaTree> children, O output);

    public void addToChildren(I input, List<JavaTree> addTo) {
        if (extract(input) != null && canParse(input))
        {
            addToChildren(addTo, parse(extract(input)));
        }
    }
}
