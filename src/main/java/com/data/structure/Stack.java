package com.data.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

/**
 * @author carl
 */
public class Stack<T> {

    private Node top;

    public Stack() {
        this.top = null;
    }

    public T push(T e) {
        Node node = new Node(e);
        node.next = top;
        top = node;
        return e;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node top = this.top;
        this.top = this.top.next;
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return top.value;
    }

    @Data
    @NoArgsConstructor
    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }
}
