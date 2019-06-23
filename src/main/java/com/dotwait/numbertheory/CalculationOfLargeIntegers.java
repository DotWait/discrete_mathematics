package com.dotwait.numbertheory;

import static com.dotwait.numbertheory.utils.ModUtils.getTheSmallestPositiveIntegerSolution;
import static com.dotwait.numbertheory.utils.PrintUtils.printArray;

/**
 * 大整数的计算
 * 此处的大整数计算依据中国剩余定理
 * 大整数的表示可采用指数的形式，通过费马小定理快速计算余数
 *
 * @author DotWait
 * @date 2019-06-16
 */
public class CalculationOfLargeIntegers {
    /**
     * 两个大正整数相加
     * modulus中的元素必须两两互素，且所有元素的乘积必须大于大整数相加的结果
     *
     * @param a 大正整数a
     * @param b 大正整数b
     * @param modulus 模数
     * @return 相加结果
     */
    public static long largeIntegersAddition(long a, long b, int[] modulus) {
        if (a <= 0 || b <= 0 || modulus.length <= 0) {
            return 0;
        }
        int[] aTuple = convertToNTuple(a, modulus);
        printArray(aTuple);
        int[] bTuple = convertToNTuple(b, modulus);
        printArray(bTuple);
        int[] resultTuple = nTupleAddition(aTuple, bTuple, modulus);
        printArray(resultTuple);
        return convertToLargeIntegers(resultTuple, modulus);
    }

    /**
     * 大整数转换为n元组
     *
     * @param num     大整数
     * @param modulus 模数
     * @return n元组
     */
    private static int[] convertToNTuple(long num, int[] modulus) {
        int[] nTuple = new int[modulus.length];
        for (int i = 0; i < modulus.length; i++) {
            nTuple[i] = (int) num % modulus[i];
        }
        return nTuple;
    }

    /**
     * n元组转换为大整数
     *
     * @param nTuple  n元组
     * @param modulus 模数
     * @return 大整数
     */
    private static long convertToLargeIntegers(int[] nTuple, int[] modulus) {
        long result = 0;
        int mods = 1;
        for (int mod : modulus) {
            mods *= mod;
        }
        System.out.println("mods=" + mods);
        for (int i = 0; i < nTuple.length; i++) {
            int mi = mods / modulus[i];
            int inverse = Inverse.inverse(mi, modulus[i]);
            result += nTuple[i] * (long) mi * inverse;
            System.out.println("result=" + result + ",tuple=" + nTuple[i] + ",mi=" + mi + ",inverse=" + inverse);
        }
        return getTheSmallestPositiveIntegerSolution(result, mods);
    }

    /**
     * n元组相加
     *
     * @param a       n元组
     * @param b       n元组
     * @param modulus 模数
     * @return n元组相加结果
     */
    private static int[] nTupleAddition(int[] a, int[] b, int[] modulus) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (a[i] + b[i]) % modulus[i];
        }
        return a;
    }
}
