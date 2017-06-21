package com.vladimir.happycubesolver.model;

public enum SidePosition2d {

    UP_END {
        public boolean[] getSide(CubeSide cubeSide) {
            boolean[] result = new boolean[cubeSide.getDimension()];
            System.arraycopy(cubeSide.getMatrix()[0], 0, result, 0, cubeSide.getDimension());
            return result;
        }
    },
    LEFT_END {
        public boolean[] getSide(CubeSide cubeSide) {
            boolean[] result = new boolean[cubeSide.getDimension()];
            for (int i = 0; i < cubeSide.getDimension(); i++) {
                result[i] = cubeSide.getMatrix()[i][0];
            }
            return result;
        }
    },
    RIGHT_END {
        public boolean[] getSide(CubeSide cubeSide) {
            boolean[] result = new boolean[cubeSide.getDimension()];
            for (int i = 0; i < cubeSide.getDimension(); i++) {
                result[i] = cubeSide.getMatrix()[i][cubeSide.getDimension() - 1];
            }
            return result;
        }
    },
    DOWN_END {
        public boolean[] getSide(CubeSide cubeSide) {
            boolean[] result = new boolean[cubeSide.getDimension()];
            System.arraycopy(cubeSide.getMatrix()[cubeSide.getDimension() - 1], 0, result, 0, cubeSide.getDimension());
            return result;
        }
    },
    UP_END_FLIP {
        public boolean[] getSide(CubeSide cubeSide) {
            boolean[] result = new boolean[cubeSide.getDimension()];
            for (int i = 0; i < cubeSide.getDimension(); i++) {
                result[i] = cubeSide.getMatrix()[0][cubeSide.getDimension() - 1 - i];
            }
            return result;
        }

    },
    LEFT_END_FLIP {
        public boolean[] getSide(CubeSide cubeSide) {
            boolean[] result = new boolean[cubeSide.getDimension()];
            for (int i = 0; i < cubeSide.getDimension(); i++) {
                result[i] = cubeSide.getMatrix()[cubeSide.getDimension() - 1 - i][0];
            }
            return result;
        }
    },
    RIGHT_END_FLIP {
        public boolean[] getSide(CubeSide cubeSide) {
            boolean[] result = new boolean[cubeSide.getDimension()];
            for (int i = 0; i < cubeSide.getDimension(); i++) {
                result[i] = cubeSide.getMatrix()[cubeSide.getDimension() - 1 - i][cubeSide.getDimension() - 1];
            }
            return result;
        }
    },
    DOWN_END_FLIP {
        public boolean[] getSide(CubeSide cubeSide) {
            boolean[] result = new boolean[cubeSide.getDimension()];
            for (int i = 0; i < cubeSide.getDimension(); i++) {
                result[i] = cubeSide.getMatrix()[cubeSide.getDimension() - 1][cubeSide.getDimension() - 1 - i];
            }
            return result;
        }
    };

    /**
     * @param cubeSide cube side
     * @return return copy of one dimension array which represent the side of two dimension array
     */
    public abstract boolean[] getSide(CubeSide cubeSide);


}
