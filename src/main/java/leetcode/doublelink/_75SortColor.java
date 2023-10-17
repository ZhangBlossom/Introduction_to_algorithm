package leetcode.doublelink;

/**
 * @author: 张锦标
 * @date: 2023/10/17 15:32
 * _75SortColor类
 */
public class _75SortColor {
    public void sortColor(int[]nums){
        int n = nums.length;
        int ptr = 0;
        for(int i = 0;i<n;i++){
            if (nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for(int i = ptr;i<n;i++){
            if (nums[i]==1){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}
