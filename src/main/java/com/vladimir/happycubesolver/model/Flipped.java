package com.vladimir.happycubesolver.model;


public enum Flipped {
    NON_FLIPPED {
        public void flip(boolean[][] nonFlipped) {
            //nothing will be done
        }
    },
    FLIPPED {
        public void flip(boolean[][] marrix) {
            for (int i = 0; i < (marrix.length / 2); i++) {
                boolean[] temp = marrix[i];
                marrix[i] = marrix[marrix.length - i - 1];
                marrix[marrix.length - i - 1] = temp;
            }
        }
    };

    public static Flipped of(boolean isFlipped) {
        return isFlipped ? FLIPPED : NON_FLIPPED;
    }

    public abstract void flip(boolean[][] nonFlipped);

}
