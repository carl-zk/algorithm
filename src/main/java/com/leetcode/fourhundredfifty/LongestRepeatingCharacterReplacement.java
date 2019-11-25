package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * <p>
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 * <p>
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 * <p>
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 * <p>
 * Note:
 * Both the string's length and k will not exceed 104.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "ABAB", k = 2
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s = "AABABBA", k = 1
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 * @author carl
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] counter = new int[128];
        int res = 0, max = 0;
        int start = 0, end = 0;

        for (end = 0; end < chars.length; end++) {
            max = Math.max(max, ++counter[chars[end] - 'A']);
            while (max + k < end - start + 1) {
                counter[chars[start++] - 'A']--;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
