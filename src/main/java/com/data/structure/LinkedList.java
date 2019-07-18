package com.data.structure;

import lombok.Data;

import java.util.NoSuchElementException;

/**
 * @author carl
 */
public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        head = tail = null;
    }

    public int getFirst() {
        44
        checkEmpty();
        return head.value;
    }

    public int getLast() {
        checkEmpty();
        return tail.value;
    }

    public int addFirst(int e) {
        Node node = new Node(e);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        return e;
    }

    public int addLast(int e) {
        Node node = new Node(e);
        if (tail == null) {
            tail = head = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return e;
    }

    public int removeFirst() {
        checkEmpty();
        Node first = head;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        return first.value;
    }

    public int removeLast() {
        checkEmpty();
        Node last = tail;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        return last.value;
    }

    public void clear() {
        for (Node x = head; x.next != null; ) {
            Node next = x.next;
            x.next = null;
            next.prev = null;
            x = next;
        }
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Data
    static class Node {
        int value;
        Node prev;
        Node next;

        public Node() {
            value = 0;
            prev = next = null;
        }

        public Node(int value) {
            this.value = value;
        }
    }
}
