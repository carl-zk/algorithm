package com.leetcode.twohundredfifty;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * <p>
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 *
 * @auther carl
 */
public class MyQueue {
    Stack<Integer> que;

    public MyQueue() {
        que = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!que.isEmpty()) {
            temp.push(que.pop());
        }
        temp.push(x);
        while (!temp.isEmpty()) {
            que.push(temp.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return que.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return que.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return que.isEmpty();
    }
}
