package main.java.com.leetcode.learn.easy.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/7 9:27
 * Description:
 * Version: 1.0.0
 */
public class ArrayJiaoji {
    public static int[] intersectionWithSet(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }
    public static void main(String[] args) {

    }
}
