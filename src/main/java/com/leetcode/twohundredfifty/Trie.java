package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * @auther carl
 */
public class Trie {
    Node root = new Node('$');

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node par = root;
        for (char c : word.toCharArray()) {
            if (par.next[c] == null) {
                par.next[c] = new Node(c);
            }
            par = par.next[c];
        }
        par.next['$'] = new Node('$');
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node p = root;
        for (char c : word.toCharArray()) {
            if (p.next[c] == null) return false;
            p = p.next[c];
        }
        return p.next['$'] != null;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node p = root;
        for (char c : prefix.toCharArray()) {
            if (p.next[c] == null) return false;
            p = p.next[c];
        }
        return true;
    }

    static class Node {
        private char v;
        private Node[] next = new Node[256];

        public Node(char v) {
            this.v = v;
        }
    }
}
