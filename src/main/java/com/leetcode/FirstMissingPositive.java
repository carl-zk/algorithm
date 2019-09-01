package com.leetcode;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * <p>
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 * @author carl
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        boolean[] visited = new boolean[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            if (1 <= nums[i] && nums[i] <= nums.length) {
                visited[nums[i]] = true;
            }
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return 0;
    }
}
