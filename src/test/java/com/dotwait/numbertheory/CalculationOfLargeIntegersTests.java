package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class CalculationOfLargeIntegersTests {
    @Test
    public void calculationOfLargeIntegersTest(){
        Assert.assertEquals(0,
                CalculationOfLargeIntegers.largeIntegersAddition(0,0,
                        new int[]{99,98,97,95}));
        Assert.assertEquals(0,
                CalculationOfLargeIntegers.largeIntegersAddition(0,1,
                        new int[]{99,98,97,95}));
        Assert.assertEquals(0,
                CalculationOfLargeIntegers.largeIntegersAddition(-1,0,
                        new int[]{99,98,97,95}));
        Assert.assertEquals(537140,
                CalculationOfLargeIntegers.largeIntegersAddition(123684,413456,
                        new int[]{99,98,97,95}));
        Assert.assertEquals(24691356,
                CalculationOfLargeIntegers.largeIntegersAddition(12345678,12345678,
                        new int[]{99,98,97,95}));
        Assert.assertEquals(246912,
                CalculationOfLargeIntegers.largeIntegersAddition(123456,123456,
                        new int[]{99,98,97,95}));
    }
}
