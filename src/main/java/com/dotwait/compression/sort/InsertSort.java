package com.dotwait.compression.sort;

import com.dotwait.compression.structure.HuffmanNode;

/**
 * 插入排序
 * 对HuffmanNode[]进行从小到大排序
 *
 * @author DotWait
 * @date 2019-07-13
 */
public class InsertSort {
    /**
     * 交换两个节点
     *
     * @param nodes Huffman节点
     * @param i     需交换的节点1
     * @param j     需交换的节点2
     */
    private static void swap(HuffmanNode[] nodes, int i, int j) {
        HuffmanNode node = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = node;
    }

    /**
     * 插入排序
     *
     * @param nodes Huffman节点
     */
    public static void sort(HuffmanNode[] nodes) {
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i] == null) {
                continue;
            }
            int weight = nodes[i].getWeight();
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (weight > nodes[j].getWeight()) {
                    break;
                }
                swap(nodes, j + 1, j);
            }
        }
    }
}
