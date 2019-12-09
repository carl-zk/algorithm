package com.leetcode.fivehundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @author carl
 */
public class LFUCache {
    Map<Integer, Node> cache;
    Map<Integer, Node> freqHeadMap;
    int capacity;
    int leastFreq;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freqHeadMap = new HashMap<>();
        this.capacity = capacity;
        leastFreq = 1;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        update(node);
        return node.val;
    }

    private void update(Node node) {
        remove(node);
        node.freq++;
        add(node);
    }

    private void remove(Node node) {
        Node head = freqHeadMap.get(node.freq);
        if (head.next == head) {
            if (leastFreq == node.freq) {
                leastFreq++;
            }
            freqHeadMap.remove(node.freq);
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        if (node == head) {
            freqHeadMap.put(node.freq, node.next);
        }
        node.pre = node.next = null;
    }

    private void add(Node node) {
        Node head = freqHeadMap.get(node.freq);
        if (head == null) {
            node.pre = node;
            node.next = node;
            freqHeadMap.put(node.freq, node);
            return;
        }
        node.next = head;
        node.pre = head.pre;
        head.pre = node;
        node.pre.next = node;
        freqHeadMap.put(node.freq, node);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() == capacity) {
                removeLeast();
            }
            leastFreq = 1;
            node = new Node(key, value);
            add(node);
            cache.put(key, node);
        } else {
            node.val = value;
            update(node);
        }
    }

    private void removeLeast() {
        Node node = freqHeadMap.get(leastFreq).pre;
        remove(node);
        cache.remove(node.key);
    }

    class Node {
        int key;
        int val;
        int freq;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 1;
            pre = next = null;
        }
    }
}
