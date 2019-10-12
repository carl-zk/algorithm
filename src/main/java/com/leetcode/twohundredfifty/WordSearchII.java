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
    List<String> ans = new LinkedList<>();
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public List<String> findWords(char[][] board, String[] words) {
        if (words.length == 0 || board.length == 0) return Collections.emptyList();

        TrieNode root = new TrieNode();
        for (String wd : words) {
            TrieNode p = root;
            for (int i = 0; i < wd.length(); i++) {
                int j = wd.charAt(i) - 'a';
                if (p.next[j] == null) {
                    p.next[j] = new TrieNode();
                }
                p = p.next[j];
            }
            p.word = wd;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root);
            }
        }
        return ans;
    }

    private void search(char[][] board, int i, int j, TrieNode node) {
        char c = board[i][j];
        if (node.next[c - 'a'] == null) return;
        node = node.next[c - 'a'];
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }
        board[i][j] = '.';
        for (int l = 0; l < dx.length; l++) {
            int x = i + dx[l];
            int y = j + dy[l];
            if (0 <= x && x < board.length && 0 <= y && y < board[0].length && board[x][y] != '.') {
                search(board, x, y, node);
            }
        }
        board[i][j] = c;
    }

    class TrieNode {
        String word;
        TrieNode[] next = new TrieNode[26];
    }
}
