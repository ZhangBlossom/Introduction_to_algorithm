package com.leetcode.learn.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/16 17:04
 * SubSet类
 */
public class SubSet {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subSets(int[] nums){
        int n =nums.length;
        for(int i=0;i< (1<<n);i++){
            t.clear();
            for(int j=0;j<n;j++){
                if ((i & (1<<j))!=0){
                    t.add(nums[j]);
                }
            }
            result.add(t);
        }
        return result;
    }
}
