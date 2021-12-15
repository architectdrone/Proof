package org.architectdrone.javacodereviewprototype.context.language.display.action;

import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;

import java.util.List;

/**
 * Represents creation of a tree
 */
public class CreateDisplayElement extends ActionDisplayElement {
    public CreateDisplayElement(List<DisplayElement> children) {
        super(children);
    }
}
