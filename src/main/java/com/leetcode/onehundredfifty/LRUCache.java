package com.leetcode.onehundredfifty;

import java.util.HashMap;

/**
 * @auther carl
 */
public class LRUCache {
    static final Node DUMMY = new Node(-1, -1);

    HashMap<Integer, Node> cache;
    int capacity;
    Node most = new Node(-1, -1);
    Node least = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;

        return node.value;
    }

    public void put(int key, int value) {

    }

    static class Node {
        int key;
        int value;
        Node pre = null;
        Node next = null;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
