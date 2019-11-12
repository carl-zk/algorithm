package com.leetcode.threehundredfifty;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 * <p>
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * Example 2:
 * <p>
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * <p>
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 *
 * @auther carl
 */
public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        int j = temp.length / 2;
        j += temp.length % 2 == 0 ? -1 : 0;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = temp[j--];
        }
        j = temp.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = temp[j--];
        }
    }
}
