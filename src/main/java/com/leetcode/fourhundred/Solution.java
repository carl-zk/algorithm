package com.leetcode.fourhundred;

import java.util.Random;

/**
 * https://leetcode.com/problems/random-pick-index/
 * <p>
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 * <p>
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * <p>
 * Example:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * <p>
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 *
 * @author carl
 */
public class Solution {
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int index = -1;
        int size = 0;

        for (int i = 0; i < nums.length; i++) {

            if (target != nums[i]) {
                continue;
            }
            if (random.nextInt(++size) == 0) {
                index = i;
            }
        }
        return index;
    }
}
