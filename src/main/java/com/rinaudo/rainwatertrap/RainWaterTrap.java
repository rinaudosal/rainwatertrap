package com.rinaudo.rainwatertrap;

import java.util.List;

/**
 * 2020/03/02
 *
 * @author salvatore.rinaudo
 */
public class RainWaterTrap {

    public int calculate(List<Integer> points) {
        if (points == null || points.isEmpty() || points.size() == 1) {
            return 0;
        }

        if (points.stream().anyMatch(v -> v < 0)) {
            throw new IllegalArgumentException("Numbers must to be non-negative");
        }


        Integer leftBorder = 0;
        Integer height = 0;
        Integer areaToGrab = 0;

        Integer totalRainWaterTrapped = 0;

        for (int i = 0; i < points.size(); i++) {
            Integer point = points.get(i);

            if (point > leftBorder) { // when point is higher to leftBorder the area is invalid and point become the leftBorder
                totalRainWaterTrapped += areaToGrab;
                areaToGrab = 0;
                height = point;
                leftBorder = i;
            } else if (point.equals(leftBorder)) { // if point is equals to leftBorder area are trapped and reset data
                int areaTrapped = height * (i -1 - leftBorder);

                areaToGrab -= areaTrapped;
                totalRainWaterTrapped += areaTrapped;
            } else { // if point is less than leftBorder probably area are trapped
                areaToGrab += (height-point) * (i-leftBorder);
            }

        }

        return totalRainWaterTrapped;
    }
}
