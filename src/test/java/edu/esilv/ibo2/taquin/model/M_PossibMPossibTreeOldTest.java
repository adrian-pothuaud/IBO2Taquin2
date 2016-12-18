package edu.esilv.ibo2.taquin.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by adrianpothuaud on 17/12/2016.
 */
public class M_PossibMPossibTreeOldTest {

    private M_Grid grid;
    private M_PossibTree_Old testTree;

    @Before
    public void setUp() throws Exception {

        grid = new M_Grid(); // random

    }

    @Test
    public void mainTestPossibilities() throws Exception {

        testTree = new M_PossibTree_Old(grid, 1);
        assertTrue(testTree.cptPerfectConfigs == 1);

    }

}