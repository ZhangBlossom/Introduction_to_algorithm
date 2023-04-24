package main.java.com.leetcode.learn.easy.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/15 8:29
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * P26
 */
public class DelDuplicatesFromSortedArr {
    public static int removeDuplicates(int[] nums) {
                int n = nums.length;
                if (n == 0) {
                    return 0;
                }
                int fast = 1, slow = 1;
                while (fast < n) {
                    if (nums[fast] != nums[fast - 1]) {
                        nums[slow] = nums[fast];
                        ++slow;
                    }
                    ++fast;
                }
        System.out.println(Arrays.toString(nums));
        return slow;
    }
    public static int rmD(int[]nums){
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i=0;
        for (Integer integer : set) {
            nums[i++]=integer;
        }
        return set.size();
    }

    public static void main(String[] args) {
//        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
//        System.out.println(removeDuplicates(new int[]{1,1,1,3,3,4,4,4,5,5,5,6,7,11,23}));
        System.out.println(rmD(new int[]{1,1,1,3,3,4,4,4,5,5,5,6,7,11,23}));
    }
}
