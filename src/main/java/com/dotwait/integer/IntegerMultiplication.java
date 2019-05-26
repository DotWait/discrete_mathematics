package com.dotwait.integer;

/**
 * 整数相乘
 *
 * @author DotWait
 * @date 2019-05-12
 */
public class IntegerMultiplication {
    /**
     * 非负整数相乘
     * @param a 非负整数
     * @param b 非负整数
     * @return 相乘结果（未考虑溢出）
     */
    public static int multiply(int a, int b) {
        int result = 0;
        int min = 0;
        int max = 0;
        if(a>b){
            min = b;
            max = a;
        }else {
            min = a;
            max = b;
        }
        int minLen = IntegerExpansion.constructBinaryExpansion(min).length();
        int[] cArray = new int[minLen];
        for (int i = 0; i < minLen; i++) {
            if (((min >> i) & 1) == 1){
                cArray[i] = max << i;
            }
        }
        for (int j = 0; j< cArray.length; j++){
            result += cArray[j];
        }
        return result;
    }
}
