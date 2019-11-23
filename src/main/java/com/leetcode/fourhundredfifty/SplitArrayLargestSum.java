package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * <p>
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 * <p>
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * Output:
 * 18
 * <p>
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 *
 * @author carl
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        long l = max, r = sum;

        while (l < r) {
            long mid = l + (r - l) / 2;
            if (isValid(mid, nums, m)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private boolean isValid(long target, int[] nums, int m) {
        int count = 1;
        long sum = 0;

        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }
}
