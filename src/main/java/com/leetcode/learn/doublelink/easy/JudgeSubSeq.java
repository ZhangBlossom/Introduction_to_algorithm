package com.leetcode.learn.doublelink.easy;

import java.util.HashMap;

/**
 * @author: 张锦标
 * @date: 2023/6/14 22:19
 * JudgeSubSeq类
 */
public class JudgeSubSeq {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
