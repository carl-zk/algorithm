package com.data.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author carl
 */
public class Stack {

    Node top;

    public Stack() {
        this.top = null;
    }

    public int push(int e) {
        Node node = new Node(e);
        node.next = top;
        top = node;
        return e;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        Node top = this.top;
        this.top = this.top.next;
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Data
    @NoArgsConstructor
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
