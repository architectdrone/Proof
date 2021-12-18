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
import static org.architectdrone.java.with.antlr.unparser.Constants.BLOCK_STATEMENT;

public class IfStatementPattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder.string("if");
        builder.space();
        builder.string("(");
        builder.oneNode(Constants.EXPRESSIONS);
        builder.string(")");
        builder.space();
        List<List<DisplayElement>> blockStatements = displayElementAccessor.getAllDisplayElements();
        builder.displayElements(blockStatements.get(0));
        if (blockStatements.size() == 2)
        {
            builder.space();
            builder.string("else");
            builder.space();
            builder.displayElements(blockStatements.get(0));
        }
        return builder.build();
    }
}
