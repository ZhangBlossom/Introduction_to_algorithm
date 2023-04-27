package com.itheima.algorithm.binarysearch;

public class E01Leetcode704 {

    // 平衡版
    public int search1(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) { // 左
                j = m;
            } else {            // 右, 或 m
                i = m;
            }
        }
        return (a[i] == target) ? i : -1;
    }

    // 改进版
    public int search2(int[] a, int target) {
        int i = 0, j = a.length;             // 1
        while (i < j) {                      // 3
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;                       // 2
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // 基础版
    public int search3(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
