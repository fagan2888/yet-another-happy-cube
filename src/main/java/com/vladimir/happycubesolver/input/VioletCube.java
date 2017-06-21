package com.vladimir.happycubesolver.input;


import com.vladimir.happycubesolver.model.*;

import java.util.Arrays;
import java.util.List;

class VioletCube {

    private static InputColor COLOR = InputColor.of("VIOLET");

    private static boolean[][] blueFront = new boolean[][]{
            {true, true, false, true, false},
            {true, true, true, true, false},
            {true, true, true, true, false},
            {false, true, true, true, true},
            {false, false, true, false, false}
    };

    private static boolean[][] blueUp = new boolean[][]{
            {false, false, false, true, true},
            {true, true, true, true, false},
            {true, true, true, true, true},
            {false, true, true, true, false},
            {false, true, false, true, false}
    };

    private static boolean[][] blueLeft = new boolean[][]{
            {false, true, false, false, false},
            {true, true, true, true, false},
            {false, true, true, true, true},
            {true, true, true, true, false},
            {false, false, true, false, false}
    };

    private static boolean[][] blueRight = new boolean[][]{
            {true, true, false, true, true},
            {false, true, true, true, true},
            {true, true, true, true, false},
            {false, true, true, true, false},
            {false, true, false, true, false}
    };

    private static boolean[][] blueDown = new boolean[][]{
            {false, false, true, false, true},
            {false, true, true, true, true},
            {true, true, true, true, true},
            {true, true, true, true, false},
            {true, false, true, true, false}
    };

    private static boolean[][] blueBack = new boolean[][]{
            {false, true, false, true, true},
            {false, true, true, true, false},
            {false, true, true, true, true},
            {true, true, true, true, false},
            {true, true, false, true, false}
    };

    List<CubeSide> getCubeSides() {
        return Arrays.asList(
                new CubeSide(blueFront,
                        SidePosition3d.FRONT,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(blueUp,
                        SidePosition3d.UP,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(blueLeft,
                        SidePosition3d.LEFT,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(blueRight,
                        SidePosition3d.RIGHT,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(blueDown,
                        SidePosition3d.DOWN,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(blueBack,
                        SidePosition3d.BACK,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED));
    }

}
