package offer.slidewindow;

/**
 * @author: 张锦标
 * @date: 2023/7/3 21:53
 * SubArrMaxAverage类
 */
public class SubArrMaxAverage {
    public double findMaxAverage(int[] nums,int k){
        int n = nums.length;
        int sum = 0;
        int max = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        for(int i=k;i<n;i++){
            sum = sum + nums[i-k] + nums[i];
            max = Math.max(sum,max);
        }
        return max*1.0/k;
    }
}
