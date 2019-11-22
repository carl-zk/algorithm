package com.leetcode.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: [
 * [".Q..",  // Solution2 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution2 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 * @auther carl
 */
public class NQueens {
    static char QUEEN = 'Q';
    static char EMPTY = '.';

    private List<List<String>> ans;
    private char[][] board;
    private int N;

    public List<List<String>> solveNQueens(int n) {
        ans = new LinkedList<>();
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
            List<String> list = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder(N);
                for (int j = 0; j < N; j++) {
                    sb.append(board[i][j] == QUEEN ? QUEEN : EMPTY);
                }
                list.add(sb.toString());
            }
            ans.add(list);
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
        for (int k = 0; k < N; k++) {
            board[i][k]++;
            board[k][j]++;
        }
        // up left
        int k = i - 1, l = j - 1;
        while (k > -1 && l > -1) {
            board[k][l]++;
            k--;
            l--;
        }
        // up right
        k = i - 1;
        l = j + 1;
        while (k > -1 && l < N) {
            board[k][l]++;
            k--;
            l++;
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
        for (int k = 0; k < N; k++) {
            board[i][k]--;
            board[k][j]--;
        }
        // up left
        int k = i - 1, l = j - 1;
        while (k > -1 && l > -1) {
            board[k][l]--;
            k--;
            l--;
        }
        // up right
        k = i - 1;
        l = j + 1;
        while (k > -1 && l < N) {
            board[k][l]--;
            k--;
            l++;
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

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4).size());
        System.out.println(nQueens.solveNQueens(2).size());

        char c = '\uFFFF';
        System.out.println(c);
        System.out.println((byte) c);
        System.out.println((byte) 'Q');
        System.out.println((byte) '.');
    }
}
