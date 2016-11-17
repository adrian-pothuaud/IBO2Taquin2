package tests;

import ai.AI_1;
import grid.model.Grid;

/**
 * Created by adrianpothuaud on 17/11/2016.
 */
public class UI_1_tests {

    public static void main(String[] args) {

        Grid g = new Grid();

        System.out.println(g);

        AI_1 iattarde = new AI_1();

        iattarde.case_1(g);

        System.out.println(g);

    }

}
