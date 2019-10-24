package com.leetcode.threehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther carl
 */
public class ExpressionAddOperators {
    List<String> ans;
    Map<String, Integer> str2int;
    Map<String, List<String>> str2arr;
    char[] operators = {'+', '-', '*'};

    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        str2int = new HashMap<>();
        str2arr = new HashMap<>();
        solve(num);

        return ans;
    }

    private List<String> solve(String str) {
        if (str2arr.containsKey(str)) {
            return str2arr.get(str);
        }
        List<String> result = new ArrayList<>();
        for (int i = 1; i < str.length() - 1; i++) {
            String str1 = str.substring(0, i);
            String str2 = str.substring(i);
            List<String> res1 = solve(str1);
            List<String> res2 = solve(str2);
            for (String a : res1) {
                for (String b : res2) {
                    for (char opt : operators) {
                        String c;
                        int r;
                        switch (opt) {
                            case '+':
                                c = a + "+" + b;
                                r = str2int.get(a) + str2int.get(b);
                                break;
                            case '-':
                                c = a + "-" + b;
                                r = str2int.get(a) - str2int.get(b);
                                break;
                            default:
                                c = a + "*" + b;
                                r = str2int.get(a) * str2int.get(b);
                        }
                        str2int.put(c, r);
                        result.add(c);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(str);
            str2int.put(str, Integer.parseInt(str));
        }
        str2arr.put(str, result);
        return result;
    }
}
