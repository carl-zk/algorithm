package com.leetcode.fourhundredfifty;

import com.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * <p>
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 * <p>
 * Example:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * <p>
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * Another valid answer is [5,2,6,null,4,null,7].
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 *
 * @author carl
 */
public class DeleteNodeinaBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            return merge(root.left, root.right);
        }
        TreeNode p = root;
        while (p != null) {
            if (key < p.val) {
                if (p.left != null && p.left.val == key) {
                    p.left = merge(p.left.left, p.left.right);
                    break;
                }
                p = p.left;
            } else {
                if (p.right != null && p.right.val == key) {
                    p.right = merge(p.right.left, p.right.right);
                    break;
                }
                p = p.right;
            }
        }
        return root;
    }

    private TreeNode merge(TreeNode left, TreeNode right) {
        if (left == null) return right;
        if (right == null) return left;
        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        p.right = right;
        return left;
    }
}
