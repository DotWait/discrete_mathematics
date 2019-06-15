package com.dotwait.numbertheory;

import com.dotwait.numbertheory.structure.PrimeFactor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FactorFactorizationTests {
    @Test
    public void factorFactorizationTest(){
        List<PrimeFactor> primeFactors = new ArrayList<>();
        Assert.assertTrue(primeFactors.equals(FactorFactorization.factorFactorization(0)));
        Assert.assertTrue(primeFactors.equals(FactorFactorization.factorFactorization(1)));
        primeFactors.add(new PrimeFactor(2, 1));
        Assert.assertTrue(primeFactors.equals(FactorFactorization.factorFactorization(2)));
        primeFactors.clear();
        primeFactors.add(new PrimeFactor(3,1));
        Assert.assertTrue(primeFactors.equals(FactorFactorization.factorFactorization(3)));
        primeFactors.clear();
        primeFactors.add(new PrimeFactor(2,2));
        Assert.assertTrue(primeFactors.equals(FactorFactorization.factorFactorization(4)));
        primeFactors.clear();
        primeFactors.add(new PrimeFactor(5,1));
        Assert.assertTrue(primeFactors.equals(FactorFactorization.factorFactorization(5)));
        primeFactors.clear();
        primeFactors.add(new PrimeFactor(2,1));
        primeFactors.add(new PrimeFactor(3,1));
        Assert.assertTrue(primeFactors.equals(FactorFactorization.factorFactorization(6)));
        primeFactors.clear();
        primeFactors.add(new PrimeFactor(2,2));
        primeFactors.add(new PrimeFactor(5,2));
        Assert.assertTrue(primeFactors.equals(FactorFactorization.factorFactorization(100)));
    }
}
