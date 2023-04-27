package com.itheima.datastructure.stack;

import java.util.LinkedList;

/**
 * 中缀表达式转后缀
 */
public class E03InfixToSuffix {

    public static void test() {
        int a = 10;
        int b = 20;
        int c = 5;
        int d = (a + b) * c;
    }

    /*
        思路

        |   |
        |   |
        |   |
        _____

        a+b             ab+
        a+b-c           ab+c-
        a*b+c           ab*c+
        a+b*c           abc*+
        a+b*c-d         abc*+d-
        (a+b)*c         ab+c*
        (a+b*c-d)*e     abc*+d-e*
        a*(b+c)         abc+*

        1. 遇到非运算符 直接拼串
        2. 遇到 + - * /
            - 它的优先级比栈顶运算符高, 入栈, 如: 栈中是 + 当前是 *
            - 否则把栈里优先级 >= 它 的都出栈, 它再入栈, 如: 栈中是 +*, 当前是 -
        3. 遍历完成, 栈里剩余运算符依次出栈
        4. 带()
            - 左括号直接入栈, 左括号优先设置为0
            - 右括号就把栈里到左括号为止的所有运算符出栈
     */
    public static void main(String[] args) {
//        System.out.println(infixToSuffix("a+b"));
//        System.out.println(infixToSuffix("a+b-c"));
//        System.out.println(infixToSuffix("a+b*c"));
//        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("(a+b)*c"));
        System.out.println(infixToSuffix("(a+b*c-d)*e"));
        System.out.println(infixToSuffix("a*(b+c)"));
    }

    static int priority(char c) {
        return switch (c) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '(' -> 0;
            default -> throw new IllegalArgumentException("不合法的运算符:" + c);
        };
    }

    static String infixToSuffix(String exp) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '*', '/', '+', '-' -> {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                }
                case '(' -> {
                    stack.push(c);
                }
                case ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> {
                    sb.append(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
