package com.leetcode.twohundred;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * @auther carl
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = another(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j != -1) {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    private int another(int[] numbers, int start, int end, int expect) {
        if (start > end) return -1;
        if (start == end && numbers[start] != expect) return -1;
        int mid = (start + end) >> 1;
        if (numbers[mid] == expect) return mid;
        if (numbers[mid] < expect) return another(numbers, mid + 1, end, expect);
        return another(numbers, start, mid - 1, expect);
    }
}
