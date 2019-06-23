package com.dotwait.cryptography;

import org.junit.Assert;
import org.junit.Test;

public class ClassicalCryptographyTests {
    @Test
    public void classicalCryptographyTest(){
        Assert.assertEquals("khoor zruog", ClassicalCryptography.encryption("hello world", 3));
        Assert.assertEquals("hello world", ClassicalCryptography.decryption("khoor zruog", 3));
        Assert.assertEquals("bcd,yza", ClassicalCryptography.encryption("abc,xyz", 1));
        Assert.assertEquals("abc,xyz", ClassicalCryptography.decryption("bcd,yza", 1));
        Assert.assertEquals("@4#@ajj", ClassicalCryptography.encryption("@4#@ajj", 52));
        Assert.assertEquals("@4#@ajj", ClassicalCryptography.decryption("@4#@ajj", 52));
    }
}
