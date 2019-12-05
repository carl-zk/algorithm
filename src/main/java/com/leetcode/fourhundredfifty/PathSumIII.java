package com.leetcode.fourhundredfifty;

import com.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/path-sum-iii/
 * <p>
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * @author carl
 */
public class PathSumIII {
    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        traversal(root, sum);
        return ans;
    }

    private void traversal(TreeNode root, int sum) {
        if (root == null) return;

        solve(root, sum, 0);

        traversal(root.left, sum);
        traversal(root.right, sum);
    }

    private void solve(TreeNode start, int target, int sum) {
        if (start == null) return;

        sum += start.val;

        if (target == sum) ans++;

        solve(start.left, target, sum);
        solve(start.right, target, sum);
    }
}
