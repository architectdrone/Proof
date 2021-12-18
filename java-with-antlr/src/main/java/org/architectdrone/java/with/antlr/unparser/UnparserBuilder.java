package org.architectdrone.java.with.antlr.unparser;/*
 * Description
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import org.architectdrone.java.with.antlr.JavaNode;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.NewLineDisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.StringDisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.TabDecreaseDisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.TabIncreaseDisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.unparser.DisplayElementAccessor;

import static org.architectdrone.java.with.antlr.JavaNode.PACKAGE_DECLARATION;

public class UnparserBuilder {
    @Getter
    DisplayElementAccessor<JavaNode> accessor;
    List<DisplayElement> toReturn;
    boolean lastDidAdd = false;
    boolean isBuffering = false;
    public UnparserBuilder(DisplayElementAccessor<JavaNode> displayElementAccessor)
    {
        this.accessor = displayElementAccessor;
    }

    public UnparserBuilder() {

    }

    public UnparserBuilder buffer() {
        this.isBuffering = true;
        return this;
    }

    List<DisplayElement> build()
    {
        return this.toReturn;
    }

    public UnparserBuilder displayElement(DisplayElement displayElement)
    {
        return displayElements(Collections.singletonList(displayElement));
    }

    public UnparserBuilder displayElements(List<DisplayElement> displayElements)
    {
        if (isBuffering)
        {
            if (!lastDidAdd)
            {
                return this;
            }
            isBuffering = false;
        }
        toReturn.addAll(displayElements);
        lastDidAdd = true;
        return this;
    }

    public UnparserBuilder tabUp()
    {
        return displayElement(new TabIncreaseDisplayElement());
    }

    public UnparserBuilder tabDown()
    {
        return displayElement(new TabDecreaseDisplayElement());
    }

    public UnparserBuilder blockStart() {
        return displayElements(new UnparserBuilder()
                .string("{")
                .newLine()
                .tabUp()
                .build());
    }

    public UnparserBuilder blockEnd() {
        return displayElements(new UnparserBuilder()
                .newLine()
                .tabDown()
                .string("}")
                .build());
    }

    public UnparserBuilder encloseInBlock(JavaNode javaNode)
    {
        return displayElements( new UnparserBuilder()
                .blockStart()
                .node(javaNode)
                .blockEnd()
                .build());
    }

    public UnparserBuilder string(String string)
    {
        return displayElement(new StringDisplayElement(string));
    }

    public UnparserBuilder period()
    {
        return string(".");
    }

    public UnparserBuilder space()
    {
        return string(" ");
    }

    public UnparserBuilder semicolon()
    {
        return string(";");
    }

    public UnparserBuilder newLine()
    {
        return displayElement(new NewLineDisplayElement());
    }

    public UnparserBuilder node(JavaNode node)
    {
        assert accessor != null;
        return displayElements(accessor.withLabel(node).getDisplayElements());
    }

    public UnparserBuilder oneNode(JavaNode... nodes)
    {
        assert accessor != null;
        return displayElements(accessor.withLabels(nodes).getDisplayElements());
    }

    public UnparserBuilder nodeOrNone(JavaNode node)
    {
        assert accessor != null;
        DisplayElementAccessor<JavaNode> nodeAccessor = accessor.withLabel(node);
        if (!nodeAccessor.isEmpty())
        {
            return displayElements(accessor.withLabel(node).getDisplayElements());
        } else {
            return this;
        }
    }

    public UnparserBuilder block(List<DisplayElement> lineDelimiter, List<DisplayElement> blockEnd, JavaNode... labels)
    {
        assert accessor != null;
        DisplayElementAccessor<JavaNode> elements = accessor.withLabels(labels);
        if (!elements.isEmpty())
        {
            displayElements(elements.getAllDisplayElementsDelimited(lineDelimiter));
            displayElements(blockEnd);
        } else {
            lastDidAdd = false;
        }
        return this;
    }

    public UnparserBuilder newLineBlock(JavaNode ... labels)
    {
        List<DisplayElement> newLine = new UnparserBuilder().newLine().build();
        return block(newLine, newLine, labels);
    }

    public UnparserBuilder spaceBlock(JavaNode ... labels)
    {
        List<DisplayElement> space = new UnparserBuilder().space().build();
        return block(space, labels);
    }

    /**
     * Represents labels as a list. The delimiter is placed between pairs of items, so there is no trailing item
     * @param delimiter What to put between each item
     * @param labels What labels to select
     */
    public UnparserBuilder list(List<DisplayElement> delimiter, JavaNode... labels)
    {
        DisplayElementAccessor<JavaNode> listAccessor = accessor.withLabels(labels);
        List<List<DisplayElement>> elements = listAccessor.getAllDisplayElements();
        if (elements.isEmpty())
        {
            lastDidAdd = false;
        }
        for (int i = 0; i < listAccessor.getAllDisplayElements()
                .size(); i++) {
            if (i != 0)
            {
                displayElements(delimiter);
            }
            displayElements(elements.get(i));
        }
        return this;
    }

    public UnparserBuilder list(JavaNode... labels)
    {
        return list(new UnparserBuilder().build(), labels);
    }

    public UnparserBuilder spaceList(JavaNode... labels)
    {
        return list(new UnparserBuilder().space().build(), labels);
    }

    public UnparserBuilder commaList(JavaNode... labels)
    {
        return list(new UnparserBuilder().string(",").space().build(), labels);
    }

    public UnparserBuilder block(List<DisplayElement> delimiter, JavaNode... labels)
    {
        block(delimiter, new ArrayList<>(), labels);
        return this;
    }

    public UnparserBuilder block(JavaNode... labels)
    {
        block(new ArrayList<>(), labels);
        return this;
    }
}
