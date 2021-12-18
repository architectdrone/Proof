package org.architectdrone.java.with.antlr.unparser;

import java.sql.BatchUpdateException;
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

public class EnumDeclarationPattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder.spaceList(MODIFIERS);
        builder.buffer().space();
        builder.string("enum");
        builder.space();
        builder.displayElement(label);
        builder.space();
        builder.spaceList(IMPLEMENTS_INTERFACE);
        builder.newLine();
        builder.encloseInBlock(ENUM_BODY);
        return builder.build();
    }
}
