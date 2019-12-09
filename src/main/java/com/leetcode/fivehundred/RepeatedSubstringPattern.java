package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * <p>
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * <p>
 * Input: "aba"
 * Output: False
 * Example 3:
 * <p>
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 * @author carl
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        return ss.substring(1, ss.length() - 1).contains(s);
    }
}
