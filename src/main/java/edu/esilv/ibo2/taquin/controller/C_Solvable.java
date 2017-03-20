package edu.esilv.ibo2.taquin.controller;

import com.oracle.tools.packager.Log;
import edu.esilv.ibo2.taquin.model.M_Grid;
import edu.esilv.ibo2.taquin.model.M_Position;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

class C_Solvable {

    private M_Grid g = new M_Grid(C_Party.perfect);
    private ArrayList<Integer> lastMoves = new ArrayList<Integer>();

    C_Solvable() {
        g = new M_Grid(C_Party.perfect); // perfect grid
    }

    private String getRandomDirection() {

        ArrayList<String> directions = new ArrayList<String>();
        directions.add("getLeft");
        directions.add("getTop");
        directions.add("getRight");
        directions.add("getBottom");

        int rdm = new Random().nextInt() % directions.size();
        Log.info("Random index : " + String.valueOf(rdm));

        return directions.get(rdm);
    }

    private void randomMoveZero() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Log.info("test");
        int rdm = new Random().nextInt() % 4;
        Log.info("Random int : " + String.valueOf(rdm));
        M_Position pos = null;
        switch (rdm) {
            case 0:
                pos = g.getCaseByKey(0).getPos().getTop();
                break;
            case 1:
                pos = g.getCaseByKey(0).getPos().getRight();
                break;
            case 2:
                pos = g.getCaseByKey(0).getPos().getBottom();
                break;
            case 3:
                pos = g.getCaseByKey(0).getPos().getLeft();
                break;
        }
        if (pos != null && pos.isInGrid()) {
            g.moveCase(g.getCaseByPos(pos));
            lastMoves.add(rdm);
            return;
        }
    }

    M_Grid genSolvablegrid(int iterations) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (int i = 0; i < iterations; i++) {
            randomMoveZero();
        }
        return g;
    }

}
