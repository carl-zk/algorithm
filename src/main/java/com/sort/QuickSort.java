package com.sort;

import java.util.Objects;
import java.util.Random;

/**
 * 快速排序
 * O(nlgn), worst would be O(n^2); optimized by random.
 * in place
 *
 * @author carl
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] a) {
        Objects.requireNonNull(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * quick sort
     *
     * @param a data
     * @param p left index, include
     * @param r right index, include
     */
    private void sort(int[] a, int p, int r) {
        if (p < r) {
            int q = randomPartition(a, p, r);
            sort(a, p, q - 1);
            sort(a, q + 1, r);
        }
    }

    private int randomPartition(int[] a, int p, int r) {
        int i = internalNextInt(random, p, r + 1);
        swap(a, i, r);
        return partition(a, p, r);
    }

    private int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= x) {
                i = i + 1;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    Random random = new Random();

    /**
     * next in range [origin, bound)
     *
     * @param random random instance
     * @param origin start, include
     * @param bound  end, exclude
     * @return int
     */
    static final int internalNextInt(Random random, int origin, int bound) {
        if (origin < bound) {
            int n = bound - origin;
            if (n > 0) {
                return random.nextInt(n) + origin;
            } else {  // range not representable as int
                int r;
                do {
                    r = random.nextInt();
                } while (r < origin || r >= bound);
                return r;
            }
        } else {
            return random.nextInt();
        }
    }
}
