package com.leetcode.fivehundred;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/matchsticks-to-square/
 * <p>
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 * <p>
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 * <p>
 * Example 1:
 * Input: [1,1,2,2,2]
 * Output: true
 * <p>
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * Example 2:
 * Input: [3,3,3,3,4]
 * Output: false
 * <p>
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * Note:
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 *
 * @author carl
 */
public class MatchstickstoSquare {
    boolean[] used;
    int sum = 0;

    public boolean makesquare(int[] nums) {
        Arrays.sort(nums);
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        sum /= 4;
        used = new boolean[nums.length];
        return dfs(nums, 0, 0, 0);
    }

    private boolean dfs(int[] nums, int index, int total, int count) {
        for (int i = index; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                int s = nums[i] + total;
                if (s == sum) {
                    if (dfs(nums, 0, 0, count + 1)) return true;
                }
                if (s > sum) {
                    used[i] = false;
                    return false;
                }
                if (dfs(nums, i + 1, s, count)) return true;
                used[i] = false;
            }
        }
        return total == 0 && count == 4;
    }
}
