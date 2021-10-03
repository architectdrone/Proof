package org.architectdrone.javacodereviewprototype.context.language.display.meta;

import lombok.Builder;
import lombok.Getter;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.base.StringDisplayElement;

/**
 * A string, modified.
 */
@Builder
public class ModifyDisplayElement implements DisplayElement {
    @Getter
    StringDisplayElement from;
    @Getter
    StringDisplayElement to;
}
