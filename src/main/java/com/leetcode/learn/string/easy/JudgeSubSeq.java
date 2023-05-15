package com.leetcode.learn.string.easy;

/**
 * @author: 张锦标
 * @date: 2023/5/15 11:07
 * JudgeSubSqu类
 */
public class JudgeSubSeq {
    //s = "abc", t = "ahbgdc"
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
