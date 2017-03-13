package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.M_Grid;
import edu.esilv.ibo2.taquin.model.M_PossibNode;
import edu.esilv.ibo2.taquin.model.M_PossibTree;

import java.util.PriorityQueue;

/**
 * Created by adrianpothuaud on 14/12/2016.
 */
public class C_BruteForceSolver {

    // instanciate possibTree
    // each node will compute his own childs till perfect config
    // add a cpt to nb nodes, nb perfect configs and stop the auto generation when a given cpt is reached

    private M_PossibTree myTree;
    private PriorityQueue<M_PossibNode> myQueue;

    public void init() {
        myTree = new M_PossibTree(new M_Grid()); // Random grid configuration

    }

}
