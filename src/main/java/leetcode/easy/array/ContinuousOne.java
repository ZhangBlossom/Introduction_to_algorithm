package leetcode.easy.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/14 9:15
 * Description:
 * Version: 1.0.0
 */
public class ContinuousOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

}
