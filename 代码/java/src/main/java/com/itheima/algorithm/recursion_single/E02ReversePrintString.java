package com.itheima.algorithm.recursion_single;

/**
 * 递归反向打印字符串
 */
public class E02ReversePrintString {

    public static void f(int n, String str) {
        if (n == str.length()) {
            return;
        }
        f(n + 1, str);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        f(0, "abcd");
    }
}
