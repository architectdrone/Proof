package org.architectdrone.javacodereviewprototype.context.language.display.action;

import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.StringDisplayElement;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModifyDisplayElement extends ActionDisplayElement {
    public ModifyDisplayElement(String oldString, String newString) {
        super(createModifyTree(oldString, newString));
    }

    private static List<DisplayElement> createModifyTree(String oldString, String newString) {
        StringDisplayElement oldDisplayElement = new StringDisplayElement(oldString);
        StringDisplayElement newDisplayElement = new StringDisplayElement(newString);
        //Todo: We probably need some shared visual display element that is not an action... will do later.
        CreateDisplayElement createDisplayElement = new CreateDisplayElement(Collections.singletonList(newDisplayElement));
        DeleteDisplayElement deleteDisplayElement = new DeleteDisplayElement(Collections.singletonList(oldDisplayElement));
        return Stream.of(createDisplayElement, deleteDisplayElement).collect(Collectors.toList());
    }
}
