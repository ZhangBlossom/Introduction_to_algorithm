package com.itheima.datastructure.heap;

import java.util.Arrays;

public class E01HeapSort {
    public static void sort(int[] array) {
        // 1. 建堆
        int size = array.length;
        heapify(size, array);

        while (size > 1) {
            // 2. 将堆顶元素交换至堆底
            swap(0, size - 1, array);
            // 堆大小减一
            size--;
            // 重新调整堆
            down(0, size, array);
        }
    }

    // 建堆
    private static void heapify(int size, int[] array) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i, size, array);
        }
    }

    // 下潜
    private static void down(int parent, int size, int[] array) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) { // 找到了更大的孩子
            swap(max, parent, array);
            down(max, size, array);
        }
    }

    // 交换
    private static void swap(int i, int j, int[] array) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 7, 6, 4, 5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
