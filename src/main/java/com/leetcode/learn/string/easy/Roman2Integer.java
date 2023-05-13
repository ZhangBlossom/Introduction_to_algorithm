package com.leetcode.learn.string.easy;

/**
 * @author: 张锦标
 * @date: 2023/5/11 18:28
 * Roman2Integer类
 */
public class Roman2Integer {
    public static int romanToInt(String s) {
        int sum=0;
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.toCharArray().length; i++) {
            int cur = getValue(s.charAt(i));
            if (pre<cur){
                sum-=pre;
            }else{
                sum+=pre;
            }
            pre = cur;
        }
        sum+=pre;
        return sum;
    }
    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {

    }
}
