package com.leetcode.learn.tanxing.middle;

/**
 * @author: 张锦标
 * @date: 2023/6/18 9:14
 * JumpGame2类
 */
public class JumpGame2 {
    public int jump(int[] nums){
        int position = nums.length-1;
        int step = 0;
        while(position>0){
            for(int i=0;i<position;i++){
                if (nums[i]+i>=position){
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}
