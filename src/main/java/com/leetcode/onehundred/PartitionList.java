package com.leetcode.onehundred;

/**
 * https://leetcode.com/problems/partition-list/
 * <p>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * @author carl
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode p = preHead, q = preHead, cur, next;

        while (q.next != null) {
            if (q.next.val < x) {
                if (p.next == q.next) {
                    p = p.next;
                    q = q.next;
                } else {
                    cur = q.next;
                    q.next = cur.next;
                    next = q;
                    cur.next = p.next;
                    p.next = cur;
                    p = cur;
                    q = next;
                }
            } else {
                q = q.next;
            }
        }
        return preHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
