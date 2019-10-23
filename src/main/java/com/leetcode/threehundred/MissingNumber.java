package com.leetcode.threehundred;

/**
 * https://leetcode.com/problems/missing-number/
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * @auther carl
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = ((1 + n) * n) >> 1;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
