package edu.esilv.ibo2.taquin.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by adrianpothuaud on 16/12/2016.
 */
public class M_PositionTest {

    private M_Position pos1, pos2, pos1b, pos2b, pos3, pos4, posBis, posTer;

    @Before
    public void setUp() throws Exception {

        /*
                            posTer
         -------------------------
        |       | pos1   |        |
posBis  | pos2  |        |  pos3  |
        |       | pos4   |        |
         -------------------------

         */

        pos1 = new M_Position(0, 1);
        pos1b = new M_Position(0, 1);
        pos2 = new M_Position(1, 0);
        pos2b = new M_Position(1, 0);
        pos3 = new M_Position(1, 2);
        pos4 = new M_Position(2, 1);
        posBis = new M_Position(1, -1);
        posTer = new M_Position(-1, 2);

    }

    @Test
    public void isEqual() throws Exception {

        assertTrue(pos1.isEqual(pos1b));
        assertTrue(pos2.isEqual(pos2b));
        assertFalse(pos1.isEqual(pos3));

    }

    @Test
    public void equals() throws Exception {

        pos1.equals(pos3);
        assertTrue(pos1.isEqual(pos3));

    }

    @Test
    public void isInGrid() throws Exception {

        assertTrue(pos1.isInGrid());
        assertTrue(pos2.isInGrid());
        assertTrue(pos3.isInGrid());
        assertFalse(posBis.isInGrid());
        assertFalse(posTer.isInGrid());

    }

}