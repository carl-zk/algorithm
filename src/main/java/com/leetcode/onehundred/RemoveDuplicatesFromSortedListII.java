package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 * @author carl
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode j = head;
        head = null;
        ListNode i = null;

        while (j != null) {
            ListNode next = j.next;

            if (j.next == null || j.val != j.next.val) {
                if (i == null) {
                    head = i = j;
                } else {
                    i.next = j;
                    i = j;
                }
                j.next = null;
            } else {
                while (j.next != null && j.next.val == j.val) {
                    j = j.next;
                }
                next = j.next;
            }
            j = next;
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
