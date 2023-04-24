package main.java.com.leetcode.learn.easy.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: 张锦标
 * @date: 2023/2/28 9:51
 * StackAsQueue类
 */
public class StackAsQueue {

}
class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
