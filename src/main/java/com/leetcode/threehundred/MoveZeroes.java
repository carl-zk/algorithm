package com.leetcode.threehundred;

/**
 * https://leetcode.com/problems/move-zeroes/
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @author carl
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                while (j < nums.length && nums[j] == 0) j++;
                if (j == nums.length) return;
                nums[i] = nums[j];
                nums[j] = 0;
            }
            if (j <= i) j = i + 1;
        }
    }
}
