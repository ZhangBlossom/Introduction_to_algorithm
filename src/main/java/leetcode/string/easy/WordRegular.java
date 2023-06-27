package leetcode.string.easy;

import java.util.HashMap;

/**
 * @author: 张锦标
 * @date: 2023/5/14 15:12
 * WordRegular类
 */
public class WordRegular {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> p2s = new HashMap<>();
        HashMap<String,Character> s2p = new HashMap<>();
        String[] s1 = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (s1.length!=chars.length){
            return false;
        }
        for (int i = 0; i < s1.length; i++) {
            if ((p2s.containsKey(chars[i]) &&  !s1[i].equals(p2s.get(chars[i]))) ||
                s2p.containsKey(s1[i]) && !s2p.get(s1[i]).equals(chars[i])){
                return false;
            }
            p2s.put(chars[i],s1[i]);
            s2p.put(s1[i],chars[i]);
        }
        return true;
    }
    public static boolean wordPattern1(String pattern, String s) {
        String[] s1 = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (s1.length!=chars.length){
            return false;
        }
        HashMap<Character,String> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i]) && !map.containsValue(s1[i])){
                map.put(chars[i],s1[i]);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (!s1[i].equals(map.get(chars[i]))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(wordPattern("abba",
                "dog cat cat dog"));
    }
}
