package com.vladimir.happycubesolver.util;

import com.vladimir.happycubesolver.input.InputCubeFactory;
import com.vladimir.happycubesolver.model.CubeSide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

/**
 * Print in the requested format
 */
public class FormattedResultPrinter {

    private static Logger log = LoggerFactory.getLogger(FormattedResultPrinter.class);

    /**
     * Print cube to file in requested format
     *
     * @param cube                List of cube sides. It should be not null and not empty
     * @param filePath            Result file path
     * @param shouldPrint2Console true if you need to print the cube to the console as well
     */
    public static void print(List<CubeSide> cube, String filePath, boolean shouldPrint2Console) {
        log.info("\n" + "Print cube to file" +
                (shouldPrint2Console ? " and console" : "") + System.getProperty("line.separator"));
        String result = "";
        result += "The pieces of the " + cube.get(0).getColor().name().toLowerCase()
                + " cube look as follows:" + System.getProperty("line.separator");
        result += new InputPrinter().getFormattedString
                (InputCubeFactory.getCubeSidesByColor(cube.get(0).getColor()));
        result += System.getProperty("line.separator");
        result += "One of the solutions in \"unfolded form\" looks as follows:" + System.getProperty("line.separator");
        result += new SolutionPrinter().getFormattedString(cube);

        if (shouldPrint2Console) {
            printToConsole(cube, result);
        }

        printToAsciiFile(filePath, result);
    }

    private static void printToAsciiFile(String filePath, String result) {
        PrintWriter out = null;
        try {
            File file = new File(filePath);
            out = new PrintWriter(file, "ASCII");
            out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static void printToConsole(List<CubeSide> cube, String result) {
        System.out.println("\n" + "Solution for color: " + cube.get(0).getColor());
        System.out.println("\n" + result);
    }

}
