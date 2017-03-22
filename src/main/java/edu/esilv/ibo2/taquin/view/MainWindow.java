package edu.esilv.ibo2.taquin.view;

import edu.esilv.ibo2.taquin.controller.SolvableGrid;
import edu.esilv.ibo2.taquin.model.Case;
import edu.esilv.ibo2.taquin.model.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by APD2 on 3/13/2017.
 */
public class MainWindow extends JFrame {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Grid grid = new Grid(); // random grid
        Grid solvableGrid = new SolvableGrid().genSolvablegrid(5);
        new MainWindow(solvableGrid);
    }

    public MainWindow(final Grid g){
        this.setTitle("Projet Taquin");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //On définit le layout à utiliser sur le content pane
        this.setLayout(new GridLayout(4, 4));

        // On crée des boutons avec les Case de la Grid
        List<ArrayList<Case>> cases = (List<ArrayList<Case>>) g.getCases();
        for (ArrayList<Case> row : cases) {
            for (final Case curCase : row) {
                final JButton newBtn = new JButton(String.valueOf(curCase.getKey()));
                // on ajoute le btn à la grille graphique
                this.getContentPane().add(newBtn);

                // on click listener on affiche la case
                newBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Case cliquée : " + String.valueOf(curCase.getKey()));
                        System.out.println("Ligne : " + String.valueOf(curCase.getPos().getX() + 1));
                        System.out.println("Colonne : " + String.valueOf(curCase.getPos().getY() + 1));
                        System.out.println("Case is movable ? : " + String.valueOf(curCase.isMovable(g)));
                        System.out.println("");
                        // Si case movable change the grid and update graphics ...
                        if (curCase.isMovable(g) == true) { // If is movable
                            System.out.println("Grid before move case \n " + g);
                            System.out.println("--------");

                            g.moveCase(curCase);

                            System.out.println("Grid after move case \n " + g);
                            System.out.println("--------");

                            new MainWindow(g);

                            try {
                                this.finalize();
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }


                        }
                    }


                });


            }
        }

        this.setVisible(true);
    }

}