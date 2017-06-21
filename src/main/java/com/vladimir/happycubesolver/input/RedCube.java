package com.vladimir.happycubesolver.input;


import com.vladimir.happycubesolver.model.*;

import java.util.Arrays;
import java.util.List;

class RedCube {

    private static InputColor COLOR = InputColor.of("RED");

    private static boolean[][] redFront = new boolean[][]{
            {false, false, false, true, true},
            {false, true, true, true, false},
            {true, true, true, true, true},
            {false, true, true, true, false},
            {false, true, false, true, true}
    };

    private static boolean[][] redUp = new boolean[][]{
            {false, true, false, true, false},
            {true, true, true, true, false},
            {false, true, true, true, true},
            {true, true, true, true, false},
            {false, true, false, false, false}
    };

    private static boolean[][] redLeft = new boolean[][]{
            {false, true, true, false, true},
            {true, true, true, true, true},
            {false, true, true, true, false},
            {true, true, true, true, true},
            {true, false, false, true, true}
    };

    private static boolean[][] redRight = new boolean[][]{
            {false, false, true, false, false},
            {true, true, true, true, false},
            {false, true, true, true, true},
            {true, true, true, true, false},
            {false, false, true, false, false}
    };

    private static boolean[][] redDown = new boolean[][]{
            {false, false, true, true, false},
            {true, true, true, true, true},
            {false, true, true, true, false},
            {true, true, true, true, true},
            {true, false, true, false, false}
    };

    private static boolean[][] redBack = new boolean[][]{
            {false, true, true, false, false},
            {false, true, true, true, false},
            {true, true, true, true, true},
            {false, true, true, true, false},
            {true, true, false, true, true}
    };

    List<CubeSide> getCubeSides() {
        return Arrays.asList(
                new CubeSide(redFront,
                        SidePosition3d.FRONT,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(redUp,
                        SidePosition3d.UP,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(redLeft,
                        SidePosition3d.LEFT,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(redRight,
                        SidePosition3d.RIGHT,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(redDown,
                        SidePosition3d.DOWN,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(redBack,
                        SidePosition3d.BACK,
                        COLOR,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED));
    }

}
