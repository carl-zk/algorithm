package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author carl
 */
public class GenerateParentheses {
    List<String> ans;
    char[] a;

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        ans = new LinkedList<>();
        a = new char[n << 1];
        generate(0, 0, n);
        return ans;
    }

    /**
     * 生成合法排序
     *
     * @param left  ( 的个数
     * @param right ) 的个数
     * @param n     输入的 n
     */
    private void generate(int left, int right, int n) {
        if (right == n) {
            ans.add(new String(a));
            return;
        }
        if (left < n) {
            a[left + right] = '(';
            generate(left + 1, right, n);
        }
        if (left > right) {
            a[left + right] = ')';
            generate(left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> result = gp.generateParenthesis(9);
        result.forEach(s -> System.out.println(s));
    }
}
