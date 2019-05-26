package com.dotwait.integer;

import org.junit.Assert;
import org.junit.Test;

public class IntegerMultiplicationTests {
    @Test
    public void integerMultiplyTest(){
        Assert.assertTrue(6 == IntegerMultiplication.multiply(2,3));
        Assert.assertTrue(0 == IntegerMultiplication.multiply(0,3));
        Assert.assertTrue(0 == IntegerMultiplication.multiply(12,0));
        Assert.assertTrue(36 == IntegerMultiplication.multiply(12,3));
        Assert.assertTrue(100 == IntegerMultiplication.multiply(25,4));
    }
}
