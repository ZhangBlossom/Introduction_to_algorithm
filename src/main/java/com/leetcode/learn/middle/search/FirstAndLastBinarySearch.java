package com.leetcode.learn.middle.search;

/**
 * @author: 张锦标
 * @date: 2023/4/26 10:54
 * FirstAndLastBinarySearch类
 */
public class FirstAndLastBinarySearch {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftSearch(nums,target),rightSearch(nums,target)};
    }

    /**
     * 寻找最左侧的值
     * @param nums
     * @param target
     * @return
     */
    public int leftSearch(int[]nums,int target){
        int low = 0;
        int high = nums.length-1;
        int candidate = -1;
        while(low<=high){
            int mid = (low+high)>>>1;
            if(target<nums[mid]){
                high = mid - 1;
            }else if(nums[mid]<target){
                low = mid + 1;
            }else{
                candidate = mid;
                high = mid - 1;
            }
        }
        return candidate;
    }

    /**
     * 寻找最右侧的值
     * @param nums
     * @param target
     * @return
     */
    public int rightSearch(int[]nums,int target){
        int low = 0;
        int high = nums.length-1;
        int candidate = -1;
        while(low<=high){
            int mid = (low+high)>>>1;
            if(target<nums[mid]){
                high = mid - 1;
            }else if(nums[mid]<target){
                low = mid + 1;
            }else{
                candidate = mid;
                low = mid + 1;
            }
        }
        return candidate;
    }
}
