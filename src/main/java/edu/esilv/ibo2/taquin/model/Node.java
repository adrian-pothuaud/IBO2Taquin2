package edu.esilv.ibo2.taquin.model;

import java.util.ArrayList;

public class Node {

    Grid data;
    ArrayList<Node> childrens;

    public Node(Grid g){
        childrens = new ArrayList<Node>();
        data = g;
    }

    public void addChild(Grid g){
        childrens.add(new Node(g));
    }

    public boolean haveChild() {
        return !childrens.isEmpty();
    }

    int getNbChilds() {
        return childrens.size();
    }

    public Node getChildren(int i) {
        return childrens.get(i);
    }

    public Grid getGrid() {
        return data;
    }

    public boolean gridEquals(Grid g1) {
        return data.equals(g1);
    }

    public ArrayList<Node> getChildrens() {
        return childrens;
    }
}
