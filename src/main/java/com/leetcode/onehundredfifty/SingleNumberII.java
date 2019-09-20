package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/single-number-ii/
 * <p>
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 *
 * @auther carl
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int m1 = 0, m2 = 0;
        for (int i = 0; i < nums.length; i++) {
            m1 = (m1 ^ nums[i]) & (~m2);
            m2 = (m2 ^ nums[i]) & (~m1);
        }
        return m1;
    }

    public int singleNumber4(int[] nums) {
        int m1 = 0, m2 = 0, m3 = 0;
        for (int i = 0; i < nums.length; i++) {
            m1 = (m1 ^ nums[i]) & (~m2) & (~m3);
            m2 = (m2 ^ nums[i]) & (~m1) & (~m3);
            m3 = (m3 ^ nums[i]) & (~m1) & (~m2);
        }
        return m1;
    }

    public static void main(String[] args) {
        SingleNumberII s = new SingleNumberII();
        System.out.println(s.singleNumber(new int[]{1, 2, 2}));
        System.out.println(s.singleNumber(new int[]{1, 2, 2, 2}));
        System.out.println(s.singleNumber4(new int[]{3, 2, 2, 2, 2}));
        System.out.println(s.singleNumber4(new int[]{1, 1, 1, 1, 5, 2, 2, 2, 2}));
    }
}
