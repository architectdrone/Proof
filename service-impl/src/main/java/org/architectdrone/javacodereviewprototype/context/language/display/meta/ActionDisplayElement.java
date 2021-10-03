package org.architectdrone.javacodereviewprototype.context.language.display.meta;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.tree.ReferenceType;

import java.util.List;

@Builder
public class ActionDisplayElement implements MetaDisplayElement {
    ReferenceType referenceType;
    @Singular
    @Getter List<DisplayElement> children;
}
