package com.vladimir.happycubesolver.util;

import com.vladimir.happycubesolver.model.SidePosition3d;

import java.util.EnumMap;
import java.util.Map;

import static com.vladimir.happycubesolver.model.SidePosition3d.*;

/**
 * Print input cube in the requested format
 */
public class InputPrinter extends CubePrinter {


    @Override
    protected Map<SidePosition3d, Position> getPositionMap(int dimension) {
        //  Please see the printing area
        //	                 L F R
        //                     D
        //                     B
        //                     U

        Map<SidePosition3d, Position> positionMap = new EnumMap<SidePosition3d, Position>(SidePosition3d.class);
        positionMap.put(LEFT, new Position(0, 0));
        positionMap.put(FRONT, new Position(0, dimension));
        positionMap.put(RIGHT, new Position(0, dimension * 2));
        positionMap.put(DOWN, new Position(dimension, 0));
        positionMap.put(UP, new Position(dimension, dimension));
        positionMap.put(BACK, new Position(dimension, dimension * 2));
        return positionMap;
    }

    @Override
    protected boolean[][] getPrintingArea(int dimension) {
        return new boolean[dimension * 2][dimension * 3];
    }
}
