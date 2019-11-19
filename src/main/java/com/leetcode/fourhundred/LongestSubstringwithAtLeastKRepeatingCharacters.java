package com.leetcode.fourhundred;

/**
 * @author carl
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    int ans = 0;

    public int longestSubstring(String s, int k) {
        solve(s.toCharArray(), 0, s.length() - 1, k);
        return ans;
    }

    private void solve(char[] chars, int start, int end, int k) {
        if (start > end) return;
        if (end - start < ans) return;
        int[] counter = new int[256];
        for (char c : chars) {
            counter[c]++;
        }
        int i, j;
        for (i = start, j = start; i <= end; i++) {
            if (counter[chars[i]] < k) {
                solve(chars, j, i - 1, k);
                j = i + 1;
            }
        }
        if (j == start) {
            ans = Math.max(ans, end - start + 1);
        } else {
            solve(chars, j, i - 1, k);
        }
    }
}
