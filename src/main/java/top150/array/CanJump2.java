package top150.array;

/**
 * @author: 张锦标
 * @date: 2023/9/28 13:54
 * CanJump2类
 */
public class CanJump2 {
    class Solution {
        public int jump(int[] nums) {
            int position = nums.length-1;
            int step=0;
            while(position>0){
                for(int i = 0;i<position;i++){
                    if(i+nums[i]>=position){
                        position=i;
                        step++;
                        break;
                    }
                }
            }
            return step;
        }
    }
}
