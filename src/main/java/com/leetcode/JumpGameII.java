package com.leetcode;

import java.util.LinkedList;

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
    int[] dist;
    boolean[] reach;
    LinkedList<Integer> queue;

    public int jump(int[] nums) {
        dist = new int[nums.length];
        reach = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            reach[i] = nums[i] + i + 1 >= nums.length;
        }
        dist[0] = 0;
        queue = new LinkedList<>();
        queue.addLast(0);

        while (!queue.isEmpty()) {
            int i = queue.removeFirst();
            if (reach[i]) {
                return i == nums.length - 1 ? dist[i] : dist[i] + 1;
            }
            for (int j = i + 1, k = 0; k < nums[i] && j + k < nums.length; k++) {
                if (dist[j + k] == Integer.MAX_VALUE) {
                    dist[j + k] = dist[i] + 1;
                    if (reach[j + k]) {
                        return j + k == nums.length - 1 ? dist[j + k] : dist[j + k] + 1;
                    }
                    queue.addLast(j + k);
                }
            }
        }
        return 0;
    }
}
