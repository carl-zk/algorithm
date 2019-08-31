package com.leetcode;

/**
 * @author carl
 */
public class CountAndSay {
    static String[] seq = new String[31];

    static {
        seq[0] = "";
        seq[1] = "1";
        seq[2] = "11";
        seq[3] = "21";
        for (int i = 4; i < seq.length; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            char pre = seq[i - 1].charAt(0);
            while (j < seq[i - 1].length()) {
                int count = 0;
                while (j < seq[i - 1].length() && seq[i - 1].charAt(j) == pre) {
                    count++;
                    j++;
                }
                sb.append(count);
                sb.append(pre);
                if (j < seq[i - 1].length()) {
                    pre = seq[i - 1].charAt(j);
                }
            }
            seq[i] = sb.toString();
        }
    }

    public String countAndSay(int n) {
        return seq[n];
    }
}
