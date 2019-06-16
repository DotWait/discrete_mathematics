package com.dotwait.numbertheory;

/**
 * 贝祖原理
 *
 * @author DotWait
 * @date 2019-06-16
 */
public class BezoPrinciple {
    /**
     * 贝祖恒等式求解
     *
     * @param a 正整数a
     * @param b 正整数b
     * @return 数组，第一个元素为最大公约数，第二元素为a的系数s，第三个元素为b的系数t
     */
    public static int[] bezoPrinciple(int a, int b) {
        if (a <= 0 || b <= 0) {
            return new int[]{0, 0, 0};
        }
        int[] result = exgcd(a, b, 0, 0);
        return result;
    }

    /**
     * 扩展欧几里得算法，求解最大公约数和贝祖恒等式
     * 递归求解 sa+tb=gcd(a,b)
     *
     * 　　推理1，当 b=0，gcd（a，b）=a。此时 x=1，y=0;
     * 　　推理2，ab!=0 时
     * 　　设 ax1+by1=gcd(a,b);
     * 　　bx2+(a mod b)y2=gcd(b,a mod b);
     * 　　根据朴素的欧几里德原理有 gcd(a,b)=gcd(b,a mod b);
     * 　　则:ax1+by1=bx2+(a mod b)y2;
     * 　　即:ax1+by1=bx2+(a-(a/b)*b)y2=ay2+bx2-(a/b)*by2;
     * 　　根据恒等定理得：x1=y2 ,y1=x2-(a/b)*y2;//推理2
     * 　　这样我们就得到了求解 x1,y1 的方法：x1，y1 的值基于 x2，y2.
     *
     * @param a 正整数a
     * @param b 正整数b
     * @param x a的系数s
     * @param y b的系数t
     * @return 数组，第一个元素为最大公约数，第二元素为a的系数s，第三个元素为b的系数t
     */
    private static int[] exgcd(int a, int b, int x, int y) {
        if (b == 0) {
            /*递归终止条件*/
            x = 1;
            y = 0;
            return new int[]{a, 1, 0};
        }
        int[] result = exgcd(b, a % b, x, y);
        x = result[2];
        y = result[1] - (a / b) * result[2];
        result[1] = x;
        result[2] = y;
        return result;
    }
}
