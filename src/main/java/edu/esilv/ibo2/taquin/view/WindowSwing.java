package edu.esilv.ibo2.taquin.view;
import javax.swing.*;

/**
 * Created by guillaumelesieur on 16/02/2017.
 */
public class WindowSwing extends JFrame{

    JPanel p = new JPanel();
    JButton b= new JButton("GO");

    public static void main(String[] args){
        new WindowSwing();
    }

    // constructor
    public WindowSwing(){
        super("Taquin");

        setSize(400,300);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.add(b);
        add(p);


        setVisible(true);
    }

}
