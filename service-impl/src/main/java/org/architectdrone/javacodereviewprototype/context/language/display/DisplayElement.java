package org.architectdrone.javacodereviewprototype.context.language.display;

import org.architectdrone.javacodereviewprototype.context.language.LanguageContext;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;

/**
 * A command given to a program about how to display something.
 * <p>
 * The result of running the parser is a {@link DiffTree}. While the problem of finding a diff is solved by this point,
 * we still need to display the information to the client in a way they understand. We *could* show the {@link DiffTree}
 * itself, but we can't expect people to understand how to read the AST.
 * <p>
 * Instead, we convert the AST back into a form the consumers will be familiar with - actual code. This "reverse parsing"
 * also allows us to define how all code will be displayed, meaning that it will all be presented in the same way (no pedantic
 * differences)
 * <p>
 * Here's how it will work. Every DiffTree will correspond to exactly one List of DisplayElements. Some of these elements
 * will be strings and control characters -- for example, new lines and tab increases. Other DisplayElements will themselves
 * be list of DisplayElements, allowing for a recursive structure.
 */
public interface DisplayElement {
}
