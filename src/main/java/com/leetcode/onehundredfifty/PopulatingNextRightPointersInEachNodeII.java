package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Example:
 *
 *
 *
 * Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 *
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 *
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 *
 * @auther carl
 */
public class PopulatingNextRightPointersInEachNodeII {

    public Node connect(Node root) {
        Node next = null, cur = root;
        Node l, r;
        while (cur != null) {
            l = null;
            r = null;
            if (cur.left != null) {
                l = cur.left;
                if (next == null) {
                    next = cur.left;
                }
                cur.left.next = cur.right;
            }
            if (cur.right != null) {
                l = cur.right;
                if (next == null) {
                    next = cur.right;
                }
            }
            for (Node p = cur.next; p != null; p = p.next) {
                r = p.left != null ? p.left : p.right;
                if (r != null) {
                    if (l != null) {
                        l.next = r;
                    } else {
                        if (next == null) {
                            next = r;
                        }
                    }
                    break;
                }
            }
            cur = cur.next;
            if (cur == null) {
                cur = next;
                next = null;
            }
        }
        return root;
    }
}
