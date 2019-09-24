package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/surrounded-regions/
 * <p>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * @author carl
 */
public class SurroundedRegions {
    static final char X = 'X';
    static final char O = 'O';
    static final char MARK = '.';

    boolean[][] visited;
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{-1, 1, 0, 0};

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == O && !visited[i][j]) {
                    if (judgeAndMark(board, i, j)) {
                        flip(board, i, j);
                    } else unMark(board, i, j);
                }
            }
        }
    }

    private boolean judgeAndMark(char[][] board, int r, int c) {
        visited[r][c] = true;
        board[r][c] = MARK;
        if (r == 0 || r == board.length - 1 || c == 0 || c == board[0].length - 1) return false;
        boolean surround = true;
        for (int i = 0; i < dx.length; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (surround && x > -1 && x < board.length && y > -1 && y < board[0].length) {
                if (board[x][y] == O && !visited[x][y]) {
                    visited[x][y] = true;
                    board[x][y] = MARK;
                    surround = judgeAndMark(board, x, y);
                } else if (board[x][y] == O && visited[x][y]) {
                    return false;
                }
            }
        }
        return surround;
    }

    private void flip(char[][] board, int r, int c) {
        board[r][c] = X;
        for (int i = 0; i < dx.length; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (x > -1 && x < board.length && y > -1 && y < board[0].length && board[x][y] == MARK) {
                visited[x][y] = true;
                board[x][y] = X;
                flip(board, x, y);
            }
        }
    }

    private void unMark(char[][] board, int r, int c) {
        board[r][c] = O;
        for (int i = 0; i < dx.length; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (x > -1 && x < board.length && y > -1 && y < board[0].length && board[x][y] == MARK) {
                board[x][y] = O;
                unMark(board, x, y);
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        sr.solve(board);
    }
}
