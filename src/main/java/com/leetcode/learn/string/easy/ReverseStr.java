package com.leetcode.learn.string.easy;

/**
 * @author: 张锦标
 * @date: 2023/2/23 15:23
 * Description:
 */
public class ReverseStr {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[n-i-1];
            s[n-i-1]=s[i];
            s[i]=temp;
        }
    }
}
