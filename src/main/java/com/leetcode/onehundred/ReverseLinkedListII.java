package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @author carl
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = root, h = head;

        while (m > 1) {
            p = p.next;
            h = h.next;
            m--;
            n--;
        }
        ListNode pre = p, e = h, next;

        while (n > 0) {
            next = h.next;
            h.next = p;
            p = h;
            if (n == 1) {
                pre.next = h;
                e.next = next;
            }
            h = next;
            n--;
        }
        return root.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
