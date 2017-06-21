package com.vladimir.happycubesolver.model;

class CornerBrink {

    private SidePosition3d sidePosition3d;
    private CornerPosition2d cornerPosition2d;

    CornerBrink(SidePosition3d sidePosition3d, CornerPosition2d cornerPosition2d) {
        this.sidePosition3d = sidePosition3d;
        this.cornerPosition2d = cornerPosition2d;
    }

    SidePosition3d getSidePosition3d() {
        return sidePosition3d;
    }

    CornerPosition2d getCornerPosition2d() {
        return cornerPosition2d;
    }


}
