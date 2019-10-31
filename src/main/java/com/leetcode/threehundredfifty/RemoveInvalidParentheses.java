package com.leetcode.threehundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * <p>
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Example 1:
 * <p>
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 * <p>
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 * <p>
 * Input: ")("
 * Output: [""]
 *
 * @auther carl
 */
public class RemoveInvalidParentheses {
    Set<String> ans;
    int max;

    public List<String> removeInvalidParentheses(String s) {
        ans = new HashSet<>();
        max = 0;
        solve(s.toCharArray(), 0, new char[s.length()], 0, 0, 0);
        return new ArrayList<>(ans);
    }

    private void solve(char[] cs, int index, char[] temp, int len, int left, int right) {
        if (right > left) return;
        if (index == cs.length) {
            if (left == right) {
                if (len < max) return;
                if (len > max) {
                    max = len;
                    ans = new HashSet<>();
                }
                ans.add(new String(temp, 0, len));
            }
            return;
        }
        if (cs[index] == '(') {
            temp[len] = cs[index];
            solve(cs, index + 1, temp, len + 1, left + 1, right);
            solve(cs, index + 1, temp, len, left, right);
        } else if (cs[index] == ')') {
            temp[len] = cs[index];
            solve(cs, index + 1, temp, len + 1, left, right + 1);
            solve(cs, index + 1, temp, len, left, right);
        } else {
            temp[len] = cs[index];
            solve(cs, index + 1, temp, len + 1, left, right);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
        rip.removeInvalidParentheses("()())()");
    }
}
