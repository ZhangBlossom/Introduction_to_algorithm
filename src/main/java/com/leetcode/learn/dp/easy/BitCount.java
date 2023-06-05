package com.leetcode.learn.dp.easy;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/6/3 19:10
 * BitCount类
 */
public class BitCount {
    //暴力法 直接取余
    public static int[] countBits4(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j > 0) {
                if (j % 2 > 0) {
                    arr[i]++;
                }
                j /= 2;
            }
        }
        return arr;
    }
    //使用Brian Kernighan 算法
    public static int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = countOnes(i);
        }
        return arr;
    }

    private static int countOnes(int x) {
        int count = 0;
        while (x > 0) {
            x &= (x - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }
}
