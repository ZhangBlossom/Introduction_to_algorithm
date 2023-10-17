package leetcode.doublelink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/16 19:49
 * FourSum类
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < n - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //最小的四个元素都大于target了，那么后面肯定没有符合的元素了
            //直接break而不是continue
            if (nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }
            //最小加三个最大都不够大，那么这次的first不够大了，继续后移吧
            if (nums[first] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                continue;
            }
            for (int second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                if (nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                    break;
                }
                if (nums[first] + nums[second] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }
                int third = second + 1;
                int fourth = n - 1;
                while (third < fourth) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        while (third < fourth && nums[third] == nums[third + 1]) {
                            third++;
                        }
                        third++;
                        while (third < fourth && nums[fourth] == nums[fourth - 1]) {
                            fourth--;
                        }
                        fourth--;
                    } else if (sum < target) {
                        third++;
                    } else {
                        fourth--;
                    }
                }
            }
        }
        return result;
    }
}
