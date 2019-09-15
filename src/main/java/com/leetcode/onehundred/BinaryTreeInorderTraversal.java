package com.leetcode.onehundred;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 *
 * @author carl
 */
public class BinaryTreeInorderTraversal {
    List<Integer> ans;

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new LinkedList<>();
        solve(root);
        return ans;
    }

    private void solve(TreeNode root) {
        if (root == null) return;
        solve(root.left);
        ans.add(root.val);
        solve(root.right);
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
