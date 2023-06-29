package offer;

/**
 * @author: 张锦标
 * @date: 2023/6/29 21:04
 * RemoveOneLongestSubArr类
 */
public class RemoveOneLongestSubArr {
    public static int longestSubarray(int[]nums){
        if (nums.length==1){
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;
        int count =0 ;
        while (right<n){
            if (nums[right]==0){
                count++;
            }
            while(count>1){
                if (nums[left]==0){
                    count--;
                }
                left++;
            }
            res = Math.max(res,right-left);
            right++;
        }
        return res;
    }
}
