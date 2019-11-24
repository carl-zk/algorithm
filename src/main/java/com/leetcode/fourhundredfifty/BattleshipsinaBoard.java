package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 * <p>
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 *
 * @author carl
 */
public class BattleshipsinaBoard {

    public int countBattleships(char[][] board) {
        int total = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'a') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'X') {
                    total++;
                    dfs(board, i, j);
                }
            }
        }
        return total;
    }

    private void dfs(char[][] board, int i, int j) {
        int[][] dirs = {{1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= board.length || y >= board[0].length || board[x][y] == '.' || board[x][y] == 'a') continue;
            board[x][y] = 'a';
            dfs(board, x, y);
        }
    }
}