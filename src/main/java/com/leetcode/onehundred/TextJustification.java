package com.leetcode.onehundred;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 * <p>
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 * <p>
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Example 2:
 * <p>
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 * <p>
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 *
 * @author carl
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<>();
        int wl = 0, wn = 0;
        int pre = 0, cur = -1;
        while (cur + 1 < words.length) {
            while (cur + 1 < words.length && wl + words[cur + 1].length() <= maxWidth) {
                ++cur;
                wl += words[cur].length();
                wn++;
            }
            while (wl + wn - 1 > maxWidth) {
                wl -= words[cur].length();
                wn--;
                cur--;
            }
            StringBuilder sb = new StringBuilder();
            if (wn == 1) {
                sb.append(words[cur]);
                for (int i = words[cur].length(); i < maxWidth; i++) {
                    sb.append(' ');
                }
            } else if (cur == words.length - 1) {
                for (int i = pre; i <= cur; i++) {
                    sb.append(words[i]);
                    if (i < cur) {
                        sb.append(' ');
                    }
                }
                for (int i = maxWidth - sb.length(); i > 0; i--) {
                    sb.append(' ');
                }
            } else {
                int blankLen = maxWidth - wl;
                int blankSeg = wn - 1;
                int[] blanks = new int[blankSeg];
                Arrays.fill(blanks, blankLen / blankSeg);
                for (int j = 0, k = blankLen % blankSeg; j < blanks.length && k > 0; j++, k--) {
                    blanks[j]++;
                }
                for (int i = pre, j = 0; i <= cur; i++, j++) {
                    sb.append(words[i]);
                    for (int k = 0; i < cur && k < blanks[j]; k++) {
                        sb.append(' ');
                    }
                }
            }
            ans.add(sb.toString());
            pre = cur + 1;
            wl = 0;
            wn = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        tj.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }
}
