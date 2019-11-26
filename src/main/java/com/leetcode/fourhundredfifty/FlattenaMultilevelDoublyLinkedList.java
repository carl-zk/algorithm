package com.leetcode.fourhundredfifty;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * @author carl
 */
public class FlattenaMultilevelDoublyLinkedList {
    Node cur, h;

    public Node flatten(Node head) {
        if (head == null) return null;
        h = cur = head;
        Node next = head.next;
        solve(head.child);
        solve(next);
        head.child = null;
        return h;
    }

    private void solve(Node node) {
        if (node == null) return;
        Node next = node.next;
        cur.next = node;
        node.prev = cur;
        cur = node;
        solve(node.child);
        solve(next);
        node.child = null;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
