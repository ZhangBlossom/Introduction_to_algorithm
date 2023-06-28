package offer;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: 张锦标
 * @date: 2023/6/28 11:34
 * KsumMaxNum类
 */
public class KsumMaxNum {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int count = 0;
        while (left<right){
            int sum = nums[left]+nums[right];
            if (sum==k){
                count++;
            }else if (sum<k){
                left++;
            }else{
                right--;
            }
        }
        return count;

    }

}
