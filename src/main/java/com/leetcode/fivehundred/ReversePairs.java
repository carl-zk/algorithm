package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/reverse-pairs/
 *
 * @author carl
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private int solve(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) >> 1;
        int total = solve(nums, l, m) + solve(nums, m + 1, r);
        int[] merge = new int[r - l + 1];
        int i = l, j = m + 1, q = m + 1, k = 0;
        while (i <= m) {
            while (q <= r && nums[i] > 2L * nums[q]) q++;
            total += q - (m + 1);
            while (j <= r && nums[i] >= nums[j]) merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }
        System.arraycopy(nums, j, merge, k, r - j + 1);
        System.arraycopy(merge, 0, nums, l, merge.length);
        return total;
    }
}
