package com.leetcode.onehundred;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * <p>
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @author carl
 */
public class UniqueBinarySearchTreesII {
    List<TreeNode> ans;
    int N;
    boolean[] visit;
    int[] temp;
    Set<String> set;

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();

        ans = new LinkedList<>();
        N = n;
        visit = new boolean[n + 1];
        temp = new int[n];
        set = new HashSet<>();
        perm(1, 0);
        return ans;
    }

    private void perm(int index, int len) {
        if (len == N) {
            TreeNode root = null;
            for (int i = 0; i < N; i++) {
                root = build(root, temp[i]);
            }
            StringBuilder sb = new StringBuilder();
            treeToString(root, sb);
            String key = sb.toString();
            if (!set.contains(key)) {
                set.add(key);
                ans.add(root);
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                temp[len] = i;
                perm(i + 1, len + 1);
                visit[i] = false;
            }
        }
    }

    private TreeNode build(TreeNode root, int v) {
        TreeNode node = new TreeNode(v);
        if (root == null) {
            return node;
        }
        TreeNode p = root;
        while (p != null) {
            if (v < p.val) {
                if (p.left == null) {
                    p.left = node;
                    break;
                } else {
                    p = p.left;
                }
            } else if (p.right == null) {
                p.right = node;
                break;
            } else {
                p = p.right;
            }
        }
        return root;
    }

    private void treeToString(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append("#");
        treeToString(root.left, sb);
        treeToString(root.right, sb);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
