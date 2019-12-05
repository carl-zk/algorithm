package com.leetcode.fourhundredfifty;

import java.util.HashMap;
import java.util.HashSet;
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
        head = new Bucket(Integer.MAX_VALUE);
        tail = new Bucket(-1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        Bucket cur = map.get(key);
        if (cur == null) {
            if (tail.pre == head || tail.pre.count > 1) {
                cur = new Bucket(1);
                cur.keys.add(key);
                insertBefore(tail, cur);
                map.put(key, cur);
            } else {
                tail.pre.keys.add(key);
                map.put(key, tail.pre);
            }
        } else {
            Bucket pre;
            if (cur.pre == head || cur.pre.count > cur.count + 1) {
                pre = new Bucket(cur.count + 1);
                pre.keys.add(key);
                insertBefore(cur, pre);
            } else {
                pre = cur.pre;
                pre.keys.add(key);
            }
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                remove(cur);
            }
            map.put(key, pre);
        }

    }

    private void insertBefore(Bucket node, Bucket newNode) {
        newNode.pre = node.pre;
        node.pre.next = newNode;
        newNode.next = node;
        node.pre = newNode;
    }

    private void remove(Bucket node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        Bucket cur = map.get(key);
        if (cur == null) return;
        if (cur.count == 1) {
            cur.keys.remove(key);
            map.remove(key);
        } else if (cur.next == tail || cur.next.count < cur.count - 1) {
            Bucket next = new Bucket(cur.count - 1);
            next.keys.add(key);
            insertAfter(cur, next);
            map.put(key, next);
        } else {
            cur.next.keys.add(key);
            map.put(key, cur.next);
        }
        cur.keys.remove(key);
        if (cur.keys.isEmpty()) {
            remove(cur);
        }
    }

    private void insertAfter(Bucket node, Bucket newNode) {
        newNode.next = node.next;
        node.next.pre = newNode;
        node.next = newNode;
        newNode.pre = node;
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
            this.keys = new HashSet<>();
            pre = next = null;
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
