package com.leetcode.fivehundred;

// @formatter:off
/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * @author carl
 *                 
 */
// @formatter:on

public class MinimumMovestoEqualArrayElements {

    public int minMoves(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - min * nums.length;
    }
}
