package org.architectdrone.java.with.antlr.unparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.architectdrone.java.with.antlr.JavaNode;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.unparser.DisplayElementAccessor;
import org.architectdrone.javacodereviewprototype.context.language.unparser.UnparserPattern;

import static org.architectdrone.java.with.antlr.JavaNode.*;
import static org.architectdrone.java.with.antlr.unparser.Constants.EXPRESSIONS;

public class VariableDeclaratorPattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder.displayElement(label);
        builder.list(DIM);
        List<JavaNode> initializers = Arrays.asList(EXPRESSIONS);
        initializers.add(ARRAY_INITIALIZER);
        if (displayElementAccessor.contains((JavaNode[]) initializers.toArray()))
        {
            builder.space();
            builder.string("=");
            builder.space();
            builder.oneNode((JavaNode[]) initializers.toArray());
        }
        return builder.build();
    }
}
