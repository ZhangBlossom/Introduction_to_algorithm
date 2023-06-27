package leetcode.doublelink.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/16 19:17
 * ThreeSum类
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            //保证不重复 否则会出现重复答案
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int target = -nums[first];
            int third = n - 1;
            for (; second < n; second++) {
                //也是判断不重复
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
