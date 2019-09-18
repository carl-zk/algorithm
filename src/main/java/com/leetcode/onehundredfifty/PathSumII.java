package com.leetcode.onehundredfifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @auther carl
 */
public class PathSumII {
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new LinkedList<>();
        solve(root, sum, new ArrayList<>());
        return ans;
    }

    private void solve(TreeNode root, int sum, ArrayList<Integer> temp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                temp.add(root.val);
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            }
        }
        temp.add(root.val);
        solve(root.left, sum - root.val, temp);
        temp.remove(temp.size() - 1);
        temp.add(root.val);
        solve(root.right, sum - root.val, temp);
        temp.remove(temp.size() - 1);
    }
}
