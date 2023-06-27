package leetcode.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/15 9:10
 * DuplicateNumber类
 */
public class DuplicateNumber {
    public List<Integer> findDuplicates(int[] nums){
        int len = nums.length;
        int[] arr = new int[len+1];
        for (int num : nums) {
            arr[num]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==2){
                result.add(i);
            }
        }
        return result;
    }
}
