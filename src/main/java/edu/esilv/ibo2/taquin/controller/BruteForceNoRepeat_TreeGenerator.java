package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.Grid;
import edu.esilv.ibo2.taquin.model.Node;
import edu.esilv.ibo2.taquin.model.Tree;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class BruteForceNoRepeat_TreeGenerator {

    private Tree myTree;
    private ArrayList<Node> computed;
    private Grid perfect = Party.perfect;
    private int cptPerfect;

    public void C_BruteForceNoRepeat() {
        System.out.println("Building Tree for BruteForceNoRepeat solver");
        Grid g = new Grid();
        while (g.isSimilarTo(perfect)) g = new Grid();
        myTree = new Tree(g);
        computed = new ArrayList<Node>();
    }

    public void buildL1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // build root childs
        myTree.buildChilds(myTree.getRoot());
        for (Node child : myTree.getRoot().getChildrens()) {
            if (!child.gridEquals(perfect) && !computed.contains(child)) {
                computed.add(computed.size() - 1 , child);
            }
            if (computed.contains(child)) {
                myTree.getRoot().getChildrens().remove(child);
            }
        }
    }



}
