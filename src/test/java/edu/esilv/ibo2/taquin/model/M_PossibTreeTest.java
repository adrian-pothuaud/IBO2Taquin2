package edu.esilv.ibo2.taquin.model;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class M_PossibTreeTest {

    @Test
    public void basicTree() throws Exception {

        M_Grid myGrid = new M_Grid(new ArrayList<Integer>() {{
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

        M_PossibTree myTree = new M_PossibTree(myGrid);
        M_Grid rootgrid = myTree.getRoot().getGrid();
        M_Position actualZeroPos = rootgrid.getCaseByKey(0).getPos();
        M_Position posToMove;

        if(actualZeroPos.getLeft().isInGrid()) {
            posToMove = actualZeroPos.getLeft();
            M_Grid newGrid = new M_Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getTop().isInGrid()) {
            posToMove = actualZeroPos.getTop();
            M_Grid newGrid = new M_Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getRight().isInGrid()) {
            posToMove = actualZeroPos.getRight();
            M_Grid newGrid = new M_Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getBottom().isInGrid()) {
            posToMove = actualZeroPos.getBottom();
            M_Grid newGrid = new M_Grid(rootgrid);
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

        M_Grid myGrid = new M_Grid(new ArrayList<Integer>() {{
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

        M_PossibTree myTree = new M_PossibTree(myGrid);
        M_Grid rootgrid = myTree.getRoot().getGrid();
        M_Position actualZeroPos = rootgrid.getCaseByKey(0).getPos();
        M_Position posToMove;

        if(actualZeroPos.getLeft().isInGrid()) {
            posToMove = actualZeroPos.getLeft();
            M_Grid newGrid = new M_Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getTop().isInGrid()) {
            posToMove = actualZeroPos.getTop();
            M_Grid newGrid = new M_Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getRight().isInGrid()) {
            posToMove = actualZeroPos.getRight();
            M_Grid newGrid = new M_Grid(rootgrid);
            newGrid.moveCase(rootgrid.getCaseByPos(posToMove));
            myTree.getRoot().addChild(newGrid);
        }
        if(actualZeroPos.getBottom().isInGrid()) {
            posToMove = actualZeroPos.getBottom();
            M_Grid newGrid = new M_Grid(rootgrid);
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

        M_PossibTree myTree = new M_PossibTree(new M_Grid());

        assert myTree.getRoot().getNbChilds() == 0;

        ArrayList<String> directions = new ArrayList<String>() {{
            add("getLeft");
            add("getTop");
            add("getRight");
            add("getBottom");
        }};

        for (String direction : directions) {
            Method  getDir = Class.forName("edu.esilv.ibo2.taquin.model.M_Position").getDeclaredMethod(direction);
            M_Position pos = (M_Position) getDir.invoke(myTree.getRoot().getGrid().getCaseByKey(0).getPos());
            if (pos.isInGrid()) {
                M_Grid newGrid = new M_Grid(myTree.getRoot().getGrid());
                newGrid.moveCase(newGrid.getCaseByPos(pos));
                myTree.getRoot().addChild(newGrid);
            }
        }

        assert myTree.getRoot().getNbChilds() >= 2;
    }

    @Test
    public void buildChilds() throws Exception {
        M_PossibTree myTree = new M_PossibTree(new M_Grid());
        assert myTree.buildChilds(myTree.getRoot()) >= 2;
    }

    @Test
    public void printTree() throws Exception {
        M_PossibTree myTree = new M_PossibTree(new M_Grid());

        ArrayList<String> directions = new ArrayList<String>() {{
            add("getLeft");
            add("getTop");
            add("getRight");
            add("getBottom");
        }};

        // Build of root childs
        myTree.buildChilds(myTree.getRoot());

        // Build childs of root childs
        for (M_PossibNode node : myTree.getRoot().childrens) {
            myTree.buildChilds(node);
        }

        // Build 3rd level childs
        for (M_PossibNode node : myTree.getRoot().childrens) {
            for (M_PossibNode child : node.childrens) {
                myTree.buildChilds(child);
            }
        }

        myTree.printTree(myTree.getRoot());
    }

    @Test
    public void printLeafs() throws Exception {
        M_PossibTree myTree = new M_PossibTree(new M_Grid());

        System.out.println("ROOT");
        System.out.println(myTree.getRoot().getGrid());

        // Build of root childs
        myTree.buildChilds(myTree.getRoot());

        System.out.println("CHILDS");

        myTree.printLeafs(myTree.getRoot());
    }

}