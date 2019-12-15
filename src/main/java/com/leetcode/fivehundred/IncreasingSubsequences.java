package com.leetcode.fivehundred;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/increasing-subsequences/
 * <p>
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * <p>
 * <p>
 * Note:
 * <p>
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 *
 * @author carl
 */
public class IncreasingSubsequences {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        solve(nums, 0, new ArrayList<>());
        return ans;
    }

    private void solve(int[] nums, int index, List<Integer> list) {
        if (list.size() > 1) {
            ans.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if ((list.isEmpty() || nums[i] >= list.get(list.size() - 1)) && !set.contains(nums[i])) {
                set.add(nums[i]);
                list.add(nums[i]);
                solve(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
