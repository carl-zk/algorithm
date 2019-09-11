package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * @auther carl
 */
public class WordSearch {
    int M, N;
    boolean[][] visited;
    char[] target;
    int[] x = new int[]{0, 0, 1, -1};
    int[] y = new int[]{1, -1, 0, 0};
    boolean ans;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;

        M = board.length;
        N = board[0].length;
        visited = new boolean[M][N];
        target = word.toCharArray();
        ans = false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == target[0]) {
                    visited[i][j] = true;
                    dfs(board, i, j, 1);
                    visited[i][j] = false;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] board, int row, int col, int k) {
        if (ans) return;
        if (k == target.length) {
            ans = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int r = row + x[i];
            int c = col + y[i];
            if (-1 < r && r < M && -1 < c && c < N && !visited[r][c] && board[r][c] == target[k]) {
                visited[r][c] = true;
                dfs(board, r, c, k + 1);
                visited[r][c] = false;
            }
        }
    }
}
