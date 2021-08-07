package org.architectdrone.javacodereviewprototype.utils.common;

import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CommonUtilsImpl implements CommonUtils {
    @Override
    public <T> Collection<T> getUnion(Collection<T> a, Collection<T> b) {
        Set<T> set = new HashSet<>();

        set.addAll(a);
        set.addAll(b);

        return set;
    }

    @Override
    public <T> Collection<T> getIntersection(Collection<T> a, Collection<T> b) {
        return Sets.intersection(Sets.newHashSet(a), Sets.newHashSet(b));
    }
}
