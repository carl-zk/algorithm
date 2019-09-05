package com.leetcode.fifty;

import static com.leetcode.fifty.MergeTwoSortedLists.ListNode;

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
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l > r) return null;
        if (l == r) return lists[l];
        int m = (l + r) >> 1;
        ListNode a = merge(lists, l, m);
        ListNode b = merge(lists, m + 1, r);
        ListNode h = new ListNode(0), p = h;
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
        return h.next;
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
