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

    public List<String> removeInvalidParentheses(String s) {
        ans = new HashSet<>();
        int leftRem = 0, rightRem = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                rightRem = leftRem == 0 ? rightRem + 1 : rightRem;
                leftRem = leftRem == 0 ? leftRem : leftRem - 1;
            }
        }
        solve(s.toCharArray(), 0, new char[s.length()], 0, 0, 0, leftRem, rightRem);
        return new ArrayList<>(ans);
    }

    private void solve(char[] cs, int index, char[] temp, int len, int left, int right, int leftRem, int rightRem) {
        if (right > left) return;
        if (index == cs.length) {
            if (leftRem == 0 && rightRem == 0) {
                ans.add(new String(temp, 0, len));
            }
            return;
        }
        // filter non-qualified expressions
        if ((cs[index] == '(' && leftRem > 0) || (cs[index] == ')' && rightRem > 0)) {
            solve(cs, index + 1, temp, len, left, right,
                    leftRem - (cs[index] == '(' ? 1 : 0), rightRem - (cs[index] == ')' ? 1 : 0));
        }

        temp[len] = cs[index];

        if (cs[index] == '(') {
            solve(cs, index + 1, temp, len + 1, left + 1, right, leftRem, rightRem);
        } else if (cs[index] == ')') {
            solve(cs, index + 1, temp, len + 1, left, right + 1, leftRem, rightRem);
        } else {
            solve(cs, index + 1, temp, len + 1, left, right, leftRem, rightRem);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
        rip.removeInvalidParentheses("()())()");
    }
}
