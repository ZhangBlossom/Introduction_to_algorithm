package leetcode.string.middle;

import java.util.*;

/**
 * @author: 张锦标
 * @date: 2023/6/7 9:47
 * ReverseWords类
 */
public class ReverseWords {
    //API战神
    public static String reverseWords1(String s){
        //String[] s1 = s.trim().split(" ");
        //StringBuilder sb = new StringBuilder();
        //for (int i = s1.length-1; i>=0; i--) {
        //    if(s1[i]!=null && !s1[i].equals("")){
        //        sb.append(s1[i].trim()+" ");
        //    }
        //}
        //return sb.toString().trim();
        //--------------------------------
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);

    }


    public static String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public static StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public static void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }


    public static String reverse(String s){
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char c = chars[chars.length - i - 1];
            chars[chars.length-i-1] = chars[i];
            chars[i] = c;
        }
        return new String(chars);
    }

    public String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }


    public static void main(String[] args) {
        String s = "  the   sky is blue";
        //System.out.println(reverseWords(s));
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse());
        System.out.println(reverse(s));
        reverse(sb,0,s.length()-1);
        System.out.println(sb);
    }
}
