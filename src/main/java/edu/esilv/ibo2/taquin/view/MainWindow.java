package edu.esilv.ibo2.taquin.view;

import edu.esilv.ibo2.taquin.controller.N_Opt_TreeGenerator;
import edu.esilv.ibo2.taquin.controller.Party;
import edu.esilv.ibo2.taquin.controller.SolvableGrid;
import edu.esilv.ibo2.taquin.model.Case;
import edu.esilv.ibo2.taquin.model.Grid;
import edu.esilv.ibo2.taquin.model.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GL on 3/13/2017.
 */
public class MainWindow extends JFrame {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Grid grid = new Grid(); // random grid
        Grid solvableGrid = new SolvableGrid().genSolvablegrid(20);
        new MainWindow(solvableGrid);
    }

    public MainWindow(final Grid g){
        this.setTitle("Projet Taquin");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //On définit le layout à utiliser sur le content pane
        this.setLayout(new GridLayout(4, 4));
        JMenuBar menuBar = new JMenuBar();
        JButton menu1 = new JButton("Help");
        JButton menu2 = new JButton("Solve");
        menuBar.add(menu1);
        menuBar.add(menu2);
        setJMenuBar(menuBar);

        // HELP
        menu1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N_Opt_TreeGenerator myGenerator = new N_Opt_TreeGenerator(new Tree(g));
                ArrayList<String> myDirections;
                try {
                    myDirections = myGenerator.lvlOrderBuildTillPerfect();
                    System.out.println("Move case at direction : " + myDirections.get(0) + " from case 0");
                    // meme message en graphique
                    if (myDirections.get(0)=="getRight"){
                        JOptionPane.showMessageDialog(null, "A droite du zéro");
                    }
                    else if (myDirections.get(0)=="getLeft"){
                        JOptionPane.showMessageDialog(null, "A gauche du zéro");
                    }
                    else if (myDirections.get(0)=="getBottom"){
                        JOptionPane.showMessageDialog(null, "En bas du zéro");
                    }
                    else if (myDirections.get(0)=="getTop"){
                        JOptionPane.showMessageDialog(null, "En haut du zéro");
                    }
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                }

            }
        });

        // SOLVE
        menu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                N_Opt_TreeGenerator myGenerator = new N_Opt_TreeGenerator(new Tree(g));
                ArrayList<String> myDirections;
                try {
                    myDirections = myGenerator.lvlOrderBuildTillPerfect();
                    System.out.println(myDirections);
                    ArrayList<Grid> gridToPerfect = new ArrayList<Grid>();
                    // Case currentTarget = null;
                    for (String direction : myDirections) {
                        // on récupère la case en fonction de la direction donnée
                        if(direction.equals("getLeft")) {
                            // on récupère la case à gauche de 0
                            Case currentTarget = g.getCaseByPos(g.getCaseByKey(0).getPos().getLeft());
                            Grid newGrid = new Grid(g);
                            newGrid.moveCase(currentTarget);
                            gridToPerfect.add(newGrid);
                        }
                        else if (direction.equals("getTop")) {
                            Case currentTarget = g.getCaseByPos(g.getCaseByKey(0).getPos().getTop());
                            Grid newGrid = new Grid(g);
                            newGrid.moveCase(currentTarget);
                            gridToPerfect.add(newGrid);
                        }
                        else if(direction.equals("getRight")) {
                            Case currentTarget = g.getCaseByPos(g.getCaseByKey(0).getPos().getRight());
                            Grid newGrid = new Grid(g);
                            newGrid.moveCase(currentTarget);
                            gridToPerfect.add(newGrid);
                        }
                        else {
                            Case currentTarget = g.getCaseByPos(g.getCaseByKey(0).getPos().getBottom());
                            Grid newGrid = new Grid(g);
                            newGrid.moveCase(currentTarget);
                            gridToPerfect.add(newGrid);
                        }

                    }
                    // on a une liste de grid à afficher
                    //gridToPerfect.
                    System.out.println("size = "+ gridToPerfect.size());

                    for (int i=0; i<gridToPerfect.size();i++){
                        System.out.println(gridToPerfect.get(i));
                    }
                    //new MainWindow(newGrid);

//                    JFrame fenetre = new JFrame();
//
//                    //Définit un titre pour notre fenêtre
//                    fenetre.setTitle("Solve");
//                    //Définit sa taille : 400 pixels de large et 100 pixels de haut
//                    fenetre.setLayout(new GridLayout(4, 4));
//                    //Nous demandons maintenant à notre objet de se positionner au centre
//                    fenetre.setLocationRelativeTo(null);
//                    //Termine le processus lorsqu'on clique sur la croix rouge
//                    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    //Et enfin, la rendre visible
//                    fenetre.setVisible(true);

                    // On crée des boutons avec les Case de la Grid
                    List<ArrayList<Case>> cases = (List<ArrayList<Case>>) g.getCases();





                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Victoire !!!
        if (g.isSimilarTo(Party.perfect)) {
            JOptionPane.showMessageDialog(null, "Vous avez gagné !!! ");
        }

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