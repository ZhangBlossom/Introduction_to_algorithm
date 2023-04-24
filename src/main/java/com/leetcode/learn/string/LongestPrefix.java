package main.java.com.leetcode.learn.string;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/8 10:13
 * Description:
 * Version: 1.0.0
 * 14
 */
public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
