package com.dotwait.numbertheory;

import com.dotwait.numbertheory.structure.PrimeFactor;

import java.util.List;

/**
 * 最大公约数
 *
 * @author DotWait
 * @date 2019-06-15
 */
public class GreatestCommonDivisor {
    /**
     * 求两个正整数的最大公约数
     * 求解方法：素因子分解
     *
     * @param a 正整数a
     * @param b 正整数b
     * @return a和b的最大公约数
     */
    public static int greatestCommonDivisor(int a, int b) {
        if (a <= 0 || b <= 0) {
            return 0;
        }
        int gcd = 1;
        List<PrimeFactor> aPrimeFactors = FactorFactorization.factorFactorization(a);
        List<PrimeFactor> bPrimeFactors = FactorFactorization.factorFactorization(b);
        for (int i = 0, j = 0; i < aPrimeFactors.size() && j < bPrimeFactors.size(); ) {
            int aBase = aPrimeFactors.get(i).getBase();
            int bBase = bPrimeFactors.get(j).getBase();
            if (aBase < bBase) {
                i++;
            } else if (aBase > bBase) {
                j++;
            } else {
                int aIndex = aPrimeFactors.get(i).getIndex();
                int bIndex = bPrimeFactors.get(j).getIndex();
                if (aIndex < bIndex) {
                    gcd = exponentialMultiplication(gcd, aBase, aIndex);
                } else {
                    gcd = exponentialMultiplication(gcd, bBase, bIndex);
                }
                i++;
                j++;
            }
        }
        return gcd;
    }

    /**
     * 指数乘法计算
     *
     * @param num   乘数
     * @param base  底数
     * @param index 指数
     * @return 相乘结果
     */
    private static int exponentialMultiplication(int num, int base, int index) {
        for (int i = 0; i < index; i++) {
            num *= base;
        }
        return num;
    }

    /**
     * 求两个正整数的最大公约数
     * 求解方法：欧几里得算法
     *
     * @param a 正整数a
     * @param b 正整数b
     * @return a和b的最大公约数
     */
    public static int euclideanAlgorithm(int a, int b) {
        if (a <= 0 || b <= 0) {
            return 0;
        }
        int x = 0;
        int y = 0;
        int r = 0;
        if (a >= b) {
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }
        while (y != 0) {
            r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}
