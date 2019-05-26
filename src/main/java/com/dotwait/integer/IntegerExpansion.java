package com.dotwait.integer;

/**
 * 构造b进制展开式
 * @author DotWait
 * @date 2019-05-12
 */
public class IntegerExpansion {
    /**
     * 一个十进制非负整数构造成b进制展开式
     * 由于超过十的数未定义，因此展开式格式采用：1-2-3等价于123
     * @param num 十进制非负整数
     * @param b   构造展开式的进制数
     * @return b进制的展开式
     */
    public static String constructExpansion(int num, int b) {
        if (num == 0){
            return "0";
        }
        String expansion = "";
        while (num != 0) {
            expansion = num % b + "-" + expansion;
            num = num / b;
        }
        return "".equals(expansion) ? expansion : expansion.substring(0, expansion.length()-1);
    }

    /**
     * 一个十进制非负整数构造成二进制展开式
     * @param num 十进制非负整数
     * @return 二进制的展开式
     */
    public static String constructBinaryExpansion(int num) {
        if (num == 0){
            return "0";
        }
        String expansion = "";
        while (num != 0) {
            expansion = num % 2 + expansion;
            num = num / 2;
        }
        return expansion;
    }
}
