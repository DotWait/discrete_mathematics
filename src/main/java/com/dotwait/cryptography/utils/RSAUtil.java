package com.dotwait.cryptography.utils;

import com.dotwait.integer.ModularExponentiation;
import com.dotwait.numbertheory.GreatestCommonDivisor;
import com.dotwait.numbertheory.TrialDivision;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * RSA
 * 此处的RSA只根据原理进行了简单的实现，未进行大整数的处理
 * 主要用以原理的理解，暂时不考虑大整数
 *
 * @author DotWait
 * @date 2019-06-24
 */
public class RSAUtil {
    /**
     * ASCII表映射,key:Character,value:digital
     */
    private static Map<Character, String> mapChar;
    /**
     * ASCII表映射,key:digital,value:Character
     */
    private static Map<String, Character> mapDigital;
    /**
     * 素数映射表，10000以内，共1229个
     */
    private static Map<Integer, Integer> mapPrime;
    /**
     * 大素数
     */
    private static Integer bigPrime;
    /**
     * 公钥，加密公钥
     */
    private static Integer e;
    /**
     * 随机数生成器
     */
    private static Random random = new Random();

    static {
        initMap();
        initPrimeMap();
    }

    /**
     * 初始化
     */
    private static void initMap() {
        mapChar = new HashMap<>();
        mapDigital = new HashMap<>();
        String digital = "";
        for (int i = 0; i < 128; i++) {
            if (i < 10) {
                digital = "00" + i;
            } else if (i < 100) {
                digital = "0" + i;
            } else {
                digital = "" + i;
            }
            mapChar.put((char) i, digital);
            mapDigital.put(digital, (char) i);
        }
    }

    /**
     * 初始化素数映射表，10000以内素数
     */
    private static void initPrimeMap() {
        mapPrime = new HashMap<>();
        int j = 0;
        for (int i = 2; i < 10000; i++) {
            if (TrialDivision.isPrimeNumber(i)) {
                mapPrime.put(j, i);
                j++;
            }
        }
        System.out.println("mapPrime size = " + mapPrime.size());
    }

    /**
     * message转换为数字序列
     * @param message 字符串消息
     * @return 数字序列
     */
    public static String convertToDigitalString(String message) {
        char[] chars = message.toCharArray();
        String digitalStr = "";
        for (Character letter : chars) {
            digitalStr += RSAUtil.getDigital(letter);
        }
        return digitalStr;
    }

    /**
     * 按len长度均分数字序列
     * @param digitalStr 数字序列
     * @param len 指定长度
     * @return 均分后数字数组
     */
    public static Integer[] separateDigitalString(String digitalStr, int len) {
        int digitalCount = digitalStr.length();
        int separateCount;
        if (digitalCount % len == 0) {
            separateCount = digitalCount / len;
        } else {
            separateCount = digitalCount / len + 1;
        }
        Integer[] sepDigital = new Integer[separateCount];
        for (int i = 0; i < separateCount; i++) {
            String substring;
            if (i == separateCount - 1) {
                substring = digitalStr.substring(i * len);
            } else {
                substring = digitalStr.substring(i * len, i * len + len);
            }
            sepDigital[i] = Integer.valueOf(substring);
        }
        return sepDigital;
    }

    /**
     * 获取数字字符串
     *
     * @param c 字符
     * @return 数字字符串
     */
    public static String getDigital(char c) {
        return mapChar.get(c);
    }

    /**
     * 生成大素数
     * @return 大素数
     */
    public static Integer generateBigPrime() {
        do {
            bigPrime = mapPrime.get(random.nextInt(1230));
            if (bigPrime < 1000) {
                continue;
            }
        } while (!isPrime(bigPrime));
        return bigPrime;
    }

    /**
     * 是否为素数，使用素数测试
     * @param bigPrime 大素数
     * @return true=是素数，false=不是素数
     */
    private static boolean isPrime(Integer bigPrime) {
        return ModularExponentiation.modular(2, bigPrime - 1, bigPrime) == 1;
    }

    /**
     * 生成加密公钥e
     * @param bigPrime1 大素数1
     * @param bigPrime2 大素数2
     * @return 加密公钥e
     */
    public static Integer generateE(Integer bigPrime1, Integer bigPrime2) {
        int gcd1;
        int gcd2;
        do {
            e = mapPrime.get(random.nextInt(1230));
            while (e > 1000) {
                e = mapPrime.get(random.nextInt(1230));
            }
            gcd1 = GreatestCommonDivisor.euclideanAlgorithm(e, bigPrime1);
            gcd2 = GreatestCommonDivisor.euclideanAlgorithm(e, bigPrime2);
        } while (!(gcd1 == 1 && gcd2 == 1));
        return e;
    }

    /**
     * 对数字序列数组中每组数字序列进行加密
     * @param sepDigital 数字数组
     * @param e 加密公钥
     * @param mod 加密公钥（两个大素数的乘积）
     * @return 加密后的数字序列数组
     */
    public static Integer[] encrypt(Integer[] sepDigital, int e, int mod) {
        Integer[] encrytMsg = new Integer[sepDigital.length];
        for (int i = 0; i < sepDigital.length; i++) {
            encrytMsg[i] = (int) ModularExponentiation.modular(sepDigital[i], e, mod);
        }
        return encrytMsg;
    }

    /**
     * 数字序列数组转换为字符串消息
     * @param digitalMsg 数字序列数组
     * @return 字符串消息
     */
    public static String convertToMessage(Integer[] digitalMsg) {
        StringBuilder message = new StringBuilder();
        for (Integer digital : digitalMsg) {
            if (digital >= 100) {
                message.append(mapDigital.get(String.valueOf(digital)));
            } else if (digital >= 10) {
                message.append(mapDigital.get("0" + digital));
            } else {
                message.append(mapDigital.get("00" + digital));
            }
        }
        return message.toString();
    }
}
