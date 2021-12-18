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
import static org.architectdrone.java.with.antlr.unparser.Constants.MODIFIERS;

public class MethodEllipsisParameterPattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        //TODO: same possible problem
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        List<DisplayElement> modifiers = new UnparserBuilder(displayElementAccessor.getAllBefore(TYPE)).spaceList(MODIFIERS).build();
        List<DisplayElement> annotations = new UnparserBuilder(displayElementAccessor.getAllAfter(TYPE)).spaceList(ANNOTATION).build();
        builder.displayElements(modifiers);
        builder.buffer().space();
        builder.node(TYPE);
        if (!annotations.isEmpty())
        {
            builder.space();
            builder.displayElements(annotations);
            builder.space();
        }
        builder.string("...");
        builder.space();
        builder.displayElement(label);
        builder.list(DIM);
        return builder.build();
    }
}
