package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/
 * <p>
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
 * <p>
 * Note: 1 ≤ k ≤ n ≤ 109.
 * <p>
 * Example:
 * <p>
 * Input:
 * n: 13   k: 2
 * <p>
 * Output:
 * 10
 * <p>
 * Explanation:
 * The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 *
 * @author carl
 */
public class KthSmallestinLexicographicalOrder {

    public int findKthNumber(int n, int k) {
        long cur = 1;

        while (k > 1) {
            long gap = calGap(cur, cur + 1, n);

            if (gap < k) {
                cur += 1;
                k -= gap;
            } else {
                cur *= 10;
                k -= 1;
            }
        }
        return (int) cur;
    }

    private long calGap(long a, long b, int n) {
        long gap = 0;

        while (a <= n) {
            gap += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return gap;
    }
}
