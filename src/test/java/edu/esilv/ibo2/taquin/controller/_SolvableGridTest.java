package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.Grid;
import org.junit.Test;

/**
 * Created by adrianpothuaud on 20/03/2017.
 */
public class _SolvableGridTest {

    @Test
    public void randomMoveZero() throws Exception {

    }

    @Test
    public void genSolvablegrid() throws Exception {
        SolvableGrid sol = new SolvableGrid();
        Grid g = sol.genSolvablegrid(250);
        System.out.println(g.toString());
    }

}