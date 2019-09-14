package com.leetcode.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * <p>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * @author carl
 */
public class SubsetsII {
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new LinkedList<>();

        Arrays.sort(nums);

        solve(nums, 0, new ArrayList<>());
        return ans;
    }

    private void solve(int[] nums, int start, ArrayList<Integer> temp) {
        ans.add(new ArrayList(temp));

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] > nums[i - 1]) {
                temp.add(nums[i]);
                solve(nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
