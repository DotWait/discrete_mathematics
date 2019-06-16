package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class LinearCongruenceEquationTests {
    @Test
    public void linearCongruenceEquationTest(){
        Assert.assertEquals(0, LinearCongruenceEquation.linearCongruence(0,0,0));
        Assert.assertEquals(0, LinearCongruenceEquation.linearCongruence(0,1,1));
        Assert.assertEquals(0, LinearCongruenceEquation.linearCongruence(1,1,0));
        Assert.assertEquals(0, LinearCongruenceEquation.linearCongruence(1,0,1));
        Assert.assertEquals(1, LinearCongruenceEquation.linearCongruence(1,3,2));
        Assert.assertEquals(0, LinearCongruenceEquation.linearCongruence(2,3,2));
        Assert.assertEquals(6, LinearCongruenceEquation.linearCongruence(3,4,7));
    }
}
