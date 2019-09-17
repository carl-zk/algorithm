package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
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
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int[] in;
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder;
        post = postorder;

        return solve(postorder.length - 1, 0, 0, inorder.length - 1);
    }

    private TreeNode solve(int pend, int pstart, int istart, int iend) {
        if (pend < pstart || istart > iend) return null;

        TreeNode node = new TreeNode(post[pend]);
        int i = istart;
        while (in[i] != post[pend]) i++;
        node.left = solve(pend - iend + i - 1, pstart, istart, i - 1);
        node.right = solve(pend - 1, pend - iend + i, i + 1, iend);
        return node;
    }
}
