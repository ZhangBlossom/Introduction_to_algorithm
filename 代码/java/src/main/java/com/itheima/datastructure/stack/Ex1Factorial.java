package com.itheima.datastructure.stack;

public class Ex1Factorial {

    static class Frame<E> {
        int n;
        E result;
        int branch;
        int returnBranch;

//        public static <E> Frame<E> call(int enterAddress, int exitAddress, Object...args){
//
//        }

        public Frame(int n, int branch, int returnBranch) {
            this.n = n;
            this.branch = branch;
            this.returnBranch = returnBranch;
        }

        @Override
        public String toString() {
            return "State{" +
                    "n=" + n +
                    ", r=" + result +
                    '}';
        }
    }

    public static int f(int n) {
        ArrayStack<Frame<Integer>> stack = new ArrayStack<>(n);
        stack.push(new Frame<>(n, 0, 3));
        while (!stack.isEmpty()) {
            Frame<Integer> curr = stack.peek();
            switch (curr.branch) {
                case 0 -> {
                    if (curr.n == 1) {
                        curr.result = 1;
                        curr.branch = curr.returnBranch;
                    } else {
                        stack.push(new Frame<>(curr.n - 1, 0, 1));
                    }
                }
                case 1 -> {
                    Frame<Integer> x = stack.pop();
                    System.out.println(x);
                    Frame<Integer> prev = stack.peek();
                    prev.result = prev.n * x.result;
                    prev.branch = prev.returnBranch;
                }
                default -> {
                    return curr.result;
                }
            }
        }
        return -1; // 不会执行到这儿
    }

    public static void main(String[] args) {
        f(5);
    }
}
