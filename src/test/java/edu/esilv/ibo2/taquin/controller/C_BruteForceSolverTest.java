package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.M_PossibTree;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by APD2 on 3/13/2017.
 */
public class C_BruteForceSolverTest {

    @Test
    public void buildChildLvlTillPerfect() throws Exception {

        C_BruteForceSolver mySolver = new C_BruteForceSolver();

        mySolver.init();
        mySolver.buildChildLvlTillPerfect();
    }

}