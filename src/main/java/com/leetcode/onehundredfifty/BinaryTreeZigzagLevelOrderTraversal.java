package com.leetcode.onehundredfifty;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @auther carl
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    List<List<Integer>> ans;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new LinkedList<>();

        solve(root, 0, true);
        return ans;
    }

    private void solve(TreeNode root, int level, boolean toRight) {
        if (root == null) return;
        if (ans.size() == level) {
            ans.add(new LinkedList<>());
        }
        if (toRight) {
            ans.get(level).add(root.val);
        } else {
            ans.get(level).add(0, root.val);
        }
        solve(root.left, level + 1, !toRight);
        solve(root.right, level + 1, !toRight);
    }
}
