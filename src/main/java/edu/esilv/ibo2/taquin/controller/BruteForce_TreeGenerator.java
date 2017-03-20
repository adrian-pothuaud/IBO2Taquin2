package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.Grid;
import edu.esilv.ibo2.taquin.model.Node;
import edu.esilv.ibo2.taquin.model.Tree;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

public class BruteForce_TreeGenerator {

    // instanciate possibTree
    // each node will compute his own childs till perfect config
    // add a cpt to nb nodes, nb perfect configs and stop the auto generation when a given cpt is reached

    private Tree myTree;
    private LinkedList<Node> myQueue;
    private int nbConfigs = 0;
    private int nbPerfectConf = 0;

    public BruteForce_TreeGenerator(Tree myTree) {
        this.myTree = myTree;
    }

    public Tree getMyTree() {
        return myTree;
    }

    public void setMyTree(Tree myTree) {
        this.myTree = myTree;
    }

    public LinkedList<Node> getMyQueue() {
        return myQueue;
    }

    public void setMyQueue(LinkedList<Node> myQueue) {
        this.myQueue = myQueue;
    }

    public int getNbConfigs() {
        return nbConfigs;
    }

    public void setNbConfigs(int nbConfigs) {
        this.nbConfigs = nbConfigs;
    }

    public void init() {
        myTree = new Tree(new Grid()); // Random grid configuration
    }

    public void build1stLvlchilds() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        myTree.buildChilds(myTree.getRoot());
    }

    public void build2ndLvlChilds() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (Node node : myTree.getRoot().getChildrens()) {
            myTree.buildChilds(node);
        }
    }

    public void buildChildLvlTillPerfect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        myQueue = new LinkedList<Node>();
        myQueue.add(myTree.getRoot());
        while (!myQueue.isEmpty()) {
            Node current = myQueue.poll();
            myTree.buildChilds(current);
            for (Node child : current.getChildrens()) {
                if (!child.gridEquals(Party.perfect)) {
                    myQueue.add(child);
                    nbConfigs++;
                }
                else{
                    nbPerfectConf++;
                }
                System.out.println("Nb configurations computed : " + String.valueOf(nbConfigs));
                System.out.println("Nb perfect configurations computed : " + String.valueOf(nbPerfectConf));
            }
        }
    }
}
