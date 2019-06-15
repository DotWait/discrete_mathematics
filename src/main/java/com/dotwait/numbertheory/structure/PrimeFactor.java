package com.dotwait.numbertheory.structure;

import java.util.Objects;

/**
 * 素因子
 *
 * @author DotWait
 * @date 2019-06-15
 */
public class PrimeFactor {
    /**
     * 底数
     */
    private int base;
    /**
     * 指数
     */
    private int index;

    public PrimeFactor() {
    }

    public PrimeFactor(int base, int index) {
        this.base = base;
        this.index = index;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeFactor that = (PrimeFactor) o;
        return base == that.base &&
                index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, index);
    }
}
