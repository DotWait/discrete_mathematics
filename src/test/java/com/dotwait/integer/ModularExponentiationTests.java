package com.dotwait.integer;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ModularExponentiationTests {
    @Test
    public void modularExponentiationTest(){
        Assert.assertTrue(36 == ModularExponentiation.modular(3, 644, 645));
        Assert.assertTrue(1 == ModularExponentiation.modular(3, 4, 4));
        Assert.assertTrue(0 == ModularExponentiation.modular(0, 4, 4));
        Assert.assertTrue(1 == ModularExponentiation.modular(3, 0, 4));
    }
}
