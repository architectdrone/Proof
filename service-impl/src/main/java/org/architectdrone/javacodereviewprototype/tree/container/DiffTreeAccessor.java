package org.architectdrone.javacodereviewprototype.tree.container;

import lombok.AllArgsConstructor;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Provides a quick and easy way to access DiffTrees
 */
@AllArgsConstructor
public class DiffTreeAccessor<L> {
    List<DiffTree<L>> diffTrees;

    public DiffTreeAccessor(DiffTree<L> parent)
    {
        this(parent.getChildren());
    }

    public DiffTreeAccessor<L> withIndex(int index) {
        return new DiffTreeAccessor<>(
                diffTrees
                .stream()
                .filter(a -> a.getChildNumber() == index)
                .collect(Collectors.toList())
        );
    }

    public DiffTreeAccessor<L> withLabel(L label) {
        return new DiffTreeAccessor<>(
                diffTrees
                .stream()
                .filter(a -> a.getLabel() == label)
                .collect(Collectors.toList())
        );
    }

    public Set<Integer> getUniqueIndexes() {
            return diffTrees
                .stream()
                .map(DiffTree::getChildNumber)
                .collect(Collectors.toSet());
    }

    public Set<L> getLabels() {
        return diffTrees
                .stream()
                .map(DiffTree::getLabel)
                .collect(Collectors.toSet());
    }

    public int getNumberOfUniqueIndexes() {
        return getUniqueIndexes().size();
    }

    public int getNumberOfTrees() {
        return diffTrees.size();
    }

    public int getNumberOfLabels() {
        return getLabels().size();
    }

    public boolean isLabelDual() {
        return isDual() && getNumberOfLabels() == 1;
    }

    public boolean isDual() {
        return getNumberOfTrees() == 2 && getNumberOfUniqueIndexes() == 1;
    }

    public boolean isSingleton() {
        return getNumberOfTrees() == 1;
    }

    public DiffTree<L> getOnly() {
        assert isSingleton();
        return diffTrees.get(0);
    }

    public DiffTree<L> getPositiveOfDual() {
        assert isDual();
        Optional<DiffTree<L>> diffTree = diffTrees
                .stream()
                .filter(a -> a.getReferenceType().getLinesCreated() == 1)
                .findFirst();
        if (diffTree.isPresent())
        {
            return diffTree.get();
        }
        else {
            throw new RuntimeException("No positive exists");
        }
    }

    public DiffTree<L> getNegativeOfDual() {
        assert isDual();
        Optional<DiffTree<L>> diffTree = diffTrees
                .stream()
                .filter(a -> a.getReferenceType().getLinesCreated() == -1)
                .findFirst();
        if (diffTree.isPresent())
        {
            return diffTree.get();
        }
        else {
            throw new RuntimeException("No negative exists");
        }
    }
}
