package main.java.com.leetcode.learn.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/28 10:53
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 219
 */
public class DuplicateElement2 {
    //region 暴力解法
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i=0;i<nums.length;i++){
            for (int j=k; j>0;j--){
                while (i+j>=nums.length && j>0){
                    j--;
                }
                if (j>0 && nums[i]==nums[i+j]){
                    return true;
                }
            }
            i+=k;
        }
        return false;
    }
    //endregion
    //region hash解法
    public static boolean containsNearbyDuplicateByHash(int[] nums, int k) {
        HashMap<Integer,Integer> map  =new HashMap<>(nums.length);
        for (int i=0;i<nums.length;i++) {
            int num = nums[i];
            if (map.containsKey(num) && map.get(num)-i < k){
                return true;
            }
            map.put(num,i);
        }
        return false;
    }
    //endregion
    //region 滑动窗口
    public static boolean containsNearbyDuplicateByWindow(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
    //endregion

    public static void main(String[] args) {
        containsNearbyDuplicateByWindow(new int[]{1,2,3,1,2,3},2);
    }
}
