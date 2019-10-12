package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z
 *
 * @auther carl
 */
public class WordDictionary {
    Node root = new Node();

    public WordDictionary() {
        root.isEnd = true;
    }

    public void addWord(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.next[index] == null) {
                p.next[index] = new Node();
            }
            p = p.next[index];
            if (i == word.length() - 1) {
                p.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        return regularSearch(root, word.toCharArray(), 0);
    }

    private boolean regularSearch(Node cur, char[] chars, int i) {
        if (i == chars.length) return cur.isEnd;
        if (chars[i] == '.') {
            boolean match = false;
            for (int j = 0; !match && j < 26; j++) {
                if (cur.next[j] != null) {
                    match = regularSearch(cur.next[j], chars, i + 1);
                }
            }
            return match;
        }
        return cur.next[chars[i] - 'a'] != null && regularSearch(cur.next[chars[i] - 'a'], chars, i + 1);
    }

    class Node {
        boolean isEnd;
        Node[] next = new Node[26];
    }
}
