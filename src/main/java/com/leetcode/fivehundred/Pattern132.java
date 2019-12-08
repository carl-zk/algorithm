package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/132-pattern/
 * <p>
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 * <p>
 * Example 1:
 * Input: [1, 2, 3, 4]
 * <p>
 * Output: False
 * <p>
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 * <p>
 * Output: True
 * <p>
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * <p>
 * Output: True
 * <p>
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 * @author carl
 */
public class Pattern132 {

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        int[] stack = new int[nums.length];
        int top = -1;
        for (int j = nums.length - 1; j > 0; j--) {
            while (top > -1 && stack[top] <= min[j]) top--;
            if (top > -1 && stack[top] < nums[j]) return true;
            stack[++top] = nums[j];
        }
        return false;
    }
}
