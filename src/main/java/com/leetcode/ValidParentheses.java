package com.leetcode;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 *
 * @author carl
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        int top = -1;
        int i = 0;
        for (; i < chars.length; i++) {
            switch (chars[i]) {
                case ')':
                    if (top == -1 || chars[top] != '(') {
                        return false;
                    } else {
                        top--;
                        break;
                    }
                case '}':
                    if (top == -1 || chars[top] != '{') {
                        return false;
                    } else {
                        top--;
                        break;
                    }
                case ']':
                    if (top == -1 || chars[top] != '[') {
                        return false;
                    } else {
                        top--;
                        break;
                    }
                default:
                    chars[++top] = chars[i];
            }
        }
        return top == -1 && i == chars.length;
    }
}
