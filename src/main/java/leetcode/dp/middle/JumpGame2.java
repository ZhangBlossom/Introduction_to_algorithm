package leetcode.dp.middle;

/**
 * @author: 张锦标
 * @date: 2023/6/27 21:26
 * JumpGame2类
 */
public class JumpGame2 {
    public static int jump(int[] nums) {
        int step = 0;
        int len = nums.length - 1;
        while (len > 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i]+i>=len){
                    len = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
    public static int jump1(int[] nums){
        int step=0;
        int curPosition = 0;
        int maxPosition = 0;
        for(int i=0;i<nums.length-1;i++){
            maxPosition = Math.max(nums[i]+i,maxPosition);
            if (curPosition == i ){
                step++;
                curPosition = maxPosition;
            }
        }
        return step;
    }
}
