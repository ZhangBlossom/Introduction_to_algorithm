package com.leetcode.learn.middle.doublelink;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/5/30 16:13
 * Cloest3Sum类
 */
public class Cloest3Sum {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += nums[i];
        }
        int diff = Integer.MAX_VALUE;
        int preDiff = Integer.MAX_VALUE;
        int result = sum;
        for (int i = 3; i <= nums.length; i++) {
            //记录差值 并且保存差值最小的那个值对应的时候的sum
            diff = Math.min(Math.abs(sum - target), preDiff);
            if (diff < preDiff) {
                result = sum;
                preDiff = diff;
            }
            if (i < nums.length) {

                sum = sum + nums[i] - nums[i - 3];
            }
        }
        return result;
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }


    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }
}
