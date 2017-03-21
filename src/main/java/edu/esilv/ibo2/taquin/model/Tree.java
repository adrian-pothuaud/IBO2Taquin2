package edu.esilv.ibo2.taquin.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * A class used for Puzzle solving algorithms.
 * Stores an initial configuration as root node and a list of childrens(inner class M_PossibNode).
 */
public class Tree {

    private Node root;

    public Tree(Grid r) {
        root = new Node(r);
    }

    public Node getRoot() {
        return root;
    }

    public int buildChilds(Node leaf) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        int cpt = 0;

        ArrayList<String> directions = new ArrayList<String>() {{
            add("getLeft");
            add("getTop");
            add("getRight");
            add("getBottom");
        }};

        for (String direction : directions) {
            Method getDir = Class.forName("edu.esilv.ibo2.taquin.model.Position").getDeclaredMethod(direction);
            Position pos = (Position) getDir.invoke(leaf.getGrid().getCaseByKey(0).getPos());
            if (pos.isInGrid()) {
                Grid newGrid = new Grid(leaf.getGrid());
                newGrid.moveCase(newGrid.getCaseByPos(pos));
                leaf.addChild(newGrid);
                cpt ++;
            }
        }

        return cpt;
    }

    public int buildChildsImproved(Node leaf) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        int cpt = 0;

        ArrayList<String> directions = new ArrayList<String>() {{
            add("getLeft");
            add("getTop");
            add("getRight");
            add("getBottom");
        }};

        for (String direction : directions) {
            Method getDir = Class.forName("edu.esilv.ibo2.taquin.model.Position").getDeclaredMethod(direction);
            Position pos = (Position) getDir.invoke(leaf.getGrid().getCaseByKey(0).getPos());
            if (pos.isInGrid()) {
                Grid newGrid = new Grid(leaf.getGrid());
                newGrid.moveCase(newGrid.getCaseByPos(pos));
                leaf.addChild(newGrid);
                cpt ++;
            }
        }

        return cpt;
    }

    public void printTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getGrid());
        for(Node child : node.childrens) {
            printTree(child);
        }
    }

    public void printLeafs(Node node) {
        if (!node.haveChild()) {
            System.out.println(node.getGrid());
            return;
        }
        for (Node child : node.childrens) {
            printLeafs(child);
        }
    }

    public int maxDepth(Node node){
        if(!node.haveChild()){
            return 0;
        }
        else {
            // compute the depth of each sub tree
            ArrayList<Integer> depths = new ArrayList<Integer>();
            for (Node child : node.getChildrens()) {
                depths.add(maxDepth(child));
            }
            return (LIST_MAX(depths) + 1);
        }
    }

    private int LIST_MAX(ArrayList<Integer> depths) {
        int max = depths.get(0);
        for (Integer i : depths) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}