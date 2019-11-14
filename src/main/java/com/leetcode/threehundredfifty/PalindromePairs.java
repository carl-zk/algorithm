package com.leetcode.threehundredfifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 * <p>
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 * <p>
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 *
 * @auther carl
 */
public class PalindromePairs {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            add(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(root, words[i], i);
        }
        return ans;
    }

    private void add(Trie root, String word, int index) {
        char[] cs = word.toCharArray();
        for (int i = cs.length - 1; i >= 0; i--) {
            if (root.next[cs[i]] == null) {
                root.next[cs[i]] = new Trie();
            }
            if (isPalindrome(cs, 0, i)) {
                root.list.add(index);
            }
            root = root.next[cs[i]];
        }
        root.list.add(index);
        root.index = index;
    }

    private void search(Trie root, String word, int index) {
        char[] cs = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (root.index >= 0 && root.index != index && isPalindrome(cs, i, cs.length - 1)) {
                ans.add(Arrays.asList(index, root.index));
            }
            if (root.next[cs[i]] == null) return;
            root = root.next[cs[i]];
        }
        for (int j : root.list) {
            if (j == index) continue;
            ans.add(Arrays.asList(index, j));
        }
    }

    private boolean isPalindrome(char[] cs, int start, int end) {
        while (start <= end) {
            if (cs[start++] != cs[end--]) return false;
        }
        return true;
    }

    class Trie {
        int index;
        Trie[] next;
        List<Integer> list;

        public Trie() {
            this.index = -1;
            this.next = new Trie[256];
            this.list = new ArrayList<>();
        }
    }
}
