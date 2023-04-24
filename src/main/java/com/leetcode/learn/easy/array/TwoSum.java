package main.java.com.leetcode.learn.easy.array;

import java.util.*;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/5 15:32
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 1
 * 两数之和
 */
public class TwoSum {
//    public static int[] twoSum(int[] nums, int target) {
//        //key存放这个数据  value存放相减后的值
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(target-nums[i],i); // 7-0 2-1 -2-2 -6-3
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i]) && map.get(nums[i])!=i){
//                return new int[]{i,map.get(nums[i])};
//            }
//        }
//        return new int[0];
//    }
    public static int[] twoSum(int[] nums, int target) {
        //key存放这个数据  value存放相减后的值
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i])!=i){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{4,2,3}, 6)));
    }
}
