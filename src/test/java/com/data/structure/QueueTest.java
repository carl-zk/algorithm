package com.data.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author carl
 */
public class QueueTest {

    @Test
    public void testDeQueue_whenEmpty() {
        Queue queue = new Queue();
        assertThrows(IllegalStateException.class, () -> queue.deQueue());
    }

    @Test
    public void testIsEmpty_whenEmpty() {
        Queue queue = new Queue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test_normal() {
        Queue queue = new Queue();
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int e = queue.deQueue();
            assertEquals(i++, e);
        }
    }
}
