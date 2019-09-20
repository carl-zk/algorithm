package com.leetcode.onehundredfifty;

/**
 * @auther carl
 */
public class BinaryTreeMaximumPathSum {
    long ans;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        ans = Integer.MIN_VALUE;
        solve(root);
        return (int) ans;
    }

    private long solve(TreeNode root) {
        if (root == null) return 0;
        if (root.val > ans) {
            ans = root.val;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        long left = solve(root.left);
        if (left > ans) {
            ans = left;
        }
        long right = solve(root.right);
        if (right > ans) {
            ans = right;
        }
        long[] arr = new long[]{root.val + left, root.val + right};
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        if (max > ans) {
            ans = max;
        }
        if (root.val + left + right > ans) {
            ans = root.val + left + right;
        }
        return max;
    }
}
