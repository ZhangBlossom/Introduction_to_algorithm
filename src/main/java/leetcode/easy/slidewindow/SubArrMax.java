package leetcode.easy.slidewindow;

import java.util.ArrayList;

/**
 * @author: 张锦标
 * @date: 2023/5/29 11:29
 * SubArrMax类 643
 */
public class SubArrMax {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        for(int i =0 ;i<k;i++){
            sum+=nums[i];
        }
        int max = sum;
        for(int i = k;i<nums.length;i++){
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(sum,max);
        }
        return max*1.0/k;
    }
    public static void main(String[] args) {

    }
}
