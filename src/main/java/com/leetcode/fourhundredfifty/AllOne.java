package com.leetcode.fourhundredfifty;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/all-oone-data-structure/
 * <p>
 * Implement a data structure supporting the following operations:
 * <p>
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 *
 * @author carl
 */
public class AllOne {
    Bucket head;
    Bucket tail;
    Map<String, Bucket> map;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        head = new Bucket(0);
        tail = new Bucket(0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        Bucket cur = map.getOrDefault(key, tail);
        Bucket pre = cur.pre;
        if (pre.count != cur.count + 1) {
            pre = new Bucket(cur.count + 1);
            pre.insertBefore(cur);
        }
        removeKey(cur, key);
        addKey(pre, key);
    }

    private void addKey(Bucket node, String key) {
        node.keys.add(key);
        map.put(key, node);
    }

    private void removeKey(Bucket node, String key) {
        node.keys.remove(key);
        if (node != tail && node.keys.isEmpty()) {
            node.remove();
        }
        map.remove(key);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        Bucket cur = map.get(key);
        if (cur == null) return;
        if (cur.count == 1) {
            removeKey(cur, key);
            return;
        }
        Bucket next = cur.next;
        if (next.count != cur.count - 1) {
            next = new Bucket(cur.count - 1);
            next.insertAfter(cur);
        }
        removeKey(cur, key);
        addKey(next, key);
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return tail.pre == head ? "" : tail.pre.keys.iterator().next();
    }

    class Bucket {
        int count;
        Set<String> keys;
        Bucket pre;
        Bucket next;

        public Bucket(int count) {
            this.count = count;
            this.keys = new LinkedHashSet<>();
            pre = next = null;
        }

        private void insertBefore(Bucket node) {
            node.pre.next = this;
            this.pre = node.pre;
            this.next = node;
            node.pre = this;
        }

        private void insertAfter(Bucket node) {
            this.next = node.next;
            node.next.pre = this;
            this.pre = node;
            node.next = this;
        }

        private void remove() {
            this.pre.next = this.next;
            this.next.pre = this.pre;
        }
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");

        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("leet");
        allOne.dec("hello");
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
    }
}
