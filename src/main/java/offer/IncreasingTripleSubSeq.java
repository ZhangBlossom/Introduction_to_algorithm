package offer;

/**
 * @author: 张锦标
 * @date: 2023/6/28 10:01
 * IncreasingTripleSubSeq类
 */
public class IncreasingTripleSubSeq {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if (nums[i]<=min1){
                min1=nums[i];
            }else if (nums[i]<=min2){
                min2=nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}
