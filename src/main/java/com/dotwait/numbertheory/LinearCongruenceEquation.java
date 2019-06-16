package com.dotwait.numbertheory;

import static com.dotwait.numbertheory.util.ModUtils.getTheSmallestPositiveIntegerSolution;

/**
 * 线性同余方程
 * 形如：ax=b(mod m)
 * 线性同余方程有无数个解
 *
 * @author DotWait
 * @date 2019-06-16
 */
public class LinearCongruenceEquation {
    /**
     * 求解线性同余方程
     *
     * @param a 正整数a
     * @param b 整数b
     * @param m 正整数m
     * @return 最小的正整数解
     */
    public static int linearCongruence(int a, int b, int m) {
        if (a <= 0 || m <= 0) {
            return 0;
        }
        int inverse = Inverse.inverse(a, m);
        int result = b * inverse;
        return getTheSmallestPositiveIntegerSolution(result, m);
    }
}
