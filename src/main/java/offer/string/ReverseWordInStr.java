package offer.string;

import org.junit.platform.commons.util.StringUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: 张锦标
 * @date: 2023/6/28 8:47
 * ReverseWordInStr类
 */
public class ReverseWordInStr {
    public static String reverseWords1(String s){
        String[] s1 = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length-1; i>=0; i--) {
            if(s1[i]!=null && !s1[i].equals("")){
                sb.append(s1[i].trim()+" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverseWords(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<s.length() && s.charAt(left)==' '){
            left++;
        }
        while (right>0 && s.charAt(right)==' '){
            right--;
        }
        Deque<String> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (left<=right){
            if (s.charAt(left)==' ' && StringUtils.isNotBlank(sb.toString())){
                deque.addFirst(sb.toString());
                sb.setLength(0);
            }else if (s.charAt(left)!=' '){
                sb.append(s.charAt(left));
            }
            left++;
        }
        deque.addFirst(sb.toString());
        return String.join(" ",deque);
    }
}
