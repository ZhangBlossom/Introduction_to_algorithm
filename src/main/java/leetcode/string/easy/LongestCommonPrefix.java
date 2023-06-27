package leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/13 8:50
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 14
 * 最长公共前缀
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix1(String[] strs) {
        int min = strs[0].length();
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
                index = i;
            }
        }
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < strs[index].length(); i++) {
            map.put(i + 1, strs[index].substring(0, i + 1));
        }
        String totalPrefix = "";
        for (int j = 1; j <= map.size(); j++) {
            String prefix = map.get(j);
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)){
                    return totalPrefix;
                }
            }
            totalPrefix=prefix;
        }
        System.out.println(map);
        System.out.println(totalPrefix);
        return totalPrefix;
    }

    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"flower", "flow", "flight", "fog"});

    }

    public static String longestCommonPrefix(String[] strs) {
        int min = strs[0].length();
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
                index = i;
            }
        }
        String prefix = "";
        String totalPrefix = "";
        String minStr = strs[index];
        for (int j = 0; j < min; j++) {
            totalPrefix = minStr.substring(0,j+1);
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(totalPrefix)){
                    return prefix;
                }
            }
            prefix=totalPrefix;
        }
        return prefix;
    }
}
