package type.binarysearch;

/**
 * @author: 张锦标
 * @date: 2023/10/14 15:39
 * _540SingleNonDuplicate类
 */
public class _540SingleNonDuplicate {
    //有序数组中的单一元素
    //public int singleNonDuplicate(int[]nums){
    //    int slow = 0;
    //    int fast = 1;
    //    int len = nums.length;
    //    while(slow<len){
    //        if (nums[slow]==nums[fast]){
    //            slow+=2;
    //            fast+=2;
    //        }else{
    //            return nums[slow];
    //        }
    //    }
    //    return len;
    //}

    public int singleNonDuplicate(int[]nums){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (right - left)/2+left;
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }else{
                if(nums[mid]==nums[mid-1]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
        }
        return nums[left];
    }
}
