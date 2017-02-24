package edu.esilv.ibo2.taquin.view;

/**
 * Created by guillaumelesieur on 23/02/2017.
 */

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

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
        this.getContentPane().add(new JButton("0"));
        this.getContentPane().add(new JButton("1"));
        this.getContentPane().add(new JButton("2"));
        this.getContentPane().add(new JButton("3"));
        this.getContentPane().add(new JButton("4"));
        this.getContentPane().add(new JButton("5"));
        this.getContentPane().add(new JButton("6"));
        this.getContentPane().add(new JButton("7"));
        this.getContentPane().add(new JButton("8"));
        this.getContentPane().add(new JButton("9"));
        this.getContentPane().add(new JButton("10"));
        this.getContentPane().add(new JButton("11"));
        this.getContentPane().add(new JButton("12"));
        this.getContentPane().add(new JButton("13"));
        this.getContentPane().add(new JButton("14"));
        this.getContentPane().add(new JButton("15"));



        this.setVisible(true);
    }

}


