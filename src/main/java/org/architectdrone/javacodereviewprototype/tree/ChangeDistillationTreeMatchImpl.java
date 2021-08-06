package org.architectdrone.javacodereviewprototype.tree;

import com.github.javaparser.utils.Pair;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.var;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarity;

import static org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTreeMatch.N;
import static org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTreeMatch.STRING_SIMILARITY_THRESHOLD;

/**
 * Tools for {@link ChangeDistillationTreeMatch}.
 * Methods are kept here so they can be tested without cluttering the API.
 */
public class ChangeDistillationTreeMatchImpl implements ChangeDistillationTreeMatch {
    StringSimilarity stringSimilarity;

    @Inject
    public ChangeDistillationTreeMatchImpl(StringSimilarity stringSimilarity)
    {
        this.stringSimilarity = stringSimilarity;
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
}
