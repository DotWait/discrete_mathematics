package com.dotwait.compression;

import com.dotwait.compression.structure.HuffmanNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static com.dotwait.compression.utils.Print.print;
import static com.dotwait.compression.utils.Print.printEncode;

public class HuffmanCodeTests {
    @Test
    public void huffmanCodeTest(){
        HuffmanTree tree = new HuffmanTree();
        HuffmanNode[] init = tree.init(4);
        HuffmanNode[] huffmanTree = tree.build(init);
        print(huffmanTree);
        Map<Object, String> encode = new HuffmanCode().encode(huffmanTree);
        printEncode(encode);
    }

    @Test
    public void encodeMessageTest(){
        String message = "hello world! @#@*(FDJFDFJKDSfdskjfdsf";
        HuffmanCode huffmanCode = new HuffmanCode();
        String encodeMessage = huffmanCode.encodeMessage(message);
        System.out.println(encodeMessage);

        String decodeMessage = huffmanCode.decodeMessage(encodeMessage);
        System.out.println(decodeMessage);
    }
}
