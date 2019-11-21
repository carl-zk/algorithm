package com.leetcode.fourhundred;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * <p>
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "aaabb", k = 3
 * <p>
 * Output:
 * 3
 * <p>
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * <p>
 * Input:
 * s = "ababbc", k = 2
 * <p>
 * Output:
 * 5
 * <p>
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
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
        for (int i = start; i <= end; i++) {
            counter[chars[i]]++;
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

    public static void main(String[] args) {
        LongestSubstringwithAtLeastKRepeatingCharacters ls = new LongestSubstringwithAtLeastKRepeatingCharacters();
        System.out.println(ls.longestSubstring("ababacb", 3));
    }
}
