package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * @author carl
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode i = head, j = i.next;
        i.next = null;

        while (j != null) {
            if (j.val > i.val) {
                i.next = j;
                i = j;
                j = j.next;
                i.next = null;
            } else {
                j = j.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
