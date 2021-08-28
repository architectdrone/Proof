package org.architectdrone.javacodereviewprototype.dependencyinjection;

import com.google.inject.AbstractModule;
import org.architectdrone.javacodereviewprototype.tree.ChangeDistillationTreeMatchImpl;
import org.architectdrone.javacodereviewprototype.tree.PopulateDiffTree;
import org.architectdrone.javacodereviewprototype.tree.PopulateDiffTreeImpl;
import org.architectdrone.javacodereviewprototype.tree.TreeMatch;
import org.architectdrone.javacodereviewprototype.utils.common.CommonUtils;
import org.architectdrone.javacodereviewprototype.utils.common.CommonUtilsImpl;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarity;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarityImpl;

public class DefaultModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(StringSimilarity.class).to(StringSimilarityImpl.class);
        bind(CommonUtils.class).to(CommonUtilsImpl.class);
        bind(TreeMatch.class).to(ChangeDistillationTreeMatchImpl.class);
        bind(PopulateDiffTree.class).to(PopulateDiffTreeImpl.class);
    }
}
