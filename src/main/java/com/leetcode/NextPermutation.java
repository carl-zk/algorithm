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
        int l = nums.length - 2;
        while (l > -1) {
            if (nums[l] < nums[l + 1]) {
                break;
            }
            l--;
        }

        if (l > -1) {
            int r = nums.length - 1;
            while (nums[r] <= nums[l]) {
                r--;
            }
            swap(nums, l, r);
        }

        l++;
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
