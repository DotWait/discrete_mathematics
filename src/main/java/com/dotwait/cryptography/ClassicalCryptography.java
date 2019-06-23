package com.dotwait.cryptography;

import com.dotwait.cryptography.utils.DigitalLetterMappingUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 古典密码学
 * 所有古典密码，包括移位密码和仿射密码，都是私钥密码系统。一旦知道了加密密钥，就能很快找到解密密钥。
 *
 * @author DotWait
 * @date 2019-06-23
 */
public class ClassicalCryptography {
    /**
     * 加密
     * 凯撒加密，移位加密
     *
     * @param message 待加密的消息
     * @param key     密钥
     * @return 加密后的消息
     */
    public static String encryption(String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder encryptedMsg = new StringBuilder();
        for (Character letter : chars) {
            Integer digital = DigitalLetterMappingUtil.getDigital(letter);
            if (digital == null) {
                encryptedMsg.append(letter);
                continue;
            }
            digital = shiftDigital(digital, key);
            encryptedMsg.append(DigitalLetterMappingUtil.getLetter(digital));
        }
        return encryptedMsg.toString();
    }

    /**
     * 解密
     * 移位解密
     *
     * @param message 待解密的消息
     * @param key     密钥
     * @return 解密后的消息
     */
    public static String decryption(String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder decryptedMsg = new StringBuilder();
        for (Character letter : chars) {
            Integer digital = DigitalLetterMappingUtil.getDigital(letter);
            if (digital == null) {
                decryptedMsg.append(letter);
                continue;
            }
            digital = shiftDigital(digital, -key);
            decryptedMsg.append(DigitalLetterMappingUtil.getLetter(digital));
        }
        return decryptedMsg.toString();
    }

    /**
     * 数字移位处理
     *
     * @param digital 数字
     * @param key     密钥
     * @return 移位后数字
     */
    private static int shiftDigital(int digital, int key) {
        if (digital >= 0 && digital < 26) {
            digital = (digital + key) % 26 < 0 ? (digital + key) % 26 + 26 : (digital + key) % 26;
        } else if (digital >= 26 && digital < 52) {
            digital = (digital - 26 + key) % 26 < 0 ? (digital - 26 + key) % 26 + 52 : (digital - 26 + key) % 26 + 26;
        }
        return digital;
    }

}
