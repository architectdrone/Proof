package org.architectdrone.java.with.antlr.unparser;

import java.util.List;
import org.architectdrone.java.with.antlr.JavaNode;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.unparser.DisplayElementAccessor;
import org.architectdrone.javacodereviewprototype.context.language.unparser.UnparserPattern;

import static org.architectdrone.java.with.antlr.JavaNode.*;

public class VariableDeclarationPattern extends UnparserPattern<JavaNode> {

    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        List<DisplayElement> declaratorDelimiter = new UnparserBuilder().string(",").space().build();
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder.spaceList(Constants.MODIFIERS);
        builder.buffer().space();
        builder.node(TYPE);
        builder.space();
        builder.list(declaratorDelimiter, VARIABLE_DECLARATOR);
        builder.semicolon();
        return builder.build();
    }
}
