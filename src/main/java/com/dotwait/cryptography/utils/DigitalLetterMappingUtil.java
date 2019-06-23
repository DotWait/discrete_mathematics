package com.dotwait.cryptography.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 数字字幕映射
 *
 * @author DotWait
 * @date 2019-06-23
 */
public class DigitalLetterMappingUtil {
    /**
     * 数字与小写字母的映射
     */
    private static Map<Integer, Character> intToLowerCaseChar;
    /**
     * 数字与大写字母的映射
     */
    private static Map<Integer, Character> intToUpperCaseChar;
    /**
     * 数字与字母（大小写）的映射
     */
    private static Map<Integer, Character> intToChar;
    /**
     * 小写字母与数字的映射
     */
    private static Map<Character, Integer> lowerCaseCharToInt;
    /**
     * 大写字母与数字的映射
     */
    private static Map<Character, Integer> upperCaseCharToInt;
    /**
     * 字母（大小写）和数字的映射
     */
    private static Map<Character, Integer> charToInt;

    static {
        initMap();
        initMixedCaseMap();
    }

    /**
     * 初始化映射
     */
    private static void initMap() {
        intToLowerCaseChar = new HashMap<>();
        intToUpperCaseChar = new HashMap<>();
        lowerCaseCharToInt = new HashMap<>();
        upperCaseCharToInt = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            intToLowerCaseChar.put(i, (char) (i + 97));
            intToUpperCaseChar.put(i, (char) (i + 65));
            lowerCaseCharToInt.put((char) (i + 97), i);
            upperCaseCharToInt.put((char) (i + 65), i);
        }
    }

    /**
     * 初始化大小写字母和数字映射
     */
    private static void initMixedCaseMap() {
        intToChar = new HashMap<>();
        charToInt = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            intToChar.put(i, (char) (i + 65));
            charToInt.put((char) (i + 65), i);
        }
        for (int i = 26; i < 52; i++) {
            intToChar.put(i, (char) (i + 71));
            charToInt.put((char) (i + 71), i);
        }
    }

    /**
     * 获取小写字母
     *
     * @param digital 数字
     * @return 小写字母
     */
    public static Character getLowerLetter(int digital) {
        return intToLowerCaseChar.get(digital);
    }

    /**
     * 获取大写字母
     *
     * @param digital 数字
     * @return 大写字母
     */
    public static Character getUpperLetter(int digital) {
        return intToUpperCaseChar.get(digital);
    }

    /**
     * 获取字母（大小写）
     *
     * @param digital 数字
     * @return 字母
     */
    public static Character getLetter(int digital) {
        return intToChar.get(digital);
    }

    /**
     * 获取数字
     *
     * @param lowerLetter 小写字母
     * @return 数字
     */
    public static Integer getDigitalLower(char lowerLetter) {
        return lowerCaseCharToInt.get(lowerLetter);
    }

    /**
     * 获取数字
     *
     * @param upperLetter 大写字母
     * @return 数字
     */
    public static Integer getDigitalUpper(char upperLetter) {
        return upperCaseCharToInt.get(upperLetter);
    }

    /**
     * 获取数字
     *
     * @param letter 字母（大小写）
     * @return 数字
     */
    public static Integer getDigital(char letter) {
        return charToInt.get(letter);
    }
}
