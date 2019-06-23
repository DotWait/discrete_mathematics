package com.dotwait.numbertheory;

/**
 * 伪随机数
 * 由系统方法产生的数并不是真正的随机数，因此称为伪随机数
 * 最常用的产生伪随机数的过程是线性同余法
 * 当增量为0时，这样的线性同余生成器称为纯倍式生成器。以10为模，则再重复之前会产生9个数
 *
 * @author DotWait
 * @date 2019-06-23
 */
public class PseudoRandomNumber {
    /**
     * 模数
     */
    private int modulus;
    /**
     * 倍数
     */
    private int multiple;
    /**
     * 增量
     */
    private int increment;
    /**
     * 种子
     */
    private int seed;

    /**
     * 初始化
     *
     * @param modulus   模数
     * @param multiple  倍数
     * @param increment 增量
     * @param seed      种子
     */
    public PseudoRandomNumber(int modulus, int multiple, int increment, int seed) {
        this.modulus = modulus;
        this.multiple = multiple;
        this.increment = increment;
        this.seed = seed;
    }

    /**
     * 线性同余法 产生伪随机数
     *
     * @return 伪随机数
     */
    public int randomNumberLCM() {
        seed = (multiple * seed + increment) % modulus;
        return seed;
    }
}
