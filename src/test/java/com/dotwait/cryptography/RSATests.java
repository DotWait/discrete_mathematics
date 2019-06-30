package com.dotwait.cryptography;

import org.junit.Assert;
import org.junit.Test;

public class RSATests {
    @Test
    public void RSATest(){
        String message = "hello,world!";
        Assert.assertEquals(message, RSA.decryption(RSA.encryption(message, 3, 1024)));
        message = "@$#)*$(,sdfksjldkf";
        Assert.assertEquals(message, RSA.decryption(RSA.encryption(message, 3, 1024)));
        message = "skdf./156sfjslk";
        Assert.assertEquals(message, RSA.decryption(RSA.encryption(message, 3, 1024)));
        message = "`sjoif`lskfd\\";
        Assert.assertEquals(message, RSA.decryption(RSA.encryption(message, 3, 1024)));
        message = "ndsf8090#@$()#kwpf=";
        Assert.assertEquals(message, RSA.decryption(RSA.encryption(message, 3, 1024)));
    }
}
