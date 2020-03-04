package com.rinaudo.rainwatertrap;

import java.util.List;

/**
 * Utility class containing method with alghoritm to trap the rain water passing in input a {@link List} of height of building blocks
 * 2020/03/02
 *
 * @author salvatore.rinaudo
 */
public class RainWaterTrap {
    private static final int MAX_HEIGHT = 5;

    /**
     * Method to trap rain water when it rains and are building blocks in order to input
     *
     * @param points the sequence of the heights of the building  block
     * @return the area of the  rain trapped, null-safe method
     * @throws IllegalArgumentException if list of points contains negative values or higher of MAX_HEIGHT permitted
     */
    public int trap(List<Integer> points) {
        if (points == null || points.isEmpty() || points.size() == 1) {
            return 0;
        }

        if (points.stream().anyMatch(v -> v < 0 || v > MAX_HEIGHT)) {
            throw new IllegalArgumentException("Numbers must to be non-negative and less than " + MAX_HEIGHT);
        }

        Integer cursorLeft = 0;
        Integer cursorRight = points.size() - 1;
        Integer highestLeft = 0;
        Integer highestRight = 0;

        Integer totalRainWaterTrapped = 0;

        // two cursor way, stop it when are equals
        while (cursorLeft < cursorRight) {
            if (points.get(cursorLeft) > highestLeft) {
                highestLeft = points.get(cursorLeft);
            } else if (points.get(cursorRight) > highestRight) {
                highestRight = points.get(cursorRight);
            } else if (highestLeft < highestRight) {
                totalRainWaterTrapped += Math.max(0, highestLeft - points.get(cursorLeft));
                cursorLeft++;
            } else {
                totalRainWaterTrapped += Math.max(0, highestRight - points.get(cursorRight));
                cursorRight--;
            }
        }

        return totalRainWaterTrapped;
    }
}
