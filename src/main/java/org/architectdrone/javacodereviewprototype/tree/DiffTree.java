package org.architectdrone.javacodereviewprototype.tree;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Simple tree data structure with data for the matching process.
 * @param <L> The label type
 */
public class DiffTree<L> {
    //Tree data
    @Getter
    List<DiffTree<L>> children; //Children of the root node

    //Advanced tree data
    private DiffTree<L> parent;
    private int childNumber;
    @Setter private boolean hasAdvancedDataBeenPopulated;

    //Container data
    @Getter
    final L label; //The label of the root node
    @Getter
    final String value; //The value of the root node
    
    //Matching data
    @Getter
    private boolean isMatched = false; //Whether or not the root node is matched with a node from the other tree.
    @Getter
    private DiffTree<L> match; //The matching node from the other tree, if it exists.

    //Diff data
    @Getter
    final boolean isOriginal;
    @Getter @Setter
    boolean considered;
    @Getter @Setter
    DiffTree<L> referenceLocation;
    @Getter @Setter @Builder.Default
    ReferenceType referenceType = ReferenceType.NONE;
    @Getter @Setter
    String oldValue;

    /**
     * Constructs a {@link DiffTree} from some other tree type.
     * @param otherTree Root of other tree.
     * @param getChildrenOfTree Function that gets the children of the given tree type.
     * @param getValue Function that gets the value of the tree type
     * @param getLabel Function that gets the label of the tree type
     * @param <N> Other tree type.
     */
    public <N> DiffTree(N otherTree, boolean isOriginal, Function<N, List<N>> getChildrenOfTree, Function<N, String> getValue, Function<N, L> getLabel)
    {
        this.isOriginal = isOriginal;
        this.label = getLabel.apply(otherTree);
        this.value = getValue.apply(otherTree);
        this.children = new ArrayList<>();
        for (N child : getChildrenOfTree.apply(otherTree))
        {
            children.add(new DiffTree<L>(child, isOriginal, getChildrenOfTree, getValue, getLabel));
        }
    }

    public DiffTree(final L label, final String value, final List<DiffTree<L>> children, boolean isOriginal) {
        this.label = label;
        this.value = value;
        this.children = children;
        this.isOriginal = isOriginal;
    }

    /**
     * Gets the descendants of the tree.
     * @param includeLeaves Include leaves?
     * @return descendants
     */
    public List<DiffTree<L>> getDescendants(boolean includeLeaves)
    {
        List<DiffTree<L>> toReturn = new ArrayList<>();

        toReturn.addAll(children.stream().flatMap(c -> c.getDescendants(includeLeaves).stream()).collect(Collectors.toList()));
        toReturn.addAll(children.stream().filter(c -> !c.getChildren().isEmpty() || includeLeaves).collect(Collectors.toList()));
        return toReturn;
    }

    public void setMatch(DiffTree<L> match)
    {
        assert match.isOriginal() != this.isOriginal(); //We do not allow originals to match with other originals, or vice versa
        this.match = match;
        this.isMatched = true;
        if (!match.isMatched)
        {
            match.setMatch(this);
        }
    }

    public List<DiffTree<L>> getLeaves() {
        if (children.isEmpty())
        {
            return Collections.singletonList(this);
        }
        else
        {
            List<DiffTree<L>> toReturn = new ArrayList<>();
            for (DiffTree<L> child : children)
            {
                toReturn.addAll(child.getLeaves());
            }
            return toReturn;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(MessageFormat.format("[{0}] {1}:{2} => ", isOriginal ? "O" : "M", label, value));
        if (!isMatched)
        {
            builder.append("NONE ");
        }
        else {
            builder.append(MessageFormat.format("{0}:{1}", match.getLabel(), match.getValue()));
        }
        return builder.toString();
    }

    /**
     * Compares two trees, using labels, values, and children
     * @param otherTree The other tree.
     * @return Whether they match or not.
     */
    public boolean treeEquals(DiffTree<L> otherTree)
    {
        if (!getLabel().equals(otherTree.getLabel()))
        {
            return false;
        }
        else if (!getValue().equals(otherTree.getValue()))
        {
            return false;
        }
        if (getChildren().size() == 0)
        {
            return true;
        }

        if (getChildren().size() != otherTree.getChildren().size())
        {
            return false;
        }

        for (int i = 0; i < getChildren().size(); i++) {
            if (!getChildren().get(i).treeEquals(otherTree.getChildren().get(i)))
            {
                return false;
            }
        }
        return true;
    }

    public void printFullReport()
    {
        printFullReport(0);
    }

    private void printFullReport(int indentLevel)
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < indentLevel; i++) {
            builder.append("\t");
        }
        builder.append(this.toString());
        System.out.println(builder.toString());
        for (DiffTree child : getChildren())
        {
            child.printFullReport(indentLevel+1);
        }
    }

    /**
     * @return The parent of the node. Null if it has no parent.
     */
    public DiffTree<L> getParent()
    {
        if (!hasAdvancedDataBeenPopulated)
        {
            throw new RuntimeException("Advanced tree data has not been populated yet.");
        }
        return parent;
    }

    /**
     * @return The child number.
     */
    public int getChildNumber()
    {
        if (!hasAdvancedDataBeenPopulated)
        {
            throw new RuntimeException("Advanced tree data has not been populated yet.");
        }
        return childNumber;
    }

    /**
     * Sets the child number.
     * @param childNumber New child number
     */
    protected void setChildNumber(int childNumber)
    {
        this.childNumber = childNumber;
    }

    /**
     * Sets the parent.
     * @param parent New parent.
     */
    protected void setParent(DiffTree<L> parent)
    {
        this.parent = parent;
    }

    /**
     * Populates advanced data (child number and parent)
     */
    public void populateAdvancedData()
    {
        if (hasAdvancedDataBeenPopulated)
        {
            throw new RuntimeException("Advanced tree data has already been populated.");
        }

        for (int i = 0; i < getChildren().size(); i++) {
            DiffTree<L> child = getChildren().get(i);
            child.setChildNumber(i);
            child.setParent(this);
            child.populateAdvancedData();
        }

        this.hasAdvancedDataBeenPopulated = true;
    }

    /**
     * Gets all nodes on a given level of the tree.
     * @param level The level to get
     * @return
     */
    public List<DiffTree<L>> getLevel(int level)
    {
        if (level == 0)
        {
            return Collections.singletonList(this);
        }
        else
        {
            List<DiffTree<L>> toReturn = new ArrayList<>();
            for (DiffTree<L> child : getChildren())
            {
                toReturn.addAll(child.getLevel(level-1));
            }
            return toReturn;
        }
    }

    /**
     * Gets all nodes with the given child number. This may be >1 due to coinciding nodes.
     * @param childNumber The child number
     * @return List of nodes with the child number.
     */
    public List<DiffTree<L>> getChild(int childNumber)
    {
        return getChildren()
                .stream()
                .filter(t -> t.getChildNumber() == childNumber)
                .collect(Collectors.toList());
    }

    public void shiftDownAfterChild(int childNumber)
    {
        getChildren()
                .stream()
                .filter(c -> c.getChildNumber() >= childNumber)
                .filter(c -> c.getChildNumber() > 0)
                .forEach(c -> c.setChildNumber(c.getChildNumber()-1));
    }

    /**
     * Inserts a node, and shifts subsequent nodes up to account for the new node.
     * @param toInsert The node to insert.
     */
    public void insertAndShiftUp(DiffTree<L> toInsert)
    {
        getChildren()
                .stream()
                .filter(c -> c.getChildNumber() >= toInsert.getChildNumber())
                .forEach(c -> c.setChildNumber(c.getChildNumber()+1));
        //TODO: find a better way to do this!
        ArrayList<DiffTree<L>> temp = new ArrayList<>(getChildren());
        temp.add(toInsert);
        children = temp;
    }

    public void rectifyNodes()
    {
        children.sort(Comparator.comparingInt(DiffTree::getChildNumber));
        ReferenceType previousReferenceType = ReferenceType.NONE;
        int numberOfDeletes = 0;
        for (DiffTree<L> child : children)
        {
            ReferenceType currentReferenceType = child.getReferenceType();
            if (!((currentReferenceType == ReferenceType.CREATE) && (previousReferenceType == ReferenceType.DELETE)))
            {
                child.setChildNumber(child.getChildNumber()+numberOfDeletes);
            }
            if (currentReferenceType == ReferenceType.DELETE)
            {
                numberOfDeletes+=1;
            }
            previousReferenceType = currentReferenceType;
        }
    }
}
