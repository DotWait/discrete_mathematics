package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class TrialDivisionTests {
    @Test
    public void trialDivisionTest(){
        Assert.assertFalse(TrialDivision.isPrimeNumber(-1));
        Assert.assertFalse(TrialDivision.isPrimeNumber(0));
        Assert.assertFalse(TrialDivision.isPrimeNumber(1));
        Assert.assertTrue(TrialDivision.isPrimeNumber(2));
        Assert.assertTrue(TrialDivision.isPrimeNumber(3));
        Assert.assertFalse(TrialDivision.isPrimeNumber(4));
        Assert.assertTrue(TrialDivision.isPrimeNumber(5));
        Assert.assertFalse(TrialDivision.isPrimeNumber(6));
        Assert.assertFalse(TrialDivision.isPrimeNumber(10));
        Assert.assertFalse(TrialDivision.isPrimeNumber(91));
        Assert.assertFalse(TrialDivision.isPrimeNumber(1024));
        Assert.assertTrue(TrialDivision.isPrimeNumber(97));
    }
}
