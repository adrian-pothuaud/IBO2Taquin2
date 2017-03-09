package edu.esilv.ibo2.taquin.model;

import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Created by adrianpothuaud on 18/12/2016.
 */
public class M_PossibTreeTest {

    private M_PossibTree myTree;
    private M_Grid myGrid;
    private PriorityQueue<M_PossibNode> myQueue;

    @Before
    public void setUp() throws Exception {
        myQueue = new PriorityQueue<M_PossibNode>();
        myGrid = new M_Grid();
        myTree = new M_PossibTree(myGrid);
    }

    @Test
    public void basicTree() throws Exception {
        /**
         *
         */
        M_Grid rootgrid = myTree.getRoot().getGrid();
        M_Position actualZeroPos = rootgrid.getCaseByKey(0).getPos();
        M_Position posToMove;

        if(actualZeroPos.getLeft().isInGrid()) {
            posToMove = actualZeroPos.getLeft();
        }
        else if(actualZeroPos.getTop().isInGrid()) {
            posToMove = actualZeroPos.getTop();
        }
        else if(actualZeroPos.getRight().isInGrid()) {
            posToMove = actualZeroPos.getRight();
        }
        else if(actualZeroPos.getBottom().isInGrid()) {
            posToMove = actualZeroPos.getBottom();
        }
        else {
            throw new Exception("Actual zero case has no movable neighbour !");
        }

        M_Grid newGrid = new M_Grid(rootgrid);
        newGrid.moveCase(rootgrid.getCaseByPos(posToMove));


    }
}