package org.architectdrone.javacodereviewprototype.utils.strings;

public interface StringSimilarity {
    /**
     * Gets string similarity using n-gram method.
     * Will be 0 <= x <= 2.
     * @param a The first string
     * @param b The second string
     * @param n The "n" in "n-gram"
     * @return The similarity.
     */
    abstract float getStringSimilarity(String a, String b, int n);
}
