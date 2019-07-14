package com.partition;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 最大子数组问题，p38
 *
 * @author carl
 */
@AllArgsConstructor
class MaxSubarray {
    private int[] a;

    Sub getResult() {
        if (a == null || a.length == 0) {
            return null;
        }
        return getMaxSubarray(0, a.length - 1);
    }

    /**
     * get max sub of a
     *
     * @param left  0
     * @param right length - 1
     * @return {@link Sub}
     */
    private Sub getMaxSubarray(int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            Sub maxLeft = getMaxSubarray(left, mid);
            Sub maxRight = getMaxSubarray(mid + 1, right);
            Sub maxCross = getMaxCrossSubarray(left, right);
            return max(max(maxLeft, maxRight), maxCross);
        }
        return new Sub(left, right, a[left]);
    }

    /**
     * get max sum of subarray which crossed middle index
     *
     * @param left  include
     * @param right include
     * @return {@link Sub}
     */
    private Sub getMaxCrossSubarray(int left, int right) {
        int mid = (left + right) >> 1;
        int maxL = a[mid], maxR = a[mid + 1], l = mid, r = mid + 1;
        for (int i = mid, sum = 0; i >= left; i--) {
            sum += a[i];
            if (sum > maxL) {
                maxL = sum;
                l = i;
            }
        }
        for (int j = mid + 1, sum = 0; j <= right; j++) {
            sum += a[j];
            if (sum > maxR) {
                maxR = sum;
                r = j;
            }
        }
        return new Sub(l, r, maxL + maxR);
    }

    private Sub max(Sub a, Sub b) {
        return a.sum > b.sum ? a : b;
    }

    @Data
    @AllArgsConstructor
    static class Sub {
        private int left;
        private int right;
        private int sum;
    }
}
