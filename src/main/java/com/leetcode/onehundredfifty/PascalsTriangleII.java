package com.leetcode.onehundredfifty;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @auther carl
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex);
        for (int i = 0, j; i <= rowIndex; i++) {
            ans.add(1);
            j = i - 1;
            while (j > 0) {
                ans.set(j, ans.get(j - 1) + ans.get(j));
                j--;
            }
        }
        return ans;
    }
}
