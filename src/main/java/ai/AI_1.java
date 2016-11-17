package ai;

import grid.model.Grid;
import grid.model.Position;

import java.util.logging.Logger;

/**
 * Created by adrianpothuaud on 17/11/2016.
 * Implemente la première méthode de résolution
 * Placer la case 1 avec une rotation de la case vide
 * Placer la case 2
 * Placer 4 et 3 en glissement
 * Placer 5 puis 6 comme 1 et 2
 * Placer 8 et 7 comme 4 et 3
 * Placer 9 et 13
 * Placer 10 et 14
 * Arranger le coin inférieur droit
 */

public class AI_1 {

    private static final Logger LOGGER = Logger.getLogger(AI_1.class.getName());

    public boolean case_1(Grid g){

        //loc tgt pos for case 1
        Position tgt = new Position(0,0);

        //Localiser la case 1

        //Localiser la case 0
        Position tmp0 = g.getCaseByKey(0).getPos();

        //Ammener la case 0 en [0,0]
        while(!g.getCaseByKey(0).getPos().IsEqual(tgt)){
            LOGGER.info("0 not in pos");
            if(tmp0.getLeft().isInGrid()){
                LOGGER.info("moving left");
                g.move(g.getCaseByPos(tmp0.getLeft()));
            }
            tmp0 = g.getCaseByKey(0).getPos();
            if(tmp0.getTop().isInGrid()){
                LOGGER.info("moving top");
                g.move(g.getCaseByPos(tmp0.getTop()));
            }
            tmp0 = g.getCaseByKey(0).getPos();
        }

        //Faire tourner le rectangle définit par les deux cases jusqu'à ce que la case 1 soit à sa place

        return true;
    }

}
