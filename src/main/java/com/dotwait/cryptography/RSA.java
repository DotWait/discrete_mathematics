package com.dotwait.cryptography;

/**
 * RSA加密算法
 * RSA属于公钥密码系统
 * 在RSA密码系统中，每个人都有一个加密密钥（n，e），这里n=p*q是一个由两个大素数，
 * 比如各有200位数字的p和q的乘积构成的模数，e是与（p-1）（q-1）互素的指数。要生成
 * 可用的密钥，必须找到两个大素数。这可以通过随机性素数性测试迅速完成。
 * 这两个素数的乘积n=p*q大约有400位数字，迄今为止不可能在合理的时间内被因子分解，
 * 这正是迄今为止没有单独的解密密钥是不可能迅速解密的重要原因。
 * @author DotWait
 * @date 2019-06-23
 */
public class RSA {
}