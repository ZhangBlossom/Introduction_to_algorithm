package main.java.com.leetcode.learn.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/8 9:02
 * Description:
 * Version: 1.0.0
 * 303
 */

public class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }


    public static void main(String[] args) {

    }
}
