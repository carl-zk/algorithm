package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * <p>
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * Output: 6
 *
 * @auther carl
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        int s = (1 << rh) - 1;
        return lh == rh ? s: 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftHeight(TreeNode root) {
        return root == null ? 0 : 1 + leftHeight(root.left);
    }

    private int rightHeight(TreeNode root) {
        return root == null ? 0 : 1 + rightHeight(root.right);
    }
}
