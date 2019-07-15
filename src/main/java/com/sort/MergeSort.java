package com.sort;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;

/**
 * 归并排序
 * O(nlgn)
 * 非原址排序
 *
 * @author carl
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] a) {
        requireNonNull(a);
        splitThenMerge(a, 0, a.length);
    }

    /**
     * split then merge
     *
     * @param a     array of data
     * @param first first index of a, inclusive
     * @param last  last index of a, exclusive
     */
    private void splitThenMerge(int[] a, int first, int last) {
        if (last - first > 1) {
            int mid = (first + last) >> 1;
            splitThenMerge(a, first, mid);
            splitThenMerge(a, mid, last);
            merge(a, first, mid, last);
        }
    }

    private void merge(int[] a, int first, int mid, int last) {
        int[] copyOfSortedL = Arrays.copyOfRange(a, first, mid);
        int[] copyOfSortedR = Arrays.copyOfRange(a, mid, last);
        int i, j, k;
        for (i = 0, j = 0, k = first; notOutBound(i, copyOfSortedL) && notOutBound(j, copyOfSortedR); ) {
            a[k++] = copyOfSortedL[i] <= copyOfSortedR[j] ?
                    copyOfSortedL[i++] : copyOfSortedR[j++];
        }

        if (notOutBound(i, copyOfSortedL)) {
            appendRemains(copyOfSortedL, i, a, k, copyOfSortedL.length - i);
        } else if (notOutBound(j, copyOfSortedR)) {
            appendRemains(copyOfSortedR, j, a, k, copyOfSortedR.length - j);
        }
    }

    private boolean notOutBound(int index, int[] array) {
        return index < array.length;
    }

    private void appendRemains(int[] src, int srcPos, int[] des, int desPos, int length) {
        System.arraycopy(src, srcPos, des, desPos, length);
    }
}
