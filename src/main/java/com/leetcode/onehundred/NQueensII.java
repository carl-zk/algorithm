package com.leetcode.onehundred;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/n-queens-ii/
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 * @auther carl
 */
public class NQueensII {
    static char QUEEN = 'Q';
    static char EMPTY = '.';

    private int ans;
    private char[][] board;
    private int N;
    private boolean[] y;
    private boolean[] p;
    private boolean[] q;

    public int totalNQueens(int n) {
        ans = 0;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], EMPTY);
        }
        N = n;
        y = new boolean[n];
        p = new boolean[2 * n];
        q = new boolean[2 * n];
        dfs(0);
        return ans;
    }

    private void dfs(int x) {
        if (x == N) {
            ans++;
            return;
        }
        for (int j = 0; j < N; j++) {
            if (!y[j] && !p[j - x + N] && !q[x + j]) {
                y[j] = true;
                p[j - x + N] = true;
                q[x + j] = true;
                board[x][j] = QUEEN;
                dfs(x + 1);
                board[x][j] = EMPTY;
                q[x + j] = false;
                p[j - x + N] = false;
                y[j] = false;
            }
        }
    }
}
