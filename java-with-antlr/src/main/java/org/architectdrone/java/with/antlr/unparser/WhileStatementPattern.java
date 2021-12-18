package org.architectdrone.java.with.antlr.unparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.plaf.ButtonUI;
import org.architectdrone.java.with.antlr.JavaNode;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.unparser.DisplayElementAccessor;
import org.architectdrone.javacodereviewprototype.context.language.unparser.UnparserPattern;

import static org.architectdrone.java.with.antlr.JavaNode.*;
import static org.architectdrone.java.with.antlr.unparser.Constants.BLOCK_STATEMENT;
import static org.architectdrone.java.with.antlr.unparser.Constants.EXPRESSIONS;

public class WhileStatementPattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder.string("while");
        builder.space();
        builder.string("(");
        builder.oneNode(EXPRESSIONS);
        builder.string(")");
        builder.space();
        builder.oneNode(BLOCK_STATEMENT);
        return builder.build();
    }
}
