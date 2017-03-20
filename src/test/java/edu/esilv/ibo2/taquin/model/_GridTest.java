package edu.esilv.ibo2.taquin.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class _GridTest {

    private Grid testGrid1, testGrid2, perfGrid;
    private Case case15, case0;

    @Before
    public void setUp() throws Exception {

        /*
         y=0  y=1  y=2  y=3
         -------------------
 x=0    |  1 |  2 |  3 |  4 |
 x=1    |  5 |  6 |  7 |  8 |
 x=2    |  9 | 10 | 11 | 12 |
 x=3    | 13 | 14 | 15 |  0 |
         -------------------
         */

        ArrayList<Integer> perfConfig = new ArrayList<Integer>();
        perfConfig.add(1);
        perfConfig.add(2);
        perfConfig.add(3);
        perfConfig.add(4);
        perfConfig.add(5);
        perfConfig.add(6);
        perfConfig.add(7);
        perfConfig.add(8);
        perfConfig.add(9);
        perfConfig.add(10);
        perfConfig.add(11);
        perfConfig.add(12);
        perfConfig.add(13);
        perfConfig.add(14);
        perfConfig.add(15);
        perfConfig.add(0);
        perfGrid = new Grid(perfConfig);

        /*
        TESTGRID1
         y=0  y=1  y=2  y=3
         -------------------
 x=0    |  2 |  7 | 10 |  4 |
 x=1    |  1 |  6 |  9 |  3 |
 x=2    | 13 |  0 | 11 | 15 |
 x=3    | 14 | 12 |  8 |  5 |
         -------------------
         */

        ArrayList<Integer> config1 = new ArrayList<Integer>();
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

        /*
        TESTGRID2
         y=0  y=1  y=2  y=3
         -------------------
 x=0    |  2 |  7 | 10 |  4 |
 x=1    |  1 |  6 |  9 |  3 |
 x=2    | 13 |  0 | 11 | 15 |
 x=3    | 14 | 12 |  8 |  5 |
         -------------------
         */

        testGrid2 = new Grid(testGrid1);
    }

    @Test
    public void getCaseByKey() throws Exception {

        assertNull(testGrid1.getCaseByKey(54));

        assertNotNull(testGrid1.getCaseByKey(1));
        assertTrue(testGrid1.getCaseByKey(1).getKey() == 1);
        assertNotNull(testGrid1.getCaseByKey(5));
        assertTrue(testGrid1.getCaseByKey(5).isInGrid());
        assertNotNull(testGrid1.getCaseByKey(12));
        assertTrue(testGrid1.getCaseByKey(12).isMovable(testGrid1));

        case0 = new Case(0, 2, 1);
        assertNotNull(testGrid1.getCaseByKey(0));
        assertTrue(case0.isEqual(testGrid2.getCaseByKey(0)));

        case15 = new Case(15, testGrid1.getCaseByKey(15).getPos());
        assertTrue(case15.isEqual(testGrid1.getCaseByKey(15)));

        assertNull(testGrid1.getCaseByKey(25));
    }

    @Test
    public void getCaseByPos() throws Exception {

        assertNull(testGrid1.getCaseByPos(new Position(6, 8)));

        assertNotNull(testGrid1.getCaseByPos(new Position(1, 0)));
        assertTrue(testGrid1.getCaseByPos(new Position(1, 0)).getKey() == 1);
        assertNotNull(testGrid1.getCaseByPos(new Position(3, 3)));
        assertTrue(testGrid1.getCaseByPos(new Position(3, 3)).isInGrid());
        assertNotNull(testGrid1.getCaseByPos(new Position(3, 1)));
        assertTrue(testGrid1.getCaseByPos(new Position(3, 1)).isMovable(testGrid1));

        case0 = new Case(0, 2, 1);
        assertNotNull(testGrid1.getCaseByPos(new Position(2, 1)));
        assertTrue(case0.isEqual(testGrid2.getCaseByPos(new Position(2, 1))));

        case15 = new Case(15, new Position(2, 3));
        assertTrue(case15.isEqual(testGrid1.getCaseByPos(new Position(2, 3))));

    }

    @Test
    public void isSimilarTo() throws Exception {
        assertTrue(testGrid2.isSimilarTo(testGrid1));
        assertFalse(testGrid2.isSimilarTo(perfGrid));
    }

    @Test
    public void moveCase() throws Exception {

        assertTrue(testGrid2.isSimilarTo(testGrid1));
        /*
        TESTGRID2
         y=0  y=1  y=2  y=3
         -------------------
 x=0    |  2 |  7 | 10 |  4 |
 x=1    |  1 |  6 |  9 |  3 |
 x=2    | 13 |  0 | 11 | 15 |
 x=3    | 14 | 12 |  8 |  5 |
         -------------------
         */
        testGrid2.moveCase(testGrid2.getCaseByKey(6));
        /*
        TESTGRID2
         y=0  y=1  y=2  y=3
         -------------------
 x=0    |  2 |  7 | 10 |  4 |
 x=1    |  1 |  0 |  9 |  3 |
 x=2    | 13 |  6 | 11 | 15 |
 x=3    | 14 | 12 |  8 |  5 |
         -------------------
         */

        assertTrue(testGrid2.getCaseByKey(0).getPos().isEqual(new Position(1, 1)));
        assertTrue(testGrid2.getCaseByKey(6).getPos().isEqual(new Position(2, 1)));
        assertFalse(testGrid1.getCaseByKey(0).getPos().isEqual(new Position(1, 1)));
        assertFalse(testGrid1.getCaseByKey(6).getPos().isEqual(new Position(2, 1)));
        assertFalse(testGrid2.isSimilarTo(testGrid1));

    }

    @Test
    public void testString() throws Exception {
        assertTrue(testGrid2.toString() != null);
    }

}