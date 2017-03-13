package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.M_Grid;
import edu.esilv.ibo2.taquin.model.M_PossibNode;
import edu.esilv.ibo2.taquin.model.M_PossibTree;

import java.util.ArrayList;

public class C_BruteForceNoRepeat {

    private M_PossibTree myTree;
    private ArrayList<M_PossibNode> computed;
    private M_Grid perfect = C_Party.perfect;
    private int cptPerfect;

    public void C_BruteForceNoRepeat() {
        System.out.println("Building Tree for BrutoForceNoRepeat solver");
        myTree = new M_PossibTree(new M_Grid());
        while (myTree.getRoot().gridEquals(perfect)) {
            myTree.getRoot() = new M_PossibNode(new M_Grid());
        }
    }

    public void build() {

    }

}
