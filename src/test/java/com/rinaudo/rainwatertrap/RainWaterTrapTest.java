package com.rinaudo.rainwatertrap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;

/**
 * 2020/03/02
 *
 * @author salvatore.rinaudo
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class RainWaterTrapTest {
    private RainWaterTrap target;

    @Before
    public void setUp() {
        target = new RainWaterTrap();
    }

    @Test
    public void calculateReturnZeroOnNullParams() {
        int areaToCheck = target.calculate(null);
        Assert.assertEquals("Invalid rain area calculated", 0, areaToCheck);
    }

    @Test
    public void calculateReturnZeroOnEmptyParams() {
        int areaToCheck = target.calculate(Collections.emptyList());
        Assert.assertEquals("Invalid rain area calculated", 0, areaToCheck);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateThrowAnExceptionOnNegativeValues() {
        target.calculate(Arrays.asList(1, -2));
    }

    @Test
    public void calculateReturnAreaOnParams() {
        int areaToCheck = target.calculate(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
        Assert.assertEquals("Invalid rain area calculated", 6, areaToCheck);
    }


}
