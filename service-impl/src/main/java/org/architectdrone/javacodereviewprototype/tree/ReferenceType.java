package org.architectdrone.javacodereviewprototype.tree;

import lombok.AllArgsConstructor;

/**
 * Different types of reference nodes.
 */
@AllArgsConstructor
public enum ReferenceType {
    MOVE_FROM(1),
    MOVE_TO(-1),
    CREATE(1),
    DELETE(-1),
    MODIFY(0),
    NONE(0);

    int linesCreated;
}
