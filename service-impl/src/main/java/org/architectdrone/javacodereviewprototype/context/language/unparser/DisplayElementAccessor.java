package org.architectdrone.javacodereviewprototype.context.language.unparser;/*
 * Description
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
