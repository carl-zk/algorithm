package com.leetcode.fourhundred;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 * <p>
 * Given an integer n, return 1 - n in lexicographical order.
 * <p>
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p>
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 * @auther carl
 */
public class LexicographicalNumbers {
    List<Integer> ans;

    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>();
        Trie root = new Trie();

        for (int i = 1; i <= n; i++) {
            build(root, i);
        }

        traversal(root);

        return ans;
    }

    private void build(Trie root, int val) {
        for (char c : Integer.toString(val).toCharArray()) {
            if (root.next[c - '0'] == null)
                root.next[c - '0'] = new Trie();
            root = root.next[c - '0'];
        }
        root.val = val;
        root.count++;
    }

    private void traversal(Trie root) {
        if (root.count > 0) {
            for (int i = 0; i < root.count; i++) {
                ans.add(root.val);
            }
        }
        for (int i = 0; i < 10; i++) {
            if (root.next[i] != null) {
                traversal(root.next[i]);
            }
        }
    }

    class Trie {
        int val;
        int count;
        Trie[] next;

        public Trie() {
            this.count = 0;
            next = new Trie[10];
        }
    }
}
