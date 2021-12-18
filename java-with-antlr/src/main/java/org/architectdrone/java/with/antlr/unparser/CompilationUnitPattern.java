package org.architectdrone.java.with.antlr.unparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.architectdrone.java.with.antlr.JavaNode;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.unparser.DisplayElementAccessor;
import org.architectdrone.javacodereviewprototype.context.language.unparser.UnparserPattern;

import static org.architectdrone.java.with.antlr.JavaNode.ANNOTATION_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.CLASS_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.ENUM_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.INTERFACE_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.NORMAL_IMPORT_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.PACKAGE_DECLARATION;
import static org.architectdrone.java.with.antlr.JavaNode.STATIC_IMPORT_DECLARATION;

public class CompilationUnitPattern extends UnparserPattern<JavaNode> {
    @Override
    public List<DisplayElement> unparse(final DisplayElement label, final DisplayElementAccessor<JavaNode> displayElementAccessor) {
        UnparserBuilder builder = new UnparserBuilder(displayElementAccessor);
        builder.newLineBlock(PACKAGE_DECLARATION);
        builder.newLineBlock(NORMAL_IMPORT_DECLARATION, STATIC_IMPORT_DECLARATION);
        builder.newLineBlock(CLASS_DECLARATION, INTERFACE_DECLARATION, ENUM_DECLARATION, ANNOTATION_DECLARATION);
        return builder.build();
    }
}
