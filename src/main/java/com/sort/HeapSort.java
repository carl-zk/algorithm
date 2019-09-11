package com.sort;

import java.util.Objects;

/**
 * 堆排序
 * O(nlgn)
 * 符合原址性(in place)
 * <p>
 * heap root index start from 0
 * </p>
 *
 * @author carl
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] a) {
        Objects.requireNonNull(a);
        buildMaxHeap(a);
        for (int i = 0, size = a.length; i < size; ) {
            swap(a, 0, size - 1);
            size--;
            maxHeapify(a, size, 0);
        }
    }

    private void buildMaxHeap(int[] a) {
        int lastParent = (a.length - 2) >> 1;
        for (int i = lastParent; i >= 0; i--) {
            maxHeapify(a, a.length, i);
        }
    }

    private void maxHeapify(int[] a, int size, int i) {
        int largest = i;
        int l = left(i), r = right(i);

        if (l < size && a[largest] < a[l]) {
            largest = l;
        }

        if (r < size && a[largest] < a[r]) {
            largest = r;
        }

        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, size, largest);
        }
    }

    private int left(int i) {
        // 2*i+1
        return (i << 1) + 1;
    }

    private int right(int i) {
        // 2*i+2
        return (i + 1) << 1;
    }

    private int parent(int i) {
        // (i-1)/2
        return (i - 1) >> 1;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] a = new int[]{3, 2, 4, 6, 5, 7};
        sort.sort(a);
        System.out.println();
    }
}
