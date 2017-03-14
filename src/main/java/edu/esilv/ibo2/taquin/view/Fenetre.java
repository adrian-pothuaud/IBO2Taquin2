package edu.esilv.ibo2.taquin.view;

/**
 * Created by guillaumelesieur on 23/02/2017.
 */

import edu.esilv.ibo2.taquin.model.M_Grid;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Random;

public class Fenetre extends JFrame{


    public static void main(String[] args){
        new Fenetre();
    }

    public Fenetre(){
        this.setTitle("Taquin");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //On définit le layout à utiliser sur le content pane
        //Trois lignes sur deux colonnes
        this.setLayout(new GridLayout(4, 4));
        //On ajoute le bouton au content pane de la JFrame

        // Random
        Random rand = new Random();
        int  n = rand.nextInt(10) + 1;


        //JButton button0 = new JButton("0");
        JButton button1 = new JButton("n");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button10 = new JButton("10");
        JButton button11 = new JButton("11");
        JButton button12 = new JButton("12");
        JButton button13 = new JButton("13");
        JButton button14 = new JButton("14");
        JButton button15 = new JButton("15");

        this.getContentPane().add(button1);
        this.getContentPane().add(button2);
        this.getContentPane().add(button3);
        this.getContentPane().add(button4);
        this.getContentPane().add(button5);
        this.getContentPane().add(button6);
        this.getContentPane().add(button7);
        this.getContentPane().add(button8);
        this.getContentPane().add(button9);
        this.getContentPane().add(button10);
        this.getContentPane().add(button11);
        this.getContentPane().add(button12);
        this.getContentPane().add(button13);
        this.getContentPane().add(button14);
        this.getContentPane().add(button15);




        this.setVisible(true);
    }


    // une fois que je clique je fais appel a ismovable depuis la case
    // if (ismovable) sssswitch
}


