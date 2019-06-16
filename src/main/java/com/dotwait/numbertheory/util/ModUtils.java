package com.dotwait.numbertheory.util;

/**
 * modulus utils
 * @author DotWait
 * @date 2019-06-16
 */
public class ModUtils {
    /**
     * 获取余数最小的正整数解
     *
     * @param num 解
     * @param m   模
     * @return 最小的正整数解
     */
    public static int getTheSmallestPositiveIntegerSolution(int num, int m) {
        if (num >= 0) {
            return num % m;
        } else {
            num = -num;
            return m - num % m;
        }
    }
    /**
     * 获取余数最小的正整数解
     *
     * @param num 解
     * @param m   模
     * @return 最小的正整数解
     */
    public static long getTheSmallestPositiveIntegerSolution(long num, int m) {
        if (num >= 0) {
            return num % m;
        } else {
            num = -num;
            return m - num % m;
        }
    }
}
