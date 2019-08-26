package com.leetcode;

/**
 * @author carl
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        // 滑动窗口左
        int i = 0;
        // 滑动窗口右
        int j;
        char[] cs = s.toCharArray();
        char expect = '(';
        int ans = 0;

        for (j = 0; j < cs.length; j++) {
            if (cs[j] == expect) {
                if (cs[j] == ')') {
                    ans = Math.max(ans, j - i + 1);
                }
                expect = expect == '(' ? ')' : '(';
            } else if (cs[j] == '(') {
                i = j;
            } else {
                i = j + 1;
            }
        }
        return ans;
    }
}
