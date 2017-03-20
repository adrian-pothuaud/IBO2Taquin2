package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.M_Grid;
import edu.esilv.ibo2.taquin.model.M_PossibNode;
import edu.esilv.ibo2.taquin.model.M_PossibTree;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class C_BruteForceNoRepeat {

    private M_PossibTree myTree;
    private ArrayList<M_PossibNode> computed;
    private M_Grid perfect = C_Party.perfect;
    private int cptPerfect;

    public void C_BruteForceNoRepeat() {
        System.out.println("Building Tree for BruteForceNoRepeat solver");
        M_Grid g = new M_Grid();
        while (g.isSimilarTo(perfect)) g = new M_Grid();
        myTree = new M_PossibTree(g);
        computed = new ArrayList<M_PossibNode>();
    }

    public void buildL1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // build root childs
        myTree.buildChilds(myTree.getRoot());
        for (M_PossibNode child : myTree.getRoot().getChildrens()) {
            if (!child.gridEquals(perfect) && !computed.contains(child)) {
                computed.add(computed.size() - 1 , child);
            }
            if (computed.contains(child)) {
                myTree.getRoot().getChildrens().remove(child);
            }
        }
    }



}
