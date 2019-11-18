package com.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 * <p>
 * Given an integer n, return 1 - n in lexicographical order.
 * <p>
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p>
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 * @auther carl
 */
public class LexicographicalNumbers {
    List<Integer> ans;

    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            helper(i, n);
        }
        return ans;
    }

    private void helper(int cur, int n) {
        if (cur > n) return;
        ans.add(cur);
        for (int i = 0; i < 10; i++) {
            helper(cur * 10 + i, n);
        }
    }
}
