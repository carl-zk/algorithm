package com.leetcode.fifty;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author carl
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head, p;
        if (l1.val < l2.val) {
            head = p = l1;
            l1 = l1.next;
        } else {
            head = p = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return head;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public static ListNode buildList(int[] values) {
            ListNode head = new ListNode(values[0]);
            ListNode p = head;
            for (int i = 1; i < values.length; i++) {
                p.next = new ListNode(values[i]);
                p = p.next;
            }
            return head;
        }
    }
}
