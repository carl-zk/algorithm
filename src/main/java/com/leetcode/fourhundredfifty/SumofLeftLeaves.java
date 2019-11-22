package com.leetcode.fourhundredfifty;

import com.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * <p>
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 * @author carl
 */
public class SumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return solve(root, false);
    }

    private int solve(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (isLeft && root.left == null && root.right == null) return root.val;
        return solve(root.left, true) + solve(root.right, false);
    }
}
