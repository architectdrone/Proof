package org.architectdrone.javacodereviewprototype.context.language;

import org.architectdrone.javacodereviewprototype.tree.DiffTree;

/*
 * A Language Context allows for the parsing of some language.
 */
public interface LanguageContext {
    /**
     * @return The file extension that this language context deals with
     */
    String getFileExtension();

    /**
     * Create a {@link DiffTree} from a file.
     * @param <L> Label type.
     * @param file The text of some file.
     * @param isOriginal
     * @return The parsed file.
     */
    <L> DiffTree<L> parse(String file, Boolean isOriginal);
}
