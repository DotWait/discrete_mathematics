package com.dotwait.integer;

import org.junit.Assert;
import org.junit.Test;

public class IntegerAdditionTests {
    @Test
    public void addBinaryTest(){
        Assert.assertTrue("0".equals(IntegerAddition.addBinary("0", "0")));
        Assert.assertTrue("110010".equals(IntegerAddition.addBinary("101111", "11")));
        Assert.assertTrue("110".equals(IntegerAddition.addBinary("11", "11")));
    }

    @Test
    public void addTest(){
        Assert.assertTrue("0".equals(IntegerAddition.add(0, 0)));
        Assert.assertTrue("110010".equals(IntegerAddition.add(47, 3)));
        Assert.assertTrue("110".equals(IntegerAddition.add(3, 3)));
    }
}
