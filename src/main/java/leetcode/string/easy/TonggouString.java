package leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/5/13 14:59
 * TonggouString类
 */
public class TonggouString {

    //代码正确但是超时
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> m = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {

            if (!m.containsKey(s.charAt(i))) {
                if (m.containsValue(t.charAt(i))) {
                    return false;
                }
                m.put(s.charAt(i), t.charAt(i));
            }
        }
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (!m.get(s.charAt(i)).equals(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public boolean isIsomorphicRight(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
