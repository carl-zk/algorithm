package com.data.structure;

import lombok.Data;

/**
 * @author carl
 */
public class Queue {
    Node head;
    Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public int enQueue(int e) {
        Node node = new Node(e);
        if (head == null) {
            head = tail = node;
        }
        tail.next = node;
        tail = node;
        return e;
    }

    public int deQueue() {
        if (head == null) {
            throw new IllegalStateException("queue is empty");
        }
        Node h = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return h.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Data
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
