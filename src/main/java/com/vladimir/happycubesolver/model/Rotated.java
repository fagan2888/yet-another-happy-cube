package com.vladimir.happycubesolver.model;

public enum Rotated {
    NON_ROTATED {
        public void rotate(boolean[][] nonRotated) {
            //nothing will be done
        }

        public int getRotationQuantity() {
            return 0;
        }
    },
    ONE_CLOACKEWISE {
        public void rotate(boolean[][] nonRotated) {
            rotateClockWise(nonRotated);
        }

        public int getRotationQuantity() {
            return 1;
        }
    },
    TWO_CLOACKEWISE {
        public void rotate(boolean[][] nonRotated) {
            rotateClockWise(nonRotated);
            rotateClockWise(nonRotated);
        }

        public int getRotationQuantity() {
            return 2;
        }

    },
    _THREE_CLOACKWISE {
        public void rotate(boolean[][] nonRotated) {
            rotateClockWise(nonRotated);
            rotateClockWise(nonRotated);
            rotateClockWise(nonRotated);
        }

        public int getRotationQuantity() {
            return 3;
        }
    };

    private static void rotateClockWise(boolean[][] matrix) {
        rotateClockwise(matrix, matrix.length);
    }

    public static Rotated of(int rotatedTimes) {
        if (rotatedTimes < 1 || rotatedTimes > 4) {
            throw new IllegalArgumentException("Rotated emum element was not recognized");
        }
        Rotated[] rotatedTimesArray = new Rotated[]{ONE_CLOACKEWISE, TWO_CLOACKEWISE, _THREE_CLOACKWISE, NON_ROTATED};
        return rotatedTimesArray[rotatedTimes - 1];
    }

    /**
     * Method to rotate a matrix by 90degree clockwise
     *
     * @param matrix Matix to rotate
     * @param order  Order of the marix.
     */
    public static void rotateClockwise(final boolean[][] matrix, final int order) {
        transposeMatrix(matrix, order);
        mirrorHorizontally(matrix, order);
    }

    /**
     * Method to take transpose of a given matrix.
     *
     * @param matrix Matrix to be transposed.
     * @param order  Order of the matrix.
     */
    private static void transposeMatrix(final boolean[][] matrix, final int order) {
        for (int i = 0; i < order; i++) {
            for (int j = i + 1; j < order; j++) {
                boolean temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * Method to take mirror the matrix horizontally.
     *
     * @param matrix Matrix to mirror.
     * @param order  Order of the matrix.
     */
    private static void mirrorHorizontally(final boolean[][] matrix, final int order) {
        for (int i = 0; i < order / 2; i++) {
            for (int j = 0; j < order; j++) {
                boolean temp = matrix[j][i];
                matrix[j][i] = matrix[j][order - (i + 1)];
                matrix[j][order - (i + 1)] = temp;
            }
        }
    }

    public abstract void rotate(boolean[][] nonRotated);

    public abstract int getRotationQuantity();


}