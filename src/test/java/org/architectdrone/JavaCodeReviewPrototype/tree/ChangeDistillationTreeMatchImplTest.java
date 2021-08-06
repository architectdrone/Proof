package org.architectdrone.JavaCodeReviewPrototype.tree;

import com.github.javaparser.utils.Pair;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.val;
import org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTree;
import org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTreeMatchImpl;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarity;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeDistillationTreeMatchImplTest {
    @Nested
    class leafMatchingTest
    {
        private ChangeDistillationTree<String> getLeaf(String label, String value, boolean isOriginal)
        {
            return new ChangeDistillationTree<String>(label, value, Collections.emptyList(), isOriginal);
        }

        @Nested
        class scorePotentialLeafMatchesTest {

            @Test
            void sameLabelAndValue_areMatched()
            {
                ChangeDistillationTree<String> leafA = getLeaf("LABEL", "value_a", true);
                ChangeDistillationTree<String> leafB = getLeaf("LABEL", "value_a", false);

                List<ChangeDistillationTree<String>> leavesA = Stream.of(
                        leafA
                ).collect(Collectors.toList());
                List<ChangeDistillationTree<String>> leavesB = Stream.of(
                        leafB
                ).collect(Collectors.toList());

                StringSimilarity mockStringSimilarity = StringSimilarityMockFactory
                        .builder()
                        .aString("value_a")
                        .bString("value_a")
                        .result((float) 1.2)
                        .build()
                        .getMockStringSimilarity();

                Map<Pair<ChangeDistillationTree<String>, ChangeDistillationTree<String>>, Float> result =
                        new ChangeDistillationTreeMatchImpl(mockStringSimilarity)
                                .scorePotentialLeafMatches(leavesA, leavesB, 1.0f, 4);

                assertTrue(result.containsKey(new Pair<>(leafA, leafB)));
                assertEquals(1.2f, result.get(new Pair<>(leafA, leafB)));
            }

            @Test
            void differentLabels_areNotMatched()
            {
                ChangeDistillationTree<String> leafA = getLeaf("LABELA", "value_a", true);
                ChangeDistillationTree<String> leafB = getLeaf("LABELB", "value_a", false);

                List<ChangeDistillationTree<String>> leavesA = Stream.of(
                        leafA
                ).collect(Collectors.toList());
                List<ChangeDistillationTree<String>> leavesB = Stream.of(
                        leafB
                ).collect(Collectors.toList());

                StringSimilarity mockStringSimilarity = StringSimilarityMockFactory
                        .builder()
                        .aString("value_a")
                        .bString("value_a")
                        .result((float) 1.2)
                        .build()
                        .getMockStringSimilarity();

                Map<Pair<ChangeDistillationTree<String>, ChangeDistillationTree<String>>, Float> result =
                        new ChangeDistillationTreeMatchImpl(mockStringSimilarity)
                                .scorePotentialLeafMatches(leavesA, leavesB, 1.0f, 4);

                assertFalse(result.containsKey(new Pair<>(leafA, leafB)));
            }

            @Test
            void lowSimilarity_areNotMatched()
            {
                ChangeDistillationTree<String> leafA = getLeaf("LABEL", "value_a", true);
                ChangeDistillationTree<String> leafB = getLeaf("LABEL", "value_b", false);

                List<ChangeDistillationTree<String>> leavesA = Stream.of(
                        leafA
                ).collect(Collectors.toList());
                List<ChangeDistillationTree<String>> leavesB = Stream.of(
                        leafB
                ).collect(Collectors.toList());

                StringSimilarity mockStringSimilarity = StringSimilarityMockFactory
                        .builder()
                        .aString("value_a")
                        .bString("value_b")
                        .result((float) 0.2)
                        .build()
                        .getMockStringSimilarity();

                Map<Pair<ChangeDistillationTree<String>, ChangeDistillationTree<String>>, Float> result =
                        new ChangeDistillationTreeMatchImpl(mockStringSimilarity)
                                .scorePotentialLeafMatches(leavesA, leavesB, 1.0f, 4);

                assertFalse(result.containsKey(new Pair<>(leafA, leafB)));
            }

            @Test
            void multipleChoices_canBeMatched()
            {
                ChangeDistillationTree<String> leafA = getLeaf("LABEL", "value_a", true);
                ChangeDistillationTree<String> leafB = getLeaf("LABEL", "value_b", false);
                ChangeDistillationTree<String> leafC = getLeaf("LABEL", "value_c", false);
                ChangeDistillationTree<String> leafD = getLeaf("LABEL", "value_d", false);

                List<ChangeDistillationTree<String>> leavesA = Stream.of(
                        leafA,
                        leafD
                ).collect(Collectors.toList());
                List<ChangeDistillationTree<String>> leavesB = Stream.of(
                        leafB,
                        leafC
                ).collect(Collectors.toList());

                StringSimilarity mockStringSimilarity = StringSimilarityMockFactory
                        .builder()
                        .aString("value_a")
                        .bString("value_b")
                        .result((float) 1.2)
                        .aString("value_a")
                        .bString("value_c")
                        .result((float) 1.4)
                        .aString("value_d")
                        .bString("value_b")
                        .result((float) 0.2)
                        .aString("value_d")
                        .bString("value_c")
                        .result((float) 0.4)
                        .build()
                        .getMockStringSimilarity();

                Map<Pair<ChangeDistillationTree<String>, ChangeDistillationTree<String>>, Float> result =
                        new ChangeDistillationTreeMatchImpl(mockStringSimilarity)
                                .scorePotentialLeafMatches(leavesA, leavesB, 1.0f, 4);

                assertTrue(result.containsKey(new Pair<>(leafA, leafB)));
                assertTrue(result.containsKey(new Pair<>(leafA, leafC)));
                assertFalse(result.containsKey(new Pair<>(leafD, leafB)));
                assertFalse(result.containsKey(new Pair<>(leafD, leafB)));
                assertEquals(1.2f, result.get(new Pair<>(leafA, leafB)));
                assertEquals(1.4f, result.get(new Pair<>(leafA, leafC)));
            }
        }

        @Nested
        class matchLeavesTest {
            @Test
            void makesBestChoice() {
                ChangeDistillationTree<String> leafA = getLeaf("LABEL", "value_a", true);
                ChangeDistillationTree<String> leafB = getLeaf("LABEL", "value_b", false);
                ChangeDistillationTree<String> leafC = getLeaf("LABEL", "value_c", false);
                val possibleMatchAB = new Pair<>(leafA, leafB);
                val possibleMatchAC = new Pair<>(leafA, leafC);
                Map<Pair<ChangeDistillationTree<String>, ChangeDistillationTree<String>>, Float> scores = new HashMap<>();
                scores.put(possibleMatchAB, (float) 1.2);
                scores.put(possibleMatchAC, (float) 1.4);
                new ChangeDistillationTreeMatchImpl(null)
                        .matchLeafNodes(scores);

                assertEquals(leafC, leafA.getMatch());
                assertEquals(leafA, leafC.getMatch());
                assertFalse(leafB.isMatched());
                assertTrue(leafA.isMatched());
                assertTrue(leafC.isMatched());
            }
        }
    }
}