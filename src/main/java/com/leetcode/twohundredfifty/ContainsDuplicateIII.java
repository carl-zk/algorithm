package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 * <p>
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 * @author carl
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        k = Math.min(k, nums.length);
        for (int i = 1; i <= k && i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                if (Math.abs(d) <= t) return true;
            }
        }
        for (int i = k + 1; i < nums.length; i++) {
            for (int j = i - k; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                if (Math.abs(d) <= t) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII cd = new ContainsDuplicateIII();
        /*System.out.println(cd.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(cd.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647},
                1,
                2147483647));*/
        System.out.println(cd.containsNearbyAlmostDuplicate(new int[]{2147483647, -2147483647},
                1,
                2147483647));
    }
}
