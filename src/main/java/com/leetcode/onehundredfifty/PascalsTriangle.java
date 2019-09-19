package com.leetcode.onehundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * <p>
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * @auther carl
 */
public class PascalsTriangle {
    List<List<Integer>> ans;

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();

        ans = new LinkedList<>();
        ans.add(Arrays.asList(1));
        if (numRows == 1) return ans;
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> arr = new ArrayList<>(i);
            arr.add(0, 1);
            List<Integer> pre = ans.get(i - 2);
            for (int j = 1; j < i - 1; j++) {
                arr.add(j, pre.get(j - 1) + pre.get(j));
            }
            arr.add(i - 1, 1);
            ans.add(arr);
        }
        return ans;
    }
}
