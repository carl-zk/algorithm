package com.leetcode.fifty;

import java.util.Stack;

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
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < cs.length; i++) {
            if ('(' == cs[i]) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek().intValue());
                }
            }
        }
        return ans;
    }
}
