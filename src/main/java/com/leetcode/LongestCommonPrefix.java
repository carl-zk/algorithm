package com.leetcode;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 *
 * @author carl
 */
public class LongestCommonPrefix {
    public static final int SIZE = 26;

    Node root;
    StringBuilder sb;

    public String longestCommonPrefix(String[] strs) {
        root = new Node(' ', null);
        sb = new StringBuilder();
        Node p;
        int i;
        for (i = 0; i < strs.length - 1; i++) {
            p = root;
            for (int j = 0; j < strs[i].length(); j++) {
                append(p, i, j, strs);
                p = p.children[strs[i].charAt(j) - 'a'];
            }
        }
        if (i == strs.length - 1) {
            p = root;
            for (int j = 0; j < strs[i].length(); j++) {
                append(p, i, j, strs);
                if (p.children[strs[i].charAt(j) - 'a'].count == strs.length) {
                    sb.append(strs[i].charAt(j));
                }
                p = p.children[strs[i].charAt(j) - 'a'];
            }
        }

        return sb.toString();
    }

    private void append(Node p, int i, int j, String[] strs) {
        if (p.children[strs[i].charAt(j) - 'a'] == null) {
            Node node = new Node(strs[i].charAt(j), p);
            p.children[strs[i].charAt(j) - 'a'] = node;
        } else {
            p.children[strs[i].charAt(j) - 'a'].count++;
        }
    }

    static class Node {
        public char value;
        public int count;
        public Node[] children;
        public Node pre;

        public Node(char c, Node pre) {
            this.value = c;
            this.count = 1;
            this.children = new Node[SIZE];
            this.pre = pre;
        }
    }
}
