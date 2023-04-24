package main.java.com.leetcode.learn.string;

import java.util.*;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/1/13 19:30
 * @Connection: qq460219753 wx15377920718
 * Description:
 * Version: 1.0.0
 * 20
 * 有效的字符
 */
public class ValidParentheses {
    public static boolean isValid(String s){
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)){
                if(stack.isEmpty() || stack.peek().equals(pairs.get(ch))){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();

        //   while(true){
        //            int l=s.length();
        //            s=s.replace("()","");
        //            s=s.replace("{}","");
        //            s=s.replace("[]","");
        //            if(s.length()==l){return l==0;}
        //        }

    }
    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }
}
