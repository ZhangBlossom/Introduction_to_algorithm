package com.leetcode.learn.easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: 张锦标
 * @date: 2023/6/7 9:34
 * DiffAvgNum类
 */
public class DiffAvgNum {
    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<Double> set = new HashSet<>();
        for (int i = 0,j=n-1; i < n/2 && j>=n/2; i++,j--) {
            set.add((nums[i]+nums[j])/2.0);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(distinctAverages(new int[]{1,100}));
    }
}
