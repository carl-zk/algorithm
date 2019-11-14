package com.leetcode.threehundredfifty;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * <p>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 * <p>
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 *
 * @author carl
 */
public class ReverseVowelsofaString {

    public String reverseVowels(String s) {
        boolean[] dict = new boolean[256];
        dict['a'] = dict['e'] = dict['i'] = dict['o'] = dict['u'] = true;
        dict['A'] = dict['E'] = dict['I'] = dict['O'] = dict['U'] = true;
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            while (i < j && !dict[cs[i]]) i++;
            while (i < j && !dict[cs[j]]) j--;
            if (i >= j || !dict[cs[i]] || !dict[cs[j]]) break;
            char c = cs[i];
            cs[i] = cs[j];
            cs[j] = c;
            i++;
            j--;
        }
        return new String(cs);
    }
}
