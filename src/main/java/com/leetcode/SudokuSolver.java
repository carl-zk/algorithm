package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

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
    boolean find;
    PriorityQueue<Node> queue = new PriorityQueue<>();

    public void solveSudoku(char[][] board) {
        Node node = new Node(board);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node sudoku = queue.poll();
            int ro = -1;
            int co = -1;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudoku.board[i][j] == '.') {
                        ro = i;
                        co = j;
                        j = 9;
                        i = 9;
                    }
                }
            }
            if (ro == -1) {
                find = true;
                //print(sudoku.board);
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        board[i][j] = sudoku.board[i][j];
                    }
                }
                break;
            }
            boolean[] used = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (sudoku.board[ro][i] != '.') {
                    used[sudoku.board[ro][i] - '1'] = true;
                }
                if (sudoku.board[i][co] != '.') {
                    used[sudoku.board[i][co] - '1'] = true;
                }
            }
            for (int i = 0; i < 9; i++) {
                if (!used[i]) {
                    sudoku.board[ro][co] = (char) ('1' + i);
                    if (isValid(sudoku.board)) {
                        Node no = new Node(sudoku.board);
                        queue.add(no);
                    }
                }
            }
        }
    }

    private boolean isValid(char[][] sudoku) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] used = new boolean[9];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int ro = i + k;
                        int co = j + l;
                        if (sudoku[ro][co] != '.') {
                            if (used[sudoku[ro][co] - '1']) {
                                return false;
                            } else {
                                used[sudoku[ro][co] - '1'] = true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private void print(char[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + ", ");
            }
            System.out.println();
        }
    }

    static class Node implements Comparable<Node> {
        char[][] board;
        int weight;

        public Node(char[][] board) {
            this.board = new char[9][9];
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

        @Override
        public int compareTo(Node o) {
            return o.weight - weight;
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
}
