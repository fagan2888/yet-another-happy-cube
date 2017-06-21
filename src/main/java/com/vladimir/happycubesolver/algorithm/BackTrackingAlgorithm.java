package com.vladimir.happycubesolver.algorithm;

import com.vladimir.happycubesolver.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class BackTrackingAlgorithm {

    private final static Logger log = LoggerFactory.getLogger(BackTrackingAlgorithm.class);
    private static AtomicInteger counter = new AtomicInteger(0);

    private List<CubeSide> getSolvedCube(List<List<Integer>> permutations, final int indexOfPermutationList,
                                         List<CubeSide> copyInput) {
        log.info("Permutation=" + indexOfPermutationList);
        List<Integer> permutationForThisCase = permutations.get(indexOfPermutationList);

        CubeSide[] shuffledCubeSides = new CubeSide[6];
        // First piece will never be changed
        shuffledCubeSides[0] = new CubeSide(copyInput.get(0).getMatrix(),
                SidePosition3d.of(0), copyInput.get(0).getColor(), copyInput.get(0).getRotated(), copyInput.get(0).getFlipped());
        for (int j = 0; j < 5; j++) {
            CubeSide tmpCubeSide = copyInput.get(permutationForThisCase.get(j));//
            shuffledCubeSides[j + 1] = new CubeSide(tmpCubeSide.getMatrix(),
                    SidePosition3d.of(j + 1), tmpCubeSide.getColor(), tmpCubeSide.getRotated(), tmpCubeSide.getFlipped());
        }

        List<CubeSide> unsolved = new ArrayList<CubeSide>(Arrays.asList(shuffledCubeSides));
        // The point of invocation of recursive algorithm
        List<CubeSide> result = isCompatible(new ArrayList<CubeSide>(unsolved.subList(0, 1)),
                new ArrayList<CubeSide>(unsolved.subList(1, unsolved.size())));

        if (result != null && !result.isEmpty()) {
            log.info("First solution have been found.");
            return result;
        } else {
            return Collections.emptyList();
        }
    }

    // Recursive algorithm
    private List<CubeSide> isCompatible(List<CubeSide> placedSides,
                                        List<CubeSide> unplacedPieces) {
        log.debug("Counter=" + counter.getAndIncrement());
        log.debug("placedSides=" + placedSides.size() +
                " unplacedPieces=" + unplacedPieces.size());
        // Base case
        if (unplacedPieces.size() == 0) {
            if (!(Combinations.isAllSidesCompatible(placedSides)
                    && Combinations.isAllCornersCompatible(placedSides))) {
                return Collections.emptyList();
            }

            return placedSides;
        }

        // Recursive case
        boolean isFlipped = false;
        int rotatedTimes = 0;
        CubeSide cubeSide = unplacedPieces.get(0);
        for (int i = 0; i < 8; i++) {
            boolean[][] matrix = cubeSide.getMatrix();
            if (i == 4) {
                rotatedTimes = 0;
                isFlipped = true;
                Flipped.FLIPPED.flip(matrix);
            }
            rotatedTimes++;
            Rotated.ONE_CLOACKEWISE.rotate(matrix);

            List<CubeSide> subPieces = new ArrayList<CubeSide>(placedSides);
            cubeSide.setRotated(Rotated.of(rotatedTimes));
            cubeSide.setFlipped(Flipped.of(isFlipped));

            subPieces.add(0, cubeSide);

            List<CubeSide> result = isCompatible(subPieces, unplacedPieces.subList(1, unplacedPieces.size()));
            if (!result.isEmpty()) {
                return result;
            }
        }
        // No solutions were found
        return Collections.emptyList();
    }

    public List<CubeSide> solve(List<CubeSide> input) throws Exception {
        // For each variant of placing pieces
        List<List<Integer>> permutations = permute(new int[]{1, 2, 3, 4, 5});
        log.info("Permutation size=" + permutations.size());

        // Call  for each permutation
        for (int i = 0; i < permutations.size(); i++) {
            List<CubeSide> copyInput = new ArrayList<CubeSide>();
            for (CubeSide cubeSide : input) {
                copyInput.add(new CubeSide(cubeSide));
            }
            List<CubeSide> result = getSolvedCube(permutations, i, copyInput);
            if (result != null && !result.isEmpty()) {
                return result;
            }
        }
        return Collections.emptyList();
    }

    /**
     * Find all permutation for given array
     *
     * @param numbers which should be permutated
     * @return List of List of permuted numbers
     */
    private List<List<Integer>> permute(int[] numbers) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        permutations.add(new ArrayList<Integer>());

        for (int number : numbers) {
            List<List<Integer>> current = new ArrayList<List<Integer>>();
            for (List<Integer> permutation : permutations) {
                int j = 0;
                int n = permutation.size() + 1;
                while (j < n) {
                    List<Integer> temp = new ArrayList<Integer>(permutation);
                    temp.add(j, number);
                    current.add(temp);
                    j++;
                }
            }
            permutations = new ArrayList<List<Integer>>(current);
        }
        return permutations;
    }

}
