package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.Node;
import edu.esilv.ibo2.taquin.model.Tree;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;

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

    public void letOnlyBestGrids(Node parent) {
        System.out.println("NBChilds : " + String.valueOf(parent.getChildrens().size()));
        int highestFactor = getHighestFactor(parent.getChildrens());
        System.out.println("Current highest factor in childs is : " + String.valueOf(highestFactor));
        ArrayList<Node> childsToRemove = new ArrayList<Node>();
        for (Node child : parent.getChildrens()) {
            if (child.getGrid().computeNOptFactor() < highestFactor) {
                System.out.println("1 child to be removed");
                childsToRemove.add(child);
            }
        }
        for (Node childToRemove : childsToRemove) {
            System.out.println("Removing 1 child");
            parent.getChildrens().remove(childToRemove);
        }
        System.out.println("NBChilds : " + String.valueOf(parent.getChildrens().size()));
    }

    private int getHighestFactor(ArrayList<Node> childs) {
        int factor = 0;
        for (Node child : childs){
            int childFactor = child.getGrid().computeNOptFactor();
            if (childFactor > factor) {
                factor = childFactor;
            }
        }
        return factor;
    }

    public void lvlOrderBuildTillPerfect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        myQueue.addLast(myTree.getRoot());
        System.out.println("Adding root to queue");

        int actualPerfConf = getNbPerfectConf();
        System.out.println("Initialy " + String.valueOf(actualPerfConf) + " perfect configs");

        while (!myQueue.isEmpty()) {
            System.out.println("Queue not empty");

            Node current = myQueue.poll();
            System.out.println("Looking at node : ");
            System.out.println(current.getGrid());

            if (current.getGrid().computeNOptFactor() == 15) {
                System.out.println("PERFECT FOUND, LEAVING ALGORITHM RIGHT NOW");
                break;
            }

            System.out.println("Building all current's node childs");
            myTree.buildChilds(current);

            System.out.println("Cleaning current node's childs");
            letOnlyBestGrids(current);

            System.out.println("Adding remaining childs to queue");
            addRemainingChildsToQueue(current);

            System.out.println(myQueue);
            System.out.println("Now " + String.valueOf(actualPerfConf) + " perfect configs");
        }
    }

    private void addRemainingChildsToQueue(Node current) {
        for (Node remainingChild : current.getChildrens()) {
            myQueue.add(remainingChild);
        }
    }

    public void buildWithPerfConfLimiter(int cptLimiter) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int previousNbPerf = getNbPerfectConf();
        if (cptLimiter == 0) {
            return;
        }
        lvlOrderBuildTillPerfect();
        buildWithPerfConfLimiter(cptLimiter - (getNbPerfectConf() - previousNbPerf));
    }
}
