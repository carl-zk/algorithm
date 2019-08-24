package com.leetcode;

import java.util.Arrays;

import static com.leetcode.MergeTwoSortedLists.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * @author carl
 */
public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return merge(lists[0], lists[1]);
        }
        int mid = lists.length >> 1;
        ListNode[] a = Arrays.copyOfRange(lists, 0, mid);
        ListNode[] b = Arrays.copyOfRange(lists, mid, lists.length);
        return merge(mergeKLists(a), mergeKLists(b));
    }

    private ListNode merge(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head, p;
        if (a.val < b.val) {
            head = p = a;
            a = a.next;
        } else {
            head = p = b;
            b = b.next;
        }
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        p.next = a == null ? b : a;
        return head;
    }

    public static void main(String[] args) {
        ListNode[] list = new ListNode[3];
        list[0] = ListNode.buildList(new int[]{1, 4, 5});
        list[1] = ListNode.buildList(new int[]{1, 3, 4});
        list[2] = ListNode.buildList(new int[]{2, 6});
        MergekSortedLists msl = new MergekSortedLists();
        ListNode result = msl.mergeKLists(list);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
