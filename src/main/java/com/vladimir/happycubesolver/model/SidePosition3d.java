package com.vladimir.happycubesolver.model;


public enum SidePosition3d {
    FRONT,
    UP,
    LEFT,
    RIGHT,
    DOWN,
    BACK;

    public static SidePosition3d of(int i) {
        if (i > 5 || i < 0) {
            throw new IllegalArgumentException("SidePosition3d by index was not recognised. Index is: " + i);
        }
        SidePosition3d[] positions3d = new SidePosition3d[]{FRONT,
                UP,
                LEFT,
                RIGHT,
                DOWN,
                BACK};
        return positions3d[i];
    }
}
