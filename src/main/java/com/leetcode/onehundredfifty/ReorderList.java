package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/reorder-list/
 * <p>
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * @author carl
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        ListNode reverse = null, q;
        while (fast != null) {
            q = fast.next;
            fast.next = reverse;
            reverse = fast;
            fast = q;
        }

        ListNode p = head;
        while (p != null) {
            q = reverse.next;
            reverse.next = p.next;
            p.next = reverse;
            p = reverse.next;
            if (p == null && q != null) reverse.next = q;
            reverse = q;
        }
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(build(1, 2, 3, 4, 5));
    }

    private static ListNode build(int... args) {
        ListNode head = null, q = null;
        for (int val : args) {
            ListNode node = new ListNode(val);
            if (q == null) {
                head = q = node;
            } else {
                q.next = node;
                q = node;
            }
        }
        return head;
    }
}
