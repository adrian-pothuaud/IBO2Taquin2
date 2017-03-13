package edu.esilv.ibo2.taquin.model;

import java.util.ArrayList;

public class M_PossibNode {

    M_Grid data;
    ArrayList<M_PossibNode> childrens;

    public M_PossibNode(M_Grid g){
        childrens = new ArrayList<M_PossibNode>();
        data = g;
    }

    public void addChild(M_Grid g){
        childrens.add(new M_PossibNode(g));
    }

    public boolean haveChild() {
        return !childrens.isEmpty();
    }

    int getNbChilds() {
        return childrens.size();
    }

    public M_PossibNode getChildren(int i) {
        return childrens.get(i);
    }

    public M_Grid getGrid() {
        return data;
    }

    public boolean gridEquals(M_Grid g1) {
        return data.equals(g1);
    }

    public ArrayList<M_PossibNode> getChildrens() {
        return childrens;
    }
}
