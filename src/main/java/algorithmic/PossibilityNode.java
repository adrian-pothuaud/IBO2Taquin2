package algorithmic;

import grid.model.Grid;

public class PossibilityNode {

    Grid grid;
    PossibilityNode zeroGoesTop;
    PossibilityNode zeroGoesRight;
    PossibilityNode zeroGoesBottom;
    PossibilityNode zeroGoesLeft;

    public PossibilityNode() {
        // TODO Auto-generated constructor stub
    }

    public PossibilityNode(Grid g) {
        // TODO Auto-generated constructor stub
    }

    public PossibilityNode getZeroGoesTopNode(){
        return zeroGoesTop;
    }

}
