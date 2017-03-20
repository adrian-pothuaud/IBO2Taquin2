package edu.esilv.ibo2.taquin.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class _NodeTest {

    private Grid g1;
    private Grid g2;
    private Grid g3;
    private Tree myTree;

    @Before
    public void setUp() throws Exception {
        /*
        ----------- root -----------
        ---- c1 ---- c2 ---- c3 ----
        - c12 ---------- c31 - c32 -
         */
        Grid g = new Grid();
        g1 = new Grid(g);
        g2 = new Grid(g);
        g3 = new Grid(g);
        myTree = new Tree(g);
    }

    @Test
    public void addChildV1() throws Exception {
        assert myTree.getRoot().childrens.isEmpty();
        myTree.getRoot().childrens.add(new Node(g1));
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
        g1 = new Grid();
        g2 = new Grid();
        g3 = new Grid();
        ArrayList<Node> myList = new ArrayList<Node>();
        myList.add(new Node(g1));
        assert !myList.isEmpty();
        myList.add(new Node(g2));
        myList.add(new Node(g3));
        assert myList.size() == 3;
        assert myList.get(1).data.equals(g2);
        myList.remove(myList.get(1));
        assert myList.size() == 2;
        assert myList.get(1).data.equals(g3);
    }

    @Test
    public void add2ChildsV1() throws Exception {
        assert myTree.getRoot().childrens.isEmpty();
        myTree.getRoot().childrens.add(new Node(g1));
        assert !myTree.getRoot().childrens.isEmpty();
        assert myTree.getRoot().childrens.size() == 1;
        assert myTree.getRoot().childrens.get(0).data.equals(g1);
        myTree.getRoot().childrens.add(new Node(g2));
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