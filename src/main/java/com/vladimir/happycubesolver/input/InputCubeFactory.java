package com.vladimir.happycubesolver.input;

import com.vladimir.happycubesolver.model.CubeSide;
import com.vladimir.happycubesolver.model.InputColor;

import java.util.List;


public class InputCubeFactory {

    public static List<CubeSide> getCubeSidesByColor(InputColor color) {

        if (color == InputColor.BLUE) {
            return new BlueCube().getCubeSides();
        } else if (color == InputColor.RED) {
            return new RedCube().getCubeSides();
        } else if (color == InputColor.VIOLET) {
            return new VioletCube().getCubeSides();
        } else if (color == InputColor.YELLOW) {
            return new YellowCube().getCubeSides();
        } else {
            throw new IllegalArgumentException("Cube with such color: " + color.name() +
                    " is not supported.");
        }
    }
}
