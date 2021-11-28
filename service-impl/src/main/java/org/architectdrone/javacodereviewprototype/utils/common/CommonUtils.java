package org.architectdrone.javacodereviewprototype.utils.common;

import java.util.Collection;

/**
 * Various tools, including tools for set comprehension.
 */
public interface CommonUtils {
    /**
     * Gets the union of two lists
     * @param a list a
     * @param b list b
     * @return The union of a and b
     */
    <T> Collection<T> getUnion(Collection<T> a, Collection<T> b);

    /**
     * Gets the intersection of two lists
     * @param a list a
     * @param b list b
     * @return The union of a and b
     */
    <T> Collection<T> getIntersection(Collection<T> a, Collection<T> b);
}
