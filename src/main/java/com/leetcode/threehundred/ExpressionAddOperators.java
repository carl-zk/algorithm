package com.leetcode.threehundred;

import java.util.*;

/**
 * https://leetcode.com/problems/expression-add-operators/
 * <p>
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * <p>
 * Example 1:
 * <p>
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 * Example 2:
 * <p>
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * Example 3:
 * <p>
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * Example 4:
 * <p>
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * Example 5:
 * <p>
 * Input: num = "3456237490", target = 9191
 * Output: []
 *
 * @auther carl
 */
public class ExpressionAddOperators {
    List<String> ans;
    char[] operators = {'+', '-', '*'};
    long target;

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) return Collections.emptyList();
        ans = new ArrayList<>();
        this.target = target;
        char[] temp = new char[1 << 10];
        solve(num.toCharArray(), 0, temp, 0, 0, '+', 0, 0);
        return ans;
    }

    private void solve(char[] digits, int index, char[] expression, int len, long preOperand, char preOperator, long curOperand, long result) {
        if (index == digits.length) {
            if (result == target) {
                ans.add(String.valueOf(expression, 0, len));
            }
            return;
        }
        curOperand = curOperand * 10 + (digits[index] - '0');
        if (preOperand != 0) {
            expression[len] = digits[index];
            solve(digits, index + 1, expression, len + 1, preOperand, '+', curOperand, preOperand + curOperand);
        }
        if (len > 0) {
            expression[len] = '+';
            expression[len + 1] = digits[index];
            solve(digits, index + 1, expression, len + 2, curOperand, '+', 0, result + curOperand);

            expression[len] = '-';
            expression[len + 1] = digits[index];
            solve(digits, index + 1, expression, len + 2, -curOperand, '-', 0, result - curOperand);

            expression[len] = '*';
            expression[len + 1] = digits[index];
            if (preOperator == '*') {
                solve(digits, index + 1, expression, len + 2, curOperand, '*', 0, result + preOperand - curOperand);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators instance = new ExpressionAddOperators();
        instance.addOperators("105", 5);
    }
}
