package com.vladimir.happycubesolver.model;

import org.junit.Test;

import static com.vladimir.happycubesolver.model.Flipped.FLIPPED;
import static com.vladimir.happycubesolver.model.Flipped.NON_FLIPPED;
import static org.junit.Assert.assertArrayEquals;


/**
 * Flipped Tester.
 */
public class FlippedTest {

    private static boolean[][] nonFlippedMatrix = new boolean[][]{
            {false, false, true},
            {true, true, false},
            {false, true, true}
    };

    private static boolean[][] flippedOneTimeMatrix = new boolean[][]{
            {false, true, true},
            {true, true, false},
            {false, false, true}
    };


    private static CubeSide notFlippedCubeSide = new CubeSide(nonFlippedMatrix,
            null, null, null, null);


    private static CubeSide flippedOneTimeCubeSide = new CubeSide(flippedOneTimeMatrix,
            null, null, null, null);

    /**
     * Method: getFlippedOnce(boolean [] []  nonFlipped)
     */
    @Test
    public void testGetFlippedOnce() throws Exception {
        boolean[][] expected = flippedOneTimeCubeSide.getMatrix();

        FLIPPED.flip(notFlippedCubeSide.getMatrix());
        boolean[][] actual = notFlippedCubeSide.getMatrix();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testNonFlipped() throws Exception {
        boolean[][] expected = notFlippedCubeSide.getMatrix();
        NON_FLIPPED.flip(notFlippedCubeSide.getMatrix());
        boolean[][] actual = notFlippedCubeSide.getMatrix();
        assertArrayEquals(expected, actual);
    }
}
