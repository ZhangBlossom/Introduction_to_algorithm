package com.datastructure.learn.binary_search;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/4/24 14:05
 * BinarySearch类
 */
public class BinarySearch {
    //基础版本
    public static int binarysearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;
        //这里是小于等于 如果没有就会少比较一次
        while (i <= j) {
            //使用移位运算可以保证不出现负数
            int m = (i + j) >>> 1;
            if (target < a[m]) {//目标在左边
                j = m - 1;
            } else if (a[m] < target) { //目标在右边
                i = m + 1;
            } else {//找到了
                return m;
            }
        }
        return -1;
    }

    //改动版本
    public static int binarysearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;
        //这里是小于  如果加上等于就会出现死循环
        while (i < j) {
            //使用移位运算可以保证不出现负数
            int m = (i + j) >>> 1;
            if (target < a[m]) {//目标在左边
                j = m; //这里就没有在-1了
            } else if (a[m] < target) { //目标在右边
                i = m + 1;
            } else {//找到了
                return m;
            }
        }
        return -1;
    }

    /**
     * 优点在于循环内的平均比较次数减少
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchBalanced(int[] arr, int target) {
        int i = 0, j = arr.length;
        while (1 < j - i) { //while语句只是用来缩小范围
            int m = (j + i) >>> 1;
            if (target < arr[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        if (arr[i] == target) {
            return i;
        } else {
            return -1;
        }
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10};
        System.out.println(binarysearchBasic(arr, 9));
        //这个如果没找到位置 那么就会返回插入点（负数）-1 也就是 绝对值-1就是这个值应该插入在的位置
        Arrays.binarySearch(arr,3);
    }
}
