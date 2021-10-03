package org.architectdrone.javacodereviewprototype.context.language.display.meta;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;

import java.util.List;

/**
 * Marks the section as being "deleted".
 */
@Builder
public class DeleteDisplayElement implements MetaDisplayElement {
    @Singular @Getter
    List<DisplayElement> children;
}
