package com.leetcode.threehundredfifty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 * <p>
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * <p>
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,4,6].
 *
 * @auther carl
 */
public class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> list = new ArrayList<>();
    int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.index = 0;
        flat(nestedList);
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    private void flat(List<NestedInteger> nestedList) {
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                list.add(nested.getInteger());
            } else {
                flat(nested.getList());
            }
        }
    }

    interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
