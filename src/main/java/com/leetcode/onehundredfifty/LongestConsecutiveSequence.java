package com.leetcode.onehundredfifty;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * @author carl
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int n = 0;
                while (set.contains(nums[i])) {
                    n++;
                    nums[i]++;
                }
                if (n > ans) {
                    ans = n;
                }
            }
        }
        return ans;
    }
}
