package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * @auther carl
 */
public class UniqueBinarySearchTrees {
    int[][] dp;

    public int numTrees(int n) {
        dp = new int[n + 1][n + 1];
        return solve(1, n);
    }

    private int solve(int start, int end) {
        if (start >= end) {
            return 1;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        for (int i = start; i <= end; i++) {
            int left = solve(start, i - 1);
            int right = solve(i + 1, end);
            dp[start][end] += left * right;
        }
        return dp[start][end];
    }
}
