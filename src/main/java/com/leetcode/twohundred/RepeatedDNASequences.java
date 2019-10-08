package com.leetcode.twohundred;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        ans = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0, end = s.length() - 10; i <= end; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) == 2) {
                ans.add(str);
            }
        }
        return ans;
    }
}
