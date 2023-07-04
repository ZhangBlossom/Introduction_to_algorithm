package offer.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: 张锦标
 * @date: 2023/7/3 22:35
 * TwoArrDiff类
 */
public class TwoArrDiff {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>(2);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        List<Integer> list1=  new ArrayList<>();
        for (Integer integer : set1) {
            if (set2.add(integer)){
                list1.add(integer);
            }
        }
        List<Integer> list2=  new ArrayList<>();
        for (Integer integer : set2) {
            if (set1.add(integer)){
                list2.add(integer);
            }
        }
        list.add(list1);
        list.add(list2);
        return list;
    }
}
