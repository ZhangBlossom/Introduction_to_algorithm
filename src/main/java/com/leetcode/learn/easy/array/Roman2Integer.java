package main.java.com.leetcode.learn.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/12 8:31
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * P13
 * 得到罗马数字
 */
public class Roman2Integer {

    public static int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
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
        System.out.println(romanToInt("IVX"));
    }
}
