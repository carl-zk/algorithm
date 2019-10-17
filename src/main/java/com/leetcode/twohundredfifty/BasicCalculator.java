package com.leetcode.twohundredfifty;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther carl
 */
public class BasicCalculator {

    public int calculate(String s) {
        if (s.length() == 0) return 0;
        int i = 0, j;
        List<String> list = new ArrayList<>();
        while (i < s.length()) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                list.add(String.valueOf(s.charAt(i)));
                i++;
            } else {
                j = i + 1;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                j++;
            }
            list.add(new String(s.getBytes(), i, j - i));
            i = j;
        }
    }
        return solve(list);
}

    private int solve(List<String> list) {
        if (list.isEmpty()) return 0;
        if (list.size() == 1) return Integer.valueOf(list.get(0));
        String first = list.get(0);
        if (first.charAt(0) == '(') {
            int match = 1;
            List<String> partial = new ArrayList<>();
            int i = 1;
            for (; i < list.size() && match > 0; i++) {
                if (list.get(i).charAt(0) == '(') match++;
                if (list.get(i).charAt(0) == ')') match--;
                partial.add(list.get(i));
            }
            while (i > 0) {
                list.remove(0);
                i--;
            }
            if (list.isEmpty()) {
                return solve(partial);
            }
            char op = list.get(0).charAt(0);
            list.remove(0);
            return op == '+' ? solve(partial) + solve(list) : solve(partial) - solve(list);
        }
        int a = Integer.valueOf(list.get(0));
        list.remove(0);
        char op = list.get(0).charAt(0);
        list.remove(0);
        return op == '+' ? a + solve(list) : a - solve(list);
    }
}
