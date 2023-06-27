package leetcode.string.substr;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 张锦标
 * @date: 2023/6/15 10:19
 * LongNoDupSubStr类
 */
public class LongNoDupSubStr {
    //暴力解法 没有用到之前保存的数据
     public int lengthOfLongestSubstring1(String s) {
         Set<Character> set = new HashSet<>();
         int n = s.length();
         int max = 0;
         for(int i=0;i<n;i++){
             int index = i;
             int cur = 0;
             while (index<n && set.add(s.charAt(index++))){
                 cur++;
                 max = Math.max(cur,max);
             }

             set.clear();
         }
         return max;
     }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (set.size()>=1) {
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

}
