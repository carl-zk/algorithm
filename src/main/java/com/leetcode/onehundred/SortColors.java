package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/sort-colors/
 * <p>
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 * @auther carl
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int p = 0, q = nums.length - 1;
        int i = 0;
        while (i <= q) {
            if (nums[i] == 0 && i > p) {
                swap(nums, i, p);
                p++;
            } else if (nums[i] == 2) {
                swap(nums, i, q);
                q--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
