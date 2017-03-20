package edu.esilv.ibo2.taquin.model;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class TreeTest {

    @Test
    public void basicTree() throws Exception {

        Grid myGrid = new Grid(new ArrayList<Integer>() {{
            add(0);
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
            add(10);
            add(11);
            add(12);
            add(13);
            add(14);
            add(15);
        }});

        Tree myTree = new Tree(myGrid);
        Grid rootgrid = myTree.getRoot().getGrid();
        Position actualZeroPos = rootgrid.getCaseByKey(0).getPos();
        Position posToMove;

        if(actualZeroPos.getLeft().isInGrid()) {
            posToMove = actualZeroPos.getLeft();
            Grid newGrid = new Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getTop().isInGrid()) {
            posToMove = actualZeroPos.getTop();
            Grid newGrid = new Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getRight().isInGrid()) {
            posToMove = actualZeroPos.getRight();
            Grid newGrid = new Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getBottom().isInGrid()) {
            posToMove = actualZeroPos.getBottom();
            Grid newGrid = new Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        else {
            throw new Exception("Actual zero case has no movable neighbour !");
        }

        assert myTree.getRoot().getNbChilds() == 2;
    }

    @Test
    public void basicTree2() throws Exception {

        Grid myGrid = new Grid(new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(0);
            add(7);
            add(8);
            add(9);
            add(10);
            add(11);
            add(12);
            add(13);
            add(14);
            add(15);
        }});

        Tree myTree = new Tree(myGrid);
        Grid rootgrid = myTree.getRoot().getGrid();
        Position actualZeroPos = rootgrid.getCaseByKey(0).getPos();
        Position posToMove;

        if(actualZeroPos.getLeft().isInGrid()) {
            posToMove = actualZeroPos.getLeft();
            Grid newGrid = new Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getTop().isInGrid()) {
            posToMove = actualZeroPos.getTop();
            Grid newGrid = new Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getRight().isInGrid()) {
            posToMove = actualZeroPos.getRight();
            Grid newGrid = new Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getBottom().isInGrid()) {
            posToMove = actualZeroPos.getBottom();
            Grid newGrid = new Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        else {
            throw new Exception("Actual zero case has no movable neighbour !");
        }

        assert myTree.getRoot().getNbChilds() == 4;
    }

    @Test
    public void conditionalInvokingSwitches() throws Exception {

        Tree myTree = new Tree(new Grid());

        assert myTree.getRoot().getNbChilds() == 0;

        ArrayList<String> directions = new ArrayList<String>() {{
            add("getLeft");
            add("getTop");
            add("getRight");
            add("getBottom");
        }};

        for (String direction : directions) {
            Method  getDir = Class.forName("edu.esilv.ibo2.taquin.model.Position").getDeclaredMethod(direction);
            Position pos = (Position) getDir.invoke(myTree.getRoot().getGrid().getCaseByKey(0).getPos());
            if (pos.isInGrid()) {
                Grid newGrid = new Grid(myTree.getRoot().getGrid());
                newGrid.moveCase(newGrid.getCaseByPos(pos));
                myTree.getRoot().addChild(newGrid);
            }
        }

        assert myTree.getRoot().getNbChilds() >= 2;
    }

    @Test
    public void buildChilds() throws Exception {
        Tree myTree = new Tree(new Grid());
        assert myTree.buildChilds(myTree.getRoot()) >= 2;
    }

    @Test
    public void printTree() throws Exception {
        Tree myTree = new Tree(new Grid());

        ArrayList<String> directions = new ArrayList<String>() {{
            add("getLeft");
            add("getTop");
            add("getRight");
            add("getBottom");
        }};

        // Build of root childs
        myTree.buildChilds(myTree.getRoot());

        // Build childs of root childs
        for (Node node : myTree.getRoot().childrens) {
            myTree.buildChilds(node);
        }

        // Build 3rd level childs
        for (Node node : myTree.getRoot().childrens) {
            for (Node child : node.childrens) {
                myTree.buildChilds(child);
            }
        }

        myTree.printTree(myTree.getRoot());
    }

    @Test
    public void printLeafs() throws Exception {
        Tree myTree = new Tree(new Grid());

        System.out.println("ROOT");
        System.out.println(myTree.getRoot().getGrid());

        // Build of root childs
        myTree.buildChilds(myTree.getRoot());

        System.out.println("CHILDS");

        myTree.printLeafs(myTree.getRoot());
    }

}