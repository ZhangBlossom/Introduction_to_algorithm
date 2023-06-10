package com.leetcode.learn.easy;

/**
 * @author: 张锦标
 * @date: 2023/6/10 20:11
 * GeWeiXiangJia类
 */
public class GeWeiXiangJia {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

}
