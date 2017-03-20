package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.Tree;
import org.junit.Test;

/**
 * Created by APD2 on 3/13/2017.
 */
public class _BruteForceTreeGeneratorTest {

    @Test
    public void buildChildLvlTillPerfect() throws Exception {

        BruteForce_TreeGenerator mySolver = new BruteForce_TreeGenerator(new Tree(new SolvableGrid().genSolvablegrid(1)));

        mySolver.buildChildLvlTillPerfect();
    }

}