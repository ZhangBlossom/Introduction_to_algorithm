package main.java.com.leetcode.learn.string;

/**
 * @author: 张锦标
 * @date: 2023/2/23 15:23
 * Description:
 */
public class ReverseStr2 {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[n-i-1];
            s[n-i-1]=s[i];
            s[i]=temp;
        }
    }
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (String s1 : s.split(" ")) {
            char[] chars = s1.toCharArray();
            reverseString(chars);
            sb.append(new String(chars)+" ");
        }
        return sb.toString().trim();

    }
}
