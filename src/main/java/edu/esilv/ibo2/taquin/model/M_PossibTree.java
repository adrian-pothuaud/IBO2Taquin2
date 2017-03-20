package edu.esilv.ibo2.taquin.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * A class used for Puzzle solving algorithms.
 * Stores an initial configuration as root node and a list of childrens(inner class M_PossibNode).
 */
public class M_PossibTree{

    private M_PossibNode root;

    public M_PossibTree(M_Grid r) {
        root = new M_PossibNode(r);
    }

    public M_PossibNode getRoot() {
        return root;
    }

    public int buildChilds(M_PossibNode leaf) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        int cpt = 0;

        ArrayList<String> directions = new ArrayList<String>() {{
            add("getLeft");
            add("getTop");
            add("getRight");
            add("getBottom");
        }};

        for (String direction : directions) {
            Method getDir = Class.forName("edu.esilv.ibo2.taquin.model.M_Position").getDeclaredMethod(direction);
            M_Position pos = (M_Position) getDir.invoke(leaf.getGrid().getCaseByKey(0).getPos());
            if (pos.isInGrid()) {
                M_Grid newGrid = new M_Grid(leaf.getGrid());
                newGrid.moveCase(newGrid.getCaseByPos(pos));
                leaf.addChild(newGrid);
                cpt ++;
            }
        }

        return cpt;
    }

    public int buildChildsImproved(M_PossibNode leaf) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        int cpt = 0;

        ArrayList<String> directions = new ArrayList<String>() {{
            add("getLeft");
            add("getTop");
            add("getRight");
            add("getBottom");
        }};

        for (String direction : directions) {
            Method getDir = Class.forName("edu.esilv.ibo2.taquin.model.M_Position").getDeclaredMethod(direction);
            M_Position pos = (M_Position) getDir.invoke(leaf.getGrid().getCaseByKey(0).getPos());
            if (pos.isInGrid()) {
                M_Grid newGrid = new M_Grid(leaf.getGrid());
                newGrid.moveCase(newGrid.getCaseByPos(pos));
                leaf.addChild(newGrid);
                cpt ++;
            }
        }

        return cpt;
    }

    public void printTree(M_PossibNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getGrid());
        for(M_PossibNode child : node.childrens) {
            printTree(child);
        }
    }

    public void printLeafs(M_PossibNode node) {
        if (!node.haveChild()) {
            System.out.println(node.getGrid());
            return;
        }
        for (M_PossibNode child : node.childrens) {
            printLeafs(child);
        }
    }

    public void readAndExec(String parentClass, String method, ArrayList args) {

    }
}