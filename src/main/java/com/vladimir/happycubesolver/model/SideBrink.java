package com.vladimir.happycubesolver.model;

class SideBrink {

    private SidePosition3d sidePosition3d;
    private SidePosition2d sidePosition2D;

    SideBrink(SidePosition3d sidePosition3d, SidePosition2d sidePosition2D) {
        this.sidePosition3d = sidePosition3d;
        this.sidePosition2D = sidePosition2D;
    }

    SidePosition3d getSidePosition3d() {
        return sidePosition3d;
    }

    SidePosition2d getSidePosition2D() {
        return sidePosition2D;
    }


}
