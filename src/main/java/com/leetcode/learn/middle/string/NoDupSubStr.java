package com.leetcode.learn.middle.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 张锦标
 * @date: 2023/5/31 18:25
 * NoDupSubStr类
 */
public class NoDupSubStr {
    //暴力解法
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int index = i;
            int cur = 0;
            while (index < n && set.add(s.charAt(index++))) {
                cur++;
                max = Math.max(cur, max);
            }

            set.clear();
        }
        return max;
    }

    public int lengthOfLongestSubstringWithWindow(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (set != null) {
                set.remove(s.charAt(i - 1));
            }
            while (index < n && !set.contains(s.charAt(index))) {
                set.add(s.charAt(index));
                index++;
            }
            max = Math.max(max, index - i);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
