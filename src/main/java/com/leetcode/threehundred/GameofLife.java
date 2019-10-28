package com.leetcode.threehundred;

/**
 * https://leetcode.com/problems/game-of-life/
 * <p>
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output:
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * Follow up:
 * <p>
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 * <p>
 * 原数组中标记法：
 * origin dest  mark
 * 0      0     0
 * 1      0     -1
 * 0      1     2
 * 1      1     3
 *
 * @auther carl
 */
public class GameofLife {
    int[] directs = {0, 1, -1};
    int m, n;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    board[i][j] = lives == 2 || lives == 3 ? 3 : -1;
                } else if (lives == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] < 1 ? 0 : 1;
            }
        }
    }

    private int liveNeighbors(int[][] board, int i, int j) {
        int count = 0;
        for (int k = 0; k < directs.length; k++) {
            for (int l = 0; l < directs.length; l++) {
                int x = i + directs[k];
                int y = j + directs[l];
                if (0 <= x && x < m && 0 <= y && y < n) {
                    count += (board[x][y] == 0 || board[x][y] == 2 ? 0 : 1);
                }
            }
        }
        return count - board[i][j];
    }
}
