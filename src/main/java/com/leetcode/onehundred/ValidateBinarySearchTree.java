package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * @auther carl
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer large_limit, Integer low_limit) {
        if (root == null) return true;
        if (large_limit != null && root.val >= large_limit) return false;
        if (low_limit != null && root.val <= low_limit) return false;
        if (!isValid(root.left, root.val, low_limit)) return false;
        if (!isValid(root.right, large_limit, root.val)) return false;
        return true;
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
