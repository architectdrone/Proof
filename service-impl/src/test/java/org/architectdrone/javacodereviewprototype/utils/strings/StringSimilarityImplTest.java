package org.architectdrone.javacodereviewprototype.utils.strings;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.architectdrone.javacodereviewprototype.utils.common.CommonUtilsImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSimilarityImplTest {
    StringSimilarityImpl stringSimilarity = new StringSimilarityImpl(new CommonUtilsImpl());
    @Nested
    class getNGramsTests
    {
        @Test
        void whenStringSizeIsGreaterThanN_returnsAllNGrams() {
            Collection<String> nGrams = stringSimilarity.getNGrams("backpack", 3);
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
            Collection<String> nGrams = stringSimilarity.getNGrams("hi", 3);
            assertEquals(1, nGrams.size());
            assertTrue(nGrams.contains("hi"));
        }

        @Test
        void whenStringSizeIsEqualToN_returnsString() {
            Collection<String> nGrams = stringSimilarity.getNGrams("hey", 3);
            assertEquals(1, nGrams.size());
            assertTrue(nGrams.contains("hey"));
        }
    }

    @Nested
    class getNGramsSimilarityTests
    {
        @Test
        void WhenAAndBShareAllNGrams() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("a", "b").collect(Collectors.toList());

            assertEquals(2.0, stringSimilarity.getNGramsSimilarity(a, b));
        }

        @Test
        void WhenAAndBHasAnExtraNGram() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("a", "b", "c").collect(Collectors.toList());

            assertEquals(((float) 4/3), stringSimilarity.getNGramsSimilarity(a, b));
        }

        @Test
        void WhenAAndBShareNoNGrams() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Stream.of("c", "d").collect(Collectors.toList());

            assertEquals(0, stringSimilarity.getNGramsSimilarity(a, b));
        }

        @Test
        void WhenOneHasNoNGrams() {
            List<String> a = Stream.of("a", "b").collect(Collectors.toList());
            List<String> b = Collections.emptyList();

            assertEquals(0, stringSimilarity.getNGramsSimilarity(a, b));
        }

        @Test
        void WhenBothHaveNoNGrams() {
            List<String> a = Collections.emptyList();
            List<String> b = Collections.emptyList();

            assertEquals(2, stringSimilarity.getNGramsSimilarity(a, b));
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