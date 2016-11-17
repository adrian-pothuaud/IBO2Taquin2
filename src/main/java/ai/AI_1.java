package ai;

import grid.model.Case;
import grid.model.Grid;
import grid.model.Position;

import java.util.ArrayList;

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

    public boolean case_1(Grid g){
        Position tgt = new Position(0,0);
        //Localiser la case 1
        Position tmp1 = g.getCaseByKey(1).getPos();
        //Localiser la case 0
        Position tmp0 = g.getCaseByKey(0).getPos();
        //Ammener la case 0 en [0,0]
        while(g.getCaseByKey(0).getPos()!=tgt){
            //trouver les voisins de la case 0
            ArrayList<Case> neighb = new ArrayList<Case>();
            
            //identifier le plus proche de la position souhaitée
            //bouger le voisin identifié
        }
        //Faire tourner le rectangle définit par les deux cases jusqu'à ce que la case 1 soit à sa place

        return true;
    }

}
