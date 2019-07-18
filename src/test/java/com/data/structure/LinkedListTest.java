package com.data.structure;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author carl
 */
public class LinkedListTest {

    @Test
    public void testIsEmpty() {
        LinkedList linkedList = new LinkedList();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testRemoveWhenEmpty() {
        LinkedList linkedList = new LinkedList();
        assertAll("empty list",
                () -> assertThrows(NoSuchElementException.class, () -> linkedList.removeFirst()),
                () -> assertThrows(NoSuchElementException.class, () -> linkedList.removeLast()));
    }

    @Test
    public void testAdd() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        assertEquals(1, linkedList.getFirst());
        assertEquals(1, linkedList.getLast());

        linkedList.addFirst(2);
        assertEquals(2, linkedList.getFirst());
        assertEquals(1, linkedList.getLast());
    }

    @Test
    public void testRemove() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        int i = 4;
        while (!linkedList.isEmpty()) {
            assertEquals(i--, linkedList.removeFirst());
        }

        for (int j = 0; j < 10; j++) {
            linkedList.addLast(j);
        }
        int j = 0;
        while (!linkedList.isEmpty()) {
            assertEquals(j++, linkedList.removeFirst());
        }
    }

    @Test
    public void testClear() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
        }
        linkedList.clear();
        assertTrue(linkedList.isEmpty());
    }
}
