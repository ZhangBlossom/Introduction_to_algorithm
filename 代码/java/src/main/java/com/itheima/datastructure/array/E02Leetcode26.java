package com.itheima.datastructure.array;

import java.util.Arrays;

/**
 * 删除有序数组的重复项（题目中已说明 nums.length >= 1）
 */
public class E02Leetcode26 {

    /*              p1
                                   p2
        0, 1, 2, 3, 4, 2, 2, 3, 3, 4
     */

    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        while (p2 < nums.length) {
            if (nums[p1] != nums[p2]) {
                nums[++p1] = nums[p2];
            }
            p2++;
        }
        return p1 + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = new E02Leetcode26().removeDuplicates(nums);
        System.out.println(len == 5);
        System.out.println(Arrays.equals(new int[]{0, 1, 2, 3, 4}, 0, len, nums, 0, len));
    }
}
