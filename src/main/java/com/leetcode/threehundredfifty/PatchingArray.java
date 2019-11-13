package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/patching-array/
 * <p>
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3], n = 6
 * Output: 1
 * Explanation:
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 * Example 2:
 * <p>
 * Input: nums = [1,5,10], n = 20
 * Output: 2
 * Explanation: The two patches can be [2, 4].
 * Example 3:
 * <p>
 * Input: nums = [1,2,2], n = 5
 * Output: 0
 *
 * @auther carl
 */
public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int ans = 0, i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PatchingArray pa = new PatchingArray();
        System.out.println(pa.minPatches(new int[]{1, 2, 31, 33}, 2147483647));
    }
}
