package offer.slidewindow;

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
            //判断是否遇到0 是则count++
            if (nums[right]==0){
                count++;
            }
            //判断count是否大于1，因为我们最多只允许一个1
            while(count>1){
                //如果count>1
                //那么我们就需要右移来减小窗口空间
                //如果遇到的是0 那么count--
                //窗口大小-1
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
