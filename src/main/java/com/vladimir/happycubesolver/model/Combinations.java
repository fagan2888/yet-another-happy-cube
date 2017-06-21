package com.vladimir.happycubesolver.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.vladimir.happycubesolver.model.CornerPosition2d.*;
import static com.vladimir.happycubesolver.model.SidePosition2d.*;
import static com.vladimir.happycubesolver.model.SidePosition3d.*;

/**
 * The class provide cube sides collision combination
 */
public class Combinations {

    private static Logger log = LoggerFactory.getLogger(Combinations.class);

    private static CornerBrink[][] cornerCombinations = new CornerBrink[][]{
            {new CornerBrink(FRONT, UP_LEFT), new CornerBrink(LEFT, UP_RIGHT), new CornerBrink(UP, DOWN_LEFT)},
            {new CornerBrink(FRONT, UP_RIGHT), new CornerBrink(RIGHT, UP_LEFT), new CornerBrink(UP, DOWN_RIGHT)},
            {new CornerBrink(FRONT, DOWN_LEFT), new CornerBrink(LEFT, DOWN_RIGHT), new CornerBrink(DOWN, UP_LEFT)},
            {new CornerBrink(FRONT, DOWN_RIGHT), new CornerBrink(RIGHT, DOWN_LEFT), new CornerBrink(DOWN, UP_RIGHT)},
            {new CornerBrink(BACK, UP_LEFT), new CornerBrink(LEFT, DOWN_LEFT), new CornerBrink(DOWN, DOWN_LEFT)},
            {new CornerBrink(BACK, UP_RIGHT), new CornerBrink(RIGHT, DOWN_RIGHT), new CornerBrink(DOWN, DOWN_RIGHT)},
            {new CornerBrink(BACK, DOWN_LEFT), new CornerBrink(LEFT, UP_LEFT), new CornerBrink(UP, UP_LEFT)},
            {new CornerBrink(BACK, DOWN_RIGHT), new CornerBrink(RIGHT, UP_RIGHT), new CornerBrink(UP, UP_RIGHT)}
    };

    private static SideBrink[][] sideCombinations = new SideBrink[][]{
            {new SideBrink(FRONT, UP_END), new SideBrink(UP, DOWN_END)},
            {new SideBrink(FRONT, DOWN_END), new SideBrink(DOWN, UP_END)},
            {new SideBrink(DOWN, DOWN_END), new SideBrink(BACK, UP_END)},
            {new SideBrink(BACK, DOWN_END), new SideBrink(UP, UP_END)},
            {new SideBrink(LEFT, RIGHT_END), new SideBrink(FRONT, LEFT_END)},
            {new SideBrink(FRONT, RIGHT_END), new SideBrink(RIGHT, LEFT_END)},
            {new SideBrink(BACK, LEFT_END_FLIP), new SideBrink(LEFT, LEFT_END)},
            {new SideBrink(BACK, RIGHT_END_FLIP), new SideBrink(RIGHT, RIGHT_END)},
            {new SideBrink(LEFT, UP_END), new SideBrink(UP, LEFT_END)},//F
            {new SideBrink(RIGHT, UP_END), new SideBrink(UP, RIGHT_END_FLIP)},
            {new SideBrink(LEFT, DOWN_END), new SideBrink(DOWN, LEFT_END_FLIP)},
            {new SideBrink(RIGHT, DOWN_END), new SideBrink(DOWN, RIGHT_END)}, //Flip?
    };

    public static boolean isAllCornersCompatible(List<CubeSide> placedSides) {
        log.debug("isAllCornersCompatible:" + Arrays.toString(placedSides.toArray()));

        Map<SidePosition3d, CubeSide> placedCubeSideMap = new HashMap<SidePosition3d, CubeSide>();
        for (CubeSide cubeSide : placedSides) {
            placedCubeSideMap.put(cubeSide.getSidePosition3d(), cubeSide);
        }
        // take one cude side and compare it against all combination
        for (CornerBrink[] cornerBrinks : cornerCombinations) {
            CornerBrink first = cornerBrinks[0];
            CornerBrink second = cornerBrinks[1];
            CornerBrink third = cornerBrinks[2];
            if (!isThreeCornersCompatible(first, second, third, placedCubeSideMap)) {
                log.trace(new StringBuilder().append("Corners: ").append(first).append(", ").append(second).append(" ,").append(third).toString());
                return false;
            }
        }
        return true;
    }

    private static boolean isThreeCornersCompatible(CornerBrink first, CornerBrink second, CornerBrink third,
                                                    Map<SidePosition3d, CubeSide> placedCubeSideMap) {
        int numberOfTrue = 0;
        if (first.getCornerPosition2d().getCorner(placedCubeSideMap.get(first.getSidePosition3d()))) {
            numberOfTrue++;
        }
        if (second.getCornerPosition2d().getCorner(placedCubeSideMap.get(second.getSidePosition3d()))) {
            numberOfTrue++;
        }
        if (third.getCornerPosition2d().getCorner(placedCubeSideMap.get(third.getSidePosition3d()))) {
            numberOfTrue++;
        }
        return numberOfTrue <= 1;

    }

    public static boolean isAllSidesCompatible(List<CubeSide> placedSides) {
        log.debug("isAllSidesCompatible:" + Arrays.toString(placedSides.toArray()));
        Map<SidePosition3d, CubeSide> placedSidesMap = new HashMap<SidePosition3d, CubeSide>();
        for (CubeSide cubeSide : placedSides) {
            placedSidesMap.put(cubeSide.getSidePosition3d(), cubeSide);
        }
        for (SideBrink[] cornerBrinks : sideCombinations) {
            SideBrink first = cornerBrinks[0];
            SideBrink second = cornerBrinks[1];
            if (!isTwoSidesCompatible(first, second, placedSidesMap)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isTwoSidesCompatible(SideBrink first, SideBrink second,
                                                Map<SidePosition3d, CubeSide> placedSides) {
        boolean result = middleNotCompatable(first.getSidePosition2D().getSide(placedSides.get(first.getSidePosition3d()))
                , second.getSidePosition2D().getSide(placedSides.get(second.getSidePosition3d())),
                placedSides.values().iterator().next().getDimension());
        return !result;

    }

    private static boolean middleNotCompatable(boolean[] edge1, boolean[] edge2, int dim) {
        for (int i = 1; i < dim - 1; i++) {
            if (!edge1[i] ^ edge2[i]) {
                return true;
            }
        }
        return false;
    }


}


