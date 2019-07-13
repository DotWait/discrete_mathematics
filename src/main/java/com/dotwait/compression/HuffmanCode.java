package com.dotwait.compression;

import com.dotwait.compression.structure.HuffmanNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.dotwait.compression.utils.Print.print;
import static com.dotwait.compression.utils.Print.printEncode;

/**
 * Huffman编码
 * 主要包括Huffman编码和译码
 *
 * @author DotWait
 * @date 2019-07-13
 */
public class HuffmanCode {
    /**
     * data和编码值的对应关系
     */
    private Map<Object, String> map = new HashMap<>();
    /**
     * Huffman树，数组方式呈现，root节点在数组最后一个元素
     */
    private HuffmanNode[] huffmanTree;

    /**
     * 对消息进行Huffman编码
     *
     * @param message 字符串消息
     * @return Huffman编码后的消息，二进制表示
     */
    public String encodeMessage(String message) {
        huffmanTree = generateHuffmanTree(message);
        print(huffmanTree);
        Map<Object, String> encodeMap = encode(huffmanTree);
        printEncode(encodeMap);
        return convertMsgToBinary(encodeMap, message);
    }

    /**
     * 根据字符串消息生成Huffman树，数组方式呈现，root节点在数组最后一个元素
     *
     * @param message 字符串消息
     * @return Huffman树
     */
    public HuffmanNode[] generateHuffmanTree(String message) {
        /*分析message中每个字符出现的频次*/
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chars = message.toCharArray();
        for (char aChar : chars) {
            if (charMap.containsKey(aChar)) {
                Integer value = charMap.get(aChar) + 1;
                charMap.put(aChar, value);
            } else {
                charMap.put(aChar, 1);
            }
        }
        /*频次作为weight，字符作为data，生成HuffmanTree*/
        Set<Map.Entry<Character, Integer>> entries = charMap.entrySet();
        HuffmanNode[] nodes = new HuffmanNode[entries.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : entries) {
            nodes[i] = new HuffmanNode(entry.getValue(), entry.getKey(), -1, -1);
            i++;
        }
        HuffmanTree tree = new HuffmanTree();
        return tree.build(nodes);
    }

    /**
     * 根据Huffman树生成对应的data和编码值的对应关系
     *
     * @param huffmanTree Huffman树
     * @return data和编码值的对应关系
     */
    public Map<Object, String> encode(HuffmanNode[] huffmanTree) {
        /*递归遍历huffmanTree*/
        traverseTree(huffmanTree, huffmanTree.length - 1, "");
        return map;
    }

    /**
     * 根据data和编码值的对应关系，将字符串消息转为二进制Huffman编码后的消息
     *
     * @param encodeMap data和编码值的对应关系
     * @param message   字符串消息
     * @return 二进制Huffman编码后的消息
     */
    public String convertMsgToBinary(Map<Object, String> encodeMap, String message) {
        char[] chars = message.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(encodeMap.get(aChar));
        }
        return stringBuilder.toString();
    }

    /**
     * 递归遍历Huffman树，生成data和编码值的对应关系
     *
     * @param tree   Huffman树
     * @param index  当前节点在数组中的下标
     * @param encode Huffman编码值
     */
    private void traverseTree(HuffmanNode[] tree, int index, String encode) {
        if (tree[index].getLeft() == -1 && tree[index].getRight() == -1) {
            map.put(tree[index].getData(), encode);
            return;
        }
        traverseTree(tree, tree[index].getLeft(), encode + "0");
        traverseTree(tree, tree[index].getRight(), encode + "1");
    }

    /**
     * 译码，对二进制Huffman编码后的消息进行解码
     *
     * @param message 二进制Huffman编码后的消息
     * @return 字符串消息
     */
    public String decodeMessage(String message) {
        char[] chars = message.toCharArray();
        int rootIndex = huffmanTree.length - 1;
        HuffmanNode node = huffmanTree[rootIndex];
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (node.getLeft() == -1 && node.getRight() == -1) {
                stringBuilder.append(node.getData());
                node = huffmanTree[rootIndex];
            }
            if (aChar == '0') {
                node = huffmanTree[node.getLeft()];
            } else if (aChar == '1') {
                node = huffmanTree[node.getRight()];
            } else {
                throw new IllegalArgumentException("the message is not right");
            }
        }
        if (node.getLeft() == -1 && node.getRight() == -1) {
            stringBuilder.append(node.getData());
        }
        return stringBuilder.toString();
    }
}
