package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/jump-game-ii/
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 * <p>
 * You can assume that you can always reach the last index.
 *
 * @author carl
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int step = 0;
        int cur_max = 0;
        int next_max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cur_max < i) {
                cur_max = next_max;
                step++;
            }
            next_max = Math.max(next_max, nums[i] + i);
        }
        return step;
    }
}
