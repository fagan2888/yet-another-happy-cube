package com.vladimir.happycubesolver.model;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * SidePosition2d Tester.
 */
public class SidePosition2dTest {

    private static boolean[][] matrix = new boolean[][]{
            {false, false, true},
            {true, true, false},
            {false, true, true}
    };
    private static CubeSide cubeSide = new CubeSide(matrix,
            null, null, null, null);


    /**
     * Method: getSide(CubeSide cubeSide)
     */
    @Test
    public void testGetSideUpEnd() throws Exception {
        boolean[] expected = new boolean[]{false, false, true};
        boolean[] actual = SidePosition2d.UP_END.getSide(cubeSide);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSideUpEndFlip() throws Exception {
        boolean[] expected = new boolean[]{true, false, false};
        boolean[] actual = SidePosition2d.UP_END_FLIP.getSide(cubeSide);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSideDownEnd() throws Exception {
        boolean[] expected = new boolean[]{false, true, true};
        boolean[] actual = SidePosition2d.DOWN_END.getSide(cubeSide);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSideDownEndFlip() throws Exception {
        boolean[] expected = new boolean[]{true, true, false};
        boolean[] actual = SidePosition2d.DOWN_END_FLIP.getSide(cubeSide);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSideLeftEnd() throws Exception {
        boolean[] expected = new boolean[]{false, true, false};
        boolean[] actual = SidePosition2d.LEFT_END.getSide(cubeSide);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSideLeftEndFlip() throws Exception {
        boolean[] expected = new boolean[]{false, true, false};
        boolean[] actual = SidePosition2d.LEFT_END_FLIP.getSide(cubeSide);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSideRightEnd() throws Exception {
        boolean[] expected = new boolean[]{true, false, true};
        boolean[] actual = SidePosition2d.RIGHT_END.getSide(cubeSide);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSideRightEndFlip() throws Exception {
        boolean[] expected = new boolean[]{true, false, true};
        boolean[] actual = SidePosition2d.RIGHT_END_FLIP.getSide(cubeSide);
        assertArrayEquals(expected, actual);
    }
}
