package com.leetcode.threehundred;

/**
 * https://leetcode.com/problems/first-bad-version/
 * <p>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 *
 * @auther carl
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int s = 1, e = n;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (isBadVersion(m)) {
                e = m;
            } else s = m + 1;
        }
        return s;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}
