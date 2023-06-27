package leetcode.easy.array;

import java.util.Arrays;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/6 8:50
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 268
 * 丢失的数字
 */
public class LostNumber {
    //region 暴力排序解法
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for(;i<nums.length;i++){
            if (i==nums[i]){

            }else{
                return i;
            }
        }
        return i+1;
    }
    //endregion

    //region 位运算
    public int missingNumberByXor(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }
    //endregion

    //region 数学计算
    //等差数列的前n项和公式n（n+1）/2 = sum
    //因此数组的和与sum的差就是少的值
    public int missingNumberB有Math(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += nums[i];
        }
        return total - arrSum;
    }
    //endregion
    public static void main(String[] args) {
        missingNumber(new int[]{3,0,1});
    }
}
