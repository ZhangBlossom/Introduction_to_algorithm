package com.base.learn.string;

/**
 * @author: 张锦标
 * @date: 2023/5/25 9:57
 * ParseInt类
 */
public class ParseInt {
    public static boolean isValid(String str) {
        char[] chars = str.toCharArray();
        //1:判断字符串不以 ‘ - ’开头并且也不是数字开头
        if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')) {
            return false;
        }
        //2:字符串以'-'开头,但是长度为1,或长度不为1,但是chars[1]='0'
        if (chars[0] == '-' && (chars.length == 1 || chars[1] == '0')) {
            return false;
        }
        //3:字符串以0开头,但是长度不为1
        if (chars[0] == '0' && chars.length != 1) {
            return false;
        }
        //4:判断字符串中是否有非法字符
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return false;
            }
        }
        return true;
    }

    public static int parseInt(String str) {
        int cur = 0;
        int res = 0;
        int maxQ = Integer.MAX_VALUE / 10;
        int maxP = Integer.MAX_VALUE % 10;
        //如果此时res已经大于了int最大值/10，并且此时cur还没有加上去就已经大于了，
        // 那么说明肯定溢出，直接返回0
        //如果等于，但是cur大于最后一位，那么也是溢出，也返回
        boolean negative = str.charAt(0) == '-' ? true : false;
        for (int i = negative ? 1 : 0; i < str.length(); i++) {
            cur = str.charAt(i) - '0';
            if (res > maxQ || (res == maxQ && cur > maxP) ||
                    (res == maxQ && negative && cur > maxP + 1)){
                return 0;
            }
            res = res * 10 + cur;
        }
        return negative ? -1 * res : res;
    }

    public static void main(String[] args) {
        String s = "123asd";
        if (!isValid(s)){
            //do something
        }else{
            parseInt(s);
        }
    }
}
