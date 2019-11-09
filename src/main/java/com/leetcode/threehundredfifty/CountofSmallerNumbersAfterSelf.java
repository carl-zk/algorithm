package com.leetcode.threehundredfifty;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * <p>
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * @auther carl
 */
public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        int l = nums.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        Integer[] ans = new Integer[l];
        int sz = max - min + 1;
        int[] tree = new int[sz];
        for (int i = l - 1; i >= 0; i--) {
            int cur = nums[i] - min;
            ans[i] = sumAll(tree, cur - 1);
            update(tree, cur);
        }
        return Arrays.asList(ans);
    }

    private int sumAll(int[] tree, int k) {
        k++;
        int sum = 0;
        while (k > 0) {
            sum += tree[k];
            k -= k & -k;
        }
        return sum;
    }

    private void update(int[] tree, int k) {
        k++;
        while (k < tree.length) {
            tree[k]++;
            k += k & -k;
        }
    }
}
