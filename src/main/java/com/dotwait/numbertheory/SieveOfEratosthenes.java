package com.dotwait.numbertheory;

import java.util.ArrayList;
import java.util.List;

/**
 * 埃拉托斯特尼筛法
 * 用途：寻找不超过一个给定整数的所有素数
 *
 * @author DotWait
 * @date 2019-06-15
 */
public class SieveOfEratosthenes {
    /**
     * 定义用于存放素数的数组
     */
    private static int[] primeNums = new int[5];

    /**
     * 初始化素数数组
     */
    static {
        primeNums[0] = 2;
        primeNums[1] = 3;
        primeNums[2] = 5;
        primeNums[3] = 7;
        primeNums[4] = 11;
    }

    /**
     * 筛选所有小于给定整数的素数
     *
     * @param num 给定整数，此处的给定整数须不超过100，如果要更大的整数，需要增加初始化素数数组的大小
     * @return 筛选后的素数集合
     */
    public static int[] primeSieve(int num) {
        if (num < 2) {
            return new int[0];
        }
        int[] allNums = new int[num+1];
        for (int i = 0; i <= num; i++) {
            allNums[i] = i;
        }
        for (int i = 0; i < primeNums.length; i++) {
            for (int j = 2; j < num; j++) {
                int delIndex = primeNums[i] * j;
                if (delIndex <= num) {
                    allNums[delIndex] = 0;
                } else {
                    break;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (allNums[i] != 0) {
                result.add(allNums[i]);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
