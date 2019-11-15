package com.leetcode.fourhundred;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 * <p>
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Note:
 * Rotation is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 * @auther carl
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] sec = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            sec[i] = envelopes[i][1];
        }
        return lis(sec);
    }

    private int lis(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = Arrays.binarySearch(nums, 0, len, nums[i]);
            if (j < 0) {
                j = -(j + 1);
            }
            nums[j] = nums[i];
            if (j == len) len++;
        }
        return len;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes rde = new RussianDollEnvelopes();
        System.out.println(rde.maxEnvelopes(new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}}));
    }
}
