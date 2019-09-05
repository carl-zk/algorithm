package com.leetcode.fifty;

import java.util.List;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 *
 * @author carl
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode pre;
        ListNode jump;
        pre = jump = head;
        while (i < n && jump != null) {
            i++;
            jump = jump.next;
        }
        if (jump == null) {
            return head.next;
        }
        while (jump.next != null) {
            pre = pre.next;
            jump = jump.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public static ListNode buildList(List<Integer> values) {
            if (values == null || values.size() == 0) {
                return null;
            }
            ListNode head = null, p = null;
            for (int val : values) {
                ListNode q = new ListNode(val);
                if (p == null) {
                    head = p = q;
                } else {
                    p.next = q;
                    p = q;
                }
            }
            return head;
        }
    }
}
