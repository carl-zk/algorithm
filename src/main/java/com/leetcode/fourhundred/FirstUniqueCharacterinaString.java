package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * <p>
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * @auther carl
 */
public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        int[] counter = new int[256];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counter[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (counter[chars[i]] == 1) return i;
        }
        return -1;
    }
}
