package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author carl
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            for (int j = i + 1, idx; j < nums.length - 1; j++) {
                while (j > i + 1 && j < nums.length && nums[j] == nums[j - 1]) {
                    j++;
                }
                if (j >= nums.length - 1 || nums[i] + nums[j] + nums[j + 1] > 0) {
                    break;
                }
                idx = search(nums, j + 1, nums.length - 1, -(nums[i] + nums[j]));
                if (idx != -1) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[idx]));
                }
            }
        }
        return ans;
    }

    /**
     * binary search
     *
     * @param a    array
     * @param from include
     * @param to   include
     * @param key  search value
     * @return
     */
    private int search(int[] a, int from, int to, int key) {
        int mid;
        while (from <= to) {
            mid = (from + to) >> 1;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                from = mid + 1;
            } else {
                to = mid - 1;
            }
        }
        return -1;
    }
}
