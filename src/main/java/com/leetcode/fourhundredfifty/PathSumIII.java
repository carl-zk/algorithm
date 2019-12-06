package com.leetcode.fourhundredfifty;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    Map<Integer, Integer> preSumCountMap = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        preSumCountMap.put(0, 1);
        return solve(root, sum, 0);
    }

    private int solve(TreeNode root, int target, int sum) {
        if (root == null) return 0;

        sum += root.val;

        int count = preSumCountMap.getOrDefault(sum - target, 0);

        preSumCountMap.put(sum, preSumCountMap.getOrDefault(sum, 0) + 1);

        count += solve(root.left, target, sum) + solve(root.right, target, sum);

        preSumCountMap.put(sum, preSumCountMap.get(sum) - 1);
        return count;
    }
}
