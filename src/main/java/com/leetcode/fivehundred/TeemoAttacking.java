package com.leetcode.fivehundred;

/**
 * https://leetcode.com/problems/teemo-attacking/
 *
 * @author carl
 */
public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int total = 0;
        int l = timeSeries[0], r = l + duration;
        for (int i : timeSeries) {
            if (r >= i) r = i + duration;
            else {
                total += r - l;
                l = i;
                r = i + duration;
            }
        }
        total += r - l;
        return total;
    }
}
