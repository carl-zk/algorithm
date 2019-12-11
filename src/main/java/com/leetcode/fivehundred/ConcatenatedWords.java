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
    Node root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Node();
        List<String> ans = new LinkedList<>();
        build(words);
        for (String word : words) {
            if (search(word.toCharArray(), 0, 0)) {
                ans.add(word);
            }
        }
        return ans;
    }

    void build(String[] words) {
        for (String w : words) {
            Node p = root;
            for (char c : w.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    p.next[c - 'a'] = new Node();
                }
                p = p.next[c - 'a'];
            }
            p.isEnd = true;
        }
    }

    boolean search(char[] chars, int start, int count) {
        Node p = root;
        for (int i = start; i < chars.length; i++) {
            if (p.next[chars[i] - 'a'] == null) return false;
            p = p.next[chars[i] - 'a'];
            if (p.isEnd) {
                if (i == chars.length - 1) return count > 0;
                if (search(chars, i + 1, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    class Node {
        boolean isEnd;
        Node[] next;

        public Node() {
            this.isEnd = false;
            // if 128, will get 98ms; if 26, 47ms. Oh Java.
            this.next = new Node[26];
        }
    }
}
