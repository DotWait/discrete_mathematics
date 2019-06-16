package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class BezoPrincipleTests {
    @Test
    public void bezoPrincipleTest(){
        Assert.assertArrayEquals(new int[]{0,0,0}, BezoPrinciple.bezoPrinciple(0,2));
        Assert.assertArrayEquals(new int[]{0,0,0}, BezoPrinciple.bezoPrinciple(3,-1));
        Assert.assertArrayEquals(new int[]{0,0,0}, BezoPrinciple.bezoPrinciple(0,0));
        Assert.assertArrayEquals(new int[]{1,0,1}, BezoPrinciple.bezoPrinciple(1,1));
        Assert.assertArrayEquals(new int[]{1,1,0}, BezoPrinciple.bezoPrinciple(1,2));
        Assert.assertArrayEquals(new int[]{2,0,1}, BezoPrinciple.bezoPrinciple(2,2));
        Assert.assertArrayEquals(new int[]{1,-7,11}, BezoPrinciple.bezoPrinciple(47,30));
        Assert.assertArrayEquals(new int[]{18,4,-5}, BezoPrinciple.bezoPrinciple(252,198));
    }
}
