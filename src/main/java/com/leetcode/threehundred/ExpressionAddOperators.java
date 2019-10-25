package com.leetcode.threehundred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    long target;

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) return Collections.emptyList();
        ans = new ArrayList<>();
        this.target = target;
        List<String> expression = new ArrayList<>();
        solve(num.toCharArray(), 0, expression, 0, 0, 0);
        return ans;
    }

    private void solve(char[] digits, int index, List<String> expression, long preOperand, long curOperand, long result) {
        if (index == digits.length) {
            if (result == target && curOperand == 0) {
                StringBuilder sb = new StringBuilder();
                expression.subList(1, expression.size()).forEach(x -> sb.append(x));
                ans.add(sb.toString());
            }
            return;
        }
        curOperand = curOperand * 10 + (digits[index] - '0');
        String curStr = String.valueOf(curOperand);
        // NO OP
        if (curOperand != 0) {
            solve(digits, index + 1, expression, preOperand, curOperand, result);
        }
        // ADD
        expression.add("+");
        expression.add(curStr);
        solve(digits, index + 1, expression, curOperand, 0, result + curOperand);
        expression.remove(expression.size() - 1);
        expression.remove(expression.size() - 1);

        if (expression.size() > 0) {
            expression.add("-");
            expression.add(curStr);
            solve(digits, index + 1, expression, -curOperand, 0, result - curOperand);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);

            expression.add("*");
            expression.add(curStr);
            solve(digits, index + 1, expression, preOperand * curOperand, 0, result - preOperand + (preOperand * curOperand));
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators instance = new ExpressionAddOperators();
        instance.addOperators("105", 5);
    }
}
