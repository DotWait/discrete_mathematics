package com.dotwait.integer;

import org.junit.Assert;
import org.junit.Test;

public class IntegerExpansionTests {
    @Test
    public void integerExpansionTest(){
        Assert.assertTrue("0".equals(IntegerExpansion.constructExpansion(0, 2)));
        Assert.assertTrue("1-1".equals(IntegerExpansion.constructExpansion(3, 2)));
        Assert.assertTrue("1-4-4".equals(IntegerExpansion.constructExpansion(100, 8)));
        Assert.assertTrue("6-4".equals(IntegerExpansion.constructExpansion(100, 16)));
        Assert.assertTrue("15".equals(IntegerExpansion.constructExpansion(15, 17)));
    }

    @Test
    public void integerBinaryExpansionTest(){
        Assert.assertTrue("0".equals(IntegerExpansion.constructBinaryExpansion(0)));
        Assert.assertTrue("11".equals(IntegerExpansion.constructBinaryExpansion(3)));
        Assert.assertTrue("1100100".equals(IntegerExpansion.constructBinaryExpansion(100)));
    }
}
