package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class GreatestCommonDivisorTests {
    @Test
    public void greatestCommonDivisorTest(){
        Assert.assertEquals(0, GreatestCommonDivisor.greatestCommonDivisor(0,3));
        Assert.assertEquals(0, GreatestCommonDivisor.greatestCommonDivisor(6,-1));
        Assert.assertEquals(0, GreatestCommonDivisor.greatestCommonDivisor(0,0));
        Assert.assertEquals(1, GreatestCommonDivisor.greatestCommonDivisor(1,1));
        Assert.assertEquals(1, GreatestCommonDivisor.greatestCommonDivisor(1,2));
        Assert.assertEquals(1, GreatestCommonDivisor.greatestCommonDivisor(2,3));
        Assert.assertEquals(2, GreatestCommonDivisor.greatestCommonDivisor(2,4));
        Assert.assertEquals(4, GreatestCommonDivisor.greatestCommonDivisor(16,12));
        Assert.assertEquals(100, GreatestCommonDivisor.greatestCommonDivisor(100,100));
        Assert.assertEquals(4, GreatestCommonDivisor.greatestCommonDivisor(24,20));
    }
}
