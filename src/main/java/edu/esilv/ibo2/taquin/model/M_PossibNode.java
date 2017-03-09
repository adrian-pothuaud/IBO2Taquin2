package edu.esilv.ibo2.taquin.model;

import java.util.ArrayList;

class M_PossibNode {

    M_Grid data;
    ArrayList<M_PossibNode> childrens;

    M_PossibNode(M_Grid g){
        childrens = new ArrayList<M_PossibNode>();
        data = g;
    }

    void addChild(M_Grid g){
        childrens.add(new M_PossibNode(g));
    }

    boolean haveChild() {
        return !childrens.isEmpty();
    }

    int getNbChilds() {
        return childrens.size();
    }

    M_PossibNode getChildren(int i) {
        return childrens.get(i);
    }

    M_Grid getGrid() {
        return data;
    }

    boolean gridEquals(M_Grid g1) {
        return data.equals(g1);
    }
}
