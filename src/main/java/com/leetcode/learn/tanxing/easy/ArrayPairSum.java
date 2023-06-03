package com.leetcode.learn.tanxing.easy;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/6/3 8:18
 * ArrayPairSum类
 */
public class ArrayPairSum {
    public static int arrayPairSum(int[] nums){
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum+=nums[i];
        }
        return sum;
    }
}
