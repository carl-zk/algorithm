package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 *
 * @author carl
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int maxId = 0;
        int pos = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[maxId]) {
                maxId = i;
            }
            if (i - maxId >= k) {
                maxId = i;
                for (int j = i - k + 1; j < i; j++) {
                    if (nums[j] > nums[maxId]) {
                        maxId = j;
                    }
                }
            }
            if (i + 1 >= k) {
                ans[pos++] = nums[maxId];
            }
        }
        return ans;
    }
}
