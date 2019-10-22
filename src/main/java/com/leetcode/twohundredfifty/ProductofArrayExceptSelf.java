package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * <p>
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * @auther carl
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int r = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] *= r;
            r *= nums[i];
        }
        return ans;
    }
}
