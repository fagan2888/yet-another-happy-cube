package com.vladimir.happycubesolver.util;

import com.vladimir.happycubesolver.model.CubeSide;
import com.vladimir.happycubesolver.model.SidePosition3d;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static com.vladimir.happycubesolver.model.SidePosition3d.*;

/*
    ________
  / | U     /|
 /__|___B_ / |
| L |_F_ _|_R|
|  /      | /
|/____D___|/

*/
/*

Print additional parameters for debug proposal only:
 LEFT, RIGHT, etc - real position
 FLIPPED, ROTATED - transformation

The result will be printed as:

LEFT FRONT RIGHT
     BOTTOM
     BACK
     UP
 */

@Deprecated
public class DebugCubePrinter extends SolutionPrinter {

    private static Logger log = LoggerFactory.getLogger(DebugCubePrinter.class);

    public static void printCubeToConsole(List<CubeSide> cube) {
        if (cube.isEmpty()) {
            log.info("No solution");
            return;
        }
        final int DIM = cube.get(0).getDimension();
        boolean[][] printingArea = new boolean[DIM * 4][DIM * 3]; // y x - axises
        //  Please see the printing area
        //	                 L F R
        //                     D
        //                     B
        //                     U


        Map<SidePosition3d, Position> positionMap = new EnumMap<SidePosition3d, Position>(SidePosition3d.class);
        positionMap.put(FRONT, new Position(0, DIM));//representation error
        positionMap.put(UP, new Position(DIM * 3, DIM));
        positionMap.put(LEFT, new Position(0, 0));
        positionMap.put(RIGHT, new Position(0, DIM * 2));
        positionMap.put(DOWN, new Position(DIM, DIM));
        positionMap.put(BACK, new Position(DIM * 2, DIM));
        log.info("\n" + "Print cube to console" + "\n");
        System.out.println("\"Print cube to console\"");

        String result = DebugCubePrinter.printSideToConsoleWithPosition(cube, printingArea, positionMap);
        log.info("\n" + result);
    }

    private static String printSideToConsoleWithPosition(List<CubeSide> cube, boolean[][] printingArea,
                                                         Map<SidePosition3d, Position> printingPositions) {
        final int DIM = cube.get(0).getDimension();
        String[][] stringPrintingArea = new String[DIM * 4][DIM * 3]; // y x - axises;
        for (int i = 0; i < stringPrintingArea.length; i++) {
            for (int j = 0; j < stringPrintingArea[0].length; j++) {
                stringPrintingArea[i][j] = " ";
            }
        }

        for (int i = 0; i < 6; i++) {
            fillInStringPrintingAreaArray(cube.get(i), printingPositions.get(cube.get(i).getSidePosition3d()), stringPrintingArea);
        }
        StringBuilder result = new StringBuilder();

        for (String[] aStringPrintingArea : stringPrintingArea) {
            for (String anAStringPrintingArea : aStringPrintingArea) {
                result.append(anAStringPrintingArea);
            }
            result.append("\n");
        }
        return result.toString();
    }

    private static void fillInStringPrintingAreaArray(CubeSide side, Position position, String[][] stringPrintingArea) {
        if (side == null) {
            throw new IllegalArgumentException("Cube side equal null - it is wrong.");
        }


        int middleIndex = side.getDimension() / 2;
        for (int i = 0; i < side.getDimension(); i++) {
            for (int j = 0; j < side.getMatrix()[i].length; j++) {
                if (i == middleIndex && j == middleIndex) {
                    stringPrintingArea[position.x + i][position.y + j] = /*side.getFlipped().toString().substring(0, 1);*/ side.getSidePosition3d().toString().substring(0, 1);
                } else {
                    stringPrintingArea[position.x + i][position.y + j] = side.getMatrix()[i][j] ? side.getRotated().toString().substring(0, 1) : " ";
                }

            }
        }
    }
}
