package leetcode.easy.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: 张锦标
 * @date: 2023/2/28 9:42
 * ValidKuohao类
 */
public class ValidKuohao {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)){
                if(stack.isEmpty() || !stack.peek().equals(pairs.get(ch))){
                    return false;
                }
                stack.pop();
            }else{ //当前是（ 【 { 直接入栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
