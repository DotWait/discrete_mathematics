package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class FermatLittleTheoremTests {
    @Test
    public void fermatLittleTheoremTest(){
        Assert.assertEquals(0, FermatLittleTheorem.integerHighPowerRemainder(0,0,0));
        Assert.assertEquals(0, FermatLittleTheorem.integerHighPowerRemainder(1,0,1));
        Assert.assertEquals(0, FermatLittleTheorem.integerHighPowerRemainder(0,1,1));
        Assert.assertEquals(0, FermatLittleTheorem.integerHighPowerRemainder(1,1,0));
        Assert.assertEquals(0, FermatLittleTheorem.integerHighPowerRemainder(1,1,1));
        Assert.assertEquals(1, FermatLittleTheorem.integerHighPowerRemainder(1,1,2));
        Assert.assertEquals(2, FermatLittleTheorem.integerHighPowerRemainder(2,3,3));
        Assert.assertEquals(5, FermatLittleTheorem.integerHighPowerRemainder(7,222,11));
    }
}
