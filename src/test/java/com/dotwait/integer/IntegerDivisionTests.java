package com.dotwait.integer;

import org.junit.Assert;
import org.junit.Test;

public class IntegerDivisionTests {
    @Test
    public void integerDivisionTest(){
        Assert.assertArrayEquals(new int[]{3,1}, IntegerDivision.division(7, 2));
        Assert.assertArrayEquals(new int[]{-4,1}, IntegerDivision.division(-7, 2));
        Assert.assertArrayEquals(new int[]{4,4}, IntegerDivision.division(24, 5));
        Assert.assertArrayEquals(new int[]{-5,1}, IntegerDivision.division(-24, 5));
        Assert.assertArrayEquals(new int[]{3,1}, IntegerDivision.division(9, 0));
    }
}
