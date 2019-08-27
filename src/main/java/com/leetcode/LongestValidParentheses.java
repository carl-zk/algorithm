package com.leetcode;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 * @author carl
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int ans = 0;
        char[] cs = s.toCharArray();
        int leftCount;

        for (int i = 0; i < cs.length; i++) {
            int len = 0;
            leftCount = 0;
            if ('(' == cs[i]) {
                for (int j = i; j < cs.length; j++) {
                    if ('(' == cs[j]) {
                        leftCount++;
                    } else if (leftCount > 0) {
                        leftCount--;
                        if (leftCount == 0) {
                            len = Math.max(len, j - i + 1);
                        }
                    } else {
                        break;
                    }
                }
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
