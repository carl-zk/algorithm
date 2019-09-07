package com.leetcode.onehundred;

/**
 * @author carl
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        int n = len - (k % len);

        if (n == len) return head;

        ListNode first = head, cur = head, last;

        while (n > 1) {
            cur = cur.next;
            n--;
        }
        head = cur.next;
        last = cur.next;
        cur.next = null;
        while (last.next != null) {
            last = last.next;
        }
        last.next = first;
        return head;
    }

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
