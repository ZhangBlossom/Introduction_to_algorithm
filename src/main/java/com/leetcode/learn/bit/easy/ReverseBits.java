package com.leetcode.learn.bit.easy;

/**
 * @author: 张锦标
 * @date: 2023/6/9 9:33
 * ReverseBits类
 */
public class ReverseBits {
    public static int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }





    public static void main(String[] args) {
        System.out.println(reverseBits(0b11111111111111111111111111111101));
    }
}
