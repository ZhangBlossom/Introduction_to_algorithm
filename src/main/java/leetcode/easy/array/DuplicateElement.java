package leetcode.easy.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/28 10:53
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 217
 */
public class DuplicateElement {
    public boolean containsDuplicate(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }

    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}
