package com.leetcode.onehundredfifty;

/**
 * @auther carl
 */
public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        solve(root);
        return root;
    }

    private Node solve(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left = root.right;
        }
        Node left = solve(root.left);
        Node right = solve(root.right);
        while (left != null) {
            if (left.next == null) {
                left.next = right;
                break;
            }
            left = left.next;
        }
        return root.left != null ? root.left : root.right;
    }
}
