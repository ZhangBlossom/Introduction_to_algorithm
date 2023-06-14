package com.leetcode.learn.math;

/**
 * @author: 张锦标
 * @date: 2023/6/14 16:27
 * ValidSquare类
 */
public class ValidSquare {
    //暴力
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        for (int i = 1; i <= num / 2; i++) {
            if (i * i > num) {
                return false;
            }
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    //二分查找
    public boolean isPerfectSquareBinarySearch(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
