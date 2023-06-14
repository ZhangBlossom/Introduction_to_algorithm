package com.leetcode.learn.math;

/**
 * @author: 张锦标
 * @date: 2023/6/14 16:56
 * IsUgly类
 */
public class IsUgly {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] nums = {2,3,5};
        for(int num: nums){
            while(n%num==0){
                n/=num;
            }
        }
        return n==1;
    }
}
