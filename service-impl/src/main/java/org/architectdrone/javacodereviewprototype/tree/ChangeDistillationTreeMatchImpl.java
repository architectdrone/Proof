package org.architectdrone.javacodereviewprototype.tree;

import com.github.javaparser.utils.Pair;
import com.google.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;
import org.architectdrone.javacodereviewprototype.utils.common.CommonUtils;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarity;

/**
 * Implements {@link TreeMatch} using Change Distillation.
 * The algorithm described here is almost exactly the algorithm described by Fluri et. al. in "Change Distilling".
 * @see <a href="https://www.researchgate.net/publication/3189787_Change_DistillingTree_Differencing_for_Fine-Grained_Source_Code_Change_Extraction">Change Distilling:Tree Differencing for Fine-Grained Source Code Change Extraction</a>
 */
public class ChangeDistillationTreeMatchImpl implements TreeMatch {
    private static final int N = 3; //"n" in "n-grams"
    private static final int STRING_SIMILARITY_THRESHOLD = 1; //Strings with a similarity lower than this number will be considered not matching.
    private static final int SMALL_SUBTREE_SIZE = 4; //What size is a "small" subtree. Fluri recommends 4.
    private static final float SMALL_SUBTREE_SIMILARITY_THRESHOLD = (float) 0.4; //Small subtrees with a similarity lower than this are considered not matching. Fluri recommends 0.4.
    private static final float LARGE_SUBTREE_SIMILARITY_THRESHOLD = (float) 0.6; //Small subtrees with a similarity lower than this are considered not matching. Fluri recommends 0.6.

    final StringSimilarity stringSimilarity;
    final CommonUtils commonUtils;

    @Inject
    public ChangeDistillationTreeMatchImpl(StringSimilarity stringSimilarity, CommonUtils commonUtils)
    {
        this.stringSimilarity = stringSimilarity;
        this.commonUtils = commonUtils;
    }

    /**{@inheritDoc} */
    @Override
    public <L> void matchTrees(DiffTree<L> treeA, DiffTree<L> treeB) {
        matchTrees(
                treeA,
                treeB,
                STRING_SIMILARITY_THRESHOLD,
                SMALL_SUBTREE_SIZE,
                SMALL_SUBTREE_SIMILARITY_THRESHOLD,
                LARGE_SUBTREE_SIMILARITY_THRESHOLD,
                N
        );
    }

    <L> void matchTrees(
            DiffTree<L> treeA,
            DiffTree<L> treeB,
            float stringSimilarityThreshold,
            int smallSubtreeSize,
            float smallSubtreeThreshold,
            float largeSubtreeThreshold,
            int n)
    {
        treeA.setMatch(treeB);
        matchLeafNodes(treeA,
                treeB,
                stringSimilarityThreshold,
                n);

        matchInnerNodes(treeA,
                treeB,
                stringSimilarityThreshold,
                smallSubtreeSize,
                smallSubtreeThreshold,
                largeSubtreeThreshold,
                n);
    }

    /**
     * Performs the leaf matching step
     * @param treeA The original tree.
     * @param treeB The modified tree
     * @param stringSimilarityThreshold See STRING_SIMILARITY_THRESHOLD
     * @param n See N.
     * @param <L> Label type.
     */
    <L> void matchLeafNodes(DiffTree<L> treeA, DiffTree<L> treeB, float stringSimilarityThreshold, int n)
    {
        List<DiffTree<L>> leavesA = treeA.getLeaves();
        List<DiffTree<L>> leavesB = treeB.getLeaves();

        List<Pair<Pair<DiffTree<L>, DiffTree<L>>, Float>> scoredPotentialLeafMatches = scorePotentialLeafMatches(leavesA, leavesB, stringSimilarityThreshold, n);
        matchLeafNodes(scoredPotentialLeafMatches);
    }

    /**
     * Performs the inner node matching step.
     * @param treeA Original Tree.
     * @param treeB Modified Tree.
     * @param stringSimilarityThreshold See STRING_SIMILARITY_THRESHOLD
     * @param smallSubtreeSize See SMALL_SUBTREE_SIZE
     * @param smallSubtreeSimilarityThreshold See SMALL_SUBTREE_SIMILARITY_THRESHOLD
     * @param largeSubtreeSimilarityThreshold See LARGE_SUBTREE_SIMILARITY_THRESHOLD
     * @param n See N.
     * @param <L> Label type.
     */
    <L> void matchInnerNodes(DiffTree<L> treeA,
                                    DiffTree<L> treeB,
                                    float stringSimilarityThreshold,
                                    int smallSubtreeSize,
                                    float smallSubtreeSimilarityThreshold,
                                    float largeSubtreeSimilarityThreshold,
                                    int n) {
        List<DiffTree<L>> innerNodesA = treeA.getDescendants(false);
        List<DiffTree<L>> innerNodesB = treeB.getDescendants(false);

        for (DiffTree<L> innerNodeA : innerNodesA)
        {
            if (innerNodeA.isMatched())
            {
                continue;
            }
            for (DiffTree<L> innerNodeB : innerNodesB)
            {
                if (innerNodeB.isMatched())
                {
                    continue;
                }
                if (doInnerNodesMatch(innerNodeA, innerNodeB, stringSimilarityThreshold, smallSubtreeSize, smallSubtreeSimilarityThreshold, largeSubtreeSimilarityThreshold, n))
                {
                    innerNodeA.setMatch(innerNodeB);
                    break;
                }
            }
        }
    }

    /**
     * Matches leaf nodes to a best matching leaf node.
     * @param scoredPotentialMatches A list of potential matches with a corresponding score.
     * @param <L> Label type
     */
    <L> void matchLeafNodes(List<Pair<Pair<DiffTree<L>, DiffTree<L>>, Float>> scoredPotentialMatches)
    {
        scoredPotentialMatches
                .stream()
                .sorted((m1, m2) -> Float.compare(m2.b, m1.b))
                .map(p -> p.a)
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
    <L> List<Pair<Pair<DiffTree<L>, DiffTree<L>>, Float>> scorePotentialLeafMatches(
            List<DiffTree<L>> leavesA,
            List<DiffTree<L>> leavesB,
            float minimumSimilarity,
            int n)
    {

        return leavesA
                .stream()
                .flatMap(la -> leavesB.stream().map(lb -> new Pair<>(la, lb)))
                .filter(p -> p.a.getLabel().equals(p.b.getLabel()))
                .map(p -> new Pair<>(p, stringSimilarity.getStringSimilarity(p.a.getValue(), p.b.getValue(), n)))
                .filter(p -> p.b > minimumSimilarity)
                .collect(Collectors.toList());
    }

    /**
     * Tells whether two nodes match.
     * @param innerNodeA The original node
     * @param innerNodeB The modified node
     * @param stringSimilarityThreshold See STRING_SIMILARITY_THRESHOLD
     * @param smallSubtreeSize See SMALL_SUBTREE_SIZE
     * @param smallSubtreeSimilarityThreshold See SMALL_SUBTREE_SIMILARITY_THRESHOLD
     * @param largeSubtreeSimilarityThreshold See LARGE_SUBTREE_SIMILARITY_THRESHOLD
     * @param n See N
     * @param <L> Label type
     * @return Whether the nodes match
     */
    <L> boolean doInnerNodesMatch(
            DiffTree<L> innerNodeA,
            DiffTree<L> innerNodeB,
            float stringSimilarityThreshold,
            int smallSubtreeSize,
            float smallSubtreeSimilarityThreshold,
            float largeSubtreeSimilarityThreshold,
            int n)
    {
        if (!innerNodeA.getLabel().equals(innerNodeB.getLabel()))
        {
            return false;
        }
        if (stringSimilarity.getStringSimilarity(innerNodeA.getValue(), innerNodeB.getValue(), n) < stringSimilarityThreshold)
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
     * Call this when you don't need the min size
     * @param innerNodeA The original node.
     * @param innerNodeB The modified node
     * @param <L> The label
     * @return innerNodeSimilarityScore
     */
    <L> float innerNodeSimilarityScore(DiffTree<L> innerNodeA, DiffTree<L> innerNodeB)
    {
        return innerNodeSimilarityScoreAndMinSize(innerNodeA, innerNodeB).a;
    }

    /**
     * Calculates inner node similarity score and minimum tree size
     * We do both in this method because calculating minimum tree size and score both depend on the same costly operations.
     * @param innerNodeA The original node.
     * @param innerNodeB The modified node
     * @param <L> The label
     * @return innerNodeSimilarityScore (first) and minimum tree size (second)
     */
    <L> Pair<Float, Integer> innerNodeSimilarityScoreAndMinSize(DiffTree<L> innerNodeA, DiffTree<L> innerNodeB)
    {
        List<DiffTree<L>> allNodesInA = innerNodeA
                .getDescendants(true);
        List<DiffTree<L>> allNodesInB = innerNodeB
                .getDescendants(true);
        List<DiffTree<L>> allMatchingNodesInA =
                allNodesInA
                        .stream()
                        .filter(DiffTree::isMatched)
                        .map(DiffTree::getMatch)
                        .collect(Collectors.toList());
        int intersectingNodes = commonUtils.getIntersection(allMatchingNodesInA, allNodesInB).size();
        int maximumNodes = Math.max(allNodesInA.size(), allNodesInB.size());
        float score = (float) intersectingNodes/maximumNodes;
        int minSize = Math.min(allNodesInA.size(), allNodesInB.size());
        return new Pair<>(score, minSize);
    }
}
