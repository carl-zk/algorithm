package com.leetcode;

/**
 * https://leetcode.com/problems/next-permutation/
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author carl
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int boundary = nums.length - 2;
        while (boundary > -1) {
            for (int i = boundary + 1; i < nums.length; i++) {
                if (nums[i] > nums[boundary]) {
                    swap(nums, i, boundary);
                    return;
                }
            }
            leftShift(nums, boundary);
            boundary--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void leftShift(int[] nums, int boundary) {
        int t = nums[boundary];
        for (int i = boundary + 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = t;
    }
}
