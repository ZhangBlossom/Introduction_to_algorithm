package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/2/27 9:27
 * Weiyizifu类
 */
public class Weiyizifu {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],i);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])==i){
                return i;
            }
        }
        return -1;
    }
}
