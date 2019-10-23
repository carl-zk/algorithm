package com.leetcode.twohundredfifty;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 * <p>
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * <p>
 * Example 1:
 * <p>
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 * <p>
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * @auther carl
 */
public class DifferentWaystoAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> res1 = diffWaysToCompute(part1);
                List<Integer> res2 = diffWaysToCompute(part2);
                for (Integer a : res1) {
                    for (Integer b : res2) {
                        switch (input.charAt(i)) {
                            case '+':
                                ans.add(a + b);
                                break;
                            case '-':
                                ans.add(a - b);
                                break;
                            default:
                                ans.add(a * b);
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(input));
        }
        return ans;
    }
}
