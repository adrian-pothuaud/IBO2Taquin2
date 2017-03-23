package edu.esilv.ibo2.taquin.controller;

import com.oracle.tools.packager.Log;
import edu.esilv.ibo2.taquin.model.Grid;
import edu.esilv.ibo2.taquin.model.Node;
import edu.esilv.ibo2.taquin.model.Tree;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by guillaumelesieur on 20/03/2017.
 */
public class _dijkstraTest {


    @Test
    public void BasicDijkstra() throws Exception {

        Grid myGrid = new Grid(new ArrayList<Integer>() {{
            add(15);
            add(1);
            add(2);
            add(3);
            add(4);
            add(7);
            add(6);
            add(5);
            add(10);
            add(9);
            add(8);
            add(11);
            add(12);
            add(15);
            add(14);
            add(13);
        }});

        Tree myTree = new Tree(myGrid);
        Dijkstra();

    }

    void Dijkstra() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // Build childs of root childs
        Tree t = new Tree(new Grid());

        System.out.println("ROOT");
        System.out.println(t.getRoot().getGrid());

        // Build of root childs
        t.buildChilds(t.getRoot());

        System.out.println("CHILDS");

        t.printLeafs(t.getRoot());


        ////

        for(int i=0; i<16;i++){
           // System.out.println("childrens : "+n.getChildren(i));

        }





        /*Foreach node set distance[node] = HIGH
                SettledNodes = empty
        UnSettledNodes = empty

        Add sourceNode to UnSettledNodes
        distance[sourceNode]= 0

        while (UnSettledNodes is not empty) {
            evaluationNode = getNodeWithLowestDistance(UnSettledNodes)
            remove evaluationNode from UnSettledNodes
            add evaluationNode to SettledNodes
            evaluatedNeighbors(evaluationNode)
        }

        getNodeWithLowestDistance(UnSettledNodes){
            find the node with the lowest distance in UnSettledNodes and return it
        }

        evaluatedNeighbors(evaluationNode){
            Foreach destinationNode which can be reached via an edge from evaluationNode AND which is not in SettledNodes {
                edgeDistance = getDistance(edge(evaluationNode, destinationNode))
                newDistance = distance[evaluationNode] + edgeDistance
                if (distance[destinationNode]  > newDistance ) {
                    distance[destinationNode]  = newDistance
                    add destinationNode to UnSettledNodes
                }
            }
        }
        */


    }


}
