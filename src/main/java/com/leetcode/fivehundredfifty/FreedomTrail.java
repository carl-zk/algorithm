package com.leetcode.fivehundredfifty;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * didn't make it
 *
 * @author carl
 */
public class FreedomTrail {
    Map<Character, TreeSet<Integer>> indexes = new HashMap<>();
    Map<Integer, Integer> visited = new HashMap<>();
    int ans = Integer.MAX_VALUE;

    public int findRotateSteps(String ring, String key) {
        if (key.length() == 0) return 0;
        for (int i = 0; i < ring.length(); i++) {
            indexes.computeIfAbsent(ring.charAt(i), k -> new TreeSet<>()).add(i);
        }
        solve(ring.toCharArray(), 0, key.toCharArray(), 0, 0);
        return ans;
    }

    private boolean solve(char[] ring, int i, char[] key, int j, int steps) {
        if (j == key.length) {
            ans = Math.min(ans, steps);
            return true;
        }
        int[] l = left(ring, i, key[j]), r = right(ring, i, key[j]);
        int nextSteps = steps + Math.min(l[1], r[1]);
        if (nextSteps >= ans || nextSteps >= visited.getOrDefault(j, Integer.MAX_VALUE)) return false;

        if (l[0] == r[0]) {
            if (l[1] <= r[1]) {
                if (solve(ring, l[0], key, j + 1, steps + l[1])) {
                    visited.put(j, steps + l[1]);
                    return true;
                }
            } else {
                if (solve(ring, r[0], key, j + 1, steps + r[1])) {
                    visited.put(j, r[1]);
                    return true;
                }
            }
        } else {
            solve(ring, l[0], key, j + 1, steps + l[1]);
            solve(ring, r[0], key, j + 1, steps + r[1]);
        }
        return false;
    }

    private int[] left(char[] ring, int start, char c) {
        int steps = 1;
        Integer i = indexes.get(c).floor(start);
        if (i == null) {
            steps += start;
            i = indexes.get(c).floor(ring.length);
            steps += ring.length - i;
        } else {
            steps += start - i;
        }
        return new int[]{i, steps};
    }

    private int[] right(char[] ring, int start, char c) {
        int steps = 1;
        Integer i = indexes.get(c).ceiling(start);
        if (i == null) {
            steps += ring.length - start;
            i = indexes.get(c).ceiling(0);
            steps += i;
        } else {
            steps += i - start;
        }
        return new int[]{i, steps};
    }

    public static void main(String[] args) {
        FreedomTrail ft = new FreedomTrail();
        System.out.println(ft.findRotateSteps("iozsbhuqqaxkqqnligjtexkdljseekxojmqhemlgbyjwuhljbgqbqsxtaeazbhtzrxdtkdxbmvvtdmljdmxphsgvqhyoyaxzowjx", "musqamioxuxkxjxkeqjxhjhgdwbkvzmbgzlsdotyqdzepxsmvoezjbqellbhaijnatxhrglahhqvmjtxqodjwyegdltbbqkxqyst"));
    }
}
