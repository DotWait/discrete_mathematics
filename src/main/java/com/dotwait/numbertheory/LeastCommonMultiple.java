package com.dotwait.numbertheory;

import com.dotwait.numbertheory.structure.PrimeFactor;

import java.util.List;

/**
 * 最小公倍数
 * 求解方法：素因子分解
 *
 * @author DotWait
 * @date 2019-06-15
 */
public class LeastCommonMultiple {
    /**
     * 求两个正整数的最小公倍数
     *
     * @param a 正整数a
     * @param b 正整数b
     * @return a和b的最小公倍数
     */
    public static int leastCommonMultiple(int a, int b) {
        if (a <= 0 || b <= 0) {
            return 0;
        }
        int lcm = 1;
        List<PrimeFactor> aPrimeFactors = FactorFactorization.factorFactorization(a);
        List<PrimeFactor> bPrimeFactors = FactorFactorization.factorFactorization(b);
        int i, j;
        for (i = 0, j = 0; i < aPrimeFactors.size() && j < bPrimeFactors.size(); ) {
            int aBase = aPrimeFactors.get(i).getBase();
            int bBase = bPrimeFactors.get(j).getBase();
            if (aBase < bBase) {
                int aIndex = aPrimeFactors.get(i).getIndex();
                lcm = exponentialMultiplication(lcm, aBase, aIndex);
                i++;
            } else if (aBase > bBase) {
                int bIndex = bPrimeFactors.get(j).getIndex();
                lcm = exponentialMultiplication(lcm, bBase, bIndex);
                j++;
            } else {
                int aIndex = aPrimeFactors.get(i).getIndex();
                int bIndex = bPrimeFactors.get(j).getIndex();
                if (aIndex < bIndex) {
                    lcm = exponentialMultiplication(lcm, bBase, bIndex);
                } else {
                    lcm = exponentialMultiplication(lcm, aBase, aIndex);
                }
                i++;
                j++;
            }
        }
        for (; i < aPrimeFactors.size(); i++) {
            lcm = exponentialMultiplication(lcm, aPrimeFactors.get(i).getBase(), aPrimeFactors.get(i).getIndex());
        }
        for (; j < bPrimeFactors.size(); j++) {
            lcm = exponentialMultiplication(lcm, bPrimeFactors.get(j).getBase(), bPrimeFactors.get(j).getIndex());
        }
        return lcm;
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
}
