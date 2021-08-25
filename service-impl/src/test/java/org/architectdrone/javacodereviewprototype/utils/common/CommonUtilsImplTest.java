package org.architectdrone.javacodereviewprototype.utils.common;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CommonUtilsImplTest {
    CommonUtils commonUtils = new CommonUtilsImpl();
    
    @Nested
    class getUnionTests
    {
        @Test
        void whenListsDontIntersect_unionIsCorrect() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("c", "d").collect(Collectors.toList());

            Collection<String> union = commonUtils.getUnion(a, b);
            assertEquals(4, union.size());
            assertEquals(1, Collections.frequency(union, "a"));
            assertEquals(1, Collections.frequency(union, "b"));
            assertEquals(1, Collections.frequency(union, "c"));
            assertEquals(1, Collections.frequency(union, "d"));
        }

        @Test
        void whenListsDoIntersect_unionIsCorrect() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("b", "d").collect(Collectors.toList());

            Collection<String> union = commonUtils.getUnion(a, b);
            assertEquals(3, union.size());
            assertEquals(1, Collections.frequency(union, "a"));
            assertEquals(1, Collections.frequency(union, "b"));
            assertEquals(1, Collections.frequency(union, "d"));
        }
    }

    @Nested
    class getIntersectionTests
    {
        @Test
        void whenListsDontIntersect_intersectionIsCorrect() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("c", "d").collect(Collectors.toList());

            Collection<String> intersection = commonUtils.getIntersection(a, b);
            assertEquals(0, intersection.size());
        }

        @Test
        void whenListsDoIntersect_unionIsCorrect() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("b", "d").collect(Collectors.toList());

            Collection<String> intersection = commonUtils.getIntersection(a, b);
            assertEquals(1, intersection.size());
            assertEquals(1, Collections.frequency(intersection, "b"));
        }
    }
}