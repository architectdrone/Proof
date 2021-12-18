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

public class InterfaceDeclarationPattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder.spaceList(MODIFIERS);
        builder.buffer().space();
        builder.string("interface");
        builder.space();
        builder.displayElement(label);
        builder.nodeOrNone(TYPE_PARAMETER_LIST);
        builder.space();
        builder.spaceList(EXTENDS_INTERFACE); //TODO: Fix how we handle interfaces: atm I think if you have two it will show up like "implements Foo implements Bar"
        builder.newLine();
        builder.encloseInBlock(TYPE_BODY);
        return builder.build();
    }
}
