package com.leetcode.fivehundredfifty;

/**
 * @author carl
 */
public class ComplexNumberMultiplication {

    /**
     * (a+bi)*(c+di) = (ac-bd) + (ad+bc)i
     */
    public String complexNumberMultiply(String a, String b) {
        int[] ab = extract(a), cd = extract(b);
        int m = ab[0] * cd[0] - ab[1] * cd[1], n = ab[0] * cd[1] + ab[1] * cd[0];
        return Integer.toString(m) + "+" + n + "i";
    }

    private int[] extract(String s) {
        String[] strs = s.split("\\+");
        return new int[]{Integer.parseInt(strs[0]), Integer.parseInt(strs[1].substring(0, strs[1].length() - 1))};
    }
}
