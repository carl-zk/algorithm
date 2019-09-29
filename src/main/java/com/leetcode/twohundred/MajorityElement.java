package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/majority-element/
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * @auther carl
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int n = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                n = nums[i];
                count = 1;
            } else if (n == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return n;
    }
}
