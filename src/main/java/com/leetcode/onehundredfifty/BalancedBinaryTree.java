package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 *
 * @author carl
 */
public class BalancedBinaryTree {
    boolean balanced;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        balanced = true;
        int l = solve(root.left);
        int r = solve(root.right);
        return balanced && Math.abs(l - r) < 2;
    }

    private int solve(TreeNode root) {
        if (root == null || !balanced) {
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        balanced = balanced && Math.abs(left - right) < 2;
        return Math.max(left, right) + 1;
    }
}
