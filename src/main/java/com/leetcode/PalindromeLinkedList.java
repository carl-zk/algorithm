package com.leetcode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @author carl
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        int size = 0;
        for (ListNode t = head; t != null; t = t.next) {
            size++;
        }
        int[] halfBefore = new int[size >> 1];
        ListNode halfAfter = head;
        for (int i = 0; i < (size + 1) >> 1; i++) {
            if (i < halfBefore.length) {
                halfBefore[i] = halfAfter.val;
            }
            halfAfter = halfAfter.next;
        }
        for (int i = (size >> 1) - 1; i > -1; i--, halfAfter = halfAfter.next) {
            if (halfBefore[i] != halfAfter.val) {
                return false;
            }
        }
        return true;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
