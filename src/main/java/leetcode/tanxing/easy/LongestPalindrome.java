package leetcode.tanxing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/6/2 21:43
 * LongestPalindrome类
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
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
    public static int longestPalindrome1(String s){
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int count=0;
        for (int i : arr) {
            //判断所有字符中奇数的个数
            count+=(i%2);
        }
        return count==0?s.length():(s.length()-count+1);
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome1("abcd"));
        System.out.println(longestPalindrome1("abcdabcd"));
    }
}
