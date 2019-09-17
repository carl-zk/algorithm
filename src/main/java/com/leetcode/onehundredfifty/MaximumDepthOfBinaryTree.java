package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * @auther carl
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return solve(root, 1);
    }

    private int solve(TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            return level;
        }
        if (root.left != null && root.right != null) {
            return Math.max(solve(root.left, level + 1), solve(root.right, level + 1));
        }
        if (root.left != null) {
            return solve(root.left, level + 1);
        }
        return solve(root.right, level + 1);
    }
}
