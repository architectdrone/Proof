package org.architectdrone.javacodereviewprototype.context.language.display;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Display element that contains other display elements.
 */
@AllArgsConstructor
public class MetaDisplayElement implements DisplayElement {
    @Getter List<DisplayElement> children;
}
