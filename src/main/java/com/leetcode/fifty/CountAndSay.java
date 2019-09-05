package com.leetcode.fifty;

/**
 * @author carl
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String pre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pre.length(); ) {
            int l = i;
            int r = i + 1;
            while (r < pre.length() && pre.charAt(r) == pre.charAt(l)) {
                r++;
            }
            sb.append(r - l);
            sb.append(pre.charAt(l));
            i = r;
        }
        return sb.toString();
    }
}
