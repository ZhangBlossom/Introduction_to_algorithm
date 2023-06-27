package leetcode.doublelink.middle;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/6/16 19:37
 * ThreeSumCloest类
 */
public class ThreeSumCloest {
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int result = 0;
        for (int first = 0; first < n; first++) {
            //重复数据不在使用
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < closest) {
                    closest = Math.abs(sum - target);
                    result = sum;
                }
                if (sum > target) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return result;
    }
}
