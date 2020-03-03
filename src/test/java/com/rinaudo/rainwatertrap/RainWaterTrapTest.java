package com.rinaudo.rainwatertrap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

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
        assertEquals("Invalid rain area calculated", 0, areaToCheck);
    }

    @Test
    public void calculateReturnZeroOnEmptyParams() {
        int areaToCheck = target.calculate(Collections.emptyList());
        assertEquals(0, areaToCheck);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateThrowAnExceptionOnNegativeValues() {
        target.calculate(Arrays.asList(1, -2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateThrowAnExceptionOnHighto5Values() {
        target.calculate(Arrays.asList(1, 6));
    }

    @Test
    public void simpleOperationReturnsOneAreaValueCorrectly() {
        assertEquals(1,
            target.calculate(Arrays.asList(1, 0, 1)));
        assertEquals(1,
            target.calculate(Arrays.asList(1, 0, 2)));
        assertEquals(1,
            target.calculate(Arrays.asList(0, 2, 0, 1)));
    }

    @Test
    public void bulkOperationCheckReturnsZeroValueCorrectly() {
        assertEquals(0,
            target.calculate(Arrays.asList(0, 0, 1, 1, 1)));
        assertEquals(0,
            target.calculate(Arrays.asList(1, 1, 1, 0, 0)));
        assertEquals(0,
            target.calculate(Arrays.asList(1, 1, 1, 1, 1)));
        assertEquals(0,
            target.calculate(Arrays.asList(0, 0, 0, 0, 0)));
    }

    @Test
    public void calculateReturnAreaOnParams() {
        int areaToCheck = target.calculate(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
        assertEquals(6, areaToCheck);
    }


}
