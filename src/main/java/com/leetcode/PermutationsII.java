package com.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii/
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @auther carl
 */
public class PermutationsII {
    List<List<Integer>> ans;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new LinkedList<>();
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
        Set<Integer> set = new HashSet<>();
        for (int k = i; k < nums.length; k++) {
            if (!set.contains(nums[k])) {
                set.add(nums[k]);
                swap(nums, i, k);
                arr[j] = nums[i];
                perm(nums, i + 1, arr, j + 1);
                swap(nums, i, k);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        PermutationsII perm = new PermutationsII();
        assert 630 == perm.permuteUnique(new int[]{-1, 2, 0, -1, 1, 0, 1}).size();
        assert 3 == perm.permuteUnique(new int[]{1, 1, 2}).size();
        assert 6 == perm.permuteUnique(new int[]{1, 1, 2, 2}).size();
        assert 20 == perm.permuteUnique(new int[]{0, 0, 0, 1, 9}).size();
    }
}
