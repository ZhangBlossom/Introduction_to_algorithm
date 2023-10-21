package type.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/10/21 16:37
 * LongestHarmoneySeq类
 */
public class _594LongestHarmoneySeq {
    public int findLHSX(int[] nums) {
        Arrays.sort(nums);
        int maxLen = 0;
        int begin = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            if (nums[end] - nums[begin] == 1) {
                maxLen = Math.max(maxLen, end-begin+1);
            }
        }
        return maxLen;

    }
    public int findLHS(int[]nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Integer key : map.keySet()) {
            if (map.containsKey(key+1)){
                max = Math.max(max,map.get(key)+map.get(key+1));
            }
        }
        return max;
    }
}
