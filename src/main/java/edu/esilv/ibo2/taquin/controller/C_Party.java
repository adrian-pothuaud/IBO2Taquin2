package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.M_Grid;

import java.util.ArrayList;
import java.util.Scanner;

public class C_Party {

    public static ArrayList<Integer> perfConf = new ArrayList<Integer>() {{
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
    public static M_Grid perfect = new M_Grid(perfConf);
    public static boolean checkWin(M_Grid grid, M_Grid perfect){
        return grid.isSimilarTo(perfect);
    }

    public static void clearCls(){
        for(int i = 0; i<1000; i++){
            System.out.println("");
        }
    }

    private static Scanner sc;

    public static void main(String[] args) {

        System.out.println("Reminder: goal is to reach perfect configuration as below");

        System.out.println(perfect);

        sc = new Scanner(System.in);
        M_Grid g = new M_Grid();
        int key=1;

        while(!checkWin(g, perfect)){
            if(!checkWin(g, perfect)) {
                System.out.println("Modify current grid by moving a case");
                System.out.println("Choose a case to move by key:");
                System.out.println(g);
                key = sc.nextInt();
                //System.out.println(g.getCaseByKey(key));
                //System.out.println("is in grid?: " + g.getCaseByKey(key).isInGrid());
                //System.out.println("is movable?: " + g.getCaseByKey(key).isMovable(g));
                while(key<=0){
                    System.out.println("MAUVAISE SAISIE recommencer...");
                    key = sc.nextInt();
                }
                if (g.getCaseByKey(key).isMovable(g)) {
                    clearCls();
                    System.out.println("Configuration has changed...");
                    g.moveCase(g.getCaseByKey(key));
                } else {
                    clearCls();
                    System.out.println("M_Case not movable, please choose another value");
                }
            }
            else{
                System.out.println("BRAVO! Vous avez gagné la partie!");
                break;
            }
        }
    }

}
