package com.dotwait.numbertheory;

import static com.dotwait.numbertheory.utils.ModUtils.getTheSmallestPositiveIntegerSolution;

/**
 * a模m的逆
 *
 * @author DotWait
 * @date 2019-06-16
 */
public class Inverse {
    /**
     * 求a模m的逆
     * 求解方法：先求贝祖恒等式，贝祖系数中包含了逆
     * a模m的逆有无数个，模m同余result[1]的都是a的逆
     *
     * @param a 正整数a
     * @param m 正整数m
     * @return a模m的逆
     */
    public static int inverse(int a, int m) {
        if (a <= 0 || m <= 0) {
            return 0;
        }
        int[] result = BezoPrinciple.bezoPrinciple(a, m);
        return getTheSmallestPositiveIntegerSolution(result[1], m);
    }
}
