package com.dotwait.numbertheory.utils;

/**
 * Print Util
 *
 * @author DotWait
 * @date 2019-06-16
 */
public class PrintUtils {
    /**
     * 打印int数组
     *
     * @param array 数组
     */
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }
}
