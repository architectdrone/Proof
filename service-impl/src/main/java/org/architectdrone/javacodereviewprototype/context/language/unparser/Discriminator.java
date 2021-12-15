package org.architectdrone.javacodereviewprototype.context.language.unparser;

import java.util.List;
import org.architectdrone.javacodereviewprototype.tree.DiffTree;

/*
 * Returns the correct pattern to use.
 * <p>
 * Copyrights 2021. Cerner Corporation.
 * @author Pharmacy Outpatient
 */
abstract class Discriminator<L> {
    abstract UnparserPattern<L> getPattern(List<DiffTree<L>> children);
}
