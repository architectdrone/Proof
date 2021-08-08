package org.architectdrone.JavaCodeReviewPrototype.tree;

import com.github.javaparser.utils.Pair;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.val;
import org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTree;
import org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTreeMatchImpl;
import org.architectdrone.javacodereviewprototype.utils.common.CommonUtils;
import org.architectdrone.javacodereviewprototype.utils.common.CommonUtilsImpl;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarity;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarityImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeDistillationTreeMatchImplTest {
    CommonUtils commonUtils = new CommonUtilsImpl();
    StringSimilarity stringSimilarity = new StringSimilarityImpl(commonUtils);
    ChangeDistillationTreeMatchImpl changeDistillationTreeMatchImpl = new ChangeDistillationTreeMatchImpl(stringSimilarity, commonUtils);

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
                        new ChangeDistillationTreeMatchImpl(mockStringSimilarity, commonUtils)
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
                        new ChangeDistillationTreeMatchImpl(mockStringSimilarity, commonUtils)
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
                        new ChangeDistillationTreeMatchImpl(mockStringSimilarity, commonUtils)
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
                        new ChangeDistillationTreeMatchImpl(mockStringSimilarity, commonUtils)
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
                changeDistillationTreeMatchImpl.matchLeafNodes(scores);

                assertEquals(leafC, leafA.getMatch());
                assertEquals(leafA, leafC.getMatch());
                assertFalse(leafB.isMatched());
                assertTrue(leafA.isMatched());
                assertTrue(leafC.isMatched());
            }
        }
    }

    @Nested
    class innerNodeMatchingTest
    {
        ChangeDistillationTree<String> f1;
        ChangeDistillationTree<String> e1;
        ChangeDistillationTree<String> d1;
        ChangeDistillationTree<String> c1;
        ChangeDistillationTree<String> b1;
        ChangeDistillationTree<String> a1;

        ChangeDistillationTree<String> f2;
        ChangeDistillationTree<String> e2;
        ChangeDistillationTree<String> d2;
        ChangeDistillationTree<String> c2;
        ChangeDistillationTree<String> b2;
        ChangeDistillationTree<String> a2;

        ChangeDistillationTree<String> getNode(String name, boolean original, List<ChangeDistillationTree<String>> children)
        {
            return new ChangeDistillationTree<String>("TEST", name, children, original);
        }

        /**
         * Construct 122-122 test trees. The structure is:
         *           [A1]               [A2]
         *          /   \              /   \
         *      [B1]     [C1]      [B2]     [C2]
         *     /    \             /    \
         * [D1]      [E1]     [D2]      [E2]
         */
        void setup122To122Tree()
        {
            set1Small("FOO");
            set2Small("FOO");
        }

        /**
         * Construct 122-123 test trees. The structure is:
         *           [A1]               [A2]
         *          /   \              /   \
         *      [B1]     [C1]      [B2]     [C2]
         *     /    \             /  |  \
         * [D1]      [E1]     [D2] [E2] [F2]
         */
        void setup122To123Tree()
        {
             set1Small("FOO");
             set2Large("FOO");
        }

        void set1Large(String label)
        {
            f1 = getNode("F1", true, Collections.emptyList());
            e1 = getNode("E1", true, Collections.emptyList());
            d1 = getNode("D1", true, Collections.emptyList());
            c1 = getNode("C1", true, Collections.emptyList());
            b1 = getNode("B1", true, Stream.of(e1, d1, f1).collect(Collectors.toList()));
            a1 = new ChangeDistillationTree<String>(label, "A1", Stream.of(b1, c1).collect(Collectors.toList()), true);
        }

        void set1Small(String label)
        {
            e1 = getNode("E1", true, Collections.emptyList());
            d1 = getNode("D1", true, Collections.emptyList());
            c1 = getNode("C1", true, Collections.emptyList());
            b1 = getNode("B1", true, Stream.of(e1, d1).collect(Collectors.toList()));
            a1 = new ChangeDistillationTree<String>(label, "A1", Stream.of(b1, c1).collect(Collectors.toList()), true);
        }

        /**
         * Looks like:
         * [A2]
         *  |
         * [B2]
         *  |
         * [C2]
         *  |
         * [D2]
         *  |
         * [E2]
         *  |
         * [F2]
         * @param label
         */
        void set2Long(String label)
        {
            f2 = getNode("F2", false, Collections.emptyList());
            e2 = getNode("E2", false, Collections.singletonList(f2));
            d2 = getNode("D2", false, Collections.singletonList(e2));
            c2 = getNode("C2", false, Collections.singletonList(d2));
            b2 = getNode("B2", false, Collections.singletonList(c2));
            a2 = new ChangeDistillationTree<String>(label, "A2", Collections.singletonList(b2), false);
        }

        /**
         * Looks like:
         * [A1]
         *  |
         * [B1]
         *  |
         * [C1]
         *  |
         * [D1]
         *  |
         * [E1]
         *  |
         * [F1]
         * @param label
         */
        void set1Long(String label)
        {
            f1 = getNode("F1", true, Collections.emptyList());
            e1 = getNode("E1", true, Collections.singletonList(f1));
            d1 = getNode("D1", true, Collections.singletonList(e1));
            c1 = getNode("C1", true, Collections.singletonList(d1));
            b1 = getNode("B1", true, Collections.singletonList(c1));
            a1 = new ChangeDistillationTree<String>(label, "A1", Collections.singletonList(b1), true);
        }

        void set2Large(String label)
        {
            f2 = getNode("F2", false, Collections.emptyList());
            e2 = getNode("E2", false, Collections.emptyList());
            d2 = getNode("D2", false, Collections.emptyList());
            c2 = getNode("C2", false, Collections.emptyList());
            b2 = getNode("B2", false, Stream.of(e2, d2, f2).collect(Collectors.toList()));
            a2 = new ChangeDistillationTree<String>(label, "A2", Stream.of(b2, c2).collect(Collectors.toList()), false);
        }

        void set2Small(String label)
        {
            e2 = getNode("E2", false, Collections.emptyList());
            d2 = getNode("D2", false, Collections.emptyList());
            c2 = getNode("C2", false, Collections.emptyList());
            b2 = getNode("B2", false, Stream.of(e2, d2).collect(Collectors.toList()));
            a2 = new ChangeDistillationTree<String>(label, "A2", Stream.of(b2, c2).collect(Collectors.toList()), false);
        }

        @Nested
        class innerNodeSimilarityScoreTest
        {
            @Test
            void whenSomeMatch()
            {
                setup122To122Tree();

                /*
                 * Construct relationships
                 * D1 => D2
                 * C1 => C2
                 */
                d1.setMatch(d2);
                c1.setMatch(c2);

                float score = changeDistillationTreeMatchImpl.innerNodeSimilarityScore(b1, b2);

                /*
                 * Comparing on b:
                 * Common nodes = 1
                 * Max nodes under trees = 2
                 * Score = 1/2
                 */
                assertEquals((float) 1/2, score);
            }

            @Test
            void whenAllMatch()
            {
                setup122To122Tree();

                /*
                 * Construct relationships
                 * D1 => D2
                 * E1 => E2
                 */
                d1.setMatch(d2);
                e1.setMatch(e2);

                float score = changeDistillationTreeMatchImpl.innerNodeSimilarityScore(b1, b2);

                /*
                 * Comparing on b:
                 * Common nodes = 2
                 * Max nodes under trees = 2
                 * Score = 1
                 */
                assertEquals(1, score);
            }

            @Test
            void whenSomeMatchOutside()
            {
                setup122To122Tree();

                /*
                 * Construct relationships
                 * D1 => C2
                 */
                d1.setMatch(c2);

                float score = changeDistillationTreeMatchImpl.innerNodeSimilarityScore(b1, b2);

                /*
                 * Comparing on b:
                 * Common nodes = 0
                 * Max nodes under trees = 2
                 * Score = 0/2 = 0
                 */
                assertEquals(0, score);
            }

            @Test
            void whenSubtreeSizeMismatch()
            {
                setup122To123Tree();

                /*
                 * Construct relationships
                 * D1 => C2
                 */
                d1.setMatch(d2);

                float score = changeDistillationTreeMatchImpl.innerNodeSimilarityScore(b1, b2);

                /*
                 * Comparing on b:
                 * Common nodes = 1
                 * Max nodes under trees = 3
                 * Score = 1/3
                 */
                assertEquals((float) 1/3, score);
            }

            @Test
            void whenNoneMatch()
            {
                setup122To122Tree();

                float score = changeDistillationTreeMatchImpl.innerNodeSimilarityScore(b1, b2);

                /*
                 * Comparing on b:
                 * Common nodes = 0
                 * Max nodes under trees = 2
                 * Score = 0/2 = 0
                 */
                assertEquals(0, score);
            }
        }

        @Nested
        class doInnerNodesMatchTest
        {
            float MOCK_STRING_SIMILARITY_THRESHOLD = 1.0f;
            int MOCK_SMALL_SUBTREE_SIZE = 4;
            float MOCK_SMALL_SUBTREE_THRESHOLD = 0.4f;
            float MOCK_LARGE_SUBTREE_THRESHOLD = 0.6f;
            void setAllDescendantsToMatch()
            {
                if (f1 != null && f2 != null)
                {
                    f1.setMatch(f2);
                }
                e1.setMatch(e2);
                d1.setMatch(d2);
                c1.setMatch(c2);
                b1.setMatch(b2);
            }

            /**
             * Creates a mock string similarity with the given difference from the mock threshold
             * @param difference difference from the threshold
             */
            StringSimilarity getStringSimilarity(float difference)
            {
                return StringSimilarityMockFactory
                        .builder()
                        .aString(a1.getValue())
                        .bString(a2.getValue())
                        .result(difference+ MOCK_STRING_SIMILARITY_THRESHOLD)
                        .build()
                        .getMockStringSimilarity();
            }

            @Test
            void whenLabelsDoNotMatch_NodesDoNotMatch()
            {
                set1Small("LABEL");
                set2Large("OTHER LABEL");
                setAllDescendantsToMatch();
                StringSimilarity mockStringSimilarity = getStringSimilarity(0.1f);

                changeDistillationTreeMatchImpl = new ChangeDistillationTreeMatchImpl(mockStringSimilarity, commonUtils);

                assertFalse(changeDistillationTreeMatchImpl.doInnerNodesMatch(
                        a1,
                        a2,
                        MOCK_STRING_SIMILARITY_THRESHOLD,
                        MOCK_SMALL_SUBTREE_SIZE,
                        MOCK_SMALL_SUBTREE_THRESHOLD,
                        MOCK_LARGE_SUBTREE_THRESHOLD));
            }

            @Test
            void whenValuesDoNotMatch_NodesDoNotMatch()
            {
                set1Small("LABEL");
                set2Large("LABEL");
                setAllDescendantsToMatch();
                StringSimilarity mockStringSimilarity = getStringSimilarity(-0.1f);

                changeDistillationTreeMatchImpl = new ChangeDistillationTreeMatchImpl(mockStringSimilarity, commonUtils);

                assertFalse(changeDistillationTreeMatchImpl.doInnerNodesMatch(
                        a1,
                        a2,
                        MOCK_STRING_SIMILARITY_THRESHOLD,
                        MOCK_SMALL_SUBTREE_SIZE,
                        MOCK_SMALL_SUBTREE_THRESHOLD,
                        MOCK_LARGE_SUBTREE_THRESHOLD));
            }

            @CsvSource({
                    "true, true, false, false",
                    "true, true, true, false",
                    "true, true, true, true",
                    "true, false, false, false",
                    "true, false, true, false",
                    "true, false, true, true",
                    "false, true, false, false",
                    "false, true, true, false",
                    "false, true, true, true",
                    "false, false, false, false",
                    "false, false, true, false",
                    "false, false, true, true",

            })
            @ParameterizedTest
            void similarityTests(boolean small1, boolean small2, boolean aboveSmallThreshold, boolean aboveLargeThreshold)
            {
                boolean mustBeAboveLarge = !small1 && !small2;
                boolean doMatch = (mustBeAboveLarge && aboveLargeThreshold) || (!mustBeAboveLarge && aboveSmallThreshold);
                if (small1)
                {
                    set1Small("LABEL");
                }
                else
                {
                    set1Large("LABEL");
                }

                if (small2)
                {
                    set2Small("LABEL");
                }
                else
                {
                    set2Large("LABEL");
                }

                b1.setMatch(b2);
                float score = changeDistillationTreeMatchImpl.innerNodeSimilarityScore(a1, a2);
                float mockSmallThreshold = 0f;
                float mockLargeThreshold = 0f;
                if (aboveSmallThreshold)
                {
                    mockSmallThreshold = score - 0.2f;
                    if (aboveLargeThreshold)
                    {
                        mockLargeThreshold = score - 0.1f;
                    }
                    else
                    {
                        mockLargeThreshold = score + 0.1f;
                    }
                }
                else
                {
                    mockSmallThreshold = score + 0.1f;
                    mockLargeThreshold = score + 0.2f;
                }

                StringSimilarity mockStringSimilarity = getStringSimilarity(0.1f);
                changeDistillationTreeMatchImpl = new ChangeDistillationTreeMatchImpl(mockStringSimilarity, commonUtils);

                boolean actualDoMatch = changeDistillationTreeMatchImpl.doInnerNodesMatch(
                        a1,
                        a2,
                        MOCK_STRING_SIMILARITY_THRESHOLD,
                        4,
                        mockSmallThreshold,
                        mockLargeThreshold);

                assertEquals(actualDoMatch,
                    doMatch);
            }
        }

        @Nested
        class matchInnerNodes
        {
            @Test
            void whenMultiplePossibleUnmatchedNodesExistInModified_choosesFirst()
            {
                set1Large("Foo");
                set2Long("Foo");

                //In this experiment, we want B1 => B2 and B1 => D2 as possible options.
                //We can consider just these cases by setting string similarity to only be the same for these nodes
                //We also set the subtree thresholds to be negative, so as to allow all subtrees to be considered.

                StringSimilarity mockStringSimilarity = StringSimilarityMockFactory
                        .builder()
                        .aString(b1.getValue())
                        .bString(d2.getValue())
                        .result(1.0f)
                        .aString(b1.getValue())
                        .bString(b2.getValue())
                        .result(1.0f)
                        .build()
                        .getMockStringSimilarity();

                changeDistillationTreeMatchImpl = new ChangeDistillationTreeMatchImpl(mockStringSimilarity, commonUtils);
                changeDistillationTreeMatchImpl.matchInnerNodes(
                        a1,
                        a2,
                        0.9f,
                        4,
                        -1.0f,
                        -1.0f
                );

                assertEquals(d2, b1.getMatch());

                //Sanity checks
                assertFalse(a1.isMatched());
                assertFalse(c1.isMatched());
                assertFalse(d1.isMatched());
                assertFalse(e1.isMatched());
                assertFalse(f1.isMatched());

                assertFalse(a2.isMatched());
                assertFalse(b2.isMatched());
                assertFalse(c2.isMatched());
                assertFalse(e2.isMatched());
                assertFalse(f2.isMatched());
            }

            @Test
            void whenMultiplePossibleUnmatchedNodesExistInOriginal_choosesFirst()
            {
                set1Long("Foo");
                set2Large("Foo");

                //In this experiment, we want B1 => B2 and D1 => B2 as possible options.
                //We can consider just these cases by setting string similarity to only be the same for these nodes
                //We also set the subtree thresholds to be negative, so as to allow all subtrees to be considered.

                StringSimilarity mockStringSimilarity = StringSimilarityMockFactory
                        .builder()
                        .aString(b1.getValue())
                        .bString(b2.getValue())
                        .result(1.0f)
                        .aString(d1.getValue())
                        .bString(b2.getValue())
                        .result(1.0f)
                        .build()
                        .getMockStringSimilarity();

                changeDistillationTreeMatchImpl = new ChangeDistillationTreeMatchImpl(mockStringSimilarity, commonUtils);
                changeDistillationTreeMatchImpl.matchInnerNodes(
                        a1,
                        a2,
                        0.9f,
                        4,
                        -1.0f,
                        -1.0f
                );

                assertEquals(d1, b2.getMatch());

                //Sanity checks
                assertFalse(a1.isMatched());
                assertFalse(c1.isMatched());
                assertFalse(b1.isMatched());
                assertFalse(e1.isMatched());
                assertFalse(f1.isMatched());

                assertFalse(a2.isMatched());
                assertFalse(d2.isMatched());
                assertFalse(c2.isMatched());
                assertFalse(e2.isMatched());
                assertFalse(f2.isMatched());
            }
        }
    }
}