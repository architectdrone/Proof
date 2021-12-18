package org.architectdrone.java.with.antlr.unparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.architectdrone.java.with.antlr.JavaNode;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.unparser.DisplayElementAccessor;
import org.architectdrone.javacodereviewprototype.context.language.unparser.Unparser;
import org.architectdrone.javacodereviewprototype.context.language.unparser.UnparserPattern;

import static org.architectdrone.java.with.antlr.JavaNode.*;

public class TypePattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);

        //type qualifier elements separated by periods.
        builder.block(new UnparserBuilder().period().build(), TYPE_QUALIFIER_ELEMENT);
        builder.block(DIM);
        return builder.build();
    }
}
