package com.leetcode.learn.string.easy;

/**
 * @author: 张锦标
 * @date: 2023/5/13 14:21
 * ExcelColumName类
 */
public class ExcelColumName {

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber>0){
            int a = (--columnNumber%26);
            sb.append((char)(a+'A'));
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
