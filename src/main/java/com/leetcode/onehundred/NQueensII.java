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

    public int totalNQueens(int n) {
        ans = 0;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], EMPTY);
        }
        N = n;
        dfs(0);
        return ans;
    }

    private void dfs(int level) {
        if (level == N) {
            ans++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (board[level][i] == EMPTY) {
                mark(level, i);
                dfs(level + 1);
                unMark(level, i);
            }
        }
    }

    private void mark(int i, int j) {
        // bottom
        int k = i + 1;
        int l = j;
        while (k < N) {
            board[k][l]++;
            k++;
        }
        // bottom left
        k = i + 1;
        l = j - 1;
        while (k < N && l > -1) {
            board[k][l]++;
            k++;
            l--;
        }
        // bottom right
        k = i + 1;
        l = j + 1;
        while (k < N && l < N) {
            board[k][l]++;
            k++;
            l++;
        }
        board[i][j] = QUEEN;
    }

    private void unMark(int i, int j) {
        // bottom
        int k = i + 1;
        int l = j;
        while (k < N) {
            board[k][l]--;
            k++;
        }
        // bottom left
        k = i + 1;
        l = j - 1;
        while (k < N && l > -1) {
            board[k][l]--;
            k++;
            l--;
        }
        // bottom right
        k = i + 1;
        l = j + 1;
        while (k < N && l < N) {
            board[k][l]--;
            k++;
            l++;
        }
        board[i][j] = EMPTY;
    }
}
