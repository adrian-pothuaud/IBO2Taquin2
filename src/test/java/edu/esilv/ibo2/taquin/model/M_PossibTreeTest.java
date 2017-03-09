package edu.esilv.ibo2.taquin.model;

import org.junit.Test;

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
}