package com.leetcode.learn.kmp.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/18 12:48
 * IndexOf类
 * 这个方法就是用来找出字符串中第一个符合
 * 完整匹配的子串的位置 也就是java的indexo方法
 */
public class IndexOf {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        List<Integer> list = new ArrayList<>();
        char start = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == start) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int startIndex = list.get(i);
            boolean flag = false;
            for (int j = 0; j < m && j + startIndex < n; j++) {
                if (needle.charAt(j)!=haystack.charAt(startIndex+j)){
                    break;
                }
                if (j==m-1){
                    return startIndex;
                }
            }
        }
        return -1;
    }
}
