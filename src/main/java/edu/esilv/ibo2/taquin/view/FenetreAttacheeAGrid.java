package edu.esilv.ibo2.taquin.view;

import edu.esilv.ibo2.taquin.model.M_Case;
import edu.esilv.ibo2.taquin.model.M_Grid;
import edu.esilv.ibo2.taquin.model.M_Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by APD2 on 3/13/2017.
 */
public class FenetreAttacheeAGrid extends JFrame {


    public static void main(String[] args){
        M_Grid grid = new M_Grid(); // random grid
        new FenetreAttacheeAGrid(grid);
    }

    public FenetreAttacheeAGrid(final M_Grid g){
        this.setTitle("Projet Taquin");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //On définit le layout à utiliser sur le content pane
        this.setLayout(new GridLayout(4, 4));

        // On crée des boutons avec les Case de la Grid
        List<ArrayList<M_Case>> cases = (List<ArrayList<M_Case>>) g.getCases();
        for (ArrayList<M_Case> row : cases) {
            for (final M_Case curCase : row) {
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

                            new FenetreAttacheeAGrid(g);
                            //this.setLayout(new GridLayout(4, 4));


                        }
                    }


                });


            }
        }

        this.setVisible(true);
    }

}