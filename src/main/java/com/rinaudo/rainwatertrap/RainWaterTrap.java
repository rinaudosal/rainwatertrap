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

        return 0;
    }
}
