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
        M_Grid g = new M_Grid();
        while (g.isSimilarTo(perfect)) g = new M_Grid();
        myTree = new M_PossibTree(g);
    }

    public void build() {

    }

}
