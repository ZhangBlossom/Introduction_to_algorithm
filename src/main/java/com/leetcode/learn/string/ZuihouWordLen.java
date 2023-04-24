package main.java.com.leetcode.learn.string;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/8 10:30
 * Description:
 * Version: 1.0.0
 */
public class ZuihouWordLen {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

}
