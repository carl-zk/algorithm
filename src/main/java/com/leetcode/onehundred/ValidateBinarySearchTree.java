package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * @auther carl
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.val == Integer.MAX_VALUE) {
            if (root.right != null) return false;
            if (root.left != null) {
                return root.left.val < root.val && isValid(root.left, root.val, null);
            }
            return true;
        }
        if (root.val == Integer.MIN_VALUE) {
            if (root.left != null) return false;
            if (root.right != null) {
                return root.right.val > root.val && isValid(root.right, null, root.val);
            }
            return true;
        }
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer lastLeft, Integer lastRight) {
        if (root.left != null && root.right != null) {
            if (root.left.val == Integer.MAX_VALUE) return false;
            if (root.left.val == Integer.MIN_VALUE && lastRight != null) return false;
            if (root.right.val == Integer.MIN_VALUE) return false;
            if (root.right.val == Integer.MAX_VALUE && lastLeft != null) return false;

            return root.left.val < root.val && (lastRight == null || root.left.val > lastRight) && isValid(root.left, root.val, lastRight)
                    && root.right.val > root.val && (lastLeft == null || root.right.val < lastLeft) && isValid(root.right, lastLeft, root.val);
        }
        if (root.left != null) {
            if (root.left.val == Integer.MAX_VALUE) return false;
            if (root.left.val == Integer.MIN_VALUE && lastRight != null) return false;
            return root.left.val < root.val && (lastRight == null || root.left.val > lastRight) && isValid(root.left, root.val, lastRight);
        }
        if (root.right != null) {
            if (root.right.val == Integer.MIN_VALUE) return false;
            if (root.right.val == Integer.MAX_VALUE && lastLeft != null) return false;
            return root.right.val > root.val && (lastLeft == null || root.right.val < lastLeft) && isValid(root.right, lastLeft, root.val);
        }
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
