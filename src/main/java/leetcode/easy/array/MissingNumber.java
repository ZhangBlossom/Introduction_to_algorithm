package leetcode.easy.array;

import java.util.*;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/11 12:53
 * Description:
 * Version: 1.0.0
 */
public class MissingNumber {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
    //超时了
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=1;i<=len;i++){
            set.add(i);
        }
        for (int num : nums) {
            set.removeIf(x->{
                return num==x;
            });
        }
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
