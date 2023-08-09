package offer.stack;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/5/27 17:57
 * SortStack类
 */
public class SortStack {
    public static void sortStackDesc(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }
    public static void sortStackAsc(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!help.isEmpty() && help.peek() > cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        sortStackAsc(stack);
        System.out.println(stack);
    }
}
