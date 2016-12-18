/**
 *
 */
package edu.esilv.ibo2.taquin.model;

/**
 * @author adrianpothuaud
 *
 */

public class M_PossibTree_Old {

    public int factor;

    private M_PossibNode_Old root;

    public int cptNodes;
    public int cptPerfectConfigs;

    /**
     *
     */
    public M_PossibTree_Old(M_Grid g, int f) {

        factor = f;

        cptNodes = 0;
        cptPerfectConfigs = 0;

        root = new M_PossibNode_Old(g, cptNodes, cptPerfectConfigs, factor);

        System.out.println("All possibilities computed in the limits of given factor: " + factor);

    }

    public int getCptNodes(){
        return cptNodes;
    }

}
