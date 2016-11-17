package algorithmic;

import grid.model.Grid;

public class PossibilityNode {

    Grid grid;
    PossibilityNode zeroGoesTop;
    PossibilityNode zeroGoesRight;
    PossibilityNode zeroGoesBottom;
    PossibilityNode zeroGoesLeft;

    public PossibilityNode(Grid g) {
        // compute childs until perfect grid

    }

    public PossibilityNode getZeroGoesTopNode(){
        return zeroGoesTop;
    }

}
