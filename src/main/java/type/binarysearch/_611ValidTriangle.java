package type.binarysearch;

import java.util.Arrays;

/**
 * @author: 张锦标
 * @date: 2023/10/14 17:34
 * _611ValidTriangle类
 */
public class _611ValidTriangle {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res =0 ;
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int left = j+1;
                int right = n-1;
                int k = j;
                while(left<=right){
                    int mid = (right-left)/2+left;
                    if(nums[mid]<nums[i]+nums[j]){
                        k = mid;
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
                res +=k-j;
            }
        }
        return res;
    }
}
