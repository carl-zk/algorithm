package com.leetcode.contest.biweekly;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 5089. Meeting Scheduler
 * <p>
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.
 * <p>
 * If there is no common time slot that satisfies the requirements, return an empty array.
 * <p>
 * The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
 * <p>
 * It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * Output: [60,68]
 * Example 2:
 * <p>
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= slots1.length, slots2.length <= 10^4
 * slots1[i].length, slots2[i].length == 2
 * slots1[i][0] < slots1[i][1]
 * slots2[i][0] < slots2[i][1]
 * 0 <= slots1[i][j], slots2[i][j] <= 10^9
 * 1 <= duration <= 10^6
 *
 * @author carl
 */
public class MeetingScheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));
        int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
            if (slots1[i][1] - slots1[i][0] < duration) {
                i++;
            } else if (slots2[j][1] - slots2[j][0] < duration) {
                j++;
            } else if (slots1[i][0] <= slots2[j][0] && (slots1[i][1] - slots2[j][0] < duration)) {
                i++;
            } else if (slots2[j][0] < slots1[i][0] && (slots2[j][1] - slots1[i][0] < duration)) {
                j++;
            } else {
                int start = Math.max(slots1[i][0], slots2[j][0]);
                return Arrays.asList(start, start + duration);
            }
        }
        return Collections.emptyList();
    }
}
