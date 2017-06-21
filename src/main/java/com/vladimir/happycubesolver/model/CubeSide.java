package com.vladimir.happycubesolver.model;

import java.util.Arrays;

/**
 * Cube Domain Model class
 */
public class CubeSide {
    private SidePosition3d sidePosition3d;
    private Rotated rotated;
    private Flipped flipped;
    private boolean[][] matrix;
    private int dimension;
    private InputColor color;

    public CubeSide(boolean[][] matrix,
                    SidePosition3d sidePosition3d,
                    InputColor color,
                    Rotated rotated,
                    Flipped flipped) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Matrix should be square matrix");
        }
        this.matrix = matrix;
        this.dimension = matrix.length;
        this.sidePosition3d = sidePosition3d;
        this.color = color;
        this.rotated = rotated;
        this.flipped = flipped;
    }

    /**
     * Copy constructor
     *
     * @param cubeSideForCopy object for copy
     */
    public CubeSide(CubeSide cubeSideForCopy) {
        if (cubeSideForCopy.matrix.length != cubeSideForCopy.matrix[0].length) {
            throw new IllegalArgumentException("Matrix should be square matrix");
        }
        this.dimension = cubeSideForCopy.matrix.length;
        this.matrix = new boolean[dimension][dimension];
        System.arraycopy(cubeSideForCopy.matrix, 0, this.matrix, 0, dimension);

        this.sidePosition3d = cubeSideForCopy.sidePosition3d;
        this.color = InputColor.of(cubeSideForCopy.color.name());
        this.rotated = cubeSideForCopy.rotated;
        this.flipped = cubeSideForCopy.flipped;
    }


    public int getDimension() {
        return dimension;
    }

    public SidePosition3d getSidePosition3d() {
        return sidePosition3d;
    }

    public InputColor getColor() {
        return color;
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public Rotated getRotated() {
        return rotated;
    }

    public void setRotated(Rotated rotated) {
        this.rotated = rotated;
    }

    public Flipped getFlipped() {
        return flipped;
    }

    public void setFlipped(Flipped flipped) {
        this.flipped = flipped;
    }

    @Override
    public String toString() {
        return "CubeSide{" +
                "sidePosition3d=" + sidePosition3d +
                ", rotated=" + rotated +
                ", flipped=" + flipped +
                ", matrix=" + Arrays.toString(matrix) +
                ", dimension=" + dimension +
                ", color=" + color +
                '}';
    }
}
