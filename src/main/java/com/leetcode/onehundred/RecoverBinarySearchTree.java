package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 * <p>
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * <p>
 * Output: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * Example 2:
 * <p>
 * Input: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 * /
 * 2
 * <p>
 * Output: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 * /
 * 3
 * Follow up:
 * <p>
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 *
 * @author carl
 */
public class RecoverBinarySearchTree {
    TreeNode first;
    TreeNode second;
    TreeNode last;

    public void recoverTree(TreeNode root) {
        solve(root);
        swap(first, second);
    }

    private void solve(TreeNode root) {
        if (root == null) return;
        solve(root.left);
        if (last != null && root.val <= last.val) {
            if (first == null) {
                first = last;
                second = root;
            } else {
                second = root;
            }
        }
        last = root;
        solve(root.right);
    }

    private void swap(TreeNode a, TreeNode b) {
        int v = a.val;
        a.val = b.val;
        b.val = v;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
