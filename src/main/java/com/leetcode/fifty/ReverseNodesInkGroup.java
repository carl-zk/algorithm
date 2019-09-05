package com.leetcode.fifty;

import com.leetcode.fifty.MergeTwoSortedLists.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * @author carl
 */
public class ReverseNodesInkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(0);
        ListNode cur = head;
        ListNode pre = h;
        ListNode p;
        ListNode jump;

        while (cur != null) {
            p = cur;
            for (int i = 1; i < k && p != null; i++) {
                p = p.next;
            }
            if (p == null) {
                pre.next = cur;
                return h.next;
            }
            jump = p.next;
            p.next = null;
            pre.next = reverse(cur);
            pre = cur;
            cur = jump;
        }
        return h.next;
    }

    private ListNode reverse(ListNode h) {
        ListNode pre = null;
        ListNode jump;

        while (h != null) {
            jump = h.next;
            h.next = pre;
            if (jump == null) {
                return h;
            }
            pre = h;
            h = jump;
        }
        return null;
    }
}
