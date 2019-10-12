package com.leetcode.twohundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/word-search-ii/
 * <p>
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 * <p>
 * <p>
 * Note:
 * <p>
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 *
 * @auther carl
 */
public class WordSearchII {
    Set<String> ans = new HashSet<>();
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        if (words.length == 0 || board.length == 0) return Collections.emptyList();

        visited = new boolean[board.length][board[0].length];
        ArrayList<String>[] ws = new ArrayList[26];
        for (int i = 0; i < words.length; i++) {
            int j = words[i].charAt(0) - 'a';
            if (ws[j] == null) {
                ws[j] = new ArrayList<>();
            }
            ws[j].add(words[i]);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int k = board[i][j] - 'a';
                if (ws[k] != null) {
                    visited[i][j] = true;
                    for (String w : ws[k]) {
                        if (!ans.contains(w) && search(board, i, j, w.toCharArray(), 1)) {
                            ans.add(w);
                        }
                    }
                    visited[i][j] = false;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    private boolean search(char[][] board, int i, int j, char[] chars, int k) {
        if (k == chars.length) return true;
        for (int l = 0; l < dx.length; l++) {
            int x = i + dx[l];
            int y = j + dy[l];
            if (0 <= x && x < board.length && 0 <= y && y < board[0].length
                    && !visited[x][y] && board[x][y] == chars[k]) {
                visited[x][y] = true;
                if (search(board, x, y, chars, k + 1)) {
                    visited[x][y] = false;
                    return true;
                } else {
                    visited[x][y] = false;
                }
            }
        }
        return false;
    }
}
