package com.dotwait.compression.structure;

/**
 * Huffman节点
 *
 * @author DotWait
 * @date 2019-07-13
 */
public class HuffmanNode {
    private int weight;
    private Object data;
    private int left;
    private int right;
//  private int parent;

    public HuffmanNode() {
    }

    public HuffmanNode(int weight, Object data, int left, int right) {
        this.weight = weight;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "weight=" + weight +
                ", data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
