package com.leetcode.twohundredfifty;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 * <p>
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 * @author carl
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                while (!operators.isEmpty()) {
                    calc(operands, operators);
                }
                operators.push(s.charAt(i));
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                while (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
                    calc(operands, operators);
                }
                operators.push(s.charAt(i));
            } else if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                int j = i + 1;
                while (j < s.length() && '0' <= s.charAt(j) && s.charAt(j) <= '9') j++;
                operands.push(Integer.valueOf(s.substring(i, j)));
                i = j - 1;
            }
        }
        while (!operators.isEmpty()) {
            calc(operands, operators);
        }
        return operands.peek();
    }

    private void calc(Stack<Integer> operands, Stack<Character> operators) {
        int sec = operands.pop();
        switch (operators.pop()) {
            case '+':
                operands.push(operands.pop() + sec);
                break;
            case '-':
                operands.push(operands.pop() - sec);
                break;
            case '*':
                operands.push(operands.pop() * sec);
                break;
            default:
                operands.push(operands.pop() / sec);
        }
    }
}
