package leetcode.string.palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/5/15 11:36
 * LongestHuiwen类
 * Easy 409
 */
public class LongestHuiwen {
    public int longestPalindrome(String s) {
        if (s.length()==1){
            return 1;
        }
        HashMap<Character,Integer> m = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (m.containsKey(chars[i])){
                m.put(chars[i],m.get(chars[i])+1);
            }else{
                m.put(chars[i],1);
            }
        }
        int max = 0;
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            Integer v = entry.getValue();
            max+=v/2*2;
            if (v%2==1 && max%2==0){
                max++;
            }
        }

        return max;
    }
}
