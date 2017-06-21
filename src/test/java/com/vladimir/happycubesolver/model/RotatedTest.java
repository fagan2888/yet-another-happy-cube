package com.vladimir.happycubesolver.model;


import org.junit.Before;
import org.junit.Test;

import static com.vladimir.happycubesolver.model.Flipped.NON_FLIPPED;
import static org.junit.Assert.assertArrayEquals;

/**
 * Rotated Tester.
 */
public class RotatedTest {

    private boolean[][] nonRotatedMatrix;
    private boolean[][] rotatedOneTimeMatrix;
    private CubeSide notRotatedCubeSide;
    private CubeSide rotatedOneTimeCubeSide;
    private boolean[][] oneExampleSide;
    private boolean[][] anotherSide;
    private CubeSide anotherCubeSide;
    private boolean[][] anotherExampleRotated3times;
    private CubeSide anotherEampleRotated3timesCubeSide;
    private CubeSide notFlippedBigCubeSide;


    @Before
    public void init() {
        this.nonRotatedMatrix = new boolean[][]{
                {false, false, true},
                {true, true, false},
                {false, true, true}
        };

        this.rotatedOneTimeMatrix = new boolean[][]{
                {false, true, false},
                {true, true, false},
                {true, false, true}
        };

        this.notRotatedCubeSide = new CubeSide(nonRotatedMatrix,
                null, null, null, null);


        this.rotatedOneTimeCubeSide = new CubeSide(rotatedOneTimeMatrix,
                null, null, null, null);

        this.oneExampleSide = new boolean[][]{
                {false, false, true, false, false},
                {false, true, true, true, true},
                {true, true, true, true, false},
                {false, true, true, true, true},
                {false, false, true, false, false}
        };

        this.anotherSide = new boolean[][]{
                {true, true, false, true, true},
                {true, true, true, true, false},
                {false, true, true, true, true},
                {true, true, true, true, false},
                {false, true, false, true, false}
        };//up
        this.anotherCubeSide = new CubeSide(anotherSide,
                null, null, null, null);

        this.anotherExampleRotated3times = new boolean[][]{
                {true, false, true, false, false},
                {true, true, true, true, true},
                {false, true, true, true, false},
                {true, true, true, true, true},
                {true, true, false, true, false}
        };//up rotsted 3 times
        this.anotherEampleRotated3timesCubeSide = new CubeSide(anotherExampleRotated3times,
                null, null, null, null);

        this.notFlippedBigCubeSide = new CubeSide(oneExampleSide,
                null, null, null, null);
    }


    @Test
    public void testGetRotatedOnce() throws Exception {
        boolean[][] expected = rotatedOneTimeCubeSide.getMatrix();
        Rotated.ONE_CLOACKEWISE.rotate(notRotatedCubeSide.getMatrix());
        boolean[][] actual = notRotatedCubeSide.getMatrix();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetRotatedThreeTimes() throws Exception {
        boolean[][] expected = anotherEampleRotated3timesCubeSide.getMatrix();
        Rotated._THREE_CLOACKWISE.rotate(anotherCubeSide.getMatrix());
        boolean[][] actual = anotherCubeSide.getMatrix();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testNonFlippedBig() throws Exception {
        boolean[][] expected = notFlippedBigCubeSide.getMatrix();
        NON_FLIPPED.flip(notFlippedBigCubeSide.getMatrix());
        boolean[][] actual = notFlippedBigCubeSide.getMatrix();
        assertArrayEquals(expected, actual);
    }


    /**
     * Method: getFlippedOnce(boolean [] []  nonFlipped)
     */
    @Test
    public void testNonRotated() throws Exception {
        boolean[][] expected = notRotatedCubeSide.getMatrix();
        Rotated.NON_ROTATED.rotate(notRotatedCubeSide.getMatrix());
        boolean[][] actual = notRotatedCubeSide.getMatrix();
        assertArrayEquals(expected, actual);
    }


}
