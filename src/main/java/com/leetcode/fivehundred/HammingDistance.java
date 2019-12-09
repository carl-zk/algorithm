package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/hamming-distance/
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * 0 ≤ x, y < 231.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 *
 * @author carl
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        x ^= y;
        int cnt = 0;
        while (x > 0) {
            cnt++;
            x &= (x - 1);
        }
        return cnt;
    }
}
