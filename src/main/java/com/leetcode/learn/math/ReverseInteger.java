package com.leetcode.learn.math;

/**
 * @author: 张锦标
 * @date: 2023/6/16 21:14
 * ReverseInteger类
 */
public class ReverseInteger {
    public int reverse(int x){
        int res = 0;
        while(x>0){
            if(res<Integer.MIN_VALUE/10 || res>Integer.MAX_VALUE/10){
                return 0;
            }
            int digit = x%10;
            x/=10;
            res+=res*10+digit;
        }
        return res;
    }
}
