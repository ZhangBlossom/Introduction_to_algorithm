package leetcode.easy.search;

/**
 * @author: 张锦标
 * @date: 2023/4/25 21:54
 * SearchInsertPlace类
 * 35题
 * 要同时返回插入的位置
 */
public class SearchInsertPlace {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)>>>1;
            if(nums[mid]<target){
                low = mid+1;
            }else if(target<nums[mid]){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return low;
    }
}
