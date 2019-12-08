package com.leetcode.fivehundred;

import java.util.HashMap;
import java.util.Map;

// @formatter:off
/**
 * https://leetcode.com/problems/4sum-ii/
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * Example:
 *
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * @author carl
 *                 
 */
// @formatter:on

public class SumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> m1 = new HashMap<>(A.length * B.length);
        Map<Integer, Integer> m2 = new HashMap<>(C.length * D.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                m1.put(A[i] + B[j], m1.getOrDefault(A[i] + B[j], 0) + 1);
                m2.put(C[i] + D[j], m2.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
            ans += entry.getValue() * m2.getOrDefault(-entry.getKey(), 0);
        }
        return ans;
    }
}
