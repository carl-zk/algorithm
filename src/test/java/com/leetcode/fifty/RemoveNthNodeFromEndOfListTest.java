package com.leetcode.fifty;

import com.leetcode.fifty.RemoveNthNodeFromEndOfList.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author carl
 */
public class RemoveNthNodeFromEndOfListTest {

    @Test
    public void test() {
        RemoveNthNodeFromEndOfList ins = new RemoveNthNodeFromEndOfList();

        ListNode result = ins.removeNthFromEnd(ListNode.buildList(Arrays.asList(1, 2, 3, 4, 5)), 2);

        assertTrue(() -> {
            int[] expected = new int[]{1, 2, 3, 5};
            ListNode p = result;
            for (int i = 0; i < 4; i++) {
                if (p.val != expected[i]) {
                    return false;
                }
                p = p.next;
            }
            return true;
        });
    }
}
