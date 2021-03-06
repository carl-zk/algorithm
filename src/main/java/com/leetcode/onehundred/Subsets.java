package com.leetcode.onehundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @auther carl
 */
public class Subsets {
    List<List<Integer>> ans;
    int[] temp;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new LinkedList<>();
        ans.add(new ArrayList<>());
        temp = new int[nums.length];

        for (int i = 1; i <= nums.length; i++) {
            solve(nums, 0, i, 0);
        }
        return ans;
    }

    private void solve(int[] nums, int start, int k, int j) {
        if (j == k) {
            List<Integer> list = new ArrayList<>(k);
            for (int i = 0; i < k; i++) {
                list.add(temp[i]);
            }
            ans.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp[j] = nums[i];
            solve(nums, i + 1, k, j + 1);
        }
    }
}
