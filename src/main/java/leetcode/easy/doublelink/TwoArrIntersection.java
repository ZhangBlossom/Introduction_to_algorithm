package leetcode.easy.doublelink;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 张锦标
 * @date: 2023/5/29 14:52
 * TwoArrIntersection类
 */
public class TwoArrIntersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        Object[] objects = set1.stream().filter(x -> set2.contains(x)).toArray();
        int[] arr = new int[objects.length];
        int index= 0;
        for (Object o : objects) {
            arr[index++]= (int) o;
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
