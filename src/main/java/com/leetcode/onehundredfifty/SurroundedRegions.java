package com.leetcode.onehundredfifty;

/**
 * @author carl
 */
public class SurroundedRegions {
    static final char X = 'X';
    static final char O = 'O';
    boolean[][] visited;
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{-1, 1, 0, 0};

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == O && !visited[i][j]) {
                    if (isSurrounded(board, i, j)) {
                        flip(board, i, j);
                    }
                }
            }
        }
    }

    private boolean isSurrounded(char[][] board, int r, int c) {
        if (r == 0 || r == board.length - 1 || c == 0 || c == board[0].length - 1) return false;
        visited[r][c] = true;
        boolean surround = true;
        for (int i = 0; i < dx.length; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (surround && x > -1 && x < board.length && y > -1 && y < board[0].length) {
                if (board[x][y] == O) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        surround = isSurrounded(board, x, y);
                    } else if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) return false;
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
            if (x > -1 && x < board.length && y > -1 && y < board[0].length && board[x][y] == O) {
                visited[x][y] = true;
                board[x][y] = X;
                flip(board, x, y);
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        sr.solve(board);
    }
}
