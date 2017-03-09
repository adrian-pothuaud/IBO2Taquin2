package edu.esilv.ibo2.taquin.model;

/**
 * A class used for Puzzle solving algorithms.
 * Stores an initial configuration as root node and a list of childrens(inner class M_PossibNode).
 */
public class M_PossibTree{

    public M_PossibNode root;
    public int cptNodes = 0;
    public int cptPerfectConf = 0;
    public int perfConfLimiter;

    public M_PossibTree(M_Grid r) {
        root = new M_PossibNode(r);
        perfConfLimiter = 5;
    }

    public M_PossibTree(M_Grid r, int pcl){
        root = new M_PossibNode(r);
        perfConfLimiter = pcl;
    }

    public M_PossibNode getRoot() {
        return root;
    }
}