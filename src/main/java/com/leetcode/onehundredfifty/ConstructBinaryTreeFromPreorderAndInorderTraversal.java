package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @auther carl
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int[] pre;
    int[] in;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        return solve(0, 0, in.length - 1);
    }

    private TreeNode solve(int index, int start, int end) {
        if (index == pre.length || start > end) return null;

        TreeNode node = new TreeNode(pre[index]);
        int i = start;
        while (in[i] != pre[index]) i++;
        node.left = solve(index + 1, start, i - 1);
        node.right = solve(index + i - start + 1, i + 1, end);
        return node;
    }
}
