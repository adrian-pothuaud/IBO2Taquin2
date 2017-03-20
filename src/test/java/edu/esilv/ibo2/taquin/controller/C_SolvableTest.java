package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.M_Grid;
import org.junit.Test;

/**
 * Created by adrianpothuaud on 20/03/2017.
 */
public class C_SolvableTest {

    @Test
    public void randomMoveZero() throws Exception {

    }

    @Test
    public void genSolvablegrid() throws Exception {
        C_Solvable sol = new C_Solvable();
        M_Grid g = sol.genSolvablegrid(250);
        System.out.println(g.toString());
    }

}