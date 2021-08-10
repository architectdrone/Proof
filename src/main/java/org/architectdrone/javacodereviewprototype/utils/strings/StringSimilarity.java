package org.architectdrone.javacodereviewprototype.utils.strings;

/**
 * Tools for comparing strings.
 */
public interface StringSimilarity {
    /**
     * Gets string similarity.
     * Will be 0 <= x <= 2.
     * @param a The first string
     * @param b The second string
     * @param n The "n" in "n-gram"
     * @return The similarity.
     */
    float getStringSimilarity(String a, String b, int n);
}
