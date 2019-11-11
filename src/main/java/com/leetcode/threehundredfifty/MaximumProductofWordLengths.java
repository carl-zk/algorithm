package com.leetcode.threehundredfifty;

import java.util.BitSet;

/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 * <p>
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 * <p>
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 * <p>
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 *
 * @auther carl
 */
public class MaximumProductofWordLengths {

    public int maxProduct(String[] words) {
        int ans = 0;
        BitSet[] bitSet = new BitSet[words.length];
        for (int i = 0; i < words.length; i++) {
            bitSet[i] = new BitSet(256);
            for (char c : words[i].toCharArray()) {
                bitSet[i].set(c);
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!bitSet[i].intersects(bitSet[j])) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
