package org.architectdrone.javacodereviewprototype.context.language.unparser;/*
 * Description
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.architectdrone.javacodereviewprototype.context.language.display.DisplayElement;

public class DisplayElementAccessor<L> {
    Set<DisplayElementAccessorElement<L>> displayElementAccessorElements;

    public DisplayElementAccessor(int index, L label, List<DisplayElement> displayElements)
    {
        displayElementAccessorElements = Collections.singleton(DisplayElementAccessorElement.
                <L>builder()
                .displayElements(displayElements)
                .label(label)
                .index(index)
                .build());
    }

    public DisplayElementAccessor(Set<DisplayElementAccessorElement<L>> displayElementAccessorElements)
    {
        this.displayElementAccessorElements = displayElementAccessorElements;
    }

    public static <A> DisplayElementAccessor<A> create(Set<DisplayElementAccessor<A>> displayElementAccessors) {
        Set<DisplayElementAccessorElement<A>> displayElementAccessorElements = new HashSet<>();
        for (DisplayElementAccessor<A> displayElementAccessor : displayElementAccessors)
        {
            displayElementAccessorElements.addAll(displayElementAccessor.getDisplayElementAccessorElements());
        }
        return new DisplayElementAccessor<>(displayElementAccessorElements);
    }

    public DisplayElementAccessor<L> withLabel(L label)
    {
        return withFilter(a -> a.getLabel() == label);
    }

    public DisplayElementAccessor<L> withLabels(L... labels) {
        return withFilter(a -> Arrays.asList(labels).contains(a.getLabel()));
    }

    public DisplayElementAccessor<L> withIndex(int index)
    {
        return withFilter(a -> a.getIndex() == index);
    }

    public List<DisplayElement> getDisplayElements()
    {
        if (displayElementAccessorElements.size() != 1)
        {
            throw new RuntimeException(MessageFormat.format("Requires 1 element, has {0}", displayElementAccessorElements.size()));
        }
        return displayElementAccessorElements.stream().findAny().get().displayElements;
    }

    public List<List<DisplayElement>> getAllDisplayElements()
    {
        return displayElementAccessorElements.stream().map(a -> a.displayElements).collect(Collectors.toList());
    }

    public List<DisplayElement> getAllDisplayElementsDelimited(List<DisplayElement> delimiter)
    {
        List<DisplayElement> toReturn = new ArrayList<>();
        for (List<DisplayElement> displayElements : getAllDisplayElements())
        {
            toReturn.addAll(displayElements);
            toReturn.addAll(delimiter);
        }
        return toReturn;
    }

    public boolean isEmpty() {
        return displayElementAccessorElements.isEmpty();
    }

    @SafeVarargs
    public final boolean contains(L... toCheck)
    {
        return !withLabels(toCheck).isEmpty();
    }

    public DisplayElementAccessor<L> getAllBefore(L label)
    {
        Optional<DisplayElementAccessorElement<L>> elementWithLabel = withLabel(label).displayElementAccessorElements.stream().findFirst();
        if (!elementWithLabel.isPresent())
        {
            throw new RuntimeException("No Element with that label exists!");
        }
        int index = elementWithLabel.get().index;

        return withFilter(a -> a.index < index);
    }

    public DisplayElementAccessor<L> getAllAfter(L label)
    {
        Optional<DisplayElementAccessorElement<L>> elementWithLabel = withLabel(label).displayElementAccessorElements.stream().findFirst();
        if (!elementWithLabel.isPresent())
        {
            throw new RuntimeException("No Element with that label exists!");
        }
        int index = elementWithLabel.get().index;

        return withFilter(a -> a.index > index);
    }

    private DisplayElementAccessor<L> withFilter(Predicate<DisplayElementAccessorElement<L>> predicate)
    {
        return new DisplayElementAccessor(displayElementAccessorElements
                .stream()
                .filter(predicate)
                .collect(Collectors.toSet()));
    }

    protected Set<DisplayElementAccessorElement<L>> getDisplayElementAccessorElements() {
        return displayElementAccessorElements;
    }
}

@Builder
@Getter
class DisplayElementAccessorElement<L> {
    int index;
    L label;
    List<DisplayElement> displayElements;
}
