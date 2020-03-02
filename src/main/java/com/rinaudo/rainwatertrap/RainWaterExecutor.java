package com.rinaudo.rainwatertrap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2020/03/02
 *
 * @author salvatore.rinaudo
 */
public class RainWaterExecutor {

    public static void main(String[] args) {
        List<Integer> points = Stream.of(args)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        System.out.println("Rain water trapped: " + new RainWaterTrap().calculate(points));
    }

}
