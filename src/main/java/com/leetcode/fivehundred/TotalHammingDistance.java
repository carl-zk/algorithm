package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/total-hamming-distance/
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 * <p>
 * Example:
 * Input: 4, 14, 2
 * <p>
 * Output: 6
 * <p>
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case). So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * Note:
 * Elements of the given array are in the range of 0 to 10^9
 * Length of the array will not exceed 10^4.
 *
 * @author carl
 */
public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            for (int j = 0; j < nums.length; j++) {
                one += (nums[j] >> i) & 1;
            }
            ans += one * (nums.length - one);
        }
        return ans;
    }
}
