package top150.array;

/**
 * @author: 张锦标
 * @date: 2023/9/18 9:19
 * DelDupVal类
 */
public class DelDupVal {
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        int fast = 1;
        int len = nums.length;
        for(;fast<len;fast++){
            if (nums[fast-1]!=nums[fast]){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }
}
