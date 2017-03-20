package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.Grid;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by adrianpothuaud on 16/12/2016.
 */
public class _PartyTest {

    Party testParty = new Party();
    Grid testGrid1, testGrid2;
    ArrayList<Integer> config1;

    @Before
    public void setUp() throws Exception {

        config1 = new ArrayList<Integer>();
        config1.add(2);
        config1.add(7);
        config1.add(10);
        config1.add(4);
        config1.add(1);
        config1.add(6);
        config1.add(9);
        config1.add(3);
        config1.add(13);
        config1.add(0);
        config1.add(11);
        config1.add(15);
        config1.add(14);
        config1.add(12);
        config1.add(8);
        config1.add(5);
        testGrid1 = new Grid(config1);

        testGrid2 = new Grid(testParty.perfect);

    }

    @Test
    public void checkWin() throws Exception {

        assertFalse(testParty.checkWin(testGrid1, testParty.perfect));
        assertTrue(testParty.checkWin(testGrid2, testParty.perfect));

    }

}