package main.java.com.leetcode.learn.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/11 12:53
 * Description:
 * Version: 1.0.0
 */
public class MissingNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
