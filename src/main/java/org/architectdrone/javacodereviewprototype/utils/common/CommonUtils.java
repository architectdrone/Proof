package org.architectdrone.javacodereviewprototype.utils.common;

import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public interface CommonUtils {
    /**
     * Gets the union of two lists
     * @param a list a
     * @param b list b
     * @return The union of a and b
     */
    public <T> Collection<T> getUnion(Collection<T> a, Collection<T> b);

    /**
     * Gets the intersection of two lists
     * @param a list a
     * @param b list b
     * @return The union of a and b
     */
    public <T> Collection<T> getIntersection(Collection<T> a, Collection<T> b);
}
