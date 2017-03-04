package edu.esilv.ibo2.taquin.model;

import java.util.ArrayList;

/**
 * A class used for Puzzle solving algorithms.
 * Stores an initial configuration as root node and a list of childrens(inner class M_PossibNode).
 */
public class M_PossibTree{

    public static class M_PossibNode{

        public M_Grid data;
        public ArrayList<M_PossibNode> childrens;

        public M_PossibNode(M_Grid g){

            data = new M_Grid(g);
            childrens = new ArrayList<M_PossibNode>();

        }

        public void addChild(M_PossibNode child){

            childrens.add(child);

        }

    }

    public M_PossibNode root;
    public int cptNodes = 0;
    public int cptPerfectConf = 0;
    public int perfConfLimiter;

    public M_PossibTree(M_Grid r, int pcl){

        root = new M_PossibNode(r);
        perfConfLimiter = pcl;

    }

    public M_PossibNode getRoot(){
        return root;
    }

}