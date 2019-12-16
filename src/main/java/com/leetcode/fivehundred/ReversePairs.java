package com.leetcode.fivehundred;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-pairs/
 *
 * @author carl
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        BITree biTree = new BITree(sorted.length + 1);
        int ans = 0;
        for (int num : nums) {
            ans += biTree.search(index(sorted, 2 * (long) num + 1));
            biTree.insert(index(sorted, num));
        }
        return ans;
    }

    int index(int[] sorted, long val) {
        int l = 0, r = sorted.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (sorted[m] >= val) r = m - 1;
            else l = m + 1;
        }
        return l + 1;
    }

    class BITree {
        int[] bit;

        public BITree(int n) {
            this.bit = new int[n];
        }

        int search(int i) {
            int sum = 0;
            while (i < bit.length) {
                sum += bit[i];
                i += i & -i;
            }
            return sum;
        }

        void insert(int i) {
            while (i > 0) {
                bit[i] += 1;
                i -= i & -i;
            }
        }
    }
}
