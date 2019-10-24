package com.leetcode.threehundred;

/**
 * https://leetcode.com/problems/h-index-ii/
 * <p>
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * Note:
 * <p>
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * <p>
 * Follow up:
 * <p>
 * This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 * Could you solve it in logarithmic time complexity?
 *
 * @auther carl
 */
public class HIndexII {

    public int hIndex(int[] citations) {
        int ans = 0;
        int h = 1, t = citations.length, n = citations.length;
        while (h <= t) {
            int m = (h + t) >> 1;
            if (citations[n - m] >= m) {
                ans = Math.max(ans, m);
                h = m + 1;
            } else {
                t = m - 1;
            }
        }
        return ans;
    }
}
