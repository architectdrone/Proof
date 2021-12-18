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

public class AnnotationPattern extends UnparserPattern<JavaNode> {



    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder.string("@");
        builder.node(QUALIFIER);

        if (displayElementAccessor.contains(ELEMENT_PAIR))
        {
            builder.string("(");
            builder.commaList(ELEMENT_PAIR);
            builder.string(")");
        } else if (displayElementAccessor.contains(Constants.elementGroup()))
        {
            builder.string("(");
            builder.oneNode(Constants.elementGroup());
            builder.string(")");
        }

        return builder.build();
    }
}
