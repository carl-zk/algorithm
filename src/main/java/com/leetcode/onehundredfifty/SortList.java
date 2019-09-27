package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/sort-list/
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * @author carl
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        head = null;
        ListNode q = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                if (q == null) {
                    head = q = left;
                } else {
                    q.next = left;
                    q = q.next;
                }
                left = left.next;
            } else {
                if (q == null) {
                    head = q = right;
                } else {
                    q.next = right;
                    q = q.next;
                }
                right = right.next;
            }
        }
        if (q == null) {
            head = left == null ? right : left;
        } else q.next = left == null ? right : left;
        return head;
    }
}
