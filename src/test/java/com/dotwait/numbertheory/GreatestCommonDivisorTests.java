package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class GreatestCommonDivisorTests {
    @Test
    public void greatestCommonDivisorTest(){
        /*素因子分解*/
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
        /*欧几里得算法*/
        Assert.assertEquals(0, GreatestCommonDivisor.euclideanAlgorithm(0,3));
        Assert.assertEquals(0, GreatestCommonDivisor.euclideanAlgorithm(6,-1));
        Assert.assertEquals(0, GreatestCommonDivisor.euclideanAlgorithm(0,0));
        Assert.assertEquals(1, GreatestCommonDivisor.euclideanAlgorithm(1,1));
        Assert.assertEquals(1, GreatestCommonDivisor.euclideanAlgorithm(1,2));
        Assert.assertEquals(1, GreatestCommonDivisor.euclideanAlgorithm(2,3));
        Assert.assertEquals(2, GreatestCommonDivisor.euclideanAlgorithm(2,4));
        Assert.assertEquals(4, GreatestCommonDivisor.euclideanAlgorithm(16,12));
        Assert.assertEquals(100, GreatestCommonDivisor.euclideanAlgorithm(100,100));
        Assert.assertEquals(4, GreatestCommonDivisor.euclideanAlgorithm(24,20));
    }
}
