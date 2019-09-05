package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 * <p>
 * <p>
 * A sudoku puzzle...
 * <p>
 * <p>
 * ...and its solution numbers marked in red.
 * <p>
 * Note:
 * <p>
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 *
 * @author carl
 */
public class SudokuSolver {
    boolean[][] rowsUsed = new boolean[9][9];
    boolean[][] columnsUsed = new boolean[9][9];
    boolean[][] boxesUsed = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        init(board);
        fillSudoku(board, 0, 0);
    }

    private void init(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowsUsed[i][board[i][j] - '1'] = true;
                    columnsUsed[board[i][j] - '1'][j] = true;
                    boxesUsed[3 * (i / 3) + j / 3][board[i][j] - '1'] = true;
                }
            }
        }
    }

    private boolean fillSudoku(char[][] board, int row, int col) {
        int ro = -1;
        int co = -1;
        for (int i = row; i < 9; i++) {
            if (ro != -1) break;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    ro = i;
                    co = j;
                    break;
                }
            }
        }
        if (ro == -1) return true;
        for (int i = 0; i < 9; i++) {
            if (!rowsUsed[ro][i]
                    && !columnsUsed[i][co]
                    && !boxesUsed[3 * (ro / 3) + co / 3][i]) {
                rowsUsed[ro][i] = columnsUsed[i][co] = boxesUsed[3 * (ro / 3) + co / 3][i] = true;
                board[ro][co] = (char) ('1' + i);
                if (fillSudoku(board, ro, co)) return true;
                rowsUsed[ro][i] = columnsUsed[i][co] = boxesUsed[3 * (ro / 3) + co / 3][i] = false;
                board[ro][co] = '.';
            }
        }
        return false;
    }

    private void print(char[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char[][] input = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sudokuSolver.solveSudoku(input);
        sudokuSolver.print(input);
    }
}
