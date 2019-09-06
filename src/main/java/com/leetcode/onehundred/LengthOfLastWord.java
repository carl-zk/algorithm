package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 *
 * @auther carl
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        while (i > -1 && chars[i] == ' ') i--;
        while (i > -1 && chars[i] != ' ') {
            ans++;
            i--;
        }
        return ans;
    }
}
