package com.vladimir.happycubesolver;

import com.vladimir.happycubesolver.algorithm.BackTrackingAlgorithm;
import com.vladimir.happycubesolver.input.InputCubeFactory;
import com.vladimir.happycubesolver.model.CubeSide;
import com.vladimir.happycubesolver.model.InputColor;
import com.vladimir.happycubesolver.util.FormattedResultPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * The main class
 */
public class HappyCubeSolver {
    private final static String PATH_TO_FILE = "./solution.txt";
    private static Logger log = LoggerFactory.getLogger(HappyCubeSolver.class);

    public static void main(String[] args) {
        try {
            String requestedColorString = args.length != 1 ? "UNKNOWN" : args[0];
            InputColor requestedColor = InputColor.of(String.valueOf(requestedColorString).trim());
            if (requestedColor == InputColor.UNKNOWN) {
                System.err.print("Please use the following arguments: " + System.getProperty("line.separator"));
                System.err.print(InputColor.getCommaSeparatedList());
                System.err.print(System.getProperty("line.separator") + System.getProperty("line.separator"));
                System.err.print("Example: HappyCubeSolver blue");
                System.err.print(System.getProperty("line.separator"));
                return;
            }
            HappyCubeSolver happyCubeSolver = new HappyCubeSolver();
            List<CubeSide> input = InputCubeFactory.getCubeSidesByColor(InputColor.of(requestedColorString.trim()));
            log.debug("Input loaded.");
            List<CubeSide> firstSolution = happyCubeSolver.findFirstSolution(input);
            if (firstSolution == null || firstSolution.isEmpty()) {
                System.err.print("Solution was not found for the cube with color: " + requestedColor.name());
                return;
            }
            FormattedResultPrinter.print(firstSolution, PATH_TO_FILE, false);
            log.debug("Solution printed.");
        } catch (Throwable ex) {
            System.err.println("Uncaught exception - " + ex.getMessage());
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }

    List<CubeSide> findFirstSolution(List<CubeSide> input) throws Exception {
        BackTrackingAlgorithm algorithm =
                new BackTrackingAlgorithm();
        return algorithm.solve(input);
    }

}
