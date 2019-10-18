package com.leetcode.twohundredfifty;

import java.util.Stack;

/**
 * @auther carl
 */
public class BasicCalculator {

    public int calculate(String s) {
        if (s.length() == 0) return 0;
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;
        char[] chars = s.toCharArray();

        while (i < chars.length) {
            if (chars[i] == ' ') {
                i++;
            } else if (chars[i] == '(') {
                operators.push('(');
                i++;
            } else if (chars[i] == ')' || chars[i] == '+' || chars[i] == '-') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    calc(numbers, operators);
                }
                if (chars[i] == ')') {
                    operators.pop();
                } else {
                    operators.push(chars[i]);
                }
                i++;
            } else {
                int j = i;
                while (j < chars.length && chars[j] >= '0' && chars[j] <= '9') {
                    j++;
                }
                numbers.push(Integer.valueOf(String.valueOf(chars, i, j - i)));
                i = j;
            }
        }
        while (!operators.isEmpty()) {
            calc(numbers, operators);
        }
        return numbers.peek();
    }

    private void calc(Stack<Integer> numbers, Stack<Character> operators) {
        char opt = operators.pop();
        int sec = numbers.pop();
        int fir = numbers.pop();
        if (opt == '+') {
            numbers.push(fir + sec);
        } else {
            numbers.push(fir - sec);
        }
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        //System.out.println(bc.calculate("1 + (2- 3)"));
        System.out.println(bc.calculate(" 2-1 + 2 "));
    }
}
