package com.leetcode.fourhundred;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/water-and-jug-problem/
 * <p>
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * <p>
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * <p>
 * Operations allowed:
 * <p>
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 * <p>
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * Example 2:
 * <p>
 * Input: x = 2, y = 6, z = 5
 * Output: False
 *
 * @author carl
 */
public class WaterandJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {
        return solve(x, 0, y, 0, z, new HashSet<>());
    }

    private boolean solve(int x, int leftx, int y, int lefty, int z, Set<String> set) {
        String key = new StringBuilder().append(x).append(leftx).append(y).append(lefty).toString();
        if (set.contains(key)) return false;
        set.add(key);
        if (leftx + lefty == z) return true;
        if (solve(x, x, y, lefty, z, set) || solve(x, leftx, y, y, z, set)) return true;
        if (solve(x, 0, y, lefty, z, set) || solve(x, leftx, y, 0, z, set)) return true;
        if (solve(x, 0, y, Math.min(y, leftx + lefty), z, set) ||
                solve(x, Math.min(x, leftx + lefty), y, Math.max(0, lefty + leftx - x), z, set)) return true;
        return false;
    }
}
