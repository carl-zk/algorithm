package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/permutation-sequence/
 * <p>
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * <p>
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 * <p>
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * <p>
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * @auther carl
 */
public class PermutationSequence {
    char[] nums;
    boolean[] visit;
    int N;
    int K;
    String ans;

    public String getPermutation(int n, int k) {
        nums = new char[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (char) ('1' + i);
        }
        visit = new boolean[n];
        N = n;
        K = k;
        ans = "";
        perm(0, new char[n]);
        return ans;
    }

    private void perm(int i, char[] stack) {
        if (i == N) {
            K--;
            if (K == 0) {
                ans = new String(stack);
            }
            return;
        }
        if (!"".equals(ans)) return;
        for (int j = 0; j < N; j++) {
            if (!visit[j]) {
                stack[i] = nums[j];
                visit[j] = true;
                perm(i + 1, stack);
                visit[j] = false;
            }
        }
    }
}
