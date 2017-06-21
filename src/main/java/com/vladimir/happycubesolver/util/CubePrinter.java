package com.vladimir.happycubesolver.util;

/*
    ________
  / | U     /|
 /__|___B_ / |
| L |_F_ _|_R|
|  /      | /
|/____D___|/

*/

/*
The result will be printed as:

LEFT FRONT RIGHT
     BOTTOM
     BACK
     UP
 */

import com.vladimir.happycubesolver.model.CubeSide;
import com.vladimir.happycubesolver.model.SidePosition3d;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public abstract class CubePrinter {
    private static Logger log = LoggerFactory.getLogger(CubeSide.class);

    String getFormattedString(List<CubeSide> cube) {
        final int dimension = cube.get(0).getDimension();
        Map<SidePosition3d, Position> positionMap = getPositionMap(dimension);
        boolean[][] printingArea = getPrintingArea(dimension);
        return transformSideToString(cube, printingArea, positionMap);
    }

    protected abstract boolean[][] getPrintingArea(int dimension);

    protected abstract Map<SidePosition3d, Position> getPositionMap(int dimension);


    private String transformSideToString(List<CubeSide> cube, boolean[][] printingArea,
                                         Map<SidePosition3d, Position> printingPositions) {
        for (int i = 0; i < 6; i++) {
            fillInPrintingAreaArray(cube.get(i), printingPositions.get(cube.get(i).getSidePosition3d()), printingArea);
        }
        StringBuilder result = new StringBuilder();

        for (boolean[] aPrintingArea : printingArea) {
            for (boolean anAPrintingArea : aPrintingArea) {
                result.append((anAPrintingArea) ? "o" : " ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private void fillInPrintingAreaArray(CubeSide side, Position position, boolean[][] printingArea) {
        if (side == null) {
            return;
        }
        for (int i = 0; i < side.getDimension(); i++) {
            for (int j = 0; j < side.getMatrix()[i].length; j++) {
                printingArea[position.x + i][position.y + j] = side.getMatrix()[i][j];
            }
        }
    }

    static class Position {
        int x;//pos0
        int y;//pos1

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
