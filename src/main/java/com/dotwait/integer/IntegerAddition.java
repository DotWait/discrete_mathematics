package com.dotwait.integer;

/**
 * @author DotWait
 * @date 2019-05-12
 * @description 非负整数相加
 */
public class IntegerAddition {
    /**
     * 非负整数以二进制的方式相加
     * @param a 非负整数a
     * @param b 非负整数b
     * @return 二进制字符串
     */
    public static String add(int a, int b) {
        assert a>=0;
        assert b>=0;
        String aBinary = IntegerExpansion.constructBinaryExpansion(a);
        String bBinary = IntegerExpansion.constructBinaryExpansion(b);
        return addBinary(aBinary, bBinary);
    }

    /**
     * 二进制字符串相加
     * @param aBinary 二进制字符串
     * @param bBinary 二进制字符串
     * @return 相加后的二进制字符串
     */
    public static String addBinary(String aBinary, String bBinary) {
        int aLen = aBinary.length();
        int bLen = bBinary.length();
        int maxLen = Math.max(aLen, bLen);
        String result = "";
        int carry = 0;
        for (int i = 0; i < maxLen; i++) {
            int a = 0;
            int b = 0;
            if (aLen - 1 - i >= 0) {
                a = Integer.parseInt("" + aBinary.charAt(aLen - 1 - i));
            }
            if (bLen - 1 - i >= 0) {
                b = Integer.parseInt("" + bBinary.charAt(bLen - 1 - i));
            }
            int d = (a + b + carry) / 2;
            int s = a + b + carry - 2 * d;
            carry = d;
            result = s + result;
        }
        return carry == 1 ? carry + result : result;
    }
}
