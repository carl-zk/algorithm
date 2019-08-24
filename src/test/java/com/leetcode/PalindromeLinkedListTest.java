package com.leetcode;

import org.junit.jupiter.api.Test;

import static com.leetcode.PalindromeLinkedList.ListNode;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class PalindromeLinkedListTest {

    @Test
    public void test() {
        PalindromeLinkedList p = new PalindromeLinkedList();

        assertTrue(p.isPalindrome(null));
        assertTrue(p.isPalindrome(build(1)));
        assertTrue(p.isPalindrome(build(1, 1)));
        assertTrue(p.isPalindrome(build(1, 2, 1)));
        assertFalse(p.isPalindrome(build(1, 2)));
    }

    private ListNode build(int... args) {
        ListNode head = new ListNode(args[0]);
        ListNode iter = head;
        for (int i = 1; i < args.length; i++) {
            iter.next = new ListNode(args[i]);
            iter = iter.next;
        }
        return head;
    }
}
