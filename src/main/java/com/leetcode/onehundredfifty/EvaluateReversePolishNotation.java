package com.leetcode.onehundredfifty;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Note:
 * <p>
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * <p>
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * @author carl
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        return solve(tokens, new int[]{tokens.length - 1});
    }

    private int solve(String[] tokens, int[] index) {
        String token = tokens[index[0]];
        index[0]--;
        int operator1;
        int operator2;
        switch (token) {
            case "+":
                operator2 = solve(tokens, index);
                operator1 = solve(tokens, index);
                return operator1 + operator2;
            case "-":
                operator2 = solve(tokens, index);
                operator1 = solve(tokens, index);
                return operator1 - operator2;
            case "*":
                operator2 = solve(tokens, index);
                operator1 = solve(tokens, index);
                return operator1 * operator2;
            case "/":
                operator2 = solve(tokens, index);
                operator1 = solve(tokens, index);
                return operator1 / operator2;
            default:
                return Integer.parseInt(token);
        }
    }
}
