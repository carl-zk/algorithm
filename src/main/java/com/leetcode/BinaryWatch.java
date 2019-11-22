package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch/
 * <p>
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * <p>
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <p>
 * <p>
 * For example, the above binary watch reads "3:25".
 * <p>
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 * <p>
 * Example:
 * <p>
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 *
 * @author carl
 */
public class BinaryWatch {
    int[] HOURS = {0, 1, 2, 4, 8};
    int[] MINUTES = {0, 1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int num) {
        if (num == 0) return Arrays.asList("0:00");
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 5 && i <= num; i++) {
            if (num - i < 7) {
                List<Integer> hours = new ArrayList<>();
                List<Integer> minutes = new ArrayList<>();
                hours(1, i, 0, hours);
                minutes(1, num - i, 0, minutes);
                for (int h : hours) {
                    for (int m : minutes) {
                        if (h < 12 && m < 60) {
                            ans.add("" + h + ":" + (m < 10 ? "0" + m : "" + m));
                        }
                    }
                }
            }
        }
        return ans;
    }

    private void hours(int index, int n, int sum, List<Integer> res) {
        if (n == 0) {
            res.add(sum);
            return;
        }
        if (index > 4) return;
        hours(index + 1, n - 1, sum + HOURS[index], res);
        hours(index + 1, n, sum, res);
    }

    private void minutes(int index, int n, int sum, List<Integer> res) {
        if (n == 0) {
            res.add(sum);
            return;
        }
        if (index > 6) return;
        minutes(index + 1, n - 1, sum + MINUTES[index], res);
        minutes(index + 1, n, sum, res);
    }
}
