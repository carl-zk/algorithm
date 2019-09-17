package com.leetcode.onehundredfifty;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @auther carl
 */
public class BinaryTreeLevelOrderTraversalII {
    List<List<Integer>> ans;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ans = new LinkedList<>();

        solve(root, 1);
        return ans;
    }

    private void solve(TreeNode root, int level) {
        if (root == null) return;
        if (level > ans.size()) {
            List<Integer> list = new LinkedList<>();
            list.add(root.val);
            ans.add(0, list);
        } else {
            ans.get(ans.size() - level).add(root.val);
        }
        solve(root.left, level + 1);
        solve(root.right, level + 1);
    }
}
