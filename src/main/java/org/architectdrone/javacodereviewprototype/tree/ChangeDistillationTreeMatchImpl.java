package org.architectdrone.javacodereviewprototype.tree;

import com.github.javaparser.utils.Pair;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.var;
import org.architectdrone.javacodereviewprototype.utils.common.CommonUtils;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarity;

/**
 * Tools for {@link ChangeDistillationTreeMatch}.
 * Methods are kept here so they can be tested without cluttering the API.
 */
public class ChangeDistillationTreeMatchImpl implements ChangeDistillationTreeMatch {
    public static int N = 3; //"n" in "n-grams"
    public static int STRING_SIMILARITY_THRESHOLD = 1; //Strings with a similarity lower than this number will be considered not matching.
    public static int SMALL_SUBTREE_SIZE = 4; //What size is a "small" subtree. Fluri recommends 4.
    public static float SMALL_SUBTREE_SIMILARITY_THRESHOLD = (float) 0.4; //Small subtrees with a similarity lower than this are considered not matching. Fluri recommends 0.4.
    public static float LARGE_SUBTREE_SIMILARITY_THRESHOLD = (float) 0.6; //Small subtrees with a similarity lower than this are considered not matching. Fluri recommends 0.6.
    StringSimilarity stringSimilarity;
    CommonUtils commonUtils;
    @Inject
    public ChangeDistillationTreeMatchImpl(StringSimilarity stringSimilarity, CommonUtils commonUtils)
    {
        this.stringSimilarity = stringSimilarity;
        this.commonUtils = commonUtils;
    }

    /**{@inheritDoc} */
    @Override
    public <L> void matchTrees(ChangeDistillationTree<L> treeA, ChangeDistillationTree<L> treeB) {
        List<ChangeDistillationTree<L>> leavesA = treeA.getLeaves();
        List<ChangeDistillationTree<L>> leavesB = treeB.getLeaves();

        var scoredPotentialLeafMatches = scorePotentialLeafMatches(leavesA, leavesB, STRING_SIMILARITY_THRESHOLD, N);
        matchLeafNodes(scoredPotentialLeafMatches);
    }

    /**
     * Matches leaf nodes to a best matching leaf node.
     * @param scoredPotentialMatches A list of potential matches with a corresponding score.
     * @param <L> Label type
     */
    public <L> void matchLeafNodes(Map<Pair<ChangeDistillationTree<L>, ChangeDistillationTree<L>>, Float> scoredPotentialMatches)
    {
        scoredPotentialMatches
                .entrySet()
                .stream()
                .sorted((m1, m2) -> Float.compare(m2.getValue(), m1.getValue()))
                .map(Map.Entry::getKey)
                .filter(potentialMatch -> !potentialMatch.a.isMatched())
                .filter(potentialMatch -> !potentialMatch.b.isMatched())
                .forEach(match -> match.a.setMatch(match.b));
    }

    /**
     * Score potential matches of leaves.
     * @param leavesA Leaves from tree a
     * @param leavesB Leaves from tree b.
     * @param minimumSimilarity The minimum similarity between nodes to be considered a possibility
     * @param n The n in the n-grams for string similarity comparisons.
     * @param <L> Label type
     * @return A list of scored potential matches.
     */
    public <L> Map<Pair<ChangeDistillationTree<L>, ChangeDistillationTree<L>>, Float> scorePotentialLeafMatches(
            List<ChangeDistillationTree<L>> leavesA,
            List<ChangeDistillationTree<L>> leavesB,
            float minimumSimilarity,
            int n)
    {

        return leavesA
                .stream()
                .flatMap(la -> leavesB.stream().map(lb -> new Pair<>(la, lb)))
                .filter(p -> p.a.getLabel().equals(p.b.getLabel()))
                .map(p -> new Pair<>(p, stringSimilarity.getStringSimilarity(p.a.getValue(), p.b.getValue(), n)))
                .filter(p -> p.b > minimumSimilarity)
                .collect(Collectors.toMap(p -> p.a, p -> p.b));
    }

    /**
     * Performs the inner node matching step.
     * @param innerNodesA The inner nodes of A. (MUST BE POSTORDER!)
     * @param innerNodesB The inner nodes of B. (MUST BE POSTORDER!)
     * @param stringSimilarityThreshold See STRING_SIMILARITY_THRESHOLD
     * @param smallSubtreeSize See SMALL_SUBTREE_SIZE
     * @param smallSubtreeSimilarityThreshold See SMALL_SUBTREE_SIMILARITY_THRESHOLD
     * @param largeSubtreeSimilarityThreshold See LARGE_SUBTREE_SIMILARITY_THRESHOLD
     * @param <L> Label type.
     */
    public <L> void matchInnerNodes(List<ChangeDistillationTree<L>> innerNodesA, List<ChangeDistillationTree<L>> innerNodesB, float stringSimilarityThreshold,
                                    int smallSubtreeSize,
                                    float smallSubtreeSimilarityThreshold,
                                    float largeSubtreeSimilarityThreshold) {
        for (ChangeDistillationTree<L> innerNodeA : innerNodesA)
        {
            if (innerNodeA.isMatched())
            {
                continue;
            }
            for (ChangeDistillationTree<L> innerNodeB : innerNodesB)
            {
                if (doInnerNodesMatch(innerNodeA, innerNodeB, stringSimilarityThreshold, smallSubtreeSize, smallSubtreeSimilarityThreshold, largeSubtreeSimilarityThreshold))
                {
                    innerNodeA.setMatch(innerNodeB);
                }
            }
        }
    }

    /**
     * Tells whether two nodes match.
     * @param innerNodeA The original node
     * @param innerNodeB The modified node
     * @param stringSimilarityThreshold See STRING_SIMILARITY_THRESHOLD
     * @param smallSubtreeSize See SMALL_SUBTREE_SIZE
     * @param smallSubtreeSimilarityThreshold See SMALL_SUBTREE_SIMILARITY_THRESHOLD
     * @param largeSubtreeSimilarityThreshold See LARGE_SUBTREE_SIMILARITY_THRESHOLD
     * @param <L> Label type
     * @return Whether the nodes match
     */
    public <L> boolean doInnerNodesMatch(
            ChangeDistillationTree<L> innerNodeA,
            ChangeDistillationTree<L> innerNodeB,
            float stringSimilarityThreshold,
            int smallSubtreeSize,
            float smallSubtreeSimilarityThreshold,
            float largeSubtreeSimilarityThreshold)
    {
        if (!innerNodeA.getLabel().equals(innerNodeB.getLabel()))
        {
            return false;
        }
        if (stringSimilarity.getStringSimilarity(innerNodeA.getValue(), innerNodeB.getValue(), N) < stringSimilarityThreshold)
        {
            return false;
        }
        Pair<Float, Integer> result = innerNodeSimilarityScoreAndMinSize(innerNodeA, innerNodeB);
        float innerNodeSimilarityScore = result.a;
        int minSize = result.b;

        float t = (minSize <= smallSubtreeSize ? smallSubtreeSimilarityThreshold : largeSubtreeSimilarityThreshold);
        return innerNodeSimilarityScore > t;
    }

    /**
     * Call this when you don't need all the min size
     * @param innerNodeA The original node.
     * @param innerNodeB The modified node
     * @param <L> The label
     * @return innerNodeSimilarityScore
     */
    public <L> float innerNodeSimilarityScore(ChangeDistillationTree<L> innerNodeA, ChangeDistillationTree<L> innerNodeB)
    {
        return innerNodeSimilarityScoreAndMinSize(innerNodeA, innerNodeB).a;
    }

    /**
     * Calculates inner node similarity score and minimum tree size
     * @param innerNodeA The original node.
     * @param innerNodeB The modified node
     * @param <L> The label
     * @return innerNodeSimilarityScore (first) and minimum tree size (second)
     */
    public <L> Pair<Float, Integer> innerNodeSimilarityScoreAndMinSize(ChangeDistillationTree<L> innerNodeA, ChangeDistillationTree<L> innerNodeB)
    {
        List<ChangeDistillationTree<L>> allNodesInA = innerNodeA
                .getDescendants(true);
        List<ChangeDistillationTree<L>> allNodesInB = innerNodeB
                .getDescendants(true);
        List<ChangeDistillationTree<L>> allMatchingNodesInA =
                allNodesInA
                        .stream()
                        .filter(ChangeDistillationTree::isMatched)
                        .map(ChangeDistillationTree::getMatch)
                        .collect(Collectors.toList());
        int intersectingNodes = commonUtils.getIntersection(allMatchingNodesInA, allNodesInB).size();
        int maximumNodes = Math.max(allNodesInA.size(), allNodesInB.size());
        float score = (float) intersectingNodes/maximumNodes;
        int minSize = Math.min(allNodesInA.size(), allNodesInB.size());
        return new Pair<>(score, minSize);
    }
}
