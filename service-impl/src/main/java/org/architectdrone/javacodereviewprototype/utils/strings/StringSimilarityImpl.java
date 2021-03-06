package org.architectdrone.javacodereviewprototype.utils.strings;
/*
 * Description
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.architectdrone.javacodereviewprototype.utils.common.CommonUtils;

import javax.inject.Inject;


public class StringSimilarityImpl implements StringSimilarity {
    CommonUtils commonUtils;

    @Inject
    public StringSimilarityImpl(CommonUtils commonUtils)
    {
        this.commonUtils = commonUtils;
    }

    /**
     * Creates a list of n-grams.
     * IE, "hello", n = 3 -> ["hel","ell","llo"]
     * @param string The string to n-gram
     * @param n the "n" in "n-gram"
     * @return List of nGrams
     */
    Collection<String> getNGrams(String string, int n) {
        List<String> toReturn = new ArrayList<>();
        if (string.length() < n)
        {
            return Collections.singletonList(string);
        }
        for (int i = 0; i <= string.length()-n; i++) {
            toReturn.add(string.substring(i, i + n));
        }
        return toReturn;
    }

    /**
     * Gets the similarity of two lists of n-grams.
     * Result is in the range 0 <= x <= 2.
     * If a and b are both empty, return 2 (they are the same, after all ;) )
     * @param a The first n-gram
     * @param b The second n-gram
     * @return The similarity score
     */
    float getNGramsSimilarity(Collection<String> a, Collection<String> b)
    {
        if (a.isEmpty() && b.isEmpty())
        {
            return 2;
        }
        return (float) (2*commonUtils.getIntersection(a, b).size()) / (commonUtils.getUnion(a, b).size());
    }

    /**
     * Gets string similarity using n-gram method.
     * Will be 0 <= x <= 2.
     * @param a The first string
     * @param b The second string
     * @param n The "n" in "n-gram"
     * @return The similarity.
     */
    @Override
    public float getStringSimilarity(String a, String b, int n)
    {
        return getNGramsSimilarity(getNGrams(a, n), getNGrams(b, n));
    }
}
