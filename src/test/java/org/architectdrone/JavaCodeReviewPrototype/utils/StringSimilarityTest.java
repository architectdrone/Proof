package org.architectdrone.JavaCodeReviewPrototype.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.architectdrone.javacodereviewprototype.utils.StringSimilarity;
import org.architectdrone.javacodereviewprototype.utils.StringSimilarityUtils;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSimilarityTest {
    StringSimilarityUtils stringSimilarityUtils = new StringSimilarityUtils();
    StringSimilarity stringSimilarity = new StringSimilarity(stringSimilarityUtils);
    @Nested
    class getNGramsTests
    {
        @Test
        void whenStringSizeIsGreaterThanN_returnsAllNGrams() {
            Collection<String> nGrams = stringSimilarityUtils.getNGrams("backpack", 3);
            assertEquals(6, nGrams.size());
            assertTrue(nGrams.contains("bac"));
            assertTrue(nGrams.contains("ack"));
            assertTrue(nGrams.contains("ckp"));
            assertTrue(nGrams.contains("kpa"));
            assertTrue(nGrams.contains("pac"));
            assertTrue(nGrams.contains("ack"));
        }

        @Test
        void whenStringSizeIsLessThanN_returnsString() {
            Collection<String> nGrams = new StringSimilarityUtils().getNGrams("hi", 3);
            assertEquals(1, nGrams.size());
            assertTrue(nGrams.contains("hi"));
        }

        @Test
        void whenStringSizeIsEqualToN_returnsString() {
            Collection<String> nGrams = new StringSimilarityUtils().getNGrams("hey", 3);
            assertEquals(1, nGrams.size());
            assertTrue(nGrams.contains("hey"));
        }
    }

    @Nested
    class getUnionTests
    {
        @Test
        void whenListsDontIntersect_unionIsCorrect() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("c", "d").collect(Collectors.toList());

            Collection<String> union = new StringSimilarityUtils().getUnion(a, b);
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

            Collection<String> union = new StringSimilarityUtils().getUnion(a, b);
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

            Collection<String> intersection = new StringSimilarityUtils().getIntersection(a, b);
            assertEquals(0, intersection.size());
        }

        @Test
        void whenListsDoIntersect_unionIsCorrect() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("b", "d").collect(Collectors.toList());

            Collection<String> intersection = new StringSimilarityUtils().getIntersection(a, b);
            assertEquals(1, intersection.size());
            assertEquals(1, Collections.frequency(intersection, "b"));
        }
    }

    @Nested
    class getNGramsSimilarityTests
    {
        @Test
        void WhenAAndBShareAllNGrams() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("a", "b").collect(Collectors.toList());

            assertEquals(2.0, new StringSimilarityUtils().getNGramsSimilarity(a, b));
        }

        @Test
        void WhenAAndBHasAnExtraNGram() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("a", "b", "c").collect(Collectors.toList());

            assertEquals(((float) 4/3), new StringSimilarityUtils().getNGramsSimilarity(a, b));
        }

        @Test
        void WhenAAndBShareNoNGrams() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("c", "d").collect(Collectors.toList());

            assertEquals(0, new StringSimilarityUtils().getNGramsSimilarity(a, b));
        }

        @Test
        void WhenOneHasNoNGrams() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Collections.emptyList();

            assertEquals(0, new StringSimilarityUtils().getNGramsSimilarity(a, b));
        }

        @Test
        void WhenBothHaveNoNGrams() {
            List<String> a = Collections.emptyList();
            List<String> b = Collections.emptyList();

            assertEquals(2, new StringSimilarityUtils().getNGramsSimilarity(a, b));
        }
    }

    @Nested
    class getStringSimilarityTests
    {
        @Test
        void whenStringsAreSame()
        {
            String a = "hello";
            String b = "hello";

            assertEquals(2, stringSimilarity.getStringSimilarity(a, b, 3));
        }

        @Test
        void whenStringsAreCompletelyDifferent()
        {
            String a = "hello";
            String b = "whats";

            assertEquals(0, stringSimilarity.getStringSimilarity(a, b, 3));
        }

        @Test
        void whenStringsAreCompletelyDifferentAndDifferentLength()
        {
            String a = "hello";
            String b = "whatsup";

            assertEquals(0, stringSimilarity.getStringSimilarity(a, b, 3));
        }

        @Test
        void whenOneStringIsEmpty()
        {
            String a = "hello";
            String b = "";

            assertEquals(0, stringSimilarity.getStringSimilarity(a, b, 3));
        }

        @Test
        void whenBothStringsAreEmpty()
        {
            String a = "";
            String b = "";

            assertEquals(2, stringSimilarity.getStringSimilarity(a, b, 3));
        }

        @Test
        void whenStringsDifferByOne()
        {
            String a = "helloa";
            String b = "hellob";

            assertEquals((float) 6/5, stringSimilarity.getStringSimilarity(a, b, 3));
        }

        @Test
        void whenStringsAgreeByOne()
        {
            String a = "zzzzza";
            String b = "yyyyya";

            assertEquals(0, stringSimilarity.getStringSimilarity(a, b, 3));
        }

        @Test
        void whenStringsAreSwitched()
        {
            String a = "abcdef";
            String b = "defabc";

            assertEquals(((float) 2/3), stringSimilarity.getStringSimilarity(a, b, 3));
        }
    }
}