package com.vladimir.happycubesolver.model;


/**
 * Colors of input cubes
 */
public enum InputColor {
    BLUE,
    RED,
    VIOLET,
    YELLOW,
    UNKNOWN;

    public static InputColor of(String input) {
        try {
            return InputColor.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }

    public static String getCommaSeparatedList() {
        StringBuilder result = new StringBuilder();
        InputColor[] colors = InputColor.values();
        boolean isFirst = true;
        for (InputColor color : colors) {
            if (color != InputColor.UNKNOWN) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    result.append(", ");
                }
                result.append(color);
            }
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
