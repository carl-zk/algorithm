package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 * @auther carl
 */
public class BinaryTreeMaximumPathSum {
    long ans;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        ans = Integer.MIN_VALUE;
        solve(root);
        return (int) ans;
    }

    private long solve(TreeNode root) {
        if (root.val > ans) {
            ans = root.val;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left != null && root.right != null) {
            long left = solve(root.left);
            if (left > ans) {
                ans = left;
            }
            long right = solve(root.right);
            if (right > ans) {
                ans = right;
            }
            long max = Math.max(root.val, Math.max(root.val + left, root.val + right));
            if (max > ans) {
                ans = max;
            }
            if (root.val + left + right > ans) {
                ans = root.val + left + right;
            }
            return max;
        }
        if (root.left != null) {
            long left = solve(root.left);
            if (left > ans) {
                ans = left;
            }
            long max = Math.max(root.val, root.val + left);
            if (max > ans) {
                ans = max;
            }
            return max;
        }
        long right = solve(root.right);
        if (right > ans) {
            ans = right;
        }
        long max = Math.max(root.val, root.val + right);
        if (max > ans) {
            ans = max;
        }
        return max;
    }
}
