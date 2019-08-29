package com.leetcode;

import java.util.Arrays;

/**
 * @author carl
 */
public class SudokuSolver {
    int[][] sudoku;
    boolean[][] fixed;
    boolean find;

    public void solveSudoku(char[][] board) {
        init(board);
        fillSudo(0, 0);
        print();
    }

    private void init(char[][] board) {
        sudoku = new int[9][9];
        fixed = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    sudoku[i][j] = board[i][j] - '0';
                    fixed[i][j] = true;
                }
            }
        }
        find = false;
    }

    private void fillSudo(int row, int col) {
        if (find || isInvalid(row, col)) return;
        int ro = -1;
        int co = -1;
        for (int i = row; i < 9; i++) {
            for (int j = col; j < 9; j++) {
                if (!fixed[i][j]) {
                    ro = i;
                    co = j;
                    j = 9;
                    i = 9;
                }
            }
        }
        if (ro == -1 && co == -1) return;
        boolean[] used = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (fixed[ro][i] || i < co && sudoku[ro][i] > 0) {
                used[sudoku[ro][i]] = true;
            }
            if (fixed[i][co] || i < ro && sudoku[i][co] > 0) {
                used[sudoku[i][co]] = true;
            }
        }
        for (int i = 1; i < 10; i++) {
            if (!used[i]) {
                sudoku[ro][co] = i;
                fillSudo(ro, co);
            }
        }
    }

    private boolean isInvalid(int row, int col) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] used = new boolean[10];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int ro = i + k;
                        int co = j + l;
                        if (fixed[ro][co] || ro <= row && co <= col && sudoku[ro][co] > 0) {
                            if (used[sudoku[ro][co]]) {
                                return true;
                            } else {
                                used[sudoku[ro][co]] = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println("////////");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print((fixed[i][j] ? 1 : 0) + ", ");
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
    }

    static class Node {
        char[][] board;
        int weight;

        public Node(char[][] board) {
            for (int i = 0; i < 9; i++) {
                this.board[i] = Arrays.copyOfRange(board[i], 0, 9);
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        this.weight++;
                    }
                }
            }
        }
    }
}
