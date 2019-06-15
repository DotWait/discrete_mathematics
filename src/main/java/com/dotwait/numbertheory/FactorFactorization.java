package com.dotwait.numbertheory;

import com.dotwait.numbertheory.structure.PrimeFactor;

import java.util.ArrayList;
import java.util.List;

/**
 * 素因子分解
 *
 * @author DotWait
 * @date 2019-06-15
 */
public class FactorFactorization {
    /**
     * 对一个正整数进行素因子分解
     * @param num 给定正整数
     * @return 素因子集合
     */
    public static List<PrimeFactor> factorFactorization(int num){
        if(num < 2){
            return new ArrayList<>();
        }
        if (num == 2 | num == 3){
            List<PrimeFactor> primeFactors = new ArrayList<>();
            primeFactors.add(new PrimeFactor(num, 1));
            return primeFactors;
        }
        List<PrimeFactor> primeFactors = new ArrayList<>();
        int index = 0;
        for (int i=2;i<=num;i++){
            index = 0;
            while (num % i == 0){
                num /= i;
                index ++;
            }
            if (index != 0){
                primeFactors.add(new PrimeFactor(i, index));
            }
            if (num == 1){
                break;
            }
        }
        return primeFactors;
    }
}
