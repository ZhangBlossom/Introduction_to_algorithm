package com.leetcode.learn.string.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/6/2 20:38
 * KeyboardRow类
 */
public class KeyboardRow {
    /*
    我们为每一个英文字母标记其对应键盘上的行号，然后检测字符串中所有字符对应的行号是否相同。
    我们可以预处理计算出每个字符对应的行号。
    遍历字符串时，统一将大写字母转化为小写字母方便计算。
     */
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<String>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); ++i) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
