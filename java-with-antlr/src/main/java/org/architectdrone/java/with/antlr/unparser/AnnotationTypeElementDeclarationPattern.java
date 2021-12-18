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
import static org.architectdrone.java.with.antlr.unparser.Constants.EXPRESSIONS;
import static org.architectdrone.java.with.antlr.unparser.Constants.MODIFIERS;

public class AnnotationTypeElementDeclarationPattern extends UnparserPattern<JavaNode> {
        @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        //todo: might also run into some problems here
        DisplayElementAccessor<JavaNode> beforeType = displayElementAccessor.getAllBefore(TYPE);
        DisplayElementAccessor<JavaNode> afterType = displayElementAccessor.getAllAfter(TYPE);
        UnparserBuilder builder = new UnparserBuilder(afterType);
        builder.displayElements(new UnparserBuilder(beforeType).spaceList(MODIFIERS).build());
        builder.buffer().space();
        builder.node(TYPE);
        builder.space();
        builder.displayElement(label);
        builder.string("()");
        if (builder.getAccessor().contains(DIM))
        {
            builder.space();
            builder.list(DIM);
        }
        List<JavaNode> defaultValues = Arrays.asList(EXPRESSIONS);
        defaultValues.add(ELEMENT_ARRAY);
        defaultValues.add(ANNOTATION);
        if (builder.getAccessor().contains((JavaNode[]) defaultValues.toArray()))
        {
            builder.space();
            builder.oneNode((JavaNode[]) defaultValues.toArray());
        }
        builder.semicolon();
        return builder.build();
    }
}
