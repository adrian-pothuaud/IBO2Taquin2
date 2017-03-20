package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.Node;
import edu.esilv.ibo2.taquin.model.Tree;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by adrianpothuaud on 14/12/2016.
 */
public class N_Opt_TreeGenerator {

    // give attributes to the grids to determine their "velocity" for being solved
    // it will depend on the number of cases that are in their final position

    private Tree myTree;
    private LinkedList<Node> myQueue = new LinkedList<Node>();
    private int nbConfigs = 0;
    private int nbPerfectConf = 0;

    public N_Opt_TreeGenerator(Tree myTree) {
        this.myTree = myTree;
    }

    public Tree getMyTree() {
        return myTree;
    }

    public LinkedList<Node> getMyQueue() {
        return myQueue;
    }

    public int getNbConfigs() {
        return nbConfigs;
    }

    public int getNbPerfectConf() {
        return nbPerfectConf;
    }

    public void letOnlyBestGrids(ArrayList<Node> childs) {
        int highestFactor = getHighestFactor(childs);

    }

    private int getHighestFactor(ArrayList<Node> childs) {
        int factor = 0;
        for (Node child : childs){

        }
    }

    public void buildChildLvlTillPerfect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        myQueue.add(myTree.getRoot());
        int actualPerfConf = getNbPerfectConf();
        while (!myQueue.isEmpty() || getNbPerfectConf() <= actualPerfConf) {
            Node current = myQueue.poll();
            myTree.buildChilds(current);
            for (Node child : current.getChildrens()) {
                if (!child.gridEquals(Party.perfect)) {
                    myQueue.add(child);
                    nbConfigs++;
                }
                else{
                    nbPerfectConf++;
                    break;
                }
                System.out.println("Nb configurations computed : " + String.valueOf(nbConfigs));
                System.out.println("Nb perfect configurations computed : " + String.valueOf(nbPerfectConf));
            }
        }
    }

    public void buildChildLvlTillPerfect(int cptLimiter) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int previousNbPerf = getNbPerfectConf();
        if (cptLimiter == 0) {
            return;
        }
        buildChildLvlTillPerfect();
        buildChildLvlTillPerfect(cptLimiter - (getNbPerfectConf() - previousNbPerf));
    }
}
