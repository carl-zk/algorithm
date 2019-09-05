package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * @author carl
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] nums, int left, int right, int target) {
        if (left < 0 || left >= nums.length) return -1;
        if (right < 0 || right >= nums.length) return -1;
        int mid = (left + right) >> 1;
        if (nums[left] == target) return left;
        if (nums[mid] == target) return mid;
        if (nums[right] == target) return right;

        if (nums[mid] > nums[right]) {
            if (target > nums[mid] || target < nums[right]) {
                return find(nums, mid + 1, right - 1, target);
            } else if (target > nums[left]) {
                return find(nums, left + 1, mid - 1, target);
            }
            return -1;
        } else if (target > nums[mid]) {
            if (target < nums[right]) {
                return find(nums, mid + 1, right - 1, target);
            }
            if (target > nums[left]) {
                return find(nums, left + 1, mid - 1, target);
            }
            return -1;
        } else {
            return find(nums, left + 1, mid - 1, target);
        }
    }
}
