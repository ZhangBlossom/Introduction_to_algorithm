package top150.array;

/**
 * @author: 张锦标
 * @date: 2023/9/18 9:17
 * RemoveVal类
 */
public class RemoveVal {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        for(;fast<n;fast++){
            if(nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }
}
