package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * <p>
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 * @author carl
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // rows and columns
        for (int i = 0; i < board.length; i++) {
            boolean[] row = new boolean[board.length];
            boolean[] column = new boolean[board.length];
            for (int j = 0; j < board.length; j++) {
                if (isDuplicate(board, row, i, j) || isDuplicate(board, column, j, i)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                if (isDuplicate(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isDuplicate(char[][] board, boolean[] used, int i, int j) {
        if ('.' != board[i][j]) {
            if (used[board[i][j] - '1']) {
                return true;
            } else {
                used[board[i][j] - '1'] = true;
            }
        }
        return false;
    }

    private boolean isDuplicate(char[][] board, int i, int j) {
        boolean[] used = new boolean[board.length];
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if ('.' != board[i + k][j + l]) {
                    if (used[board[i + k][j + l] - '1']) {
                        return true;
                    } else {
                        used[board[i + k][j + l] - '1'] = true;
                    }
                }
            }
        }
        return false;
    }
}
