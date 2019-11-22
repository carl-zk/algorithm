package com.leetcode.fourhundred;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 * <p>
 * Shuffle a set of numbers without duplicates.
 * <p>
 * Example:
 * <p>
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution2 solution = new Solution2(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 *
 * @auther carl
 */
public class Solution2 {
    int[] origin;
    Random random;

    public Solution2(int[] nums) {
        origin = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return Arrays.copyOf(origin, origin.length);
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] shuf = Arrays.copyOf(origin, origin.length);
        for (int i = 1; i < shuf.length; i++) {
            int j = random.nextInt(i + 1);
            swap(shuf, i, j);
        }
        return shuf;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
