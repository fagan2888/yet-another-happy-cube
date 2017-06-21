package com.vladimir.happycubesolver.model;


public enum CornerPosition2d {
    UP_LEFT {
        public boolean getCorner(CubeSide cubeSide) {
            return cubeSide.getMatrix()[0][0];
        }
    },
    UP_RIGHT {
        public boolean getCorner(CubeSide cubeSide) {
            int dimension = cubeSide.getDimension();
            //return cubeSide.getMatrix().get(dimension - 1, 0);
            return cubeSide.getMatrix()[0][dimension - 1];
        }
    },
    DOWN_LEFT {
        public boolean getCorner(CubeSide cubeSide) {
            int dimension = cubeSide.getDimension();
            //return cubeSide.getMatrix().get(0, dimension - 1);
            return cubeSide.getMatrix()[dimension - 1][0];
        }
    },
    DOWN_RIGHT {
        public boolean getCorner(CubeSide cubeSide) {
            int dimension = cubeSide.getDimension();
            return cubeSide.getMatrix()[dimension - 1][dimension - 1];
        }
    };

    public abstract boolean getCorner(CubeSide cubeSide);
}
