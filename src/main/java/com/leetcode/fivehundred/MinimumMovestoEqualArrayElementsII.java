package com.leetcode.fivehundred;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * <p>
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * <p>
 * You may assume the array's length is at most 10,000.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 * @author carl
 */
public class MinimumMovestoEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int ans = 0;
        for (int num : nums) {
            ans += num < mid ? mid - num : num - mid;
        }
        return ans;
    }
}
