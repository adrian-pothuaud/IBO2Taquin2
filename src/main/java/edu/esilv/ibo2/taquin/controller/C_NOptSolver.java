package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.M_PossibNode;
import edu.esilv.ibo2.taquin.model.M_PossibTree;

import java.util.LinkedList;

/**
 * Created by adrianpothuaud on 14/12/2016.
 */
public class C_NOptSolver {

    // give attributes to the grids to determine their "velocity" for being solved
    // it will depend on the number of cases that are in their final position

    private M_PossibTree myTree;
    private LinkedList<M_PossibNode> myQueue = new LinkedList<M_PossibNode>();
    private int nbConfigs = 0;
    private int nbPerfectConf = 0;

    public C_NOptSolver(M_PossibTree myTree) {
        this.myTree = myTree;
    }

    public M_PossibTree getMyTree() {
        return myTree;
    }

    public LinkedList<M_PossibNode> getMyQueue() {
        return myQueue;
    }

    public int getNbConfigs() {
        return nbConfigs;
    }

    public int getNbPerfectConf() {
        return nbPerfectConf;
    }
}
