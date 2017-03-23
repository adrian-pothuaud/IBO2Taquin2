package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.Grid;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Party {

    private static ArrayList<Integer> perfConf = new ArrayList<Integer>() {{
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
        add(0);
    }};

    public static Grid perfect = new Grid(perfConf);
    static boolean checkWin(Grid grid, Grid perfect){
        return grid.isSimilarTo(perfect);
    }

    private static void clearCls(){
        for(int i = 0; i<1000; i++){
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        System.out.println("Reminder: goal is to reach perfect configuration as below");

        System.out.println(perfect);

        Scanner sc = new Scanner(System.in);
        // Grid g = new Grid(); uncomment for classic party
        Grid g = new Grid(perfConf); // comment for party
        g.moveCase(g.getCaseByKey(15));

        while(!checkWin(g, perfect)){
            AtomicInteger key = new AtomicInteger();
            System.out.println("Modify current grid by moving a case");
            System.out.println("Choose a case to move by key:");
            System.out.println(g);
            key.set(sc.nextInt());
            while(key.get() <=0){
                System.out.println("bad input try again...");
                key.set(sc.nextInt());
            }
            if (g.getCaseByKey(key.get()).isMovable(g)) {
                clearCls();
                System.out.println("Configuration has changed...");
                g.moveCase(g.getCaseByKey(key.get()));
            } else {
                clearCls();
                System.out.println("Case not movable, please choose another value");
            }
        }
        System.out.println("Congratulations !!! You won this party.");
        System.out.println(g);
    }

}
