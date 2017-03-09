package edu.esilv.ibo2.taquin.model;

/**
 * A class used for Puzzle solving algorithms.
 * Stores an initial configuration as root node and a list of childrens(inner class M_PossibNode).
 */
class M_PossibTree{

    private M_PossibNode root;

    M_PossibTree(M_Grid r) {
        root = new M_PossibNode(r);
    }

    M_PossibNode getRoot() {
        return root;
    }
}