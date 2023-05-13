package com.leetcode.learn.string.easy;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/8 10:31
 * Description:
 * Version: 1.0.0
 */
public class BinarySum {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        int pos = 0;
        for (int i = 0; i < len; i++) { // a:11 b:1
            pos += i < a.length() ? (a.charAt(a.length() - i - 1) - '0') : 0;
            pos += i < b.length() ? (b.charAt(b.length() - i - 1) - '0') : 0;
            sb.append((char) (pos % 2 + '0'));
            pos /=2;
        }
        if (pos > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
