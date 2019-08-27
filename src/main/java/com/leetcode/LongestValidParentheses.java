package com.leetcode;

/**
 * @author carl
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int ans = 0;
        int leftCount = 0;
        int len = 0;
        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if ('(' == cs[i]) {
                leftCount++;
            } else if (leftCount > 0) {
                len += 2;
                ans = Math.max(ans, len);
                leftCount--;
                if (leftCount == 0) {
                    len = 0;
                }
            } else {
                leftCount = 0;
                len = 0;
            }
        }
        return ans;
    }
}
