package org.architectdrone.javacodereviewprototype.context.language.unparser;

import java.util.List;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;

/*
 * Takes a node and unparses it in a certain way
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */
public abstract class UnparserPattern<L> {
    public abstract List<DisplayElement> unparse(DisplayElement label, DisplayElementAccessor<L> displayElementAccessor);
}
