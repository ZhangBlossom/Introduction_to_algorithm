package offer.stack;

import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/5/27 15:28
 * ReverseStack类
 * 使用递归和栈，来反转输出一个栈
 */
public class ReverseStack {
    private static Stack<Integer> stack = new Stack<>();

    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return ;
        }
        int i = getAndRemoveLastElement(stack);
        System.out.println(i);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //System.out.println(stack);
        //reverse(stack);
        //System.out.println(stack);
        System.out.println(getAndRemoveLastElement(stack));
        System.out.println(getAndRemoveLastElement(stack));
        System.out.println(getAndRemoveLastElement(stack));
        System.out.println(getAndRemoveLastElement(stack));
        System.out.println(getAndRemoveLastElement(stack));
    }
}
