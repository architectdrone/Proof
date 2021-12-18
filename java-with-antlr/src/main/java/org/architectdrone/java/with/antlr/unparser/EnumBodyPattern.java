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

public class EnumBodyPattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder.list(new UnparserBuilder().string(",").newLine().newLine().build(), ENUM_CONSTANT);
        builder.buffer().semicolon();
        builder.newLine();
        builder.nodeOrNone(TYPE_BODY);
        return builder.build();
    }
}
