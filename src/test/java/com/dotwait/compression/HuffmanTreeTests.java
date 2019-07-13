package com.dotwait.compression;

import com.dotwait.compression.structure.HuffmanNode;
import org.junit.Test;

import static com.dotwait.compression.utils.Print.print;

public class HuffmanTreeTests {
    @Test
    public void huffmanTreeTest(){
        HuffmanTree huffmanTree = new HuffmanTree();
        HuffmanNode[] nodes = huffmanTree.init(4);
        HuffmanNode[] tree = huffmanTree.build(nodes);
        print(tree);
    }
}
