package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class LeastCommonMultipleTests {
    @Test
    public void leastCommonMultipleTest(){
        /*素因子分解*/
        Assert.assertEquals(0, LeastCommonMultiple.leastCommonMultiple(0, 2));
        Assert.assertEquals(0, LeastCommonMultiple.leastCommonMultiple(3, -1));
        Assert.assertEquals(0, LeastCommonMultiple.leastCommonMultiple(0, 0));
        Assert.assertEquals(1, LeastCommonMultiple.leastCommonMultiple(1, 1));
        Assert.assertEquals(2, LeastCommonMultiple.leastCommonMultiple(2, 1));
        Assert.assertEquals(6, LeastCommonMultiple.leastCommonMultiple(3, 2));
        Assert.assertEquals(12, LeastCommonMultiple.leastCommonMultiple(4, 6));
        Assert.assertEquals(100, LeastCommonMultiple.leastCommonMultiple(100, 100));
        Assert.assertEquals(150, LeastCommonMultiple.leastCommonMultiple(25, 30));
        /*定理4，先求最大公约数，再求最小公倍数*/
        Assert.assertEquals(0, LeastCommonMultiple.getLcmByGcd(0, 2));
        Assert.assertEquals(0, LeastCommonMultiple.getLcmByGcd(3, -1));
        Assert.assertEquals(0, LeastCommonMultiple.getLcmByGcd(0, 0));
        Assert.assertEquals(1, LeastCommonMultiple.getLcmByGcd(1, 1));
        Assert.assertEquals(2, LeastCommonMultiple.getLcmByGcd(2, 1));
        Assert.assertEquals(6, LeastCommonMultiple.getLcmByGcd(3, 2));
        Assert.assertEquals(12, LeastCommonMultiple.getLcmByGcd(4, 6));
        Assert.assertEquals(100, LeastCommonMultiple.getLcmByGcd(100, 100));
        Assert.assertEquals(150, LeastCommonMultiple.getLcmByGcd(25, 30));
    }
}
