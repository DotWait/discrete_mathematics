package com.dotwait.compression;

import com.dotwait.compression.sort.InsertSort;
import com.dotwait.compression.structure.HuffmanNode;

import java.util.Random;

/**
 * Huffman树
 * Huffman树用于Huffman编码和译码
 *
 * @author DotWait
 * @date 2019-07-13
 */
public class HuffmanTree {
    /**
     * 标记已删除Huffman节点的个数
     */
    private int deletedNum = 0;

    /**
     * 初始化Huffman节点
     *
     * @param n 个数
     * @return 包含n个Huffman节点的数组
     */
    public HuffmanNode[] init(int n) {
        Random random = new Random();
        HuffmanNode[] nodes = new HuffmanNode[n];
        for (int i = 0; i < n; i++) {
            HuffmanNode node = new HuffmanNode();
            node.setWeight(random.nextInt(100));
            node.setData((char) random.nextInt(127));
            node.setLeft(-1);
            node.setRight(-1);
            nodes[i] = node;
        }
        return nodes;
    }

    /**
     * 根据Huffman节点数组生成Huffman树，以数组的方式呈现，root节点为数组最后一个元素
     *
     * @param huffmanNodes Huffman节点数组
     * @return Huffman树
     */
    public HuffmanNode[] build(HuffmanNode[] huffmanNodes) {
        int totalSize = huffmanNodes.length * 2 - 1;
        HuffmanNode[] huffmanNodeArr = new HuffmanNode[totalSize];
        System.arraycopy(huffmanNodes, 0, huffmanNodeArr, 0, huffmanNodes.length);
        int len = huffmanNodes.length;
        for (int i = len; i < totalSize; i++) {
            /*筛选出权值最小的两个Node*/
            int minFirst = select(huffmanNodeArr, deletedNum, i);
            int minSecond = select(huffmanNodeArr, deletedNum + 1, i);
            /*合并权值最小的两个Node*/
            huffmanNodeArr[i] = new HuffmanNode();
            if (minFirst > len - 1) {
                int temp = minFirst;
                minFirst = minSecond;
                minSecond = temp;
            }
            huffmanNodeArr[i].setLeft(minFirst);
            huffmanNodeArr[i].setRight(minSecond);
            huffmanNodeArr[i].setWeight(huffmanNodeArr[minFirst].getWeight() + huffmanNodeArr[minSecond].getWeight());
            /*记录删除的个数*/
            deletedNum += 2;
        }
        return huffmanNodeArr;
    }

    /**
     * 选择权值第index小的节点的数组下标
     *
     * @param huffmanNodeArr Huffman节点数组
     * @param index          从小到大的第index个
     * @param toSize         数组长度
     * @return 第index小的节点的数组下标
     */
    //TODO  QuickSort + for is not good
    private int select(HuffmanNode[] huffmanNodeArr, int index, int toSize) {
        HuffmanNode[] nodes = new HuffmanNode[huffmanNodeArr.length];
        System.arraycopy(huffmanNodeArr, 0, nodes, 0, huffmanNodeArr.length);
//        QuickSort.sort(nodes);
        InsertSort.sort(nodes);
        for (int i = 0; i < toSize; i++) {
            if (nodes[index] == huffmanNodeArr[i]) {
                return i;
            }
        }
        return -1;
    }
}
