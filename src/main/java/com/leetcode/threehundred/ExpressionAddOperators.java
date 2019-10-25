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

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) return Collections.emptyList();
        ans = new ArrayList<>();
        char[] temp = new char[1 << 10];
        temp[0] = num.charAt(0);
        solve(num.toCharArray(), 1, temp, 1, target);
        return ans;
    }

    private void solve(char[] nums, int cur, char[] temp, int len, int target) {
        if (cur == nums.length) {
            //System.out.println(String.valueOf(temp, 0, len));
            long res = calc(temp, len);
            if (res == target) {
                ans.add(String.valueOf(temp, 0, len));
            }
            return;
        }
        int lastNum = 0;
        for (int i = len - 1, j = 1; i >= 0 && '0' <= temp[i] && temp[i] <= '9'; i--, j *= 10) {
            lastNum += j * (temp[i] - '0');
        }
        if (lastNum != 0 || temp[len - 1] < '0' || temp[len - 1] > '9') {
            temp[len] = nums[cur];
            solve(nums, cur + 1, temp, len + 1, target);
        }
        for (char opt : operators) {
            temp[len] = opt;
            temp[len + 1] = nums[cur];
            solve(nums, cur + 1, temp, len + 2, target);
        }
    }

    private long calc(char[] temp, int len) {
        Stack<Long> nums = new Stack<>();
        Stack<Character> signs = new Stack<>();
        int i = 0;
        while (i < len) {
            if (temp[i] == '+' || temp[i] == '-') {
                while (!signs.isEmpty()) {
                    calc(nums, signs);
                }
                signs.push(temp[i]);
                i++;
            } else if (temp[i] == '*') {
                while (!signs.isEmpty() && signs.peek() == '*') {
                    calc(nums, signs);
                }
                signs.push(temp[i]);
                i++;
            } else {
                int j = i + 1;
                while (j < len && '0' <= temp[j] && temp[j] <= '9') {
                    j++;
                }
                nums.push(Long.valueOf(String.valueOf(temp, i, j - i)));
                i = j;
            }
        }
        while (!signs.isEmpty()) {
            calc(nums, signs);
        }
        return nums.peek();
    }

    private void calc(Stack<Long> nums, Stack<Character> sings) {
        long sec = nums.pop();
        long fir = nums.pop();
        switch (sings.pop()) {
            case '+':
                nums.push(fir + sec);
                break;
            case '-':
                nums.push(fir - sec);
                break;
            default:
                nums.push(fir * sec);
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators instance = new ExpressionAddOperators();
        instance.addOperators("105", 5);
    }
}
