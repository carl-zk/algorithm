package com.leetcode.threehundred;

import java.util.Iterator;

/**
 * https://leetcode.com/problems/peeking-iterator/
 * <p>
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * <p>
 * Example:
 * <p>
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 * <p>
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 *
 * @author carl
 */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    int peek;
    boolean cached;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        cached = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cached) return peek;
        if (hasNext()) {
            this.peek = next();
            cached = true;
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cached) {
            cached = false;
            return peek;
        }
        return this.iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (cached) {
            return true;
        }
        return this.iterator.hasNext();
    }
}