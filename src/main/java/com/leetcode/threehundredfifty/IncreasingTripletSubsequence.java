package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * <p>
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * <p>
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 * <p>
 * Input: [5,4,3,2,1]
 * Output: false
 *
 * @author carl
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, bigger = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= bigger) {
                bigger = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
