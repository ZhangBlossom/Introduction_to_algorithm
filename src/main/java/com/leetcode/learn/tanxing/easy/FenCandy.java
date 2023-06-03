package com.leetcode.learn.tanxing.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 张锦标
 * @date: 2023/6/2 21:31
 * FenCandy类
 */
public class FenCandy{
    public int distributeCandies(int[] candyType){
        Set<Integer> set = new HashSet<>(candyType.length/2);
        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
        }
        return Math.min(set.size(),candyType.length/2);
    }
}
