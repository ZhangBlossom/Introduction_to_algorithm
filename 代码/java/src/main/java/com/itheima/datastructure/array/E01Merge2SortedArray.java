package com.itheima.datastructure.array;

import java.util.Arrays;

/**
 * 合并两个有序数组 ( Leetcode 88 题改)
 */
public class E01Merge2SortedArray {

    public static void main(String[] args) {
        int[] a1 = {1, 5, 6, 2, 4, 10, 11};
        int[] a2 = new int[a1.length];
//        merge(a1, 0, 2, 3, 6, a2, 0);
        merge(a1, 0, 2, 3, 6, a2);
        System.out.println(Arrays.toString(a2));
        System.arraycopy(a2, 0, a1, 0, a2.length);
        System.out.println(Arrays.toString(a1));
    }

    /*
        i
        1   5   6

        j
        2   4   10  11

        k

     */
    // 方法2
    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2) {
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                i++;
            } else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }
    }

    /*
        a1 原始数组  a2 结果数组 (k)
        i, iEnd 第一个有序区间的起点终点, j, jEnd 第二个有序区间的起点终点

        merge([1,5,6] [2,4,10,11], a2=[]) {
            merge([5,6] [2,4,10,11], a2=[1]) {
                merge([5,6] [4,10,11], a2=[1,2]) {
                    merge([5,6] [10,11], a2=[1,2,4]) {
                        merge([6] [10,11], a2=[1,2,4,5]) {
                            merge([] [10,11], a2=[1,2,4,5,6]) {
                                 merge([], [], a2=[1,2,4,5,6,10,11])
                            }
                        }
                    }
                }
            }
        }

     */
    // 方法1
    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd,
                             int[] a2, int k) {
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
            return;
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
            return;
        }
        if (a1[i] < a1[j]) {
            a2[k] = a1[i];
            merge(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        } else {
            a2[k] = a1[j];
            merge(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }
    }
}
