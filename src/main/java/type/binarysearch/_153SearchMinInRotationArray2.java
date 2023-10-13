package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/13 11:16
 * _153SearchMinInRotationArray2类\
 * 这道题的问题在于他存在有重复的元素
 */
public class _153SearchMinInRotationArray2 {
    public int findMin(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if (nums[mid]<nums[right]){
                right = mid;
            }else if (nums[mid]>nums[right]){
                left = mid+1;
            }else{
                right--;
            }
        }
        return left;
    }
}
