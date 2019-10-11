package com.leetcode.twohundredfifty;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @auther carl
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode p = head, q = null;
        head = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = head;
            head = q;
        }
        return head;
    }
}
