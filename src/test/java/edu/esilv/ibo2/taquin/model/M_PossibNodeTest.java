package edu.esilv.ibo2.taquin.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by adrianpothuaud on 04/03/2017.
 */
public class M_PossibNodeTest {

    M_Grid g, g1, g2, g3, g12, g31, g32;
    M_PossibTree myTree;
    M_PossibNode c1, c2, c12, c3, c31, c32;

    @Before
    public void setUp() throws Exception {
        /*
        ----------- root -----------
        ---- c1 ---- c2 ---- c3 ----
        - c12 ---------- c31 - c32 -
         */
        g = new M_Grid();
        g1 = new M_Grid(g);
        g2 = new M_Grid(g);
        g3 = new M_Grid(g);
        g12 = new M_Grid(g);
        g31 = new M_Grid(g);
        g32 = new M_Grid(g);
        myTree = new M_PossibTree(g);
        c1 = new M_PossibNode(g1);
        c12 = new M_PossibNode(g12);
        c2 = new M_PossibNode(g2);
        c3 = new M_PossibNode(g3);
        c31 = new M_PossibNode(g31);
        c32 = new M_PossibNode(g32);
    }

    @Test
    public void addChildV1() throws Exception {
        assert myTree.root.childrens.isEmpty();
        myTree.root.childrens.add(new M_PossibNode(g1));
        assert !myTree.root.childrens.isEmpty();
        assert myTree.root.childrens.size() == 1;
        assert myTree.root.childrens.get(0).data.equals(g1);
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
        assert myTree.root.childrens.isEmpty();
        myTree.root.childrens.add(new M_PossibNode(g1));
        assert !myTree.root.childrens.isEmpty();
        assert myTree.root.childrens.size() == 1;
        assert myTree.root.childrens.get(0).data.equals(g1);
        myTree.root.childrens.add(new M_PossibNode(g2));
        assert myTree.root.childrens.size() == 2;
        assert myTree.root.childrens.get(1).data.equals(g2);
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