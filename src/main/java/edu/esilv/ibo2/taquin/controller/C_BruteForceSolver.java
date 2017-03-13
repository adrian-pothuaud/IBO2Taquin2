package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.M_Grid;
import edu.esilv.ibo2.taquin.model.M_PossibNode;
import edu.esilv.ibo2.taquin.model.M_PossibTree;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

public class C_BruteForceSolver {

    // instanciate possibTree
    // each node will compute his own childs till perfect config
    // add a cpt to nb nodes, nb perfect configs and stop the auto generation when a given cpt is reached

    private M_PossibTree myTree;
    private LinkedList<M_PossibNode> myQueue;
    private int nbConfigs = 0;

    public void init() {
        myTree = new M_PossibTree(new M_Grid()); // Random grid configuration
    }

    public void build1stLvlchilds() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        myTree.buildChilds(myTree.getRoot());
    }

    public void build2ndLvlChilds() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (M_PossibNode node : myTree.getRoot().getChildrens()) {
            myTree.buildChilds(node);
        }
    }

    public void buildChildLvlTillPerfect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        myQueue = new LinkedList<M_PossibNode>();
        myQueue.add(myTree.getRoot());
        while (!myQueue.isEmpty()) {
            M_PossibNode current = myQueue.poll();
            myTree.buildChilds(current);
            for (M_PossibNode child : current.getChildrens()) {
                if (!child.gridEquals(C_Party.perfect)) {
                    myQueue.add(child);
                    nbConfigs++;
                }
                System.out.println("Nb configurations computed : " + String.valueOf(nbConfigs));
            }
        }
    }
}
