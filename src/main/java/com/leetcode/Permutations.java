package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author carl
 */
public class Permutations {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] tmp = new int[nums.length];
        perm(nums, 0, tmp, 0);
        return ans;
    }

    private void perm(int[] nums, int i, int[] arr, int j) {
        if (j == nums.length) {
            List<Integer> list = new LinkedList<>();
            for (int k = 0; k < j; k++) {
                list.add(arr[k]);
            }
            ans.add(list);
            return;
        }
        for (int k = i; k < nums.length; k++) {
            swap(nums, i, k);
            arr[j] = nums[i];
            perm(nums, i + 1, arr, j + 1);
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
