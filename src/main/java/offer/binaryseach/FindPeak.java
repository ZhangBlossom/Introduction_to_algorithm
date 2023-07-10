package offer.binaryseach;

import java.sql.SQLOutput;

/**
 * @author: 张锦标
 * @date: 2023/7/7 19:06
 * FindPeak类
 */
public class FindPeak {
    public int findPeakElement(int[]nums){
        int n = nums.length;
        if (n==1){
            return 0;
        }
        //找一个中间位置开始
        int idx = nums.length/2;
        //一直循环直到当前位置是峰值
        while(!(compare(nums,idx-1,idx)<0 && compare(nums,idx,idx+1)>0)){
            //如果左边大就左移
            if (compare(nums,idx-1,idx)>0){
                idx--;
            }else{
                //右边大右移
                idx++;
            }
        }
        return idx;
    }
    //判断大小
    public int compare(int[] nums,int idx1,int idx2){
        if (idx1==-1){
            return -1;
        }
        if(idx2==nums.length){
            return 1;
        }
        if (nums[idx1]<nums[idx2]){
            return -1;
        }else {
            return 1;
        }

    }

    public static void main(String[] args) {
        System.out.println(new FindPeak().findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
