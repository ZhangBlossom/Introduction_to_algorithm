package com.itheima.datastructure.stack;

public class CPU {
    static class Frame {
        int exit;

        public Frame(int exit) {
            this.exit = exit;
        }
    }

    static int pc = 1; // 模拟程序计数器 Program counter
    static ArrayStack<Frame> stack = new ArrayStack<>(100); // 模拟方法调用栈

    public static void main(String[] args) {
        stack.push(new Frame(-1));
        while (!stack.isEmpty()) {
            switch (pc) {
                case 1 -> {
                    System.out.println("main1");
                    pc++;
                }
                case 2 -> {
                    System.out.println("main2");
                    pc++;
                }
                case 3 -> {
                    stack.push(new Frame(pc + 1));
                    pc = 100;
                }
                case 4 -> {
                    stack.push(new Frame(pc + 1));
                    pc = 200;
                }
                case 5 -> {
                    System.out.println("main3");
                    pc = stack.pop().exit;
                }
                case 100 -> {
                    System.out.println("method1");
                    stack.push(new Frame(pc + 1));
                    pc = 300;
                }
                case 101 -> {
                    pc = stack.pop().exit;
                }
                case 200 -> {
                    System.out.println("method2");
                    pc = stack.pop().exit;
                }
                case 300 -> {
                    System.out.println("method3");
                    pc = stack.pop().exit;
                }
            }
        }
    }
}
