package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class PseudoRandomNumberTests {
    @Test
    public void pseudoRandomNumberTest(){
        PseudoRandomNumber prn = new PseudoRandomNumber(9, 7, 4, 3);
        Assert.assertEquals(7, prn.randomNumberLCM());
        Assert.assertEquals(8, prn.randomNumberLCM());
        Assert.assertEquals(6, prn.randomNumberLCM());
        Assert.assertEquals(1, prn.randomNumberLCM());
        Assert.assertEquals(2, prn.randomNumberLCM());
        Assert.assertEquals(0, prn.randomNumberLCM());
        Assert.assertEquals(4, prn.randomNumberLCM());
        Assert.assertEquals(5, prn.randomNumberLCM());
        Assert.assertEquals(3, prn.randomNumberLCM());
    }
}
