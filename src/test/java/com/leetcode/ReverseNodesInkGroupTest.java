package com.leetcode;

import org.junit.jupiter.api.Test;

import static com.leetcode.MergeTwoSortedLists.ListNode;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class ReverseNodesInkGroupTest {

    @Test
    public void test() {
        ReverseNodesInkGroup rev = new ReverseNodesInkGroup();

        assertTrue(judge(ListNode.buildList(new int[]{1}),
                rev.reverseKGroup(ListNode.buildList(new int[]{1}), 2)));
        assertTrue(judge(ListNode.buildList(new int[]{2, 1, 4, 3}),
                rev.reverseKGroup(ListNode.buildList(new int[]{1, 2, 3, 4}), 2)));
    }

    private boolean judge(ListNode expected, ListNode result) {
        while (expected != null && result != null) {
            if (expected.val != result.val) {
                return false;
            }
            expected = expected.next;
            result = result.next;
        }
        return expected == null && result == null;
    }
}
