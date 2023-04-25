package com.leetcode.learn.easy.search;

/**
 * @author: 张锦标
 * @date: 2023/4/25 21:25
 * BinarySearch类
 * 704题目
 */
public class BinarySearch {
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
}
