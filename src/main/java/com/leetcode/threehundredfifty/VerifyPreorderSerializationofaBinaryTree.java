package com.leetcode.threehundredfifty;

import java.util.Stack;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * <p>
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * <p>
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * Example 2:
 * <p>
 * Input: "1,#"
 * Output: false
 * Example 3:
 * <p>
 * Input: "9,#,#,1"
 * Output: false
 *
 * @auther carl
 */
public class VerifyPreorderSerializationofaBinaryTree {

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        if (nodes.length == 0) return false;
        if ("#".equals(nodes[0])) return nodes.length == 1;
        Stack<String> stack = new Stack<>();
        stack.push(nodes[0]);
        for (int i = 1; i < nodes.length; i++) {
            if (stack.isEmpty()) return false;
            if ("#".equals(nodes[i])) {
                while (!stack.isEmpty() && "r".equals(stack.peek())) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                    stack.push("r");
                }
            } else {
                stack.push(nodes[i]);
            }
        }
        return stack.isEmpty();
    }
}
