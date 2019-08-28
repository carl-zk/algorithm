package com.leetcode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * @author carl
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int i = search(nums, 0, nums.length - 1, target);

        if (i != -1) {
            ans[0] = ans[1] = i;
            int left = i - 1;
            while (left > -1) {
                i = search(nums, 0, left, target);
                if (i != -1) {
                    ans[0] = i;
                    left = i - 1;
                } else {
                    left = -1;
                }
            }
            int right = i + 1;
            while (right < nums.length) {
                i = search(nums, right, nums.length - 1, target);
                if (i != -1) {
                    ans[1] = i;
                    right = i + 1;
                } else {
                    right = nums.length;
                }
            }
        }
        return ans;
    }

    private int search(int[] nums, int h, int t, int key) {
        if (h > t) return -1;
        int m = (h + t) >> 1;
        if (nums[m] == key) {
            return m;
        } else if (nums[m] < key) {
            return search(nums, m + 1, t, key);
        } else return search(nums, h, m - 1, key);
    }
}
