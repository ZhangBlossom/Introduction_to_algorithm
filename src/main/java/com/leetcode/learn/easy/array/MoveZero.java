package main.java.com.leetcode.learn.easy.array;

import javafx.scene.control.Skin;

import java.util.Arrays;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/6 16:23
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 */
public class MoveZero {
    //双指针
    public static void moveZeroes(int[] nums) {
       int slow=0,fast=0;
       while (fast<nums.length){
           if (nums[fast]!=0){
               nums[slow++]=nums[fast];
           }
           fast++;
       }
       for(;slow<nums.length;slow++){
           nums[slow]=0;
       }
    }

    public static void moveZeroesWithFast(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        moveZeroes(new int[]{0,0,0,1,3,12});
    }
}
