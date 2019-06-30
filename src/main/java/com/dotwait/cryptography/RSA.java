package com.dotwait.cryptography;

import com.dotwait.cryptography.utils.RSAUtil;
import com.dotwait.integer.ModularExponentiation;
import com.dotwait.numbertheory.Inverse;
import com.dotwait.numbertheory.utils.PrintUtils;

import java.math.BigInteger;

import static com.dotwait.cryptography.utils.RSAUtil.*;

/**
 * RSA加密算法
 * RSA属于公钥密码系统
 * 在RSA密码系统中，每个人都有一个加密密钥（n，e），这里n=p*q是一个由两个大素数，
 * 比如各有200位数字的p和q的乘积构成的模数，e是与（p-1）（q-1）互素的指数。要生成
 * 可用的密钥，必须找到两个大素数。这可以通过随机性素数性测试迅速完成。
 * 这两个素数的乘积n=p*q大约有400位数字，迄今为止不可能在合理的时间内被因子分解，
 * 这正是迄今为止没有单独的解密密钥是不可能迅速解密的重要原因。
 *
 * @author DotWait
 * @date 2019-06-23
 */
public class RSA {
    /**
     * 大素数1
     */
    private static Integer bigPrime1;
    /**
     * 大素数2
     */
    private static Integer bigPrime2;
    /**
     * 加密公钥e
     */
    private static Integer e;
    /**
     * 加密公钥，两个大素数的乘积
     */
    private static Integer m;

    /**
     * 对消息进行加密，n表示多少个数字为一组进行加密，此处最好取3，容易均分，
     * 若不均分可能会出现解密失败，此问题日后有时间再解决
     * 密钥长度由于此次实现过于简单，未使用此参数
     * @param message 待加密的字符串消息
     * @param n 划分数字的长度
     * @param len 密钥长度
     * @return 加密后的数字序列数组
     */
    public static Integer[] encryption(String message, int n, int len) {
        String digitalStr = convertToDigitalString(message);
        Integer[] sepDigital = separateDigitalString(digitalStr, n);
        bigPrime1 = generateBigPrime();
        bigPrime2 = generateBigPrime();
        m = bigPrime1 * bigPrime2;
        e = generateE(bigPrime1, bigPrime2);
        printEncryptionInfo(digitalStr, sepDigital);
        return encrypt(sepDigital, e, m);
    }

    /**
     * 解密加密后的消息
     * @param encryptMsg 加密后的消息
     * @return 解密后的消息
     */
    public static String decryption(Integer[] encryptMsg) {
        int d = Inverse.inverse(e, (bigPrime1 - 1) * (bigPrime2 - 1));
        Integer[] digitalMsg = new Integer[encryptMsg.length];
        for (int i = 0; i < encryptMsg.length; i++) {
            digitalMsg[i] = (int)ModularExponentiation.modular(encryptMsg[i], d, m);
        }
        printDecryptionInfo(encryptMsg, d, digitalMsg);
        return convertToMessage(digitalMsg);
    }

    /**
     * 打印加密中的信息
     * @param digitalStr 数字序列
     * @param sepDigital 均分后的数字序列数组
     */
    private static void printEncryptionInfo(String digitalStr, Integer[] sepDigital){
        System.out.println(digitalStr);
        PrintUtils.printArray(sepDigital);
        System.out.println("bitPrime1=" + bigPrime1);
        System.out.println("bitPrime2=" + bigPrime2);
        System.out.println("mod=" + m);
        System.out.println("e=" + e);
    }

    /**
     * 打印解密过程的信息
     * @param encryptMsg 加密后的消息
     * @param inverse e模(bigPrime1 - 1) * (bigPrime2 - 1)的逆
     * @param digitalMsg 解密后的数字序列
     */
    private static void printDecryptionInfo(Integer[] encryptMsg, int inverse, Integer[] digitalMsg){
        PrintUtils.printArray(encryptMsg);
        System.out.println("inverse : " + inverse);
        PrintUtils.printArray(digitalMsg);
    }
}
