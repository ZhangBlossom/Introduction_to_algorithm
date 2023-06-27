package leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/8 9:13
 * Description:
 * Version: 1.0.0
 */
public class ArrayJiaoji2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap<>(nums1.length);
        HashMap<Integer,Integer> map2 = new HashMap<>(nums2.length);
        for (int i : nums1) {
            if (!map1.containsKey(i)){
                map1.put(i,1);
            }else{
                map1.put(i,map1.get(i)+1);
            }
        }
        List<Integer> list = new ArrayList<>(nums2.length);
        for (int i : nums2) {
            if (map1.containsKey(i) && map1.get(i)>0){
                list.add(i);
                map1.put(i,map1.get(i)-1);
            }
        }
        int[]arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }


    public int[] intersectDoublePoint(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
