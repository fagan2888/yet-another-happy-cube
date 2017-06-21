package com.vladimir.happycubesolver;

import com.vladimir.happycubesolver.input.InputCubeFactory;
import com.vladimir.happycubesolver.model.*;
import com.vladimir.happycubesolver.util.DebugCubePrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * HappyCubeSolver Tester
 */
public class HappyCubeSolverTest {

    private boolean[][] expBlueUp = new boolean[][]
            {
                    {true, true, false, true, true},
                    {true, true, true, true, false},
                    {false, true, true, true, true},
                    {true, true, true, true, false},
                    {false, true, false, true, false}
            };

    private boolean[][] expBlueBack = new boolean[][]
            {
                    {false, false, true, false, false},
                    {false, true, true, true, true},
                    {true, true, true, true, false},
                    {false, true, true, true, true},
                    {false, false, true, false, false}
            };

    private boolean[][] expBlueDown = new boolean[][]
            {
                    {true, true, false, true, true},
                    {false, true, true, true, false},
                    {true, true, true, true, true},
                    {false, true, true, true, false},
                    {true, true, false, true, true}
            };

    private boolean[][] expBlueRight = new boolean[][]
            {
                    {true, true, false, true, false},
                    {true, true, true, true, false},
                    {false, true, true, true, true},
                    {true, true, true, true, false},
                    {false, true, false, true, false}
            };


    private boolean[][] expBlueFront = new boolean[][]
            {
                    {false, false, true, false, false},
                    {false, true, true, true, false},
                    {true, true, true, true, true},
                    {false, true, true, true, false},
                    {false, false, true, false, false}
            };


    private boolean[][] expBlueLeft = new boolean[][]
            {
                    {false, false, true, false, true},
                    {true, true, true, true, true},
                    {false, true, true, true, false},
                    {true, true, true, true, true},
                    {false, true, false, true, false}
            };

    private List<CubeSide> getExpectedCubeSides() {
        return Arrays.asList(
                new CubeSide(expBlueFront,
                        SidePosition3d.FRONT,
                        InputColor.BLUE,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(expBlueUp,
                        SidePosition3d.UP,
                        InputColor.BLUE,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(expBlueLeft,
                        SidePosition3d.LEFT,
                        InputColor.BLUE,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(expBlueRight,
                        SidePosition3d.RIGHT,
                        InputColor.BLUE,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(expBlueDown,
                        SidePosition3d.DOWN,
                        InputColor.BLUE,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED),
                new CubeSide(expBlueBack,
                        SidePosition3d.BACK,
                        InputColor.BLUE,
                        Rotated.NON_ROTATED,
                        Flipped.NON_FLIPPED));
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMainWithoutInputParameters() throws Exception {
        new HappyCubeSolver();
        HappyCubeSolver.main(new String[]{});
    }

    @Test
    public void testAllCubes() throws Exception {
        testPartucularCube(InputCubeFactory.getCubeSidesByColor(InputColor.BLUE));
        testPartucularCube(InputCubeFactory.getCubeSidesByColor(InputColor.RED));
        testPartucularCube(InputCubeFactory.getCubeSidesByColor(InputColor.YELLOW));
        testPartucularCube(InputCubeFactory.getCubeSidesByColor(InputColor.VIOLET));
    }

    private void testPartucularCube(List<CubeSide> input) throws Exception {
        HappyCubeSolver happyCubeSolver = new HappyCubeSolver();
        List<CubeSide> result = happyCubeSolver.findFirstSolution(input);
        assertTrue(result != null && !result.isEmpty());
    }

    /**
     * Method: findFirstSolution(List<CubeSide> input)
     */
    @Test
    public void testFindFirstSolution() throws Exception {
        HappyCubeSolver happyCubeSolver = new HappyCubeSolver();
        List<CubeSide> input = InputCubeFactory.getCubeSidesByColor(InputColor.BLUE);
        List<CubeSide> result = happyCubeSolver.findFirstSolution(input);
        DebugCubePrinter.printCubeToConsole(result);
        DebugCubePrinter.printCubeToConsole(getExpectedCubeSides());
        for (CubeSide expSide : getExpectedCubeSides()) {
            for (CubeSide side : result) {
                if (side.getSidePosition3d().equals(expSide.getSidePosition3d())) {
                    assertTrue(Arrays.deepEquals(side.getMatrix(), expSide.getMatrix()));
                }
            }
        }
    }


}
