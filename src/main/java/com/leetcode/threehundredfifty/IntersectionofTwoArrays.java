package com.leetcode.threehundredfifty;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * <p>
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * @author carl
 */
public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> filtered = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                filtered.add(num);
            }
        }
        int[] ans = new int[filtered.size()];
        int i = 0;
        for (int x : filtered) {
            ans[i++] = x;
        }
        return ans;
    }
}
