package offer.stack;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/7/2 1:37
 * RemoveStarFromStack类
 */
public class RemoveStarFromStack {
    public static String removeStars(String s) {
        if (s.isEmpty()){
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Character c = stack.peek();
            if (c == '*') {
                stack.pop();
                int count = 0;
                while (!stack.isEmpty() && stack.peek()=='*'){
                    count++;
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek()!='*'){
                    stack.pop();
                }
                for(int i=0;i<count;i++){
                    stack.push('*');
                }
            } else {
                sb.append(c);
                stack.pop();
            }
        }

        return sb.reverse().toString();
    }


    public static String removeStars1(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        char [] cs=s.toCharArray();
        for(char ch:cs){
            if(ch == '*'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        for(Character ch:stack){
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeStars1("erase*****"));
    }
}
