package com.leetcode.fivehundred;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/concatenated-words/
 * <p>
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 * <p>
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * <p>
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * <p>
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Note:
 * The number of elements of the given array will not exceed 10,000
 * The length sum of elements in the given array will not exceed 600,000.
 * All the input string will only include lower case letters.
 * The returned elements order does not matter.
 *
 * @author carl
 */
public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new LinkedList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        for (String word : words) {
            if (trie.search(word.toCharArray(), 0) > 1) {
                ans.add(word);
            }
        }
        return ans;
    }

    class Trie {
        Node root = new Node();

        void add(String s) {
            Node p = root;
            for (char c : s.toCharArray()) {
                if (p.next[c] == null) {
                    p.next[c] = new Node();
                }
                p = p.next[c];
            }
            p.count++;
        }

        int search(char[] chars, int start) {
            Node p = root;
            for (int i = start; i < chars.length; i++) {
                if (p.next[chars[i]] == null) return -chars.length;
                if (p.next[chars[i]].count > 0) {
                    if (i == chars.length - 1) return 1;
                    if (search(chars, i + 1) > 0) {
                        return 2;
                    }
                }
                p = p.next[chars[i]];
            }
            return 0;
        }

        class Node {
            int count;
            Node[] next;

            public Node() {
                this.count = 0;
                this.next = new Node[128];
            }
        }
    }
}
