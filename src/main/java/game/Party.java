package game;

import grid.model.Grid;

import java.util.ArrayList;
import java.util.Scanner;

public class Party {

    public static ArrayList<Integer> config1;
    public static Grid perfect;
    public static boolean checkWin(Grid grid, Grid perfect){
        return grid.SimilarTo(perfect);
    }

    public static void clearCls(){
        for(int i = 0; i<1000; i++){
            System.out.println("");
        }
    }

    private static Scanner sc;

    public static void main(String[] args) {

        config1 = new ArrayList<Integer>();
        config1.add(1);
        config1.add(2);
        config1.add(3);
        config1.add(4);
        config1.add(5);
        config1.add(6);
        config1.add(7);
        config1.add(8);
        config1.add(9);
        config1.add(10);
        config1.add(11);
        config1.add(12);
        config1.add(13);
        config1.add(14);
        config1.add(15);
        config1.add(0);
        perfect = new Grid(config1);

        System.out.println("Reminder: perfect configuration is as follow:");

        System.out.println(perfect);

        sc = new Scanner(System.in);
        Grid g = new Grid();
        int key=1;

        while(!checkWin(g, perfect)){
            if(!checkWin(g, perfect)) {
                System.out.println("Choisissez une case par sa valeur pour modifier la grille en jeu:");
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
                    g.move(g.getCaseByKey(key));
                } else {
                    clearCls();
                    System.out.println("Case not movable, please choose another value");
                }
            }
            else{
                System.out.println("BRAVO! Vous avez gagné la partie!");
                break;
            }
        }
    }

}
