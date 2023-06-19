package com.leetcode.learn.tanxing.middle;

/**
 * @author: 张锦标
 * @date: 2023/6/19 9:31
 * JumpGame类
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4, 1, 1,1}));
    }
}
