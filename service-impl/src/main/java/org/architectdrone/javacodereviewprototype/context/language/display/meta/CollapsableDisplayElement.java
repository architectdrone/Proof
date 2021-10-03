package org.architectdrone.javacodereviewprototype.context.language.display.meta;


import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.base.NewLineDisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.base.TabDecreaseDisplayElement;
import org.architectdrone.javacodereviewprototype.context.language.display.base.TabIncreaseDisplayElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a collapsable section of code.
 * If collapsedChildren is null, the collapsed form is just the children without any tabs or newlines.
 */
@Builder
public class CollapsableDisplayElement implements MetaDisplayElement {
    @Getter @Singular
    List<DisplayElement> children;
    @Getter @Singular
    List<DisplayElement> collapsedChildren;

    public List<DisplayElement> getCollapsedChildren() {
        if (collapsedChildren != null)
        {
            return collapsedChildren;
        }
        else
        {
            return children
                    .stream()
                    .filter(a -> ! (a instanceof NewLineDisplayElement))
                    .filter(a -> ! (a instanceof TabDecreaseDisplayElement))
                    .filter(a -> ! (a instanceof TabIncreaseDisplayElement))
                    .collect(Collectors.toList());
        }
    }
}
