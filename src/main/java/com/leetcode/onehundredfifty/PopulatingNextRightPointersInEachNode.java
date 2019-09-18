package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * <p>
 * <p>
 * Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * <p>
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 * <p>
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 *
 * @auther carl
 */
public class PopulatingNextRightPointersInEachNode {


    public Node connect(Node root) {
        Node p = root, q = null;
        while (p != null) {
            if (p.left != null) {
                p.left.next = p.right;
            }
            if (q == null) {
                q = p.left;
            }
            if (p.right != null && p.next != null) {
                p.right.next = p.next.left;
            }
            p = p.next;
            if (p == null) {
                p = q;
                q = null;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode p = new PopulatingNextRightPointersInEachNode();
        Node root = new Node();
        root.val = 1;
        Node left = new Node();
        left.val = 2;
        Node right = new Node();
        right.val = 3;
        root.left = left;
        root.right = right;
        Node ll = new Node();
        ll.val = 4;
        Node lr = new Node();
        lr.val = 5;
        left.left = ll;
        left.right = lr;
        Node rl = new Node();
        rl.val = 6;
        Node rr = new Node();
        rr.val = 7;
        right.left = rl;
        right.right = rr;
        p.connect(root);
    }
}
