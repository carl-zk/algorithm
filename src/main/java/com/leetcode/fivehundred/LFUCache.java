package com.leetcode.fivehundred;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lfu-cache/
 * <p>
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * <p>
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 * <p>
 * <p>
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * @author carl
 */
public class LFUCache {
    int capacity;
    int size;
    Map<Integer, Node> map;
    FreqManager freqManager;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        freqManager = new FreqManager();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        freqManager.update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity < 1) return;
        Node node = map.get(key);
        if (node == null) {
            size++;
            if (size > capacity) {
                Node least = freqManager.removeLeast();
                map.remove(least.key);
                size--;
            }
            node = new Node(key, value);
            freqManager.add(node);
            map.put(key, node);
        } else {
            node.val = value;
            freqManager.update(node);
        }
    }

    class Node {
        int key;
        int val;
        int freq;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
            pre = next = null;
        }
    }

    /**
     * frequency manager
     */
    class FreqManager {
        Map<Integer, FNode> freqMap;
        FNode head, tail;

        public FreqManager() {
            freqMap = new HashMap<>();
            head = new FNode(0);
            tail = new FNode(0);
            head.next = tail;
            tail.pre = head;
        }

        public FNode getByFreq(int freq) {
            return freqMap.get(freq);
        }

        public void add(Node node) {
            FNode fNode = tail.pre;
            if (fNode.freq != 1) {
                fNode = new FNode(1);
                insertBefore(fNode, tail);
            }
            insert(fNode, node);
        }

        private void insertBefore(FNode pre, FNode cur) {
            cur.pre.next = pre;
            pre.pre = cur.pre;
            pre.next = cur;
            cur.pre = pre;
            freqMap.put(pre.freq, pre);
        }

        private void insert(FNode fNode, Node node) {
            node.next = fNode.head.next;
            fNode.head.next.pre = node;
            node.pre = fNode.head;
            fNode.head.next = node;
        }

        public Node removeLeast() {
            Node least = tail.pre.tail.pre;
            removeFromFNode(tail.pre, least);
            return least;
        }

        private void removeFromFNode(FNode fNode, Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = node.next = null;
            if (fNode.head.next == fNode.tail) {
                freeFNode(fNode);
            }
        }

        private void freeFNode(FNode fNode) {
            freqMap.remove(fNode.freq);
            fNode.pre.next = fNode.next;
            fNode.next.pre = fNode.pre;
            fNode.pre = fNode.next = null;
        }

        public void update(Node node) {
            FNode cur = getByFreq(node.freq);
            FNode pre = cur.pre;
            if (pre.freq != cur.freq + 1) {
                pre = new FNode(cur.freq + 1);
                insertBefore(pre, cur);
            }
            removeFromFNode(cur, node);
            node.freq += 1;
            insert(pre, node);
        }

        class FNode {
            int freq;
            Node head;
            Node tail;
            FNode pre, next;

            public FNode(int freq) {
                this.freq = freq;
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.pre = head;
                pre = next = null;
            }
        }
    }
}
