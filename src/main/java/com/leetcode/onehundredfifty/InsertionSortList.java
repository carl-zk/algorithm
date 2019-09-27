package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 * <p>
 * Sort a linked list using insertion sort.
 * <p>
 * <p>
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * <p>
 * <p>
 * Algorithm of Insertion Sort:
 * <p>
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
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
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode left = insertionSortList(head);
        ListNode right = insertionSortList(fast);
        head = new ListNode(0);
        ListNode q = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                q.next = left;
                left = left.next;
            } else {
                q.next = right;
                right = right.next;
            }
            q = q.next;
        }
        if (left != null) {
            q.next = left;
        } else q.next = right;
        return head.next;
    }
}
