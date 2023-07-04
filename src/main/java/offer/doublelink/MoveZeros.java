package offer.doublelink;

/**
 * @author: 张锦标
 * @date: 2023/6/28 11:28
 * MoveZeros类
 */
public class MoveZeros {
    public void moveZeroes1(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public void moveZeroes(int[] nums){
        int slow = 0;
        int fast = 0;
        while (fast<nums.length){
            if (nums[fast]!=0){
                nums[slow++]=nums[fast];
            }
            fast++;
        }
        for(;slow<nums.length;slow++){
            nums[slow]=0;
        }
    }
}
