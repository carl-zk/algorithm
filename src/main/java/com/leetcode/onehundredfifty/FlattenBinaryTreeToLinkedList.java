package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * @auther carl
 */
public class FlattenBinaryTreeToLinkedList {
    TreeNode ans;

    public void flatten(TreeNode root) {
        ans = new TreeNode(1);
        solve(root);
    }

    private void solve(TreeNode root) {
        if (root == null) return;
        ans.right = root;
        ans = root;
        TreeNode l = root.left;
        TreeNode r = root.right;
        ans.left = ans.right = null;
        solve(l);
        solve(r);
    }
}
