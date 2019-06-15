package com.dotwait.numbertheory;

/**
 * 试除法
 * 用途：判断一个整数是否为素数
 *
 * @author DotWait
 * @date 2019-06-15
 */
public class TrialDivision {
    /**
     * 判断num是否为素数
     * @param num 大于1的正整数
     * @return boolean,true为是素数，false为不是
     */
    public static boolean isPrimeNumber(int num) {
        if (num < 2){
            return false;
        }
        if (num == 2 || num == 3){
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
