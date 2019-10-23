package com.leetcode.threehundred;

/**
 * https://leetcode.com/problems/single-number-iii/
 * <p>
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 * <p>
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 * @auther carl
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // 保留最后一位1
        diff &= -diff;
        for (int num : nums) {
            if ((diff & num) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 11, i = 0;
        /*while (a != 0 && i < 31) {
            System.out.println(a & 1);
            a >>>= 1;
            i++;
        }*/
        System.out.println(a & -a);
    }
}
