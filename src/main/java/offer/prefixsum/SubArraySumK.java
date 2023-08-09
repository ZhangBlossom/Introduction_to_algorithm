package offer.prefixsum;

import java.util.HashMap;

/**
 * @author: 张锦标
 * @date: 2023/7/24 9:21
 * SubArraySumK类
 * 560
 */
public class SubArraySumK {
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int start = 0; start < len; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0, pre = 0;
            HashMap < Integer, Integer > mp = new HashMap < > ();
            mp.put(0, 1); //前缀和为0 次数为1
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }

}
