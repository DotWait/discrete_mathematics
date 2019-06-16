package com.dotwait.numbertheory;

import static com.dotwait.numbertheory.TrialDivision.isPrimeNumber;

/**
 * 费马小定理
 *
 * @author DotWait
 * @date 2019-06-16
 */
public class FermatLittleTheorem {
    /**
     * 计算整数高次幂的模p余数
     *
     * @param base    底数
     * @param index   指数
     * @param modulus 模数
     * @return 余数
     */
    public static int integerHighPowerRemainder(int base, int index, int modulus) {
        if (base <= 0 || index <= 0 || modulus <= 0) {
            return 0;
        }
        if (isPrimeNumber(modulus) && base % modulus != 0) {
            index = index % (modulus - 1);
        }else {
            return 0;
        }
        return calculatePower(base, index) % modulus;
    }

    /**
     * 计算指数
     *
     * @param base  底数
     * @param index 指数
     * @return 计算结果
     */
    private static int calculatePower(int base, int index) {
        int result = 1;
        for (int i = 0; i < index; i++) {
            result *= base;
        }
        return result;
    }
}
