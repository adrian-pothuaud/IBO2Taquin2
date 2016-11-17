package ai;

import grid.model.Case;
import grid.model.Grid;
import grid.model.Position;

/**
 * Created by adrianpothuaud on 13/10/2016.
 */
public class AI {

    /*
    left
     */


    public static Grid perfectGrid;

    public void StdMove(Grid g, int value){
        /*
        Locate case
         */
        Case tmpCase = g.getCaseByKey(value);
        Position tmpPos = tmpCase.getPos();

        /*
        Find target position for this case
         */
        int tgtLine = (value%4)==0 ? (value/4)-1 : value/4;
        int tgtCol = (value%4==0) ? 3 : (value%4)-1;

        /*
        Find "0" position
         */
        Case tmpZero = g.getCaseByKey(0);
        Position tmpZPos = tmpZero.getPos();

        /*
        Define rectangle to rotate
         */


        /*
        rotate till case in pos
         */
    }

    public void IMove(int value){
        /*

         */
    }

}
