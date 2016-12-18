package edu.esilv.ibo2.taquin.model;

import edu.esilv.ibo2.taquin.controller.C_Party;

public class M_PossibNode_Old {

    private M_Grid grid;
    private M_PossibNode_Old zeroGoesTop;
    private M_PossibNode_Old zeroGoesRight;
    private M_PossibNode_Old zeroGoesBottom;
    private M_PossibNode_Old zeroGoesLeft;

    public M_PossibNode_Old(M_Grid g, int cptNodes, int cptPerfectConfigs, int factor) {

        // set grid

        grid = g;

        // set childs
        zeroGoesLeft = null;
        zeroGoesTop = null;
        zeroGoesRight = null;
        zeroGoesBottom = null;

        if(cptPerfectConfigs % 50 == 0){
            System.out.println("configurations computed: " + cptNodes);
        }

        // if not perfect config
        if((!C_Party.perfect.isSimilarTo(grid)) && (cptNodes!=factor)){

            // LEFT
            if(grid.getCaseByKey(0).getLeft(grid)!=null){
                if(grid.getCaseByKey(0).getLeft(grid).isInGrid()){
                    M_Grid leftGrid = new M_Grid(grid);
                    leftGrid.moveCase(grid.getCaseByKey(0).getLeft(grid));
                    cptNodes ++;
                    zeroGoesLeft = new M_PossibNode_Old(leftGrid, cptNodes, cptPerfectConfigs, factor);
                }
            }

            // TOP

            if(grid.getCaseByKey(0).getTop(grid)!=null){
                if(grid.getCaseByKey(0).getTop(grid).isInGrid()){
                    M_Grid topGrid = new M_Grid(grid);
                    topGrid.moveCase(grid.getCaseByKey(0).getTop(grid));
                    cptNodes ++;
                    zeroGoesTop = new M_PossibNode_Old(topGrid, cptNodes, cptPerfectConfigs, factor);
                }
            }

            // RIGHT
            if(grid.getCaseByKey(0).getRight(grid)!=null){
                if(grid.getCaseByKey(0).getRight(grid).isInGrid()){
                    M_Grid rightGrid = new M_Grid(grid);
                    rightGrid.moveCase(grid.getCaseByKey(0).getRight(grid));
                    cptNodes ++;
                    zeroGoesRight = new M_PossibNode_Old(rightGrid, cptNodes, cptPerfectConfigs, factor);
                }
            }

            // BOTTOM
            if(grid.getCaseByKey(0).getBottom(grid)!=null){
                if(grid.getCaseByKey(0).getBottom(grid).isInGrid()){
                    M_Grid bottomGrid = new M_Grid(grid);
                    bottomGrid.moveCase(grid.getCaseByKey(0).getBottom(grid));
                    cptNodes ++;
                    zeroGoesBottom = new M_PossibNode_Old(bottomGrid, cptNodes, cptPerfectConfigs, factor);
                }
            }

        }
        else{
            if(C_Party.perfect.isSimilarTo(grid)){
                cptPerfectConfigs ++;
                System.out.println("1 perfect config found (total " + cptPerfectConfigs + "), configurations computed: " + cptNodes);
            }
        }

    }

}
