package edu.esilv.ibo2.taquin.view;
import javax.swing.*;

/**
 * Created by guillaumelesieur on 16/02/2017.
 */
public class WindowSwing extends JFrame{

    JPanel p = new JPanel();

    public static void main(String[] args){
        new WindowSwing();
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("GridLayout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // constructor
    public WindowSwing(){
        super("Taquin");

        setSize(400,300);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(p);
        setVisible(true);
    }

}