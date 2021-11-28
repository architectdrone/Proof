package org.architectdrone.javacodereviewprototype.context.language.display;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;

/**
 * A {@link DisplayElement} for representing other nodes. The other nodes may be represented in their *collapsed* form,
 * or in their *expanded* form. For example, the following block of code might be represented in its expanded form as
 * <pre>
 *     public static void sayHello(String name) {
 *         print("Hello, "+name);
 *     }
 * </pre>
 * ... or in it's collapsed form as
 * <pre>
 *     public static void sayHello(String name) {...}
 * </pre>
 */
@Builder
public class NodeDisplayElement implements DisplayElement {
    @Singular @Getter
    List<NodeDisplayElement> collapsedElements;
    @Singular @Getter
    List<NodeDisplayElement> expandedElements;
}
