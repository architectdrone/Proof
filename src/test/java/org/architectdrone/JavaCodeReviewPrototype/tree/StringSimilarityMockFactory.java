package org.architectdrone.JavaCodeReviewPrototype.tree;/*
 * Description
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarity;
import org.mockito.Matchers;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Builder
public class StringSimilarityMockFactory {
    @Singular List<String> aStrings;
    @Singular List<String> bStrings;
    @Singular List<Float> results;

    public StringSimilarity getMockStringSimilarity()
    {
        StringSimilarity mockStringSimilarity = mock(StringSimilarity.class);
        for (int i = 0; i < aStrings.size(); i++) {
            when(mockStringSimilarity.getStringSimilarity(eq(aStrings.get(i)), eq(bStrings.get(i)), anyInt())).thenReturn(results.get(i));
        }
        return mockStringSimilarity;
    }
}
