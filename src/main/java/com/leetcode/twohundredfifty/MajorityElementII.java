package com.leetcode.twohundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/majority-element-ii/
 * <p>
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Note: The algorithm should run in linear time and in O(1) space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 * @auther carl
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        int t = nums.length / 3;
        List<Integer> ans = new LinkedList<>();
        int n1 = nums[0], n2 = nums[0];
        int c1 = 0, c2 = 0;
        for (int n : nums) {
            if (n1 == n) {
                c1++;
            } else if (n2 == n) {
                c2++;
            } else if (c1 == 0) {
                n1 = n;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = n;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = c2 = 0;
        for (int n : nums) {
            if (n1 == n) {
                c1++;
            } else if (n2 == n) {
                c2++;
            }
        }
        if (c1 > t) ans.add(n1);
        if (c2 > t) ans.add(n2);
        return ans;
    }
}
