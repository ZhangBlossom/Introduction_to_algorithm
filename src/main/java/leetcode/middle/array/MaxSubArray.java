package leetcode.middle.array;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/20 8:24
 * Description:
 * Version: 1.0.0
 * 53
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        //pre表示之前和
        //maxAns表示结果
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            //如果之前和加上当前元素 还没当前元素大
            //那么就丢弃之前和 直接使用当前元素即可
            pre = Math.max(pre + x, x);
            //然后判断是之前和加上这个元素更大 还是当前这个元素更大
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;

    }
}
