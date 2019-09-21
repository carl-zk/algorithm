package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * <p>
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
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
        if (root == null) return Integer.MIN_VALUE;

        if (root.val > ans) {
            ans = root.val;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        long left = solve(root.left);
        long right = solve(root.right);
        if (left > ans) {
            ans = left;
        }
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
}
