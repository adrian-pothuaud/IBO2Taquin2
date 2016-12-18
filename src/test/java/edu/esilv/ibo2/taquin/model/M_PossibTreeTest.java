package edu.esilv.ibo2.taquin.model;

import edu.esilv.ibo2.taquin.controller.C_Party;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by adrianpothuaud on 18/12/2016.
 */
public class M_PossibTreeTest {

    @Test
    public void mainTest() throws Exception {

        /*
        TESTGRID1
         y=0  y=1  y=2  y=3
         -------------------
 x=0    |  2 |  7 | 10 |  4 |
 x=1    |  1 |  6 |  9 |  3 |
 x=2    | 13 |  0 | 11 | 15 |
 x=3    | 14 | 12 |  8 |  5 |
         -------------------
         */

        M_Grid startGrid = new M_Grid();
        M_PossibTree tree = new M_PossibTree(startGrid, 1);
        Queue<M_PossibTree.M_PossibNode> myQueue = new LinkedList<M_PossibTree.M_PossibNode>();
        myQueue.clear();
        myQueue.add(tree.root);
        while(tree.cptPerfectConf < 1){
            M_PossibTree.M_PossibNode leaf = myQueue.remove();
            if(leaf.childrens == null){
                if(leaf.data.getCaseByKey(0).getLeft(leaf.data).isMovable(leaf.data)){
                    M_Grid tmpGrid = new M_Grid(leaf.data);
                    tmpGrid.moveCase(tmpGrid.getCaseByKey(0).getLeft(tmpGrid));
                    if(tmpGrid.isSimilarTo(C_Party.perfect)) tree.cptPerfectConf++;
                    M_PossibTree.M_PossibNode tmpNode = new M_PossibTree.M_PossibNode(tmpGrid);
                    leaf.childrens.add(tmpNode);
                    tree.cptNodes++;
                    myQueue.add(tmpNode);
                }
                if(leaf.data.getCaseByKey(0).getTop(leaf.data).isMovable(leaf.data)){
                    M_Grid tmpGrid = new M_Grid(leaf.data);
                    tmpGrid.moveCase(tmpGrid.getCaseByKey(0).getTop(tmpGrid));
                    if(tmpGrid.isSimilarTo(C_Party.perfect)) tree.cptPerfectConf++;
                    M_PossibTree.M_PossibNode tmpNode = new M_PossibTree.M_PossibNode(tmpGrid);
                    leaf.childrens.add(tmpNode);
                    tree.cptNodes++;
                    myQueue.add(tmpNode);
                }
                if(leaf.data.getCaseByKey(0).getRight(leaf.data).isMovable(leaf.data)){
                    M_Grid tmpGrid = new M_Grid(leaf.data);
                    tmpGrid.moveCase(tmpGrid.getCaseByKey(0).getRight(tmpGrid));
                    if(tmpGrid.isSimilarTo(C_Party.perfect)) tree.cptPerfectConf++;
                    M_PossibTree.M_PossibNode tmpNode = new M_PossibTree.M_PossibNode(tmpGrid);
                    leaf.childrens.add(tmpNode);
                    tree.cptNodes++;
                    myQueue.add(tmpNode);
                }
                if(leaf.data.getCaseByKey(0).getBottom(leaf.data).isMovable(leaf.data)){
                    M_Grid tmpGrid = new M_Grid(leaf.data);
                    tmpGrid.moveCase(tmpGrid.getCaseByKey(0).getBottom(tmpGrid));
                    if(tmpGrid.isSimilarTo(C_Party.perfect)) tree.cptPerfectConf++;
                    M_PossibTree.M_PossibNode tmpNode = new M_PossibTree.M_PossibNode(tmpGrid);
                    leaf.childrens.add(tmpNode);
                    tree.cptNodes++;
                    myQueue.add(tmpNode);
                }
            }
            else{
                for(int j = 0; j < leaf.childrens.size(); j++){
                    myQueue.add(leaf.childrens.get(j));
                }
            }
            System.out.println(tree.cptNodes + " configurations computed, " + tree.cptPerfectConf + " are perfect.");
        }

    }

}