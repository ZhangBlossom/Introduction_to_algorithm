package com.leetcode.learn.easy.array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author: 张锦标
 * @date: 2023/6/1 14:01
 * ThirdMin类
 */
public class ThirdMax {
    public int thirdMax(int[]nums){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (set.size()>3){
                set.remove(set.first());
            }
        }
        return set.size()==3? set.first():set.last();
    }

    public int thirdMaxWithSort(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);
        for (int i = 1, diff = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1] && ++diff == 3) { // 此时 nums[i] 就是第三大的数
                return nums[i];
            }
        }
        return nums[0];
    }

    public void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
