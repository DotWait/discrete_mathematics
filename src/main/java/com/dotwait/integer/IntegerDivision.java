package com.dotwait.integer;

/**
 * 整数相除
 * @author DotWait
 * @date 2019-05-12
 */
public class IntegerDivision {
    /**
     * 两数相除，求商和余数
     * @param dividend 被除数
     * @param divisor 除数（正整数）
     * @return 整数数组，第一个为商，第二个为余数
     */
    public static int[] division(int dividend, int divisor){
        if (divisor == 0){
            throw new IllegalArgumentException("the divisor can't be 0");
        }
        int uDividend = dividend;
        if (dividend < 0){
            uDividend = -dividend;
        }
        int divResult = 0;
        int modResult = 0;
        while (uDividend >= divisor){
            uDividend -= divisor;
            divResult ++;
        }
        if (dividend < 0 && uDividend > 0){
            modResult = divisor - uDividend;
            divResult = -(divResult+1);
        }else {
            modResult = uDividend;
        }
        return new int[]{divResult, modResult};
    }
}
