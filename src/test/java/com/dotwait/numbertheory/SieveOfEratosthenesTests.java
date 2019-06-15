package com.dotwait.numbertheory;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SieveOfEratosthenesTests {
    @Test
    public void sieveOfEratosthenesTest() {
        Assert.assertArrayEquals(new int[]{}, SieveOfEratosthenes.primeSieve(0));
        Assert.assertArrayEquals(new int[]{}, SieveOfEratosthenes.primeSieve(1));
        Assert.assertArrayEquals(new int[]{2}, SieveOfEratosthenes.primeSieve(2));
        Assert.assertArrayEquals(new int[]{2, 3}, SieveOfEratosthenes.primeSieve(3));
        Assert.assertArrayEquals(new int[]{2, 3}, SieveOfEratosthenes.primeSieve(4));
        Assert.assertArrayEquals(new int[]{2, 3, 5}, SieveOfEratosthenes.primeSieve(5));
        Assert.assertArrayEquals(new int[]{2, 3, 5, 7}, SieveOfEratosthenes.primeSieve(10));
        Assert.assertArrayEquals(new int[]{2,3,5,7,11 ,13,
                17,19,23,29,31,37,
                41,43,47,53,59,61,
                67,71,73,79,83,89,
                97}, SieveOfEratosthenes.primeSieve(100));
    }
}
