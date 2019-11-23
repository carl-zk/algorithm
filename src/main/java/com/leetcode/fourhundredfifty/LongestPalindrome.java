package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/longest-palindrome/
 * <p>
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * @author carl
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] counter = new int[256];

        for (char c : chars) {
            counter[c]++;
        }

        int pair = 0, single = 0;

        for (int c : counter) {
            pair += c / 2;
            single += c % 2;
        }

        return 2 * pair + (single > 0 ? 1 : 0);
    }
}
