package com.dotwait.compression.utils;

import com.dotwait.compression.structure.HuffmanNode;

import java.util.Map;
import java.util.Set;

/**
 * 打印工具类
 *
 * @author DotWait
 * @date 2019-07-13
 */
public class Print {
    /**
     * 打印data和编码值的对应关系
     *
     * @param map data和编码值的对应关系
     */
    public static void printEncode(Map<Object, String> map) {
        Set<Map.Entry<Object, String>> entries = map.entrySet();
        for (Map.Entry<Object, String> entry : entries) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }

    /**
     * 打印Huffman节点
     *
     * @param nodes Hffman节点数组
     */
    public static void print(HuffmanNode[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("index:" + i + "\t" + nodes[i]);
        }
    }
}
