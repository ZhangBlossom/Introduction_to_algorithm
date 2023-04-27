package com.itheima.temp.binarysearch;

public class KthSmaller {
    public static void main(String[] args) {
        int[] array = {6, 7, 1, 3, 5};
        System.out.println(kthSmaller(array, 0, array.length - 1, 6));
    }

    public static int kthSmaller(int[] array, int l, int h, int k) {
        if (k > array.length) {
            return -1;
        }
        int i = l;
        int pv = array[h];
        for (int j = l; j < h; j++) {
            if (array[j] < pv) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, h);
        if (i + 1 == k) {
            return array[i];
        } else if (i + 1 < k) {
            return kthSmaller(array, i + 1, h, k);
        } else {
            return kthSmaller(array, l, i - 1, k);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
