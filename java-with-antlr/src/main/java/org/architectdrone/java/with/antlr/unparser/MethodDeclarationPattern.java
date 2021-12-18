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

public class MethodDeclarationPattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        List<DisplayElement> delimiter = new UnparserBuilder().string(",").space().build();
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder = handleModifiersAndAnnotations(builder);
        builder.oneNode(TYPE, VOID_MODIFIER_KEYWORD);
        builder.space();
        builder.string("(");
        builder.list(delimiter, METHOD_RECEIVER_PARAMETER, METHOD_PARAMETER, METHOD_ELLIPSIS_PARAMETER);
        builder.string(")");
        builder.space();
        builder.list(new ArrayList<>(), DIM);
        builder.buffer().space();
        //TODO: Careful -- this might cause some problems.
        if (builder.getAccessor().contains(THROWS_EXCEPTION)) {
            builder.string("throws");
            builder.space();
            builder.list(delimiter, THROWS_EXCEPTION);
        }

        if (builder.getAccessor().contains(BLOCK))
        {
            builder.newLine();
            builder.oneNode(BLOCK);
        }
        return builder.build();
    }

    //TODO: There's a good chance this doesn't work lol
    private UnparserBuilder handleModifiersAndAnnotations(UnparserBuilder builder)
    {
        if (!builder.getAccessor().contains(TYPE_PARAMETER_LIST))
        {
            return builder.spaceList(MODIFIERS).buffer().space();
        } else {
            List<JavaNode> modifiersAndTypeParameterList = Arrays.asList(MODIFIERS);
            modifiersAndTypeParameterList.add(TYPE_PARAMETER_LIST);
            DisplayElementAccessor<JavaNode> modifiersAndTypeParameters = builder.getAccessor().withLabels((JavaNode[]) modifiersAndTypeParameterList.toArray());
            DisplayElementAccessor<JavaNode> allBefore = modifiersAndTypeParameters.getAllBefore(TYPE_PARAMETER_LIST);
            DisplayElementAccessor<JavaNode> allAfter = modifiersAndTypeParameters.getAllAfter(TYPE_PARAMETER_LIST);
            return builder
                    .displayElements(new UnparserBuilder(allBefore).spaceList(MODIFIERS).build())
                    .buffer().space()
                    .node(TYPE_PARAMETER_LIST)
                    .space()
                    .displayElements(new UnparserBuilder(allAfter).spaceList(MODIFIERS).build())
                    .buffer().space();
        }
    }
}
