package leetcode.binary;

/**
 * @author: 张锦标
 * @date: 2023/6/18 13:06
 * FirstAndLastNum类
 * 34
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 */
public class FirstAndLastNum {
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
                //因为要找最左的，所以high应该不断变小
                //high选择mid-1
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
