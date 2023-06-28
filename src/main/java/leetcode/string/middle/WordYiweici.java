package leetcode.string.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/6/27 21:42
 * WordYiweici类
 */
public class WordYiweici {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]!=0) {
                    sb.append((char)('a'+i));
                    sb.append(arr[i]);
                }
            }
            List<String>list =
                    map.getOrDefault(sb.toString(),new ArrayList<String>());
            list.add(str);
            map.put(sb.toString(),list);
        }
        return new ArrayList<>(map.values());

    }
}
