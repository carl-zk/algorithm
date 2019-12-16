package com.leetcode.fivehundred;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/keyboard-row/
 *
 * @author carl
 */
public class KeyboardRow {

    public String[] findWords(String[] words) {
        char[] par = new char[128];
        char[] r1 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
                'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] r2 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L',
                'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] r3 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M',
                'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        mark(par, r1, 'q');
        mark(par, r2, 'a');
        mark(par, r3, 'z');
        int k = 0;
        for (String w : words) {
            boolean f = true;
            char[] cs = w.toCharArray();
            for (int i = 1; i < cs.length; i++) {
                if (par[cs[i - 1]] != par[cs[i]]) {
                    f = false;
                    break;
                }
            }
            if (f) words[k++] = w;
        }
        return Arrays.copyOfRange(words, 0, k);
    }

    private void mark(char[] par, char[] r, char p) {
        for (char c : r) par[c] = p;
    }
}
