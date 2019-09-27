package com.leetcode.onehundredfifty;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/lru-cache/
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 * @auther carl
 */
public class LRUCache {
    static final Node DUMMY_HEAD = new Node(-1, -1);
    static final Node DUMMY_TAIL = new Node(-1, -1);

    HashMap<Integer, Node> cache;
    int capacity;
    Node most;
    Node least;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.cache = new HashMap<>();
        this.capacity = capacity;
        most = DUMMY_HEAD;
        least = DUMMY_TAIL;
        most.next = least;
        least.pre = most;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        update(node);
        return node.value;
    }

    private void update(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = most.next;
        most.next.pre = node;
        node.pre = most;
        most.next = node;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            node.next = most.next;
            most.next.pre = node;
            node.pre = most;
            most.next = node;
            cache.put(key, node);
            if (cache.size() > capacity) {
                cache.remove(least.pre.key);
                least.pre = least.pre.pre;
                least.pre.next = least;
            }
        } else {
            node.value = value;
            update(node);
        }
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
