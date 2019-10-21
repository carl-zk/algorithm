package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * <p>
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * @auther carl
 */
public class KthSmallestElementInaBST {
    int i = 0;
    int K;
    TreeNode ans;

    public int kthSmallest(TreeNode root, int k) {
        ans = null;
        K = k;
        solve(root);
        return ans.val;
    }

    private void solve(TreeNode root) {
        if (root.left != null) {
            solve(root.left);
        }
        i++;
        if (i == K) {
            ans = root;
            return;
        }
        if (root.right != null) {
            solve(root.right);
        }
    }
}
