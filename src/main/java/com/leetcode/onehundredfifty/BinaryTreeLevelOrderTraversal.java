package com.leetcode.onehundredfifty;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @auther carl
 */
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> ans;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>(Collections.emptyList());

        ans = new LinkedList<>();
        ans.add(Arrays.asList(root.val));
        Queue<TreeNode> que = new LinkedList<>();
        root.val = 1;
        que.add(root);
        boolean updated;

        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            List<Integer> item = ans.size() > node.val ? ans.get(node.val) : new ArrayList<>();
            updated = false;
            if (node.left != null) {
                item.add(node.left.val);
                node.left.val = node.val + 1;
                que.add(node.left);
                updated = true;
            }
            if (node.right != null) {
                item.add(node.right.val);
                node.right.val = node.val + 1;
                que.add(node.right);
                updated = true;
            }
            if (updated) {
                if (ans.size() > node.val) {
                    ans.set(node.val, item);
                } else {
                    ans.add(node.val, item);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        traversal.levelOrder(root);
    }
}
