package com.leetcode.fourhundred;

import java.util.List;

/**
 * https://leetcode.com/problems/mini-parser/
 * <p>
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Note: You may assume that the string is well-formed:
 * <p>
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 * <p>
 * Given s = "324",
 * <p>
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * <p>
 * Given s = "[123,[456,[789]]]",
 * <p>
 * Return a NestedInteger object containing a nested list with 2 elements:
 * <p>
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * i.  An integer containing value 456.
 * ii. A nested list with one element:
 * a. An integer containing value 789.
 *
 * @auther carl
 */
public class MiniParser {

    public NestedInteger deserialize(String s) {

        return s.charAt(0) == '[' ? parseList(s.toCharArray(), 1, s.length() - 2) :
                parseNumber(s.toCharArray(), 0, s.length() - 1);
    }

    private NestedInteger parseNumber(char[] chars, int start, int end) {
        NestedInteger integer = new NestedInteger(Integer.parseInt(
                String.valueOf(chars, start, end - start + 1)));
        return integer;
    }

    private NestedInteger parseList(char[] chars, int start, int end) {
        NestedInteger list = new NestedInteger();
        for (int i = start, j; i <= end; i++) {
            switch (chars[i]) {
                case '[':
                    int counter = 1;
                    for (j = i + 1; j <= end; j++) {
                        if (chars[j] == '[') counter++;
                        if (chars[j] == ']') counter--;
                        if (counter == 0) break;
                    }
                    list.add(parseList(chars, i + 1, j - 1));
                    i = j + 1;
                    break;
                default:
                    j = i;
                    while (j + 1 <= end && chars[j + 1] != ',') j++;
                    list.add(parseNumber(chars, i, j));
                    i = j + 1;
            }
        }
        return list;
    }

    public class NestedInteger {
        int val;
        List<NestedInteger> list;

        public NestedInteger() {
        }

        public NestedInteger(int val) {
            this.val = val;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
