package org.architectdrone.javacodereviewprototype.utils;

import com.google.inject.Inject;

public class StringSimilarity {
    final StringSimilarityUtils utils;

    @Inject
    public StringSimilarity(StringSimilarityUtils utils) {
        this.utils = utils;
    }
    /**
     * Gets string similarity using n-gram method.
     * Will be 0 <= x <= 2.
     * @param a The first string
     * @param b The second string
     * @param n The "n" in "n-gram"
     * @return The similarity.
     */
    public float getStringSimilarity(String a, String b, int n)
    {
        return utils.getNGramsSimilarity(utils.getNGrams(a, n), utils.getNGrams(b, n));
    }
}
