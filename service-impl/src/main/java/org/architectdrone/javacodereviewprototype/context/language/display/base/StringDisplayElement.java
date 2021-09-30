package org.architectdrone.javacodereviewprototype.context.language.display.base;

import lombok.AllArgsConstructor;
import org.architectdrone.javacodereviewprototype.context.language.display.base.BaseDisplayElement;

/**
 * Holds some string.
 */
@AllArgsConstructor
public class StringDisplayElement implements BaseDisplayElement {
    String string;
}
