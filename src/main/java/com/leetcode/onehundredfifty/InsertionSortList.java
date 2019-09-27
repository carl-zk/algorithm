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
        ListNode p = head, q, r;
        head = null;

        while (p != null) {
            q = p;
            p = p.next;
            q.next = null;
            if (head == null) {
                head = q;
            } else {
                r = head;
                while (r.next != null && r.next.val < q.val) {
                    r = r.next;
                }
                if (r.val < q.val) {
                    q.next = r.next;
                    r.next = q;
                } else {
                    q.next = r;
                    head = q;
                }
            }
        }
        return head;
    }
}
