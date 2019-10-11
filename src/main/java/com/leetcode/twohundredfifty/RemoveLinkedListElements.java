package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * @auther carl
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head, q = null;
        head = null;
        while (p != null) {
            if (p.val != val) {
                if (q == null) {
                    head = q = p;
                } else {
                    q.next = p;
                    q = q.next;
                }
            }
            p = p.next;
        }
        if (q != null) {
            q.next = null;
        }
        return head;
    }
}
