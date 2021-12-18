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

public class TypeParameterPattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder.spaceBlock(ANNOTATION);
        builder.space();

        List<List<DisplayElement>> types = displayElementAccessor.withLabel(TYPE).getAllDisplayElements();
        if (!types.isEmpty())
        {
            builder.string("extends");
            builder.space();
            builder.displayElements(types.get(0));

            for (int i = 0; i < types.size() - 1; i++) {
                builder.space();
                builder.string("&");
                builder.space();
                builder.displayElements(types.get(i+1));
            }
        }

        return builder.build();
    }
}
