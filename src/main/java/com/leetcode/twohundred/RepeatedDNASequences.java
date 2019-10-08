package com.leetcode.twohundred;

import java.util.BitSet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * <p>
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * Example:
 * <p>
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <p>
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * @author carl
 */
public class RepeatedDNASequences {
    List<String> ans;

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return Collections.emptyList();
        ans = new LinkedList<>();

        int[] map = new int[85];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;
        BitSet seen = new BitSet(1 << 20);
        BitSet used = new BitSet(1 << 20);

        char[] cs = s.toCharArray();

        int index = 0;
        for (int i = 0; i < 10; i++) {
            index |= map[cs[i]] << (i * 2);
        }
        seen.set(index);

        for (int i = 1; i <= cs.length - 10; i++) {
            index >>= 2;
            index |= map[cs[i + 9]] << 18;
            if (!seen.get(index)) {
                seen.set(index);
            } else if (!used.get(index)) {
                ans.add(s.substring(i, i + 10));
                used.set(index);
            }
        }
        return ans;
    }
}
