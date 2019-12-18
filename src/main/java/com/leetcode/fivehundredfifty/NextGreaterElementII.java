package com.leetcode.fivehundredfifty;

import java.util.Stack;

/**
 * @author carl
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            ans[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int i : nums) {
            while (!stack.isEmpty() && nums[stack.peek()] < i) {
                ans[stack.pop()] = i;
            }
        }
        return ans;
    }
}
