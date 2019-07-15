package com.sort;

/**
 * 堆排序
 * O(nlgn)
 * 符合原址性(in place)
 * <p>
 * heap root index start from 1
 * </p>
 *
 * @author carl
 */
public class HeapSort {
    private int[] a;
    private int size;

    public HeapSort(int[] a) {
        this.a = a;
        this.size = a.length - 1;
    }

    public void sort() {
        buildMaxHeap();
        for (int i = 1; i <= size; i++) {
            swap(1, size);
            size--;
            maxHeapify(1);
        }
    }

    private void buildMaxHeap() {
        for (int i = a.length >> 1; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    private void maxHeapify(int i) {
        int largest = i;
        int l = left(i), r = right(i);

        if (l <= size && a[largest] < a[l]) {
            largest = l;
        }

        if (r <= size && a[largest] < a[r]) {
            largest = r;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private int left(int i) {
        return i << 1;
    }

    private int right(int i) {
        return (i << 1) + 1;
    }

    private int parent(int i) {
        return i >> 1;
    }

    private void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
