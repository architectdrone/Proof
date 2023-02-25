package org.architectdrone.javacodereviewprototype.server;

import org.architectdrone.javacodereviewprototype.tree.*;
import org.architectdrone.javacodereviewprototype.utils.common.CommonUtils;
import org.architectdrone.javacodereviewprototype.utils.common.CommonUtilsImpl;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarity;
import org.architectdrone.javacodereviewprototype.utils.strings.StringSimilarityImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DiffController {
    TreeMatch treeMatch;
    PopulateDiffTree populateDiffTree;
    @Inject
    public DiffController() {
        CommonUtils commonUtils = new CommonUtilsImpl();
        StringSimilarity stringSimilarity = new StringSimilarityImpl(commonUtils);
        this.treeMatch = new ChangeDistillationTreeMatchImpl(stringSimilarity, commonUtils);
        this.populateDiffTree = new PopulateDiffTreeImpl();
    }
    @GetMapping("/diff")
    @ResponseBody
    public DiffAST getDiff(@RequestBody DiffRequest diffRequest) {
        DiffTree<String> originalDiffTree = constructDiffTreeFromAST(diffRequest.original, true);
        DiffTree<String> modifiedDiffTree = constructDiffTreeFromAST(diffRequest.modified, false);
        this.treeMatch.matchTrees(originalDiffTree, modifiedDiffTree);
        this.populateDiffTree.populateDiffTree(originalDiffTree, modifiedDiffTree);
        return constructDiffASTFromDiffTree(originalDiffTree);
    }

    private DiffTree<String> constructDiffTreeFromAST(AST ast, boolean original) {
        return new DiffTree<String>(ast, original, (a -> a.children), (a -> a.value), (a -> a.label));
    }

    private DiffAST constructDiffASTFromDiffTree(DiffTree<String> root) {
        DiffAST toReturn = new DiffAST();
        toReturn.label = root.getLabel();
        toReturn.value = root.getValue();
        toReturn.oldValue = root.getOldValue();
        toReturn.referenceType = ReferenceTypeToString(root.getReferenceType());
        toReturn.children = getSortedListOfChildren(root).stream().map(this::constructDiffASTFromDiffTree).collect(Collectors.toList());
        return toReturn;
    }

    private List<DiffTree<String>> getSortedListOfChildren(DiffTree<String> root) {
        if (root.getReferenceType() == ReferenceType.MOVE_FROM)
        {
            return getSortedListOfChildren(root.getReferenceLocation());
        }
        List<DiffTree<String>> toReturn = new ArrayList<>();
        DiffTree<String> current = root.getFirst();
        while (true) {
            if (current != null) {
                toReturn.add(current);
                current = current.getNext();
            }
            else {
                break;
            }
        }
        return toReturn;
    }

    private String ReferenceTypeToString(ReferenceType referenceType) {
        return switch (referenceType) {
            case MODIFY -> "MODIFY";
            case MOVE_TO -> "MOVE_TO";
            case MOVE_FROM -> "MOVE_FROM";
            case CREATE -> "CREATE";
            case DELETE -> "DELETE";
            default -> "NONE";
        };
    }
}
