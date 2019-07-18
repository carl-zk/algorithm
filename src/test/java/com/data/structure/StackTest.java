package com.data.structure;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author carl
 */
public class StackTest {

    @Test
    public void testPop_empty() {
        Stack stack = new Stack();
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    public void testPop_notEmpty() {
        Stack stack = new Stack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        int i = 5;
        while (!stack.isEmpty()) {
            int top = stack.pop();
            i--;
            assertEquals(i, top);
        }
    }
}
