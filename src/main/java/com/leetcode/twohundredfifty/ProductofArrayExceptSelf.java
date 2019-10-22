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
        int[] pre = new int[nums.length];
        int[] aft = new int[nums.length];
        int[] ans = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i] * pre[i - 1];
        }
        aft[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            aft[i] = nums[i] * aft[i + 1];
        }
        ans[0] = aft[1];
        ans[nums.length - 1] = pre[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            ans[i] = pre[i - 1] * aft[i + 1];
        }
        return ans;
    }
}
