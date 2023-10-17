package leetcode.doublelink;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/8/9 21:13
 * DelLetterMatchLongestStr类
 * 524
 */
public class DelLetterMatchLongestStr {
    //"abpcplea"  ["ale","apple","monkey","plea"]
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            //双指针判断 此时t是s的字串 所以要是t的没有 继续移动s的指针
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            // 由于要确保t这个字符串是通过s的来
            //所以i的指针必须等于t的length
            if (i == t.length()) {
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }
}
