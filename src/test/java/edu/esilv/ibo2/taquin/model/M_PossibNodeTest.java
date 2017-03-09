package edu.esilv.ibo2.taquin.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class M_PossibNodeTest {

    private M_Grid g1;
    private M_Grid g2;
    private M_Grid g3;
    private M_PossibTree myTree;

    @Before
    public void setUp() throws Exception {
        /*
        ----------- root -----------
        ---- c1 ---- c2 ---- c3 ----
        - c12 ---------- c31 - c32 -
         */
        M_Grid g = new M_Grid();
        g1 = new M_Grid(g);
        g2 = new M_Grid(g);
        g3 = new M_Grid(g);
        myTree = new M_PossibTree(g);
    }

    @Test
    public void addChildV1() throws Exception {
        assert myTree.getRoot().childrens.isEmpty();
        myTree.getRoot().childrens.add(new M_PossibNode(g1));
        assert !myTree.getRoot().childrens.isEmpty();
        assert myTree.getRoot().childrens.size() == 1;
        assert myTree.getRoot().childrens.get(0).data.equals(g1);
    }

    @Test
    public void addChildV2() throws Exception {
        assert !myTree.getRoot().haveChild();
        myTree.getRoot().addChild(g1);
        assert myTree.getRoot().haveChild();
        assert myTree.getRoot().getNbChilds() == 1;
        assert myTree.getRoot().getChildren(0).gridEquals(g1);
    }

    @Test
    public void NodesInArrayList() throws Exception {
        g1 = new M_Grid();
        g2 = new M_Grid();
        g3 = new M_Grid();
        ArrayList<M_PossibNode> myList = new ArrayList<M_PossibNode>();
        myList.add(new M_PossibNode(g1));
        assert !myList.isEmpty();
        myList.add(new M_PossibNode(g2));
        myList.add(new M_PossibNode(g3));
        assert myList.size() == 3;
        assert myList.get(1).data.equals(g2);
        myList.remove(myList.get(1));
        assert myList.size() == 2;
        assert myList.get(1).data.equals(g3);
    }

    @Test
    public void add2ChildsV1() throws Exception {
        assert myTree.getRoot().childrens.isEmpty();
        myTree.getRoot().childrens.add(new M_PossibNode(g1));
        assert !myTree.getRoot().childrens.isEmpty();
        assert myTree.getRoot().childrens.size() == 1;
        assert myTree.getRoot().childrens.get(0).data.equals(g1);
        myTree.getRoot().childrens.add(new M_PossibNode(g2));
        assert myTree.getRoot().childrens.size() == 2;
        assert myTree.getRoot().childrens.get(1).data.equals(g2);
    }

    @Test
    public void add2ChildsV2() throws Exception {
        assert !myTree.getRoot().haveChild();
        myTree.getRoot().addChild(g1);
        assert myTree.getRoot().haveChild();
        assert myTree.getRoot().getNbChilds() == 1;
        assert myTree.getRoot().getChildren(0).gridEquals(g1);
        myTree.getRoot().addChild(g2);
        assert myTree.getRoot().getNbChilds() == 2;
        assert myTree.getRoot().getChildren(1).gridEquals(g2);
    }
}