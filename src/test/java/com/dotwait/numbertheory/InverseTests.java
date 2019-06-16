package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class InverseTests {
    @Test
    public void inverseTest(){
        Assert.assertEquals(0, Inverse.inverse(2,0));
        Assert.assertEquals(0, Inverse.inverse(0,-1));
        Assert.assertEquals(0, Inverse.inverse(0,0));
        Assert.assertEquals(0, Inverse.inverse(1,1));
        Assert.assertEquals(1, Inverse.inverse(1,2));
        Assert.assertEquals(0, Inverse.inverse(2,2));
        Assert.assertEquals(5, Inverse.inverse(3,7));
        Assert.assertEquals(1601, Inverse.inverse(101,4620));
    }
}
