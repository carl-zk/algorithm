package com.leetcode.fourhundredfifty;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 * <p>
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * <p>
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 * <p>
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 * <p>
 * Note:
 * <p>
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * <p>
 * return: 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * <p>
 * return: 2
 * <p>
 * <p>
 * Example 3:
 * <p>
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * <p>
 * return: 3
 *
 * @author carl
 */
public class MinimumGeneticMutation {
    private static final char[] GENES = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }

        if (!bankSet.contains(end) || start.length() != end.length()) return -1;
        if (start.equals(end)) return 0;

        int level = 0;
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        que.add(start);
        que.add(null);
        visited.add(start);
        bankSet.remove(start);

        for (; !que.isEmpty(); ) {
            String p = que.poll();
            if (p == null) {
                level++;
                if (!que.isEmpty()) {
                    que.add(null);
                }
                continue;
            }
            char[] chars = p.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                for (char c : GENES) {
                    chars[i] = c;
                    String next = new String(chars);
                    if (end.equals(next)) return level + 1;
                    if (bankSet.contains(next) && !visited.contains(next)) {
                        que.add(next);
                        bankSet.remove(next);
                        visited.add(next);
                    }
                }
                chars[i] = old;
            }
        }
        return -1;
    }
}
