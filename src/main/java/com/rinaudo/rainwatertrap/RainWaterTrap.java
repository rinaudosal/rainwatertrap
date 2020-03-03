package com.rinaudo.rainwatertrap;

import java.util.List;

/**
 * 2020/03/02
 *
 * @author salvatore.rinaudo
 */
public class RainWaterTrap {
    private static final int MAX_HEIGHT = 5;

    public int calculate(List<Integer> points) {
        if (points == null || points.isEmpty() || points.size() == 1) {
            return 0;
        }

        if (points.stream().anyMatch(v -> v < 0 || v > MAX_HEIGHT)) {
            throw new IllegalArgumentException("Numbers must to be non-negative and less than 5");
        }

        Integer leftBorder = 0;
        Integer highestLeft = 0;

        Integer totalRainWaterTrapped = 0;

        for (int i = 0; i < points.size(); i++) {
            Integer point = points.get(i);

            if (point > leftBorder) { // when point is higher to leftBorder the area is invalid and point become the leftBorder
                totalRainWaterTrapped += Math.max(0, highestLeft - points.get(leftBorder));
                leftBorder = i;
            } else if (point.equals(leftBorder)) { // if point is equals to leftBorder area are trapped and reset data
                int areaTrapped = highestLeft * (i - 1 - leftBorder);

                totalRainWaterTrapped += areaTrapped;
                leftBorder = i;
            } else { // if point is less than leftBorder probably area are trapped
                totalRainWaterTrapped += Math.max(0, highestLeft - point);
                highestLeft = point;
            }

        }

        return totalRainWaterTrapped;
    }
}
