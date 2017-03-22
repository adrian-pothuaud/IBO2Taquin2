package edu.esilv.ibo2.taquin.model;

import java.util.ArrayList;

public class Node {

    Grid data;
    ArrayList<Node> childrens;
    ArrayList<String> directionsFromRoot;

    public void addDirectionFromParent(String direction) {
        this.directionsFromRoot.add(direction);
    }

    public ArrayList<String> getDirectionsFromRoot() {
        return directionsFromRoot;
    }

    public void setDirectionsFromRoot(ArrayList<String> directionsFromRoot) {
        this.directionsFromRoot = directionsFromRoot;
    }

    public Node(Grid g){
        childrens = new ArrayList<Node>();
        data = g;
    }

    public void addChild(Grid g){
        Node newChild = new Node(g);
        childrens.add(newChild);
    }

    public void addChild(Grid g, String direction){
        Node newChild = new Node(g);
        newChild.setDirectionsFromRoot(this.directionsFromRoot);
        newChild.addDirectionFromParent(direction);
        childrens.add(newChild);
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
