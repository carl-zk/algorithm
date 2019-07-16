package com.sort;

/**
 * 计数排序, p108
 * O(n+k), n为元素个数，每个元素不大于k
 *
 * @author carl
 */
public class CountingSort {

    /**
     * counting sort
     *
     * @param a original list
     * @param b result list
     * @param k a[i] <= k, i = 1 to n
     */
    public void sort(int[] a, int[] b, int k) {
        int[] c = new int[k + 1];
        for (int i = 0; i < a.length; i++) {
            c[a[i]] += 1;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        for (int i = 0; i < a.length; i++) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]] -= 1;
        }
    }
}
