package com.dotwait.integer;

/**
 * 模指数运算
 * @author DotWait
 * @date 2019-05-12
 */
public class ModularExponentiation {
    /**
     * 模指数运算，计算b^n mod m，其中b、n、m均为大整数
     * @param b 底数，非负整数
     * @param n 指数，非负整数
     * @param m 模数，非负整数
     * @return 取模结果
     */
    public static int modular(int b, int n, int m){
        int modResult = 1;
        int power = b;
        int nLen = IntegerExpansion.constructBinaryExpansion(n).length();
        for (int i=0;i<nLen;i++){
            if (((n >> i) & 1) == 1){
                modResult = modResult * power % m;
            }
            power = power * power % m;
        }
        return modResult;
    }
}
